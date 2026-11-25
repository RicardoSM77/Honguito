
package com.mycompany.honguito;
import Guis.Principal;
import javax.swing.SwingUtilities;
/**
 *
 * @author ricardo
 */
public class Honguito {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Principal().setVisible(true));
    }
}
