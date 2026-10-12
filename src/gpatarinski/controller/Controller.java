package gpatarinski.controller;

import gpatarinski.model.GewinnModel;
import gpatarinski.view.GrafikFrame;
import gpatarinski.view.GrafikPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private final GrafikFrame view;
    private GewinnModel model;

    public Controller() {
        this.model = new GewinnModel();
        this.view = new GrafikFrame(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GrafikPanel panel = view.getPanel();
        if (e.getActionCommand().equals("eingabe")) {
            int eingabe;
            try {
                eingabe = Integer.parseInt(panel.getEingabeValue());
            } catch (NumberFormatException ex) {
                return;
            }
            model.berechneRunde(eingabe);
            // --- Oberflächen-Update nach der Auswertung ---
            if (model.hatGewonnen()) {
                panel.setRundenErgebnis("Gewonnen");
            } else if (model.hatVerloren()) {
                panel.setRundenErgebnis("Verloren");
            } else {
                panel.setRundenErgebnis(Integer.toString(model.getRundenErgebnis()));
            }
            panel.setComputerPunkte(Integer.toString(model.getComputerZahl()));
            panel.setGesamtPunkte("Gesamtpunkte: " + model.getGesamtPunkte());
            // --- Ende Update ---
        } else if (e.getActionCommand().equals("btn")) {
            if (model.hatGewonnen() || model.hatVerloren()) {
                model = new GewinnModel();
            }
            panel.setComputerPunkte("");
            panel.setRundenErgebnis("");
            panel.setEingabeValue("");
            panel.setGesamtPunkte("Gesamtpunkte: " + model.getGesamtPunkte());
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}