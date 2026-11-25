package Panel;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/** Dibuja el honguito sobre el tronco y lo escala según la biomasa simulada. */
public class EscenaCrecimiento extends FondoEscalable {
    private static final double BASE_X = 0.54;
    private static final double BASE_Y = 0.51;
    private static final double ALTURA_MAXIMA = 0.36;
    private static final double ESCALA_MINIMA = 0.14;

    private final SpriteHonguito hongo = new SpriteHonguito();
    private boolean iniciada;
    private double fraccion;

    public EscenaCrecimiento(ImageIcon fondo) {
        super(fondo, BASE_X, BASE_Y);
    }

    public void setFraccionDeCapacidad(double fraccion) {
        fraccion = Math.max(0, Math.min(1, fraccion));
        if (!iniciada || this.fraccion != fraccion) {
            iniciada = true;
            this.fraccion = fraccion;
            repaint();
        }
    }

    @Override
    protected void pintarPrimerPlano(Graphics2D g2) {
        if (!iniciada) {
            return;
        }
        double escala = ESCALA_MINIMA + (1 - ESCALA_MINIMA) * fraccion;
        double altoMax = Math.min(getHeight() * ALTURA_MAXIMA, getWidth() * 0.55 / hongo.getProporcion());
        int alto = Math.max(1, (int) Math.round(altoMax * escala));
        int ancho = Math.max(1, (int) Math.round(alto * hongo.getProporcion()));
        int x = (int) Math.round(getWidth() * BASE_X) - ancho / 2;
        int y = (int) Math.round(getHeight() * BASE_Y) - alto;
        hongo.dibujar(g2, x, y, ancho, alto, 2);
    }
}
