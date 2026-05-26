package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;

/**
 * The type Pannello log in admin.
 */
public class PannelloLogInAdmin extends JPanel {
    private JTextField campoUser;
    private JPasswordField campoMatricola;
    private JButton pulsanteAccessoAdmin;

    /**
     * Instantiates a new Pannello log in admin.
     *
     * @param frameHome  the frame home
     * @param controller the controller
     */
    public PannelloLogInAdmin(JFrame frameHome, Controller controller) {
        setLayout(new GridLayout(3, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(new JLabel("User Staff/Admin:"));
        campoUser = new JTextField();
        add(campoUser);

        add(new JLabel("Matricola:"));
        campoMatricola = new JPasswordField();
        add(campoMatricola);

        pulsanteAccessoAdmin = new JButton("Accesso Riservato");
        add(new JLabel());
        add(pulsanteAccessoAdmin);

        pulsanteAccessoAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int matricola = Integer.parseInt(campoMatricola.getText());

                    if(!controller.checkAdminLogInDetails(campoUser.getText(),matricola,controller,frameHome)){
                        campoUser.setBackground(new Color(255, 230, 230));
                        campoUser.setText("");
                        campoMatricola.setBackground(new Color(255, 230, 230));
                        campoMatricola.setText("");
                        JOptionPane.showMessageDialog(null,"Campi inseriti errati.");
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null,"Valore della matricola non valido.");
                    campoMatricola.setBackground(new Color(255, 230, 230));
                    campoMatricola.setText("");
                }
            }
        });

    }

    /**
     * Gets pulsante accesso admin.
     *
     * @return the pulsante accesso admin
     */
    public JButton getPulsanteAccessoAdmin() { return pulsanteAccessoAdmin; }

    /**
     * Gets codice.
     *
     * @return the codice
     */
    public String getCodice() { return campoUser.getText(); }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() { return new String(campoMatricola.getPassword()); }
}