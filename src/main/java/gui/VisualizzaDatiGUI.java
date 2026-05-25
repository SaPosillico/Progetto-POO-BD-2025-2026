package gui;

import controller.*;
import model.Staff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizzaDatiGUI {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton dettagliTurnoButton;
    private JButton visualizzaDatiButton;
    private JButton inserisciDatiButton;
    private JButton logOutButton;
    private JLabel totBiglietti;
    private JLabel valutazioniMedie;
    private JLabel bestFilm;
    private JFrame frameVisualizzaDati;

    public JFrame getFrame(){
        return this.frameVisualizzaDati;
    }

    public VisualizzaDatiGUI(JFrame frameHome, JFrame frameLocalHome, Controller controller, Staff membro) {
        frameVisualizzaDati = new JFrame("LoggedStaffGUI");
        frameVisualizzaDati.setContentPane(mainPanel);
        frameVisualizzaDati.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameVisualizzaDati.pack();

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameLocalHome);
            }
        });
        dettagliTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new TurnoGUI(frameHome,frameLocalHome,controller,membro).getFrame());
            }
        });
        inserisciDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new InserisciDatiGUI(frameHome,frameLocalHome,controller,membro).getFrame());
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameHome);
            }
        });

        controller.visualizzaDati(totBiglietti,valutazioniMedie,bestFilm);
    }
}
