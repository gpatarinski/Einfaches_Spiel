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

    //Erstellt eine zufällige Zahl von 0 bis 9 das den Computer nutzt und ausgibt
    public void berechneComputerZahl() {
        computerZahl = random.nextInt(1,10);
    }

    //Berechnet die Punkteänderung nach eine Runde
    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        berechneComputerZahl();
        if (this.spielerZahl == this.computerZahl) {
            this.rundenErgebnis = 20;
        } else if (this.spielerZahl == this.computerZahl + 1 || this.spielerZahl == this.computerZahl - 1) {
            this.rundenErgebnis = 5;
        } else {
            this.rundenErgebnis = -10;
        }
        this.gesamtPunkte += this.rundenErgebnis;
    }

    //getter-Methoden
    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }
    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
    public int getGesamtPunkte() {
        return gesamtPunkte;
    }
    public int getComputerZahl() {
        return computerZahl;
    }
    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

}
