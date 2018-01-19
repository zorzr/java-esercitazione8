// ESERCITAZIONE 8
import javax.swing.SwingUtilities;

/**
 *
 * @author zorzr
 */

public class Tester {
    public static void main(String[] args) {
        Tabellone t = new Tabellone(args[0]);
        
        createGUI(t);
    }
    
    private static void createGUI(Tabellone t) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frame f = new Frame(t);
            }
        });
    }
}
