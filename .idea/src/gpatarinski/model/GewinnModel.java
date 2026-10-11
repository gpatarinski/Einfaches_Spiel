package gpatarinski.model;
import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    private static final Random random = new Random();

    public GewinnModel() {
        gesamtPunkte = 30;
    }
}