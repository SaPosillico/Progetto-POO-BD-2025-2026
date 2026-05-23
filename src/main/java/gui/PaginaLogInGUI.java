package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;

public class PaginaLogInGUI {
    private JPanel mianPanel;
    private JButton homeButton;
    private JButton filmButton;
    private JButton proiezioniButton;
    private JButton logInButton;
    private JFrame frameLogIn;

    public JFrame getFrame() {
        return this.frameLogIn;
    }

    public PaginaLogInGUI(JFrame frameHome, Controller controller) {
        frameLogIn = new JFrame("PaginaLogInGUI");
        frameLogIn.setContentPane(mianPanel);
        frameLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogIn.pack();
        frameLogIn.setVisible(true);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameHome);
            }
        });
        filmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new PaginaFilmGUI(frameHome,controller).getFrame());
            }
        });
        proiezioniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new PaginaProiezioniGUI(frameHome,controller).getFrame());
            }
        });
    }
}
