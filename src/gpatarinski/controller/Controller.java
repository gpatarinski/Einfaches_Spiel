package gpatarinski.controller;

import gpatarinski.model.GewinnModel;
import gpatarinski.view.GrafikFrame;
import gpatarinski.view.GrafikPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private final GrafikFrame view;
    private GewinnModel model;

    //Fügt unseren erstellten Model von GewinnModel in Controller ein
    public Controller() {
        this.model = new GewinnModel();
        this.view = new GrafikFrame(this);
    }

    //Überschreibt die actionPerformed Methode von GewinnModel
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
            //Update nach der Auswertung ---
            if (model.hatGewonnen()) {
                panel.setRundenErgebnis("Gewonnen");
            } else if (model.hatVerloren()) {
                panel.setRundenErgebnis("Verloren");
            } else {
                panel.setRundenErgebnis(Integer.toString(model.getRundenErgebnis()));
            }
            panel.setComputerPunkte(Integer.toString(model.getComputerZahl()));
            panel.setGesamtPunkte("Gesamtpunkte: " + model.getGesamtPunkte());
            if (model.hatGewonnen() || model.getRundenErgebnis() > 0) {
                panel.setLabelColor(Color.GREEN);
            } else if (model.hatVerloren() || model.getRundenErgebnis() < 0) {
                panel.setLabelColor(Color.RED);
            } else {
                panel.setLabelColor(Color.WHITE);
            }
            //Ende Update
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

    //Setzt den Controller ein -> Startet das Programm
    public static void main(String[] args) {
        new Controller();
    }
}