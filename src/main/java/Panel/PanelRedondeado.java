package Panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelRedondeado extends JPanel {

    private int radio = 30;
    private Color colorFondo = Color.decode("#EBDABA");
    private Color colorBorde = Color.decode("#AE9279");
    private int grosorBorde = 2;

    public PanelRedondeado() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        int margen = Math.max(0, grosorBorde);
        int ancho = Math.max(0, getWidth() - margen);
        int alto = Math.max(0, getHeight() - margen);

        // Dibujar el fondo
        g2.setColor(colorFondo);
        g2.fillRoundRect(
            margen / 2,
            margen / 2,
            ancho,
            alto,
            radio,
            radio
        );

        // Dibujar el borde
        if (grosorBorde > 0) {
            g2.setColor(colorBorde);
            g2.setStroke(
                new java.awt.BasicStroke(grosorBorde)
            );

            g2.drawRoundRect(
                margen / 2,
                margen / 2,
                ancho,
                alto,
                radio,
                radio
            );
        }

        g2.dispose();
    }

    // Propiedad: radio
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = Math.max(0, radio);
        repaint();
    }

    // Propiedad: color de fondo
    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        if (colorFondo != null) {
            this.colorFondo = colorFondo;
            repaint();
        }
    }

    // Propiedad: color del borde
    public Color getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(Color colorBorde) {
        if (colorBorde != null) {
            this.colorBorde = colorBorde;
            repaint();
        }
    }

    // Propiedad: grosor del borde
    public int getGrosorBorde() {
        return grosorBorde;
    }

    public void setGrosorBorde(int grosorBorde) {
        this.grosorBorde = Math.max(0, grosorBorde);
        repaint();
    }
}
