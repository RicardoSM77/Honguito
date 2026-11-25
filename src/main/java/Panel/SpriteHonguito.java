package Panel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/** Añade un contorno alrededor de la silueta transparente del honguito. */
public final class SpriteHonguito {
    private final ImageIcon imagen = new ImageIcon(getClass().getResource("/honguito_cafe.png"));
    private final BufferedImage silueta = crearSilueta();

    private BufferedImage crearSilueta() {
        BufferedImage mascara = new BufferedImage(imagen.getIconWidth(), imagen.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = mascara.createGraphics();
        try {
            g.drawImage(imagen.getImage(), 0, 0, null);
            g.setComposite(AlphaComposite.SrcIn);
            g.setColor(new Color(47, 29, 19));
            g.fillRect(0, 0, mascara.getWidth(), mascara.getHeight());
        } finally {
            g.dispose();
        }
        return mascara;
    }

    public double getProporcion() {
        return (double) imagen.getIconWidth() / imagen.getIconHeight();
    }

    public void dibujar(Graphics2D g, int x, int y, int ancho, int alto, int borde) {
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dx != 0 || dy != 0) {
                    g.drawImage(silueta, x + dx * borde, y + dy * borde, ancho, alto, null);
                }
            }
        }
        g.drawImage(imagen.getImage(), x, y, ancho, alto, null);
    }
}
