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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelRedondeado2 = new Panel.PanelRedondeado();
        jPanel3 = new javax.swing.JPanel();
        panelRedondeado1 = new Panel.PanelRedondeado();
        lblarriba = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        panelRedondeado13 = new Panel.PanelRedondeado();
        jPanel17 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        barraSaludHongo = new Panel.BarraProgresoRedondeada();
        lblPorcentajeHongo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        panelRedondeado12 = new Panel.PanelRedondeado();
        jPanel19 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        panelRedondeado18 = new Panel.PanelRedondeado();
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
        jPanel29 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        panelRedondeado22 = new Panel.PanelRedondeado();
        jLabel40 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        panelRedondeado23 = new Panel.PanelRedondeado();
        jLabel41 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        panelRedondeado6 = new Panel.PanelRedondeado();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        panelRedondeado5 = new Panel.PanelRedondeado();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        panelRedondeado4 = new Panel.PanelRedondeado();
        panelRedondeado8 = new Panel.PanelRedondeado();
        jLabel1 = new javax.swing.JLabel();
        panelRedondeado9 = new Panel.PanelRedondeado();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelRedondeado11 = new Panel.PanelRedondeado();
        jLabel2 = new javax.swing.JLabel();
        sliderVelocidad = new javax.swing.JSlider();
        jLabel19 = new javax.swing.JLabel();
        panelRedondeado7 = new Panel.PanelRedondeado();
        panelRedondeado10 = new Panel.PanelRedondeado();
        panelRedondeado14 = new Panel.PanelRedondeado();
        jLabel20 = new javax.swing.JLabel();
        panelRedondeado15 = new Panel.PanelRedondeado();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEventos = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(236, 255, 211));
        jPanel1.setForeground(new java.awt.Color(177, 250, 146));
        jPanel1.setLayout(new java.awt.BorderLayout(5, 5));

        jPanel2.setBackground(new java.awt.Color(236, 255, 211));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 650));

        panelRedondeado2.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado2.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado2.setPreferredSize(new java.awt.Dimension(650, 650));

        javax.swing.GroupLayout panelRedondeado2Layout = new javax.swing.GroupLayout(panelRedondeado2);
        panelRedondeado2.setLayout(panelRedondeado2Layout);
        panelRedondeado2Layout.setHorizontalGroup(
            panelRedondeado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRedondeado2Layout.setVerticalGroup(
            panelRedondeado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado2, javax.swing.GroupLayout.DEFAULT_SIZE, 2148, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        panelRedondeado1.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado1.setColorFondo(new java.awt.Color(255, 255, 255));

        lblarriba.setBackground(new java.awt.Color(255, 255, 255));
        lblarriba.setFont(new java.awt.Font("Nunito", 1, 36)); // NOI18N
        lblarriba.setForeground(new java.awt.Color(105, 84, 96));
        lblarriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hongo60x60.png"))); // NOI18N
        lblarriba.setText("Simulador de Ecosistema Fungico");

        javax.swing.GroupLayout panelRedondeado1Layout = new javax.swing.GroupLayout(panelRedondeado1);
        panelRedondeado1.setLayout(panelRedondeado1Layout);
        panelRedondeado1Layout.setHorizontalGroup(
            panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2778, Short.MAX_VALUE)
            .addGroup(panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRedondeado1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblarriba, javax.swing.GroupLayout.DEFAULT_SIZE, 2766, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelRedondeado1Layout.setVerticalGroup(
            panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRedondeado1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblarriba, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel3.add(panelRedondeado1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(102, 255, 204));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(236, 255, 211));

        panelRedondeado13.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado13.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado13.setLayout(new java.awt.BorderLayout());

        jPanel17.setOpaque(false);
        jPanel17.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(105, 84, 80));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cruz.png"))); // NOI18N
        jLabel7.setText("Estado del Hongo:");
        jPanel17.add(jLabel7, java.awt.BorderLayout.CENTER);

        jLabel8.setText(".");
        jPanel17.add(jLabel8, java.awt.BorderLayout.NORTH);

        jLabel9.setText(".");
        jPanel17.add(jLabel9, java.awt.BorderLayout.SOUTH);

        jLabel10.setForeground(new java.awt.Color(236, 255, 211));
        jLabel10.setText("...");
        jPanel17.add(jLabel10, java.awt.BorderLayout.WEST);

        panelRedondeado13.add(jPanel17, java.awt.BorderLayout.NORTH);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.BorderLayout());

        barraSaludHongo.setValue(0);
        barraSaludHongo.setPreferredSize(new java.awt.Dimension(150, 26));
        jPanel18.add(barraSaludHongo, java.awt.BorderLayout.CENTER);

        lblPorcentajeHongo.setBackground(new java.awt.Color(255, 255, 255));
        lblPorcentajeHongo.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        lblPorcentajeHongo.setForeground(new java.awt.Color(174, 146, 121));
        lblPorcentajeHongo.setText("000");
        jPanel18.add(lblPorcentajeHongo, java.awt.BorderLayout.EAST);

        jLabel17.setText(".");
        jPanel18.add(jLabel17, java.awt.BorderLayout.SOUTH);

        panelRedondeado13.add(jPanel18, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel12.setBackground(new java.awt.Color(236, 255, 211));

        panelRedondeado12.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado12.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado12.setLayout(new java.awt.BorderLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.BorderLayout());

        jLabel18.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(105, 84, 80));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hoja.png"))); // NOI18N
        jLabel18.setText("Condiciones del Ambiente:");
        jPanel19.add(jLabel18, java.awt.BorderLayout.CENTER);

        jLabel23.setText(".");
        jPanel19.add(jLabel23, java.awt.BorderLayout.NORTH);

        jLabel24.setText("..");
        jPanel19.add(jLabel24, java.awt.BorderLayout.WEST);

        jLabel25.setText("..");
        jPanel19.add(jLabel25, java.awt.BorderLayout.EAST);

        panelRedondeado12.add(jPanel19, java.awt.BorderLayout.NORTH);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setOpaque(false);
        jPanel20.setLayout(new java.awt.BorderLayout());

        panelRedondeado18.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado18.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado18.setLayout(new java.awt.BorderLayout());

        panelRedondeado19.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado19.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado19.setLayout(new java.awt.GridLayout(4, 0));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setOpaque(false);
        jPanel27.setLayout(new java.awt.BorderLayout());

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Termometro.png"))); // NOI18N
        jPanel27.add(jLabel30, java.awt.BorderLayout.WEST);

        panelRedondeado20.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado20.setMinimumSize(new java.awt.Dimension(0, 0));
        panelRedondeado20.setPreferredSize(new java.awt.Dimension(150, 45));
        panelRedondeado20.setLayout(new java.awt.BorderLayout());

        jLabel38.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(105, 84, 80));
        jLabel38.setText("Temperatura:");
        panelRedondeado20.add(jLabel38, java.awt.BorderLayout.CENTER);

        jPanel27.add(panelRedondeado20, java.awt.BorderLayout.CENTER);

        jLabel31.setFont(new java.awt.Font("Nunito", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(105, 84, 80));
        jLabel31.setText("00°C");
        jPanel27.add(jLabel31, java.awt.BorderLayout.EAST);

        panelRedondeado19.add(jPanel27);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setOpaque(false);
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gota.png"))); // NOI18N
        jPanel28.add(jLabel32, java.awt.BorderLayout.WEST);

        panelRedondeado21.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado21.setLayout(new java.awt.BorderLayout());

        jLabel39.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(105, 84, 80));
        jLabel39.setText("Humedad:");
        panelRedondeado21.add(jLabel39, java.awt.BorderLayout.CENTER);

        jPanel28.add(panelRedondeado21, java.awt.BorderLayout.CENTER);

        jLabel33.setFont(new java.awt.Font("Nunito", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(105, 84, 80));
        jLabel33.setText("00%");
        jPanel28.add(jLabel33, java.awt.BorderLayout.EAST);

        panelRedondeado19.add(jPanel28);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setOpaque(false);
        jPanel29.setLayout(new java.awt.BorderLayout());

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sol.png"))); // NOI18N
        jPanel29.add(jLabel34, java.awt.BorderLayout.WEST);

        panelRedondeado22.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado22.setLayout(new java.awt.BorderLayout());

        jLabel40.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(105, 84, 80));
        jLabel40.setText("Luz:");
        panelRedondeado22.add(jLabel40, java.awt.BorderLayout.CENTER);

        jPanel29.add(panelRedondeado22, java.awt.BorderLayout.CENTER);

        jLabel35.setFont(new java.awt.Font("Nunito", 0, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(105, 84, 80));
        jLabel35.setText("Baja");
        jPanel29.add(jLabel35, java.awt.BorderLayout.EAST);

        panelRedondeado19.add(jPanel29);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setOpaque(false);
        jPanel30.setLayout(new java.awt.BorderLayout());

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Viento.png"))); // NOI18N
        jPanel30.add(jLabel36, java.awt.BorderLayout.WEST);

        panelRedondeado23.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado23.setLayout(new java.awt.BorderLayout());

        jLabel41.setFont(new java.awt.Font("Nunito", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(105, 84, 80));
        jLabel41.setText("Ventilación:");
        panelRedondeado23.add(jLabel41, java.awt.BorderLayout.CENTER);

        jPanel30.add(panelRedondeado23, java.awt.BorderLayout.CENTER);

        jLabel37.setFont(new java.awt.Font("Nunito", 0, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(105, 84, 80));
        jLabel37.setText("Moderada");
        jPanel30.add(jLabel37, java.awt.BorderLayout.EAST);

        panelRedondeado19.add(jPanel30);

        panelRedondeado18.add(panelRedondeado19, java.awt.BorderLayout.CENTER);

        jPanel20.add(panelRedondeado18, java.awt.BorderLayout.CENTER);

        jLabel26.setText(".");
        jPanel20.add(jLabel26, java.awt.BorderLayout.NORTH);

        jLabel27.setText(".");
        jPanel20.add(jLabel27, java.awt.BorderLayout.SOUTH);

        jLabel28.setText("..");
        jPanel20.add(jLabel28, java.awt.BorderLayout.WEST);

        jLabel29.setText("..");
        jPanel20.add(jLabel29, java.awt.BorderLayout.EAST);

        panelRedondeado12.add(jPanel20, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, java.awt.BorderLayout.LINE_END);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout(5, 5));

        jPanel9.setBackground(new java.awt.Color(236, 255, 211));
        jPanel9.setForeground(new java.awt.Color(0, 0, 0));

        panelRedondeado6.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado6.setColorBorde(new java.awt.Color(73, 230, 7));
        panelRedondeado6.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado6.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setOpaque(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelRedondeado6.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setOpaque(false);
        jPanel16.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(105, 84, 80));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mapa.png"))); // NOI18N
        jLabel6.setText("Mapa del Ecosistema:");
        jPanel16.add(jLabel6, java.awt.BorderLayout.CENTER);

        jLabel14.setText(".");
        jPanel16.add(jLabel14, java.awt.BorderLayout.NORTH);

        jLabel15.setText(".");
        jPanel16.add(jLabel15, java.awt.BorderLayout.SOUTH);

        jLabel16.setText("..");
        jPanel16.add(jLabel16, java.awt.BorderLayout.WEST);

        panelRedondeado6.add(jPanel16, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel10.setBackground(new java.awt.Color(236, 255, 211));
        jPanel10.setLayout(new java.awt.BorderLayout());

        panelRedondeado5.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado5.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado5.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendario.png"))); // NOI18N
        jPanel13.add(jLabel3, java.awt.BorderLayout.CENTER);

        jLabel11.setText(".");
        jPanel13.add(jLabel11, java.awt.BorderLayout.NORTH);

        jLabel12.setText(".");
        jPanel13.add(jLabel12, java.awt.BorderLayout.SOUTH);

        jLabel13.setText("..");
        jLabel13.setToolTipText("");
        jPanel13.add(jLabel13, java.awt.BorderLayout.WEST);

        panelRedondeado5.add(jPanel13, java.awt.BorderLayout.WEST);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(105, 84, 80));
        jLabel4.setText("Tiempo:");
        jPanel14.add(jLabel4, java.awt.BorderLayout.NORTH);

        jLabel5.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(174, 146, 121));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dia ...");
        jPanel14.add(jLabel5, java.awt.BorderLayout.CENTER);

        panelRedondeado5.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel10.add(panelRedondeado5, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel6, java.awt.BorderLayout.WEST);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        panelRedondeado4.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado4.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado4.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado4.setLayout(new java.awt.GridLayout(3, 0));

        panelRedondeado8.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado8.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado8.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado8.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(105, 84, 80));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rueda dentada.png"))); // NOI18N
        jLabel1.setText("Controles:");
        panelRedondeado8.add(jLabel1, java.awt.BorderLayout.CENTER);

        panelRedondeado4.add(panelRedondeado8);

        panelRedondeado9.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado9.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado9.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado9.setLayout(new java.awt.GridLayout(1, 3));

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

        panelRedondeado4.add(panelRedondeado9);

        panelRedondeado11.setBackground(new java.awt.Color(207, 255, 187));
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

        jPanel7.add(panelRedondeado4);

        panelRedondeado7.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado7.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado7.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado7.setLayout(new java.awt.BorderLayout());

        panelRedondeado10.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado10.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado10.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado10.setLayout(new java.awt.BorderLayout());

        panelRedondeado14.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado14.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado14.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado14.setLayout(new java.awt.BorderLayout());

        jLabel20.setFont(new java.awt.Font("Nunito", 1, 22)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(105, 84, 80));
        jLabel20.setText("Eventos Recientes:");
        panelRedondeado14.add(jLabel20, java.awt.BorderLayout.NORTH);

        panelRedondeado10.add(panelRedondeado14, java.awt.BorderLayout.NORTH);

        panelRedondeado15.setBackground(new java.awt.Color(207, 255, 187));
        panelRedondeado15.setColorFondo(new java.awt.Color(255, 255, 255));
        panelRedondeado15.setPreferredSize(new java.awt.Dimension(300, 100));
        panelRedondeado15.setLayout(new java.awt.BorderLayout());

        txtEventos.setEditable(false);
        txtEventos.setBackground(new java.awt.Color(255, 253, 247));
        txtEventos.setColumns(20);
        txtEventos.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        txtEventos.setForeground(new java.awt.Color(105, 84, 80));
        txtEventos.setLineWrap(true);
        txtEventos.setRows(5);
        txtEventos.setWrapStyleWord(true);
        txtEventos.setBorder(null);
        jScrollPane1.setViewportView(txtEventos);

        panelRedondeado15.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelRedondeado10.add(panelRedondeado15, java.awt.BorderLayout.CENTER);

        panelRedondeado7.add(panelRedondeado10, java.awt.BorderLayout.CENTER);

        jPanel7.add(panelRedondeado7);

        jPanel1.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
        );

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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPorcentajeHongo;
    private javax.swing.JLabel lblarriba;
    private Panel.PanelRedondeado panelRedondeado1;
    private Panel.PanelRedondeado panelRedondeado10;
    private Panel.PanelRedondeado panelRedondeado11;
    private Panel.PanelRedondeado panelRedondeado12;
    private Panel.PanelRedondeado panelRedondeado13;
    private Panel.PanelRedondeado panelRedondeado14;
    private Panel.PanelRedondeado panelRedondeado15;
    private Panel.PanelRedondeado panelRedondeado18;
    private Panel.PanelRedondeado panelRedondeado19;
    private Panel.PanelRedondeado panelRedondeado2;
    private Panel.PanelRedondeado panelRedondeado20;
    private Panel.PanelRedondeado panelRedondeado21;
    private Panel.PanelRedondeado panelRedondeado22;
    private Panel.PanelRedondeado panelRedondeado23;
    private Panel.PanelRedondeado panelRedondeado4;
    private Panel.PanelRedondeado panelRedondeado5;
    private Panel.PanelRedondeado panelRedondeado6;
    private Panel.PanelRedondeado panelRedondeado7;
    private Panel.PanelRedondeado panelRedondeado8;
    private Panel.PanelRedondeado panelRedondeado9;
    private javax.swing.JSlider sliderVelocidad;
    private javax.swing.JTextArea txtEventos;
    // End of variables declaration//GEN-END:variables
}
