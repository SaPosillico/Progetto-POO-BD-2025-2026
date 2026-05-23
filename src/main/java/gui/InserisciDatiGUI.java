package gui;

import controller.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserisciDatiGUI {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton dettagliTurnoButton;
    private JButton visualizzaDatiButton;
    private JButton inserisciDatiButton;
    private JButton logOutButton;
    private JFrame frameInserisciDati;

    public JFrame getFrame(){
        return this.frameInserisciDati;
    }

    public InserisciDatiGUI(JFrame frameHome, JFrame frameLocalHome, Controller controller) {
        frameInserisciDati = new JFrame("LoggedStaffGUI");
        frameInserisciDati.setContentPane(mainPanel);
        frameInserisciDati.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInserisciDati.pack();
        frameInserisciDati.setVisible(true);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameLocalHome);
            }
        });
        dettagliTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new TurnoGUI(frameHome,frameLocalHome,controller).getFrame());
            }
        });
        visualizzaDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new VisualizzaDatiGUI(frameHome,frameLocalHome,controller).getFrame());
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameHome);
            }
        });
    }
}
