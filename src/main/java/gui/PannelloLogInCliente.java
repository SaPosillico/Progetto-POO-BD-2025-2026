package gui;

import gui.AcquistaGUI;
import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelloLogInCliente extends JPanel {
    private JTextField campoEmail;
    private JPasswordField campoPassword;
    private JButton pulsanteAccesso;

    public PannelloLogInCliente(JFrame frameHome, Controller controller) {
        setLayout(new GridLayout(3, 2, 10, 10)); // Un layout semplice a griglia
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(new JLabel("Email Cliente:"));
        campoEmail = new JTextField();
        add(campoEmail);

        add(new JLabel("Password:"));
        campoPassword = new JPasswordField();
        add(campoPassword);

        pulsanteAccesso = new JButton("Accedi come Cliente");
        add(new JLabel()); // Spazio vuoto per allineamento
        add(pulsanteAccesso);

        pulsanteAccesso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!controller.checkClientLogInDetails(campoEmail.getText(),campoPassword.getText(),controller,frameHome)){
                    campoEmail.setBackground(new Color(255, 230, 230));
                    campoEmail.setText("");
                    campoPassword.setBackground(new Color(255, 230, 230));
                    campoPassword.setText("");
                    JOptionPane.showMessageDialog(null,"Campi inseriti non validi.");
                }
            }
        });
    }

    public JButton getBottoneAccedi() { return pulsanteAccesso; }
    public String getEmail() { return campoEmail.getText(); }
    public String getPassword() { return new String(campoPassword.getPassword()); }
}