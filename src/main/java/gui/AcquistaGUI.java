package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;

public class AcquistaGUI {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton acquistaButton;
    private JButton recensisciButton;
    private JButton logOutButton;
    private JFrame frameAcquista;

    public JFrame getFrame() {
        return this.frameAcquista;
    }

    public AcquistaGUI(JFrame frameHome, JFrame frameLocalHome, Controller controller) {
        frameAcquista= new JFrame("AcquistaGUI");
        frameAcquista.setContentPane(mainPanel);
        frameAcquista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAcquista.pack();
        frameAcquista.setVisible(true);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameLocalHome);
            }
        });
        recensisciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new RecensioneGUI(frameHome,frameLocalHome,controller).getFrame());
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
