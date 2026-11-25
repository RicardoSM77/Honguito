package Panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JProgressBar;

public class BarraProgresoRedondeada extends JProgressBar {

    private Color colorProgreso = Color.decode("#71FF35");
    private Color colorFondo = Color.decode("#ECFFD3");
    private Color colorBorde = Color.decode("#AE9279");

    private int radio = 20;
    private int grosorBorde = 2;

    public BarraProgresoRedondeada() {
        super(0, 100);
        setValue(0);
        setOpaque(false);
        setBorderPainted(false);
        setStringPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        int ancho = getWidth();
        int alto = getHeight();

        int grosor = Math.max(0, grosorBorde);
        int margen = (int) Math.ceil(grosor / 2.0);

        int x = margen;
        int y = margen;
        int w = Math.max(0, ancho - 2 * margen - 1);
        int h = Math.max(0, alto - 2 * margen - 1);

        int arco = Math.min(radio, h);
        RoundRectangle2D pista = new RoundRectangle2D.Double(x, y, w, h, arco, arco);
        g2.setColor(colorFondo);
        g2.fill(pista);

        // Calcular porcentaje
        double porcentaje =
            (getMaximum() > getMinimum())
            ? (double)(getValue() - getMinimum())
              / (getMaximum() - getMinimum())
            : 0;

        porcentaje = Math.max(0, Math.min(1, porcentaje));

        // Relleno del progreso
        int progreso = (int) Math.round(w * porcentaje);

        if (progreso > 0) {
            Area relleno = new Area(pista);
            relleno.intersect(new Area(new Rectangle2D.Double(x, y, progreso, h)));
            g2.setColor(colorProgreso);
            g2.fill(relleno);
        }

        // Borde exterior
        if (grosor > 0) {
            g2.setColor(colorBorde);
            g2.setStroke(new BasicStroke(grosor));
            g2.draw(pista);
        }

        g2.dispose();
    }

    public Color getColorProgreso() {
        return colorProgreso;
    }

    public void setColorProgreso(Color color) {
        if (color != null) {
            colorProgreso = color;
            repaint();
        }
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color color) {
        if (color != null) {
            colorFondo = color;
            repaint();
        }
    }

    public Color getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(Color color) {
        if (color != null) {
            colorBorde = color;
            repaint();
        }
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = Math.max(0, radio);
        repaint();
    }

    public int getGrosorBorde() {
        return grosorBorde;
    }

    public void setGrosorBorde(int grosor) {
        grosorBorde = Math.max(0, grosor);
        repaint();
    }
}
