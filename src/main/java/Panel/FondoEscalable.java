package Panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/** Rellena el panel con una imagen, conservando sus proporciones. */
public abstract class FondoEscalable extends JPanel {
    private final ImageIcon fondo;
    private final double focoX;
    private final double focoY;

    protected FondoEscalable(ImageIcon fondo, double focoX, double focoY) {
        this.fondo = fondo;
        this.focoX = focoX;
        this.focoY = focoY;
        setOpaque(false);
    }

    @Override
    protected final void paintComponent(Graphics g) {
        super.paintComponent(g);
        int ancho = getWidth();
        int alto = getHeight();
        if (ancho <= 0 || alto <= 0) {
            return;
        }

        double escala = Math.max((double) ancho / fondo.getIconWidth(), (double) alto / fondo.getIconHeight());
        int anchoImagen = (int) Math.ceil(fondo.getIconWidth() * escala);
        int altoImagen = (int) Math.ceil(fondo.getIconHeight() * escala);
        int x = (int) Math.round((ancho - anchoImagen) * focoX);
        int y = (int) Math.round((alto - altoImagen) * focoY);

        Graphics2D g2 = (Graphics2D) g.create();
        try {
            int radio = Math.min(26, Math.min(ancho, alto));
            g2.clip(new RoundRectangle2D.Double(0, 0, ancho, alto, radio, radio));
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(fondo.getImage(), x, y, anchoImagen, altoImagen, this);
            pintarPrimerPlano(g2);
        } finally {
            g2.dispose();
        }
    }

    protected abstract void pintarPrimerPlano(Graphics2D g2);
}
