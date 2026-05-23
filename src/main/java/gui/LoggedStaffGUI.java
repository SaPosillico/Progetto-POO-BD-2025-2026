package gui;

import controller.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoggedStaffGUI {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton dettagliTurnoButton;
    private JButton visualizzaDatiButton;
    private JButton inserisciDatiButton;
    private JButton logOutButton;
    private JFrame frameLoggedStaff;

    public JFrame getFrame(){
        return this.frameLoggedStaff;
    }

    public LoggedStaffGUI(JFrame frameHome, JFrame frameLocalHome, Controller controller) {
        frameLoggedStaff = new JFrame("LoggedStaffGUI");
        frameLoggedStaff.setContentPane(mainPanel);
        frameLoggedStaff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLoggedStaff.pack();
        frameLoggedStaff.setVisible(true);

        dettagliTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new TurnoGUI(frameHome,frameLoggedStaff,controller).getFrame());
            }
        });
        visualizzaDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new VisualizzaDatiGUI(frameHome,frameLoggedStaff,controller).getFrame());
            }
        });
        inserisciDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new InserisciDatiGUI(frameHome,frameLoggedStaff,controller).getFrame());
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
