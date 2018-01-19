// ESERCITAZIONE 8

/**
 *
 * @author zorzr
 */

public abstract class Partita {
    private final String SqA, SqB;
    private int ptA, ptB;
    
    public Partita (String nomeCasa, String nomeOspite) {
        SqA = nomeCasa;
        SqB = nomeOspite;
        ptA = 0;
        ptB = 0;
    }
    public Partita() {
        SqA = "SQ.A";
        SqB = "SQ.B";
        ptA = 0;
        ptB = 0;
    }
    
    public abstract boolean handleEvent(String event);
    
    
    public String getSqA() {
        return SqA;
    }
    public String getSqB() {
        return SqB;
    }
    public int getPtA() {
        return ptA;
    }
    public int getPtB() {
        return ptB;
    }

    public void setPtA(int ptA) {
        this.ptA = ptA;
    }
    public void setPtB(int ptB) {
        this.ptB = ptB;
    }
    
    public void addPtA() {
        ptA++;
    }
    public void addPtB() {
        ptB++;
    }
}
