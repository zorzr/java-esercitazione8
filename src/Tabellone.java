// ESERCITAZIONE 8
import java.io.*;
import java.util.*;

/**
 *
 * @author zorzr
 */

public class Tabellone {
    Partita match;
    ArrayList<String> lines;
    int currentIndex;
    
    public Tabellone (String path) {
        lines = readEvents(path);
        currentIndex = 0;
        
        switch (lines.get(0).split("-")[0]) {
            case "C":
                match = new Calcio();
                break;
            case "V":
                match = new Volley();
                break;
            default:
                System.out.println("ERRORE:  Formattazione errata");
                System.exit(3);
        }
    }
    
    private ArrayList readEvents (String path) {
        String line;
        ArrayList<String> lines_vect = new ArrayList();
        
        try {
            FileReader file = new FileReader(path);
            BufferedReader in = new BufferedReader(file);
            
            while((line = in.readLine()) != null) {
                lines_vect.add(line);
            }
            
            in.close();
            file.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("ERRORE:  File inesistente");
            System.exit(1);
        }
        catch (IOException ex) {
            System.out.println("ERRORE:  Impossibile leggere il file");
            System.exit(2);
        }
            
        return lines_vect;
    }
    
    public boolean nextEvent() {
        boolean r = match.handleEvent(getCurrentEvent());
        currentIndex++;
        
        return r;
    }
    
    public String getCurrentEvent() {
        if (currentIndex >= lines.size())  System.exit(0);
        return lines.get(currentIndex);
    }
}
