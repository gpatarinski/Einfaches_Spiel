package gpatarinski.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GrafikPanel extends JPanel {
    //Variablen
    private final JButton nochMalBtn;
    private final JLabel rundenErgebnis;
    private final JLabel gesamtPunkte;
    private final JTextField eingabe;
    private final JTextField computerPunkte;

    //Konstruktor-Methode für den north-, centre- und south Panele
    public GrafikPanel(ActionListener controller) {
        this.setLayout(new BorderLayout());
        JPanel oberenPanel = new JPanel();

        //NORTH Panel Einstellungen
        oberenPanel.setLayout(new GridLayout(3, 2, 4, 4));
        oberenPanel.add(new JLabel("Rundenergebnis:", JLabel.CENTER));
        oberenPanel.add(new JLabel("Gesamtpunkte:", JLabel.CENTER));
        rundenErgebnis = new JLabel("Tippe eine Zahl von 1 - 9", JLabel.CENTER);
        rundenErgebnis.setOpaque(true);
        rundenErgebnis.setBackground(new Color(255, 255, 255));
        gesamtPunkte = new JLabel("Gesamtpunkte: 30", JLabel.CENTER);
        gesamtPunkte.setOpaque(true);
        gesamtPunkte.setBackground(new Color(255, 255, 255));
        oberenPanel.add(rundenErgebnis);
        oberenPanel.add(gesamtPunkte);
        oberenPanel.add(new JLabel("Deine Zahl:", JLabel.CENTER));
        oberenPanel.add(new JLabel("Computer:", JLabel.CENTER));

        //CENTER Panel Einstellungen
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2, 4, 4));
        eingabe = new JTextField();
        eingabe.setHorizontalAlignment(JTextField.CENTER);
        centerPanel.add(eingabe);
        computerPunkte = new JTextField();
        computerPunkte.setHorizontalAlignment(JTextField.CENTER);
        computerPunkte.setEditable(false);
        centerPanel.add(computerPunkte);

        //SOUTH Panel Einstellungen
        JPanel unterenPanel = new JPanel();
        unterenPanel.setLayout(new FlowLayout());
        nochMalBtn = new JButton("Noch einmal");
        nochMalBtn.setEnabled(false);
        unterenPanel.add(nochMalBtn);

        this.nochMalBtn.addActionListener(controller);
        this.nochMalBtn.setActionCommand("btn");
        this.eingabe.addActionListener(controller);
        this.eingabe.setActionCommand("eingabe");

        //Fügt NORTH, CENTER und SOUTH Panele hinzu
        this.add(oberenPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(unterenPanel, BorderLayout.SOUTH);
    }

    // Code for Eingaben
    public String getEingabeValue() {
        return this.eingabe.getText().trim();
    }
    public void setEingabeValue(String eingabeValue) {
        this.eingabe.setText(eingabeValue);
    }
    public void setEingabeEnable(boolean enable) {
        this.eingabe.setEnabled(enable);
    }
    public void setNochMalBtnEnabled(boolean enable) {
        this.nochMalBtn.setEnabled(enable);
    }


    // Code for Labels
    public void setRundenErgebnis(String rundenErgebnis) {
        this.rundenErgebnis.setText(rundenErgebnis);
    }
    public void setGesamtPunkte(String gesamtPunkte) {
        this.gesamtPunkte.setText(gesamtPunkte);
    }
    public void setComputerPunkte(String computerPunkte) {
        this.computerPunkte.setText(computerPunkte);
    }
    public void setLabelColor(Color color) {
        this.rundenErgebnis.setBackground(color);
        this.gesamtPunkte.setBackground(color);
    }
}