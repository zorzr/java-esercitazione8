// ESERCITAZIONE 8
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author zorzr
 */

public class Frame extends JFrame {
    private JPanel panel;
    private Tabellone tab;

    public Frame(Tabellone t) {
        setSize(560, 330);
        setTitle("Tabellone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation(screenWidth / 4, screenHeight / 4);
        
        tab = t;
        
        if (tab.match instanceof Volley) {
            panel = new VolleyPanel(tab, (Volley) tab.match);
        }
        else if (tab.match instanceof Calcio) {
            panel = new CalcioPanel(tab, (Calcio) tab.match);
        }
        
        Container contentPane = getContentPane();
        contentPane.add(panel);
        
        
        // WINDOWS
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(panel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
