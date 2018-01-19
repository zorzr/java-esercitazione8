// ESERCITAZIONE 8
import java.util.*;
import java.text.*;

/**
 *
 * @author zorzr
 */

public class Calcio extends Partita {
    private String tempo;
    private Calendar inizioTempo;
    private int minuto;
    
    public Calcio (String nomeCasa, String nomeOspite) {
        super(nomeCasa, nomeOspite);
        tempo = "";
        minuto = 0;
    }
    public Calcio() {
        super();
        tempo = "";
        minuto = 0;
    }

    public String getTempo() {
        return tempo;
    }
    public int getMinuto() {
        return minuto;
    }
    
    public void nextTempo(String time) {
        switch (tempo) {
            case "":
                tempo = "1 t.";
                break;
            case "1 t.":
                tempo = "INT";
                minuto = 45;
                break;
            case "INT":
                tempo = "2 t.";
                calculateMinuto(getData(time));
                break;
            case "2 t.":
                tempo = "END";
                minuto = 0;
                break;
            default:
                break;
        }
    }
    
    @Override
    public boolean handleEvent(String event) {
        String id = event.split("\t")[0];
        String time = event.split("\t")[2];
        
        switch (id) {
            case "C-00":
            case "C-02":
                inizioTempo = getData(time);
            case "C-01":
            case "C-99":
                nextTempo(time);
                break;
            case "C-04":
                addPtA();
                calculateMinuto(getData(time));
                break;
            case "C-05":
                addPtB();
                calculateMinuto(getData(time));
                break;
            case "C-98":
                calculateMinuto(getData(time));
                break;
            default:
                return false;
        }
        
        return true;
    }
    
    private Calendar getData (String time) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date data = df.parse(time);
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(data);
            
            return cal;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void calculateMinuto (Calendar date){
        long eventMs = date.getTimeInMillis();
        long startMs = inizioTempo.getTimeInMillis();
        long delta = eventMs-startMs;
        int deltaMin = (int) delta/60000;
        
        int t = 0;
        if (tempo.equals("2 t.")) {
            t = 45;
        }
        
        minuto = t + deltaMin;
    }
}
