package gui;

import controller.*;
import model.Staff;

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

    public LoggedStaffGUI(JFrame frameHome, Controller controller, Staff membro) {
        frameLoggedStaff = new JFrame("LoggedStaffGUI");
        frameLoggedStaff.setContentPane(mainPanel);
        frameLoggedStaff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLoggedStaff.pack();

        dettagliTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new TurnoGUI(frameHome,frameLoggedStaff,controller,membro).getFrame());
            }
        });
        visualizzaDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new VisualizzaDatiGUI(frameHome,frameLoggedStaff,controller,membro).getFrame());
            }
        });
        inserisciDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new InserisciDatiGUI(frameHome,frameLoggedStaff,controller,membro).getFrame());
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
