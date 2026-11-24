package Guis;
import Panel.PanelRedondeado;
import javax.swing.*;


public class Principal extends javax.swing.JFrame {

 
    public Principal() {
        initComponents();
        barraSaludHongo.setValue(000);
        lblPorcentajeHongo.setText(
        barraSaludHongo.getValue() + "%");
        ImageIcon arreiba=new ImageIcon(getClass().getResource("/Hongo60x60.png"));
        lblarriba.setIcon(arreiba);
    }
    
    private void agregarEvento(int dia, String mensaje) {

        txtEventos.append(
            "Día " + dia + ": " + mensaje + "\n"
        );

        txtEventos.setCaretPosition(
        txtEventos.getDocument().getLength()
        );
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
        panelRedondeado9 = new Panel.PanelRedondeado();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelRedondeado11 = new Panel.PanelRedondeado();
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
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        panelCentro.setBackground(new java.awt.Color(236, 255, 211));
        panelCentro.setForeground(new java.awt.Color(177, 250, 146));
        panelCentro.setLayout(new java.awt.BorderLayout(5, 5));

        panelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        panelTitulo.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado1.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado1.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        panelRedondeado1.setColorFondo(new java.awt.Color(255, 255, 255));
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
        panelIzquierdo.setLayout(new java.awt.BorderLayout(5, 5));

        panelTiempo.setBackground(new java.awt.Color(236, 255, 211));
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

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mapa de Bosque.png"))); // NOI18N
        panelRedondeado6.add(jLabel21, java.awt.BorderLayout.CENTER);

        panelMapa.add(panelRedondeado6);

        panelIzquierdo.add(panelMapa, java.awt.BorderLayout.CENTER);

        panelCentro.add(panelIzquierdo, java.awt.BorderLayout.WEST);

        panelCentral.setBackground(new java.awt.Color(236, 255, 211));
        panelCentral.setPreferredSize(new java.awt.Dimension(650, 650));
        panelCentral.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado2.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado2.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado2.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado2.setPreferredSize(new java.awt.Dimension(650, 650));
        panelCentral.add(panelRedondeado2);

        panelCentro.add(panelCentral, java.awt.BorderLayout.CENTER);

        panelDerecho.setBackground(new java.awt.Color(102, 255, 204));
        panelDerecho.setOpaque(false);
        panelDerecho.setLayout(new java.awt.BorderLayout(0, 8));

        panelEstado.setBackground(new java.awt.Color(236, 255, 211));
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
        jPanel18.setLayout(new java.awt.BorderLayout());

        barraSaludHongo.setForeground(new java.awt.Color(255, 255, 255));
        barraSaludHongo.setValue(0);
        barraSaludHongo.setPreferredSize(new java.awt.Dimension(150, 26));
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
        gridBagConstraints.weighty = 0.6;
        panelPrincipal.add(panelCentro, gridBagConstraints);

        panelAbajo.setBackground(new java.awt.Color(255, 255, 255));
        panelAbajo.setOpaque(false);
        panelAbajo.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado4.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado4.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado4.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado4.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado4.setLayout(new java.awt.GridLayout(3, 0));

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

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado9.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado9.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado9.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado9.setLayout(new java.awt.GridLayout(1, 3, 16, 0));

        jButton1.setBackground(new java.awt.Color(177, 250, 146));
        jButton1.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(105, 84, 80));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Play.png"))); // NOI18N
        jButton1.setText("Inicio");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(73, 230, 7), 2, true));
        panelRedondeado9.add(jButton1);

        jButton2.setBackground(new java.awt.Color(253, 228, 210));
        jButton2.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(105, 84, 80));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pausa.png"))); // NOI18N
        jButton2.setText("Pausa");
        jButton2.setToolTipText("");
        panelRedondeado9.add(jButton2);

        jButton3.setBackground(new java.awt.Color(253, 228, 210));
        jButton3.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(105, 84, 80));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actualizar flecha.png"))); // NOI18N
        jButton3.setText("Reiniciar");
        panelRedondeado9.add(jButton3);

        jPanel2.add(panelRedondeado9);

        panelRedondeado4.add(jPanel2);

        panelRedondeado11.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 8));
        panelRedondeado11.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado11.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado11.setLayout(new java.awt.GridLayout(1, 3));

        jLabel2.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(105, 84, 80));
        jLabel2.setText("Velocidad:");
        panelRedondeado11.add(jLabel2);

        sliderVelocidad.setBackground(new java.awt.Color(255, 255, 255));
        sliderVelocidad.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        sliderVelocidad.setForeground(new java.awt.Color(105, 84, 80));
        sliderVelocidad.setMajorTickSpacing(1);
        sliderVelocidad.setMaximum(5);
        sliderVelocidad.setMinimum(1);
        sliderVelocidad.setValue(1);
        panelRedondeado11.add(sliderVelocidad);

        jLabel19.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(105, 84, 80));
        jLabel19.setText("X1");
        panelRedondeado11.add(jLabel19);

        panelRedondeado4.add(panelRedondeado11);

        panelAbajo.add(panelRedondeado4);

        panelRedondeado7.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado7.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelRedondeado7.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado7.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado7.setLayout(new java.awt.GridLayout(1, 0));

        panelEventos.setBackground(new java.awt.Color(207, 255, 187));
        panelEventos.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        panelEventos.setColorFondo(new java.awt.Color(255, 255, 255));
        panelEventos.setPreferredSize(new java.awt.Dimension(300, 100));
        panelEventos.setLayout(new java.awt.BorderLayout());

        jLabel20.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(105, 84, 80));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lista.png"))); // NOI18N
        jLabel20.setText("Eventos Recientes:");
        panelEventos.add(jLabel20, java.awt.BorderLayout.NORTH);

        txtEventos.setColumns(20);
        txtEventos.setRows(5);
        jScrollPane1.setViewportView(txtEventos);

        panelEventos.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelRedondeado7.add(panelEventos);

        panelAbajo.add(panelRedondeado7);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        panelPrincipal.add(panelAbajo, gridBagConstraints);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
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
    private Panel.PanelRedondeado panelRedondeado11;
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
    private Panel.PanelRedondeado panelRedondeado9;
    private javax.swing.JPanel panelTiempo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JSlider sliderVelocidad;
    private javax.swing.JTextArea txtEventos;
    // End of variables declaration//GEN-END:variables
}
