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
    private JTabbedPane accessTabbedPane;
    private JLabel benvenutoLabel;
    private JFrame frameLogIn;

    public JFrame getFrame() {
        return this.frameLogIn;
    }

    public PaginaLogInGUI(JFrame frameHome, Controller controller) {
        frameLogIn = new JFrame("PaginaLogInGUI");
        frameLogIn.setContentPane(mianPanel);
        frameLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogIn.pack();

        benvenutoLabel.setText("<html><div style='text-align: center;'>Benvenuto!<br>Inserisci i dati per effettuare il login</div></html>");

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

        PannelloLogInCliente loginCliente = new PannelloLogInCliente(frameHome,controller);
        PannelloLogInAdmin loginAdmin = new PannelloLogInAdmin(frameHome, controller);

        accessTabbedPane.addTab("Area Clienti", loginCliente);
        accessTabbedPane.addTab("Area Staff / Admin", loginAdmin);

    }
}
