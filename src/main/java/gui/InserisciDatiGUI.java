package gui;

import controller.*;
import model.Genere;
import model.Rating;
import model.Staff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserisciDatiGUI {
    private JPanel mainPanel;
    private JButton dettagliTurnoButton;
    private JButton visualizzaDatiButton;
    private JButton inserisciDatiButton;
    private JButton logOutButton;
    private JTextField campoTitolo;
    private JTextField campoRegista;
    private JComboBox campoGenere;
    private JComboBox campoRating;
    private JTextField campoGiorno;
    private JTextField campoOraInizio;
    private JTextField campoOrarioFine;
    private JButton aggiungiButton;
    private JComboBox campoSala;
    private JFrame frameInserisciDati;

    public JFrame getFrame(){
        return this.frameInserisciDati;
    }

    public InserisciDatiGUI(JFrame frameHome, Controller controller, Staff membro) {
        frameInserisciDati = new JFrame("LoggedStaffGUI");
        frameInserisciDati.setContentPane(mainPanel);
        frameInserisciDati.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInserisciDati.pack();

        dettagliTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new TurnoGUI(frameHome,controller,membro).getFrame());
            }
        });
        visualizzaDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new VisualizzaDatiGUI(frameHome,controller,membro).getFrame());
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameHome);
            }
        });

        controller.aggiungiValoriPerSelezione(campoGenere,campoRating,campoSala);
        campoGiorno.putClientProperty("JTextField.placeholderText", "AAAA-MM-DD");
        campoOraInizio.putClientProperty("JTextField.placeholderText", "HH:MM");
        campoOrarioFine.putClientProperty("JTextField.placeholderText", "HH:MM");

        aggiungiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.aggiungiFilmOProiezione(campoTitolo.getText(),campoRegista.getText(),(Genere)campoGenere.getSelectedItem(),(Rating)campoRating.getSelectedItem(),campoGiorno.getText(),campoOraInizio.getText(),campoOrarioFine.getText(),campoSala.getSelectedItem().toString())){
                    JOptionPane.showMessageDialog(null,"Dati inseriti correttamente.");
                    controller.changeFrame(new TurnoGUI(frameHome,controller,membro).getFrame());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Dati inseriti non validi.");
                }
            }
        });
    }
}
