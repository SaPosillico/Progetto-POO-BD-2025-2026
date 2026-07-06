package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;

/**
 * The type Pagina proiezioni gui.
 */
public class PaginaProiezioniGUI {
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton homeButton;
    private JButton filmButton;
    private JButton proiezioniButton;
    private JButton logInButton;
    private JTable projectionTable;
    private JFrame frameProiezioni;

    /**
     * Restituisce il frame.
     *
     * @return il frame
     */
    public JFrame getFrame() {
        return this.frameProiezioni;
    }

    /**
     * Instantiates a new Pagina proiezioni gui.
     *
     * @param frameHome  the frame home
     * @param controller the controller
     */
    public PaginaProiezioniGUI(JFrame frameHome, Controller controller) {
        frameProiezioni = new JFrame("PaginaProiezioniGUI");
        frameProiezioni.setContentPane(mainPanel);
        frameProiezioni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameProiezioni.pack();

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
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new PaginaLogInGUI(frameHome,controller).getFrame());
            }
        });
        controller.aggiornaTabellaProiezioni(projectionTable);
    }

}
