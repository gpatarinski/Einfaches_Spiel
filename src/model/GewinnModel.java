package model;

import java.util.*;
import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte = 30;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = gesamtPunkte;
        this.computerZahl = computerZahl;
        this.rundenErgebnis = rundenErgebnis;
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

    public void berechneComputerZahl() {
        Random ran = new Random();
        this.computerZahl = ran.nextInt(1, 10);
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;

        if(spielerZahl == getComputerZahl()) {
            this.rundenErgebnis = 20;
            gesamtPunkte += getRundenErgebnis();
        }
        else if (getComputerZahl() - 1 == spielerZahl || getComputerZahl() + 1 == spielerZahl) {
            this.rundenErgebnis = 5;
            gesamtPunkte += getRundenErgebnis();
        }
        else {
            this.rundenErgebnis = -10;
            gesamtPunkte += getRundenErgebnis();
        }
    }

    public boolean hatGewonnen() {
        if(getGesamtPunkte() >= 100) {
            return true;
        }
        return false;
    }
    public boolean hatVerloren() {
        if(getGesamtPunkte() <= 0) {
            return true;
        }
        return false;
    }

}

