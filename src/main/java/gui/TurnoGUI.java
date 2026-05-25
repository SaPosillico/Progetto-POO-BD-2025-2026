package gui;

import controller.*;
import model.Staff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurnoGUI {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton dettagliTurnoButton;
    private JButton visualizzaDatiButton;
    private JButton inserisciDatiButton;
    private JButton logOutButton;
    private JPanel pannelloDettagli;
    private JFrame frameTurno;

    public JFrame getFrame(){
        return this.frameTurno;
    }

    public TurnoGUI(JFrame frameHome, JFrame frameLocalHome, Controller controller, Staff membro) {
        frameTurno = new JFrame("LoggedStaffGUI");
        frameTurno.setContentPane(mainPanel);
        frameTurno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTurno.pack();

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameLocalHome);
            }
        });
        visualizzaDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new VisualizzaDatiGUI(frameHome,frameLocalHome,controller,membro).getFrame());
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

        controller.mostraDatiTurno(pannelloDettagli,membro);
    }
}
