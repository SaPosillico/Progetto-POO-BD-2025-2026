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
    private JTextField emailTextField;
    private JTextField passwordTextField;
    private JLabel benvenutoLabel;
    private JButton invioButton;
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
        frameLogIn.setExtendedState(JFrame.MAXIMIZED_BOTH);

        benvenutoLabel.setText("Benvenuto! Inserisci qui i dati del tuo account.");

        //AR: non riuscivo a centrare la label
        //benvenutoLabel.setPreferredSize(new java.awt.Dimension(2000, 100));

        benvenutoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        benvenutoLabel.setVerticalAlignment(SwingConstants.CENTER);


        emailTextField.setText("Email");

        emailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (emailTextField.getText().equals("Email")) {
                    emailTextField.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (emailTextField.getText().isEmpty()) {
                    emailTextField.setText("Email");
                }
            }
        });


        passwordTextField.setText("Password");

        passwordTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (passwordTextField.getText().equals("Password")) {
                    passwordTextField.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (passwordTextField.getText().isEmpty()) {
                    passwordTextField.setText("Password");
                }
            }
        });


        invioButton.setText("Invio");
        invioButton.setPreferredSize(new java.awt.Dimension(200, 50));


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
