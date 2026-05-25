package gui;

import controller.*;
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
    private JFrame frameInserisciDati;

    public JFrame getFrame(){
        return this.frameInserisciDati;
    }

    public InserisciDatiGUI(JFrame frameHome, JFrame frameLocalHome, Controller controller, Staff membro) {
        frameInserisciDati = new JFrame("LoggedStaffGUI");
        frameInserisciDati.setContentPane(mainPanel);
        frameInserisciDati.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInserisciDati.pack();

        dettagliTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new TurnoGUI(frameHome,frameLocalHome,controller,membro).getFrame());
            }
        });
        visualizzaDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new VisualizzaDatiGUI(frameHome,frameLocalHome,controller,membro).getFrame());
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
