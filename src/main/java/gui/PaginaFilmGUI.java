package gui;

import javax.swing.*;
import controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaFilmGUI {
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton homeButton;
    private JButton filmButton;
    private JButton proiezioniButton;
    private JButton logInButton;
    private JScrollBar scrollBar1;
    private JPanel sezioneFilm;
    private JFrame frameFilm;

    public JFrame getFrame() {
        return this.frameFilm;
    }

    public PaginaFilmGUI(JFrame frameHome, Controller controller) {
        frameFilm = new JFrame("PaginaFilmGUI");
        frameFilm.setContentPane(mainPanel);
        frameFilm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameFilm.pack();
        frameFilm.setVisible(true);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameHome);
            }
        });
        proiezioniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new PaginaProiezioniGUI(frameHome,controller).getFrame());
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new PaginaLogInGUI(frameHome,controller).getFrame());
            }
        });
    }
}
