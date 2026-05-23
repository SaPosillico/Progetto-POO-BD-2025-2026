package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;

public class RecensioneGUI {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton acquistaButton;
    private JButton recensisciButton;
    private JButton logOutButton;
    private JFrame frameRecensione;

    public JFrame getFrame() {
        return this.frameRecensione;
    }

    public RecensioneGUI(JFrame frameHome, JFrame frameLocalHome, Controller controller) {
        frameRecensione= new JFrame("AcquistaGUI");
        frameRecensione.setContentPane(mainPanel);
        frameRecensione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRecensione.pack();
        frameRecensione.setVisible(true);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameLocalHome);
            }
        });
        acquistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new AcquistaGUI(frameHome,frameLocalHome,controller).getFrame());
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
