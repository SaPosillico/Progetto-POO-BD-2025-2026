package gui;

import controller.*;
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
    private JFrame frameTurno;

    public JFrame getFrame(){
        return this.frameTurno;
    }

    public TurnoGUI(JFrame frameHome, JFrame frameLocalHome, Controller controller) {
        frameTurno = new JFrame("LoggedStaffGUI");
        frameTurno.setContentPane(mainPanel);
        frameTurno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTurno.pack();
        frameTurno.setVisible(true);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameLocalHome);
            }
        });
        visualizzaDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new VisualizzaDatiGUI(frameHome,frameLocalHome,controller).getFrame());
            }
        });
        inserisciDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new InserisciDatiGUI(frameHome,frameLocalHome,controller).getFrame());
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
