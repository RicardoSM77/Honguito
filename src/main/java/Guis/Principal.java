package Guis;
import Hilo.Inicio;
import Hilo.Pausa;
import Hilo.Reiniciar;
import Motor_Log.Logica;
import Panel.EscenaCrecimiento;
import Panel.FondoEscalable;
import Panel.PanelRedondeado;
import Panel.SpriteHonguito;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicSliderUI;


public class Principal extends javax.swing.JFrame {

    private static final int[] HITOS_BIOMASA = {25, 50, 75, 90, 99};
    private final Timer refresco = new Timer(250, e -> mostrarEstado());
    private final EscenaCrecimiento escenaCrecimiento;
    private Inicio simulacion;
    private Pausa pausa;
    private Configuracion configuracion = new Configuracion(1, 10, 18, 90);
    private double factorAmbiental;
    private int siguienteHito;
    private boolean crecimientoRegistrado;

    private record Configuracion(double masaInicial, double capacidad, double temperatura, double humedad) {
    }

    public Principal() {
        initComponents();
        sliderVelocidad.setUI(new BasicSliderUI(sliderVelocidad) {
            @Override
            public void paintTrack(Graphics g) {
                pintarRedondeado(g, new Color(205, 222, 192),
                        trackRect.x, trackRect.y + (trackRect.height - 6) / 2, trackRect.width, 6);
            }

            @Override
            protected void paintMajorTickForHorizSlider(Graphics g, Rectangle tickBounds, int x) {
                g.setColor(new Color(145, 166, 132));
                super.paintMajorTickForHorizSlider(g, tickBounds, x);
            }

            @Override
            public void paintThumb(Graphics g) {
                int diametro = 12;
                Color color = slider.hasFocus() ? new Color(57, 95, 46) : new Color(103, 147, 83);
                pintarRedondeado(g, color, thumbRect.x + (thumbRect.width - diametro) / 2,
                        thumbRect.y + (thumbRect.height - diametro) / 2, diametro, diametro);
            }

            @Override
            public void paintFocus(Graphics g) {
                // El cambio de color del mando indica el foco sin dibujar un borde.
            }

            private void pintarRedondeado(Graphics g, Color color, int x, int y, int ancho, int alto) {
                Graphics2D dibujo = (Graphics2D) g.create();
                try {
                    dibujo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    dibujo.setColor(color);
                    dibujo.fillRoundRect(x, y, ancho, alto, alto, alto);
                } finally {
                    dibujo.dispose();
                }
            }
        });
        sliderVelocidad.setOpaque(false);
        sliderVelocidad.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
        escenaCrecimiento = new EscenaCrecimiento((ImageIcon) jLabel8.getIcon());
        panelRedondeado2.remove(jLabel8);
        panelRedondeado2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        panelRedondeado2.setLayout(new BorderLayout());
        panelRedondeado2.add(escenaCrecimiento, BorderLayout.CENTER);
        dibujarHonguitosEnMapa();
        ajustarColumnaDerecha();
        barraSaludHongo.getAccessibleContext().setAccessibleName("Biomasa respecto a la capacidad");
        lblPorcentajeHongo.setText("—");
        jLabel5.setText("0 días");
        jLabel31.setText("—");
        jLabel33.setText("—");
        jLabel44.setText("—");
        jLabel47.setText("—");
        ImageIcon arreiba=new ImageIcon(getClass().getResource("/Hongo60x60.png"));
        lblarriba.setIcon(arreiba);

        txtEventos.setEditable(false);
        jButton1.addActionListener(e -> iniciarOReanudar());
        jButton2.addActionListener(e -> {
            pausa.pausar();
            refresco.stop();
            mostrarEstado();
            agregarEvento("Simulación pausada.");
            actualizarControles();
        });
        jButton3.addActionListener(e -> {
            new Reiniciar(simulacion).run();
            agregarEvento(0, "Simulación reiniciada.");
            registrarInicioHongo();
            mostrarEstado();
        });
        sliderVelocidad.addChangeListener(e -> {
            int velocidad = sliderVelocidad.getValue();
            jLabel19.setText("x" + velocidad);
            if (simulacion != null) {
                simulacion.setVelocidad(velocidad);
            }
        });

        jMenu1.setText("Simulación");
        JMenuItem itemConfigurar = new JMenuItem("Configurar simulación…");
        itemConfigurar.addActionListener(e -> configurarSimulacion());
        jMenu1.add(itemConfigurar);
        actualizarControles();
        pack();
    }

    private void iniciarOReanudar() {
        if (simulacion == null) {
            configurarSimulacion();
        } else if (pausa.isPausado()) {
            pausa.reanudar();
            refresco.start();
            agregarEvento("Simulación reanudada.");
            actualizarControles();
        }
    }

    private void configurarSimulacion() {
        JTextField masa = new JTextField(Double.toString(configuracion.masaInicial()), 10);
        JTextField capacidad = new JTextField(Double.toString(configuracion.capacidad()), 10);
        JTextField temperatura = new JTextField(Double.toString(configuracion.temperatura()), 10);
        JTextField humedad = new JTextField(Double.toString(configuracion.humedad()), 10);
        JPanel campos = new JPanel(new GridLayout(0, 2, 8, 6));
        campos.add(new JLabel("Masa inicial (kg):"));
        campos.add(masa);
        campos.add(new JLabel("Capacidad máxima (kg):"));
        campos.add(capacidad);
        campos.add(new JLabel("Temperatura (°C):"));
        campos.add(temperatura);
        campos.add(new JLabel("Humedad (%):"));
        campos.add(humedad);

        Supplier<Configuracion> leerConfiguracion = () -> new Configuracion(leerNumero(masa), leerNumero(capacidad),
                leerNumero(temperatura), leerNumero(humedad));
        JLabel vistaPrevia = new JLabel();
        Runnable actualizarVistaPrevia = () -> {
            String mensaje;
            try {
                mensaje = describirCrecimiento(leerConfiguracion.get());
            } catch (IllegalArgumentException ex) {
                mensaje = "Ingresa valores válidos para ver la estimación de crecimiento.";
            }
            vistaPrevia.setText("<html><div style='width: 275px'>" + mensaje + "</div></html>");
        };
        DocumentListener cambios = new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { actualizarVistaPrevia.run(); }
            @Override public void removeUpdate(DocumentEvent e) { actualizarVistaPrevia.run(); }
            @Override public void changedUpdate(DocumentEvent e) { actualizarVistaPrevia.run(); }
        };
        for (JTextField campo : new JTextField[]{masa, capacidad, temperatura, humedad}) {
            campo.getDocument().addDocumentListener(cambios);
        }
        actualizarVistaPrevia.run();
        JPanel contenido = new JPanel(new BorderLayout(0, 10));
        contenido.add(campos, BorderLayout.CENTER);
        contenido.add(vistaPrevia, BorderLayout.SOUTH);

        while (JOptionPane.showConfirmDialog(this, contenido, "Configurar simulación",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
            try {
                Configuracion nueva = leerConfiguracion.get();
                Pausa nuevaPausa = new Pausa();
                Logica motor = new Logica(nueva.masaInicial(), nueva.capacidad());
                Inicio nuevaSimulacion = new Inicio(motor,
                        nueva.temperatura(), nueva.humedad(), sliderVelocidad.getValue(), nuevaPausa);
                if (simulacion != null) {
                    simulacion.detener();
                }
                configuracion = nueva;
                factorAmbiental = motor.calcular(nueva.temperatura(), nueva.humedad());
                simulacion = nuevaSimulacion;
                pausa = nuevaPausa;
                jLabel44.setText(String.format("%.4g kg", nueva.masaInicial()));
                jLabel47.setText(String.format("%.4g kg", nueva.capacidad()));
                txtEventos.setText("");
                agregarEvento(0, "Simulación iniciada.");
                registrarInicioHongo();
                mostrarEstado();
                actualizarControles();

                Thread hilo = new Thread(simulacion, "honguito-simulacion");
                hilo.setDaemon(true);
                hilo.start();
                refresco.start();
                return;
            } catch (NumberFormatException ex) {
                mostrarErrorConfiguracion("Introduce un número en cada campo (puedes usar coma o punto decimal).");
            } catch (IllegalArgumentException ex) {
                mostrarErrorConfiguracion(ex.getMessage());
            }
        }
    }

    private static String describirCrecimiento(Configuracion config) {
        Logica modelo = new Logica(config.masaInicial(), config.capacidad());
        double factor = modelo.calcular(config.temperatura(), config.humedad());
        if (config.masaInicial() == config.capacidad()) {
            return "Sin crecimiento: la masa inicial ya ocupa toda la capacidad.";
        }
        if (factor == 0) {
            return "Sin crecimiento: la temperatura o la humedad anula la tasa. Prueba con 18 °C y 90 %.";
        }
        double aumento = modelo.crecimiento(1, config.humedad(), config.temperatura()) - config.masaInicial();
        if (aumento == 0) {
            return "El aumento del primer día es demasiado pequeño para representarlo con estos valores.";
        }
        return String.format("Factor ambiental: %.3g %% de la tasa base. Aumento el primer día simulado: +%.4g kg.",
                100 * factor, aumento);
    }

    private static double leerNumero(JTextField campo) {
        return Double.parseDouble(campo.getText().trim().replace(',', '.'));
    }

    private void mostrarErrorConfiguracion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Datos no válidos", JOptionPane.ERROR_MESSAGE);
    }

    private void actualizarControles() {
        boolean iniciada = simulacion != null;
        boolean pausada = iniciada && pausa.isPausado();
        jButton1.setText(pausada ? "Reanudar" : "Inicio");
        jButton1.setEnabled(!iniciada || pausada);
        jButton2.setEnabled(iniciada && !pausada);
        jButton3.setEnabled(iniciada);
    }

    private void mostrarEstado() {
        if (simulacion == null) {
            return;
        }
        Inicio.Estado estado = simulacion.getEstado();
        double fraccion = estado.masa() / estado.capacidad();
        escenaCrecimiento.setFraccionDeCapacidad(fraccion);
        int porcentaje = (int) Math.round(100 * fraccion);
        barraSaludHongo.setValue(porcentaje);
        lblPorcentajeHongo.setText(String.format("%d%% · %.4g kg", porcentaje, estado.masa()));
        jLabel5.setText(String.format("%.2f días", estado.dias()));
        jLabel31.setText(String.format("%.4g °C", estado.temperatura()));
        jLabel33.setText(String.format("%.4g %%", estado.humedad()));
        registrarCrecimiento(estado, fraccion);
    }

    private void registrarInicioHongo() {
        double masaInicial = configuracion.masaInicial();
        double capacidad = configuracion.capacidad();
        double fraccion = masaInicial / capacidad;
        siguienteHito = 0;
        crecimientoRegistrado = false;
        while (siguienteHito < HITOS_BIOMASA.length && fraccion >= HITOS_BIOMASA[siguienteHito] / 100.0) {
            siguienteHito++;
        }

        agregarEvento(0, String.format("Hongo: biomasa inicial de %.4g kg.", masaInicial));
        if (masaInicial == capacidad) {
            agregarEvento(0, "Hongo: la biomasa inicial ya está en la capacidad máxima.");
        } else if (factorAmbiental == 0) {
            agregarEvento(0, "Hongo: la combinación de temperatura y humedad no permite el crecimiento.");
        }
    }

    private void registrarCrecimiento(Inicio.Estado estado, double fraccion) {
        if (!crecimientoRegistrado && estado.masa() > configuracion.masaInicial()) {
            crecimientoRegistrado = true;
            agregarEvento(estado.dias(), String.format("Hongo: comenzó a crecer. Biomasa actual: %.4g kg.", estado.masa()));
        }
        while (siguienteHito < HITOS_BIOMASA.length && fraccion >= HITOS_BIOMASA[siguienteHito] / 100.0) {
            int hito = HITOS_BIOMASA[siguienteHito++];
            agregarEvento(estado.dias(), String.format("Hongo: alcanzó el %d %% de la capacidad. Biomasa actual: %.4g kg.",
                    hito, estado.masa()));
        }
    }

    @Override
    public void dispose() {
        refresco.stop();
        if (simulacion != null) {
            simulacion.detener();
        }
        super.dispose();
    }

    private void dibujarHonguitosEnMapa() {
        ImageIcon mapa = (ImageIcon) jLabel21.getIcon();
        SpriteHonguito honguito = new SpriteHonguito();
        int columnas = 2;
        int filas = 4;
        int tamanoMaximo = 28;
        double[][] posiciones = new double[columnas * filas][2];
        ThreadLocalRandom azar = ThreadLocalRandom.current();
        for (double[] posicion : posiciones) {
            posicion[0] = azar.nextDouble();
            posicion[1] = azar.nextDouble();
        }

        FondoEscalable mapaEscalable = new FondoEscalable(mapa, 0.5, 0.5) {
            @Override
            protected void pintarPrimerPlano(Graphics2D g2) {
                int anchoZona = getWidth() / columnas;
                int altoZona = getHeight() / filas;
                int margen = 4;
                int limite = Math.min(tamanoMaximo, Math.min(anchoZona, altoZona) - 2 * margen);
                if (limite <= 0) {
                    return;
                }

                double proporcion = honguito.getProporcion();
                int ancho = Math.max(1, (int) Math.round(limite * Math.min(1, proporcion)));
                int alto = Math.max(1, (int) Math.round(limite / Math.max(1, proporcion)));
                // Un honguito por zona para repartirlos sin superponerlos.
                for (int i = 0; i < posiciones.length; i++) {
                    int px = (i % columnas) * anchoZona + margen
                            + (int) Math.round(posiciones[i][0] * (anchoZona - ancho - 2 * margen));
                    int py = (i / columnas) * altoZona + margen
                            + (int) Math.round(posiciones[i][1] * (altoZona - alto - 2 * margen));
                    honguito.dibujar(g2, px, py, ancho, alto, 1);
                }
            }
        };
        mapaEscalable.setPreferredSize(new Dimension(mapa.getIconWidth(), 0));
        panelRedondeado6.remove(jLabel21);
        panelRedondeado6.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel16.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        panelRedondeado6.add(mapaEscalable, BorderLayout.CENTER);
    }
    
    private void ajustarColumnaDerecha() {
        panelCentro.remove(panelDerecho);
        JScrollPane desplazamiento = new JScrollPane(panelDerecho,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        desplazamiento.setBorder(BorderFactory.createEmptyBorder());
        desplazamiento.setOpaque(false);
        desplazamiento.getViewport().setOpaque(false);
        desplazamiento.getVerticalScrollBar().setUnitIncrement(16);
        Dimension preferido = panelDerecho.getPreferredSize();
        int anchoBarra = desplazamiento.getVerticalScrollBar().getPreferredSize().width;
        desplazamiento.setPreferredSize(new Dimension(preferido.width + anchoBarra, 0));
        panelCentro.add(desplazamiento, BorderLayout.LINE_END);
    }

    private void agregarEvento(String mensaje) {
        agregarEvento(simulacion.getEstado().dias(), mensaje);
    }

    private void agregarEvento(double dias, String mensaje) {
        txtEventos.append(String.format("Día %.2f: %s%n", dias, mensaje));
        txtEventos.setCaretPosition(txtEventos.getDocument().getLength());
    }


 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        panelCentro = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        panelRedondeado1 = new Panel.PanelRedondeado();
        lblarriba = new javax.swing.JLabel();
        panelIzquierdo = new javax.swing.JPanel();
        panelTiempo = new javax.swing.JPanel();
        panelRedondeado5 = new Panel.PanelRedondeado();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelMapa = new javax.swing.JPanel();
        panelRedondeado6 = new Panel.PanelRedondeado();
        jPanel16 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        panelCentral = new javax.swing.JPanel();
        panelRedondeado2 = new Panel.PanelRedondeado();
        jLabel8 = new javax.swing.JLabel();
        panelDerecho = new javax.swing.JPanel();
        panelEstado = new javax.swing.JPanel();
        panelRedondeado13 = new Panel.PanelRedondeado();
        jLabel7 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        barraSaludHongo = new Panel.BarraProgresoRedondeada();
        lblPorcentajeHongo = new javax.swing.JLabel();
        panelCondiciones = new javax.swing.JPanel();
        panelRedondeado12 = new Panel.PanelRedondeado();
        jPanel19 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        panelRedondeado19 = new Panel.PanelRedondeado();
        jPanel27 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        panelRedondeado20 = new Panel.PanelRedondeado();
        jLabel38 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        panelRedondeado21 = new Panel.PanelRedondeado();
        jLabel39 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        panelRedondeado24 = new Panel.PanelRedondeado();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        panelRedondeado25 = new Panel.PanelRedondeado();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        panelAbajo = new javax.swing.JPanel();
        panelRedondeado4 = new Panel.PanelRedondeado();
        panelRedondeado8 = new Panel.PanelRedondeado();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelVelocidad = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sliderVelocidad = new javax.swing.JSlider();
        jLabel19 = new javax.swing.JLabel();
        panelRedondeado7 = new Panel.PanelRedondeado();
        panelEventos = new Panel.PanelRedondeado();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEventos = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(177, 250, 146));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        panelCentro.setBackground(new java.awt.Color(236, 255, 211));
        panelCentro.setForeground(new java.awt.Color(177, 250, 146));
        panelCentro.setOpaque(false);
        panelCentro.setLayout(new java.awt.BorderLayout(5, 5));

        panelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        panelTitulo.setOpaque(false);
        panelTitulo.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado1.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado1.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        panelRedondeado1.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado1.setOpaque(true);
        panelRedondeado1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblarriba.setBackground(new java.awt.Color(255, 255, 255));
        lblarriba.setFont(new java.awt.Font("Nunito", 1, 36)); // NOI18N
        lblarriba.setForeground(new java.awt.Color(105, 84, 96));
        lblarriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hongo60x60.png"))); // NOI18N
        lblarriba.setText("Simulador de Ecosistema Fungico");
        panelRedondeado1.add(lblarriba);

        panelTitulo.add(panelRedondeado1);

        panelCentro.add(panelTitulo, java.awt.BorderLayout.NORTH);

        panelIzquierdo.setBackground(new java.awt.Color(255, 255, 255));
        panelIzquierdo.setOpaque(false);
        panelIzquierdo.setLayout(new java.awt.BorderLayout(5, 5));

        panelTiempo.setBackground(new java.awt.Color(236, 255, 211));
        panelTiempo.setOpaque(false);
        panelTiempo.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado5.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRedondeado5.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado5.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendario.png"))); // NOI18N
        jPanel13.add(jLabel3, java.awt.BorderLayout.CENTER);

        panelRedondeado5.add(jPanel13, java.awt.BorderLayout.WEST);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.GridLayout(2, 0));

        jLabel4.setFont(new java.awt.Font("Nunito", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(105, 84, 80));
        jLabel4.setText("Tiempo:");
        jPanel14.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Nunito", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(174, 146, 121));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dia ...");
        jPanel14.add(jLabel5);

        panelRedondeado5.add(jPanel14, java.awt.BorderLayout.CENTER);

        panelTiempo.add(panelRedondeado5);

        panelIzquierdo.add(panelTiempo, java.awt.BorderLayout.PAGE_START);

        panelMapa.setBackground(new java.awt.Color(236, 255, 211));
        panelMapa.setForeground(new java.awt.Color(0, 0, 0));
        panelMapa.setOpaque(false);
        panelMapa.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado6.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado6.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado6.setColorBorde(new java.awt.Color(73, 230, 7));
        panelRedondeado6.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado6.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setOpaque(false);
        jPanel16.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(105, 84, 80));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mapa.png"))); // NOI18N
        jLabel6.setText("Mapa del Ecosistema:");
        jPanel16.add(jLabel6);

        panelRedondeado6.add(jPanel16, java.awt.BorderLayout.NORTH);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mapa_256x564.png"))); // NOI18N
        jLabel21.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jLabel21ComponentResized(evt);
            }
        });
        panelRedondeado6.add(jLabel21, java.awt.BorderLayout.CENTER);

        panelMapa.add(panelRedondeado6);

        panelIzquierdo.add(panelMapa, java.awt.BorderLayout.CENTER);

        panelCentro.add(panelIzquierdo, java.awt.BorderLayout.WEST);

        panelCentral.setBackground(new java.awt.Color(236, 255, 211));
        panelCentral.setOpaque(false);
        panelCentral.setPreferredSize(new java.awt.Dimension(650, 500));
        panelCentral.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado2.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado2.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado2.setPreferredSize(new java.awt.Dimension(650, 500));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tronco caído en bosque soleado.png"))); // NOI18N
        panelRedondeado2.add(jLabel8);

        panelCentral.add(panelRedondeado2);

        panelCentro.add(panelCentral, java.awt.BorderLayout.CENTER);

        panelDerecho.setBackground(new java.awt.Color(102, 255, 204));
        panelDerecho.setOpaque(false);
        panelDerecho.setLayout(new java.awt.BorderLayout(0, 8));

        panelEstado.setBackground(new java.awt.Color(236, 255, 211));
        panelEstado.setOpaque(false);
        panelEstado.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado13.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado13.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado13.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado13.setLayout(new java.awt.BorderLayout(0, 8));

        jLabel7.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(105, 84, 80));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cruz.png"))); // NOI18N
        jLabel7.setText("Estado del Hongo:");
        panelRedondeado13.add(jLabel7, java.awt.BorderLayout.NORTH);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.BorderLayout(8, 0));

        barraSaludHongo.setPreferredSize(new java.awt.Dimension(150, 28));
        jPanel18.add(barraSaludHongo, java.awt.BorderLayout.CENTER);

        lblPorcentajeHongo.setBackground(new java.awt.Color(255, 255, 255));
        lblPorcentajeHongo.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        lblPorcentajeHongo.setForeground(new java.awt.Color(174, 146, 121));
        lblPorcentajeHongo.setText("000");
        jPanel18.add(lblPorcentajeHongo, java.awt.BorderLayout.EAST);

        panelRedondeado13.add(jPanel18, java.awt.BorderLayout.CENTER);

        panelEstado.add(panelRedondeado13);

        panelDerecho.add(panelEstado, java.awt.BorderLayout.PAGE_START);

        panelCondiciones.setBackground(new java.awt.Color(236, 255, 211));
        panelCondiciones.setOpaque(false);

        panelRedondeado12.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado12.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado12.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado12.setLayout(new java.awt.BorderLayout(0, 8));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.BorderLayout());

        jLabel18.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(105, 84, 80));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hoja.png"))); // NOI18N
        jLabel18.setText("Condiciones del Ambiente:");
        jPanel19.add(jLabel18, java.awt.BorderLayout.CENTER);

        panelRedondeado12.add(jPanel19, java.awt.BorderLayout.NORTH);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setOpaque(false);
        jPanel20.setLayout(new java.awt.BorderLayout(0, 16));

        panelRedondeado19.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado19.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado19.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado19.setLayout(new java.awt.GridLayout(4, 0));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setOpaque(false);
        jPanel27.setLayout(new java.awt.BorderLayout());

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Termometro.png"))); // NOI18N
        jPanel27.add(jLabel30, java.awt.BorderLayout.WEST);

        panelRedondeado20.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado20.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado20.setMinimumSize(new java.awt.Dimension(0, 0));
        panelRedondeado20.setPreferredSize(new java.awt.Dimension(150, 45));
        panelRedondeado20.setLayout(new java.awt.BorderLayout());

        jLabel38.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(105, 84, 80));
        jLabel38.setText("Temperatura:");
        panelRedondeado20.add(jLabel38, java.awt.BorderLayout.NORTH);

        jLabel31.setFont(new java.awt.Font("Nunito", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(105, 84, 80));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("00°C");
        jLabel31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRedondeado20.add(jLabel31, java.awt.BorderLayout.CENTER);

        jPanel27.add(panelRedondeado20, java.awt.BorderLayout.CENTER);

        panelRedondeado19.add(jPanel27);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setOpaque(false);
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gota.png"))); // NOI18N
        jPanel28.add(jLabel32, java.awt.BorderLayout.WEST);

        panelRedondeado21.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado21.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado21.setLayout(new java.awt.BorderLayout());

        jLabel39.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(105, 84, 80));
        jLabel39.setText("Humedad:");
        panelRedondeado21.add(jLabel39, java.awt.BorderLayout.NORTH);

        jLabel33.setFont(new java.awt.Font("Nunito", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(105, 84, 80));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("00%");
        panelRedondeado21.add(jLabel33, java.awt.BorderLayout.CENTER);

        jPanel28.add(panelRedondeado21, java.awt.BorderLayout.CENTER);

        panelRedondeado19.add(jPanel28);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setOpaque(false);
        jPanel31.setLayout(new java.awt.BorderLayout());

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Masa.png"))); // NOI18N
        jPanel31.add(jLabel42, java.awt.BorderLayout.WEST);

        panelRedondeado24.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado24.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado24.setLayout(new java.awt.BorderLayout());

        jLabel43.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(105, 84, 80));
        jLabel43.setText("Masa inicial:");
        panelRedondeado24.add(jLabel43, java.awt.BorderLayout.NORTH);

        jLabel44.setFont(new java.awt.Font("Nunito", 0, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(105, 84, 80));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Moderada");
        panelRedondeado24.add(jLabel44, java.awt.BorderLayout.CENTER);

        jPanel31.add(panelRedondeado24, java.awt.BorderLayout.CENTER);

        panelRedondeado19.add(jPanel31);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setOpaque(false);
        jPanel32.setLayout(new java.awt.BorderLayout());

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rayo.png"))); // NOI18N
        jPanel32.add(jLabel45, java.awt.BorderLayout.WEST);

        panelRedondeado25.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado25.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado25.setLayout(new java.awt.BorderLayout());

        jLabel47.setFont(new java.awt.Font("Nunito", 0, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(105, 84, 80));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Moderada");
        panelRedondeado25.add(jLabel47, java.awt.BorderLayout.CENTER);

        jLabel46.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(105, 84, 80));
        jLabel46.setText("Capacidad: ");
        panelRedondeado25.add(jLabel46, java.awt.BorderLayout.NORTH);

        jPanel32.add(panelRedondeado25, java.awt.BorderLayout.CENTER);

        panelRedondeado19.add(jPanel32);

        jPanel20.add(panelRedondeado19, java.awt.BorderLayout.CENTER);

        panelRedondeado12.add(jPanel20, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout panelCondicionesLayout = new javax.swing.GroupLayout(panelCondiciones);
        panelCondiciones.setLayout(panelCondicionesLayout);
        panelCondicionesLayout.setHorizontalGroup(
            panelCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCondicionesLayout.setVerticalGroup(
            panelCondicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelDerecho.add(panelCondiciones, java.awt.BorderLayout.CENTER);

        panelCentro.add(panelDerecho, java.awt.BorderLayout.LINE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.55;
        panelPrincipal.add(panelCentro, gridBagConstraints);

        panelAbajo.setBackground(new java.awt.Color(255, 255, 255));
        panelAbajo.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 0, 0));
        panelAbajo.setOpaque(false);
        panelAbajo.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado4.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado4.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado4.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado4.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado4.setLayout(new java.awt.GridLayout(3, 0, 0, 16));

        panelRedondeado8.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado8.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 8));
        panelRedondeado8.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado8.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado8.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(105, 84, 80));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rueda dentada.png"))); // NOI18N
        jLabel1.setText("Controles:");
        panelRedondeado8.add(jLabel1, java.awt.BorderLayout.CENTER);

        panelRedondeado4.add(panelRedondeado8);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 16, 0));

        jButton1.setBackground(new java.awt.Color(177, 250, 146));
        jButton1.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(105, 84, 80));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Play.png"))); // NOI18N
        jButton1.setText("Inicio");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 230, 7), 2, true));
        jButton1.setFocusable(false);
        jPanel2.add(jButton1);

        jButton2.setBackground(new java.awt.Color(253, 228, 210));
        jButton2.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(105, 84, 80));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pausa.png"))); // NOI18N
        jButton2.setText("Pausa");
        jButton2.setToolTipText("");
        jButton2.setFocusable(false);
        jPanel2.add(jButton2);

        jButton3.setBackground(new java.awt.Color(253, 228, 210));
        jButton3.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(105, 84, 80));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actualizar flecha.png"))); // NOI18N
        jButton3.setText("Reiniciar");
        jButton3.setFocusable(false);
        jPanel2.add(jButton3);

        panelRedondeado4.add(jPanel2);

        panelVelocidad.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 8));
        panelVelocidad.setOpaque(false);
        panelVelocidad.setPreferredSize(new java.awt.Dimension(300, 100));
        panelVelocidad.setLayout(new java.awt.BorderLayout(8, 0));

        jLabel2.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(105, 84, 80));
        jLabel2.setText("Velocidad:");
        panelVelocidad.add(jLabel2, java.awt.BorderLayout.LINE_START);

        sliderVelocidad.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        sliderVelocidad.setForeground(new java.awt.Color(105, 84, 80));
        sliderVelocidad.setMajorTickSpacing(1);
        sliderVelocidad.setMaximum(5);
        sliderVelocidad.setMinimum(1);
        sliderVelocidad.setPaintTicks(true);
        sliderVelocidad.setValue(1);
        sliderVelocidad.setOpaque(false);
        panelVelocidad.add(sliderVelocidad, java.awt.BorderLayout.CENTER);

        jLabel19.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(105, 84, 80));
        jLabel19.setText("x1");
        panelVelocidad.add(jLabel19, java.awt.BorderLayout.LINE_END);

        panelRedondeado4.add(panelVelocidad);

        panelAbajo.add(panelRedondeado4);

        panelRedondeado7.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado7.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        panelRedondeado7.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado7.setMinimumSize(new java.awt.Dimension(280, 150));
        panelRedondeado7.setPreferredSize(new java.awt.Dimension(300, 180));
        panelRedondeado7.setLayout(new java.awt.GridLayout(1, 0));

        panelEventos.setBackground(new java.awt.Color(207, 255, 187));
        panelEventos.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        panelEventos.setColorFondo(new java.awt.Color(255, 255, 255));
        panelEventos.setLayout(new java.awt.BorderLayout());

        jLabel20.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(105, 84, 80));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lista.png"))); // NOI18N
        jLabel20.setText("Eventos Recientes:");
        panelEventos.add(jLabel20, java.awt.BorderLayout.NORTH);

        txtEventos.setColumns(20);
        txtEventos.setLineWrap(true);
        txtEventos.setRows(7);
        txtEventos.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtEventos);

        panelEventos.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelRedondeado7.add(panelEventos);

        panelAbajo.add(panelRedondeado7);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.45;
        panelPrincipal.add(panelAbajo, gridBagConstraints);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel21ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel21ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21ComponentResized


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Panel.BarraProgresoRedondeada barraSaludHongo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPorcentajeHongo;
    private javax.swing.JLabel lblarriba;
    private javax.swing.JPanel panelAbajo;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelCondiciones;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelEstado;
    private Panel.PanelRedondeado panelEventos;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JPanel panelMapa;
    private javax.swing.JPanel panelPrincipal;
    private Panel.PanelRedondeado panelRedondeado1;
    private Panel.PanelRedondeado panelRedondeado12;
    private Panel.PanelRedondeado panelRedondeado13;
    private Panel.PanelRedondeado panelRedondeado19;
    private Panel.PanelRedondeado panelRedondeado2;
    private Panel.PanelRedondeado panelRedondeado20;
    private Panel.PanelRedondeado panelRedondeado21;
    private Panel.PanelRedondeado panelRedondeado24;
    private Panel.PanelRedondeado panelRedondeado25;
    private Panel.PanelRedondeado panelRedondeado4;
    private Panel.PanelRedondeado panelRedondeado5;
    private Panel.PanelRedondeado panelRedondeado6;
    private Panel.PanelRedondeado panelRedondeado7;
    private Panel.PanelRedondeado panelRedondeado8;
    private javax.swing.JPanel panelTiempo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JPanel panelVelocidad;
    private javax.swing.JSlider sliderVelocidad;
    private javax.swing.JTextArea txtEventos;
    // End of variables declaration//GEN-END:variables
}
