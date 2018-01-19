// ESERCITAZIONE 8

/**
 *
 * @author zorzr
 */

public class Volley extends Partita {
    private byte set;
    private byte setA, setB, timeoutA, timeoutB;
    private final byte MAXSET = 2;
    
    public Volley (String nomeCasa, String nomeOspite) {
        super(nomeCasa, nomeOspite);
        set = 0;
        setA = 0;
        setB = 0;
        timeoutA = 0;
        timeoutB = 0;
    }
    public Volley() {
        super();
        set = 0;
        setA = 0;
        setB = 0;
        timeoutA = 0;
        timeoutB = 0;
    }

    public byte getSet() {
        return set;
    }
    public byte getSetA() {
        return setA;
    }
    public byte getSetB() {
        return setB;
    }
    public byte getTimeoutA() {
        return timeoutA;
    }
    public byte getTimeoutB() {
        return timeoutB;
    }
    
    public void nextSet() {
        if (setA < MAXSET && setB < MAXSET) {
            set++;
            super.setPtA(0);
            super.setPtB(0);
            timeoutA = 0;
            timeoutB = 0;
        }
    }
    public void addSetA() {
        setA++;
    }
    public void addSetB() {
        setB++;
    }
    public void addTimeoutA() {
        timeoutA++;
    }
    public void addTimeoutB() {
        timeoutB++;
    }
    
    @Override
    public boolean handleEvent(String event) {
        String id = event.split("\t")[0];
        
        switch (id) {
            case "V-00":
                break;
            case "V-01":
                nextSet();
                break;
            case "V-02":
                if (getPtA() > getPtB()) {
                    addSetA();
                } else addSetB();
                break;
            case "V-03":
                addPtA();
                break;
            case "V-04":
                addPtB();
                break;
            case "V-05":
                addTimeoutA();
                break;
            case "V-06":
                addTimeoutB();
                break;
            case "V-98":
                break;
            case "V-99":
                set = 0;
                break;
            default:
                return false;
        }
        
        return true;
    }
}