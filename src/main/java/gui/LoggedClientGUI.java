package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;

public class LoggedClientGUI {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton acquistaButton;
    private JButton recensisciButton;
    private JButton logOutButton;
    private JFrame frameLoggedClient;

    public JFrame getFrame(){
        return this.frameLoggedClient;
    }

    public LoggedClientGUI(JFrame frameHome, Controller controller) {
        frameLoggedClient = new JFrame("LoggedClientGUI");
        frameLoggedClient.setContentPane(mainPanel);
        frameLoggedClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLoggedClient.pack();
        frameLoggedClient.setVisible(true);
        acquistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new AcquistaGUI(frameHome,frameLoggedClient,controller).getFrame());
            }
        });
        recensisciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new RecensioneGUI(frameHome,frameLoggedClient,controller).getFrame());
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
