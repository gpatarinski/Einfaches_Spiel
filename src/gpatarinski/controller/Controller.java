package gpatarinski.controller;

import gpatarinski.model.GewinnModel;
import gpatarinski.view.GrafikFrame;
import gpatarinski.view.GrafikPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private final GrafikFrame view;
    private GewinnModel model;

    //Fügt unseren erstellten Model von GewinnModel in Controller ein
    public Controller() {
        this.model = new GewinnModel();
        this.view = new GrafikFrame(this);

        view.getPanel().setEingabeEnable(true);
        view.getPanel().setNochMalBtnEnabled(false);
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
            panel.setEingabeEnable(false);
            panel.setNochMalBtnEnabled(true);
            //Ende Update
        } else if (e.getActionCommand().equals("btn")) {
            if (model.hatGewonnen() || model.hatVerloren()) {
                model = new GewinnModel();
            }
            panel.setComputerPunkte("");
            panel.setRundenErgebnis("");
            panel.setEingabeValue("");
            panel.setGesamtPunkte("Gesamtpunkte: " + model.getGesamtPunkte());
            panel.setEingabeEnable(true);
            panel.setNochMalBtnEnabled(false);
        }
    }

    //Setzt den Controller ein -> Startet das Programm
    public static void main(String[] args) {
        new Controller();
    }
}