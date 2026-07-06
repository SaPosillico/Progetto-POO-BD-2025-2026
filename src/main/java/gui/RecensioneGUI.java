package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;
import model.Cliente;

/**
 * The type Recensione gui.
 */
public class RecensioneGUI {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton acquistaButton;
    private JButton recensisciButton;
    private JButton logOutButton;
    private JComboBox filmSelector;
    private JComboBox valutazione;
    private JTextArea descrizione;
    private JButton pulsanteRecensione;
    private JFrame frameRecensione;

    /**
     * Restituisce il frame.
     *
     * @return il frame
     */
    public JFrame getFrame() {
        return this.frameRecensione;
    }

    /**
     * Instantiates a new Recensione gui.
     *
     * @param frameHome      the frame home
     * @param frameLocalHome the frame local home
     * @param controller     the controller
     * @param cliente        the cliente
     */
    public RecensioneGUI(JFrame frameHome, JFrame frameLocalHome, Controller controller, Cliente cliente) {
        frameRecensione= new JFrame("RecensioneGUI");
        frameRecensione.setContentPane(mainPanel);
        frameRecensione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRecensione.pack();

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameLocalHome);
            }
        });
        acquistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new AcquistaGUI(frameHome,frameLocalHome,controller,cliente).getFrame());
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameHome);
            }
        });
        controller.creaListaFilm(filmSelector);
        controller.creaListaValutazione(valutazione);

        pulsanteRecensione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object filmSel = filmSelector.getSelectedItem();
                Object valSel = valutazione.getSelectedItem();

                if (filmSel == null || valSel == null || descrizione.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Completa tutti i campi prima di inviare!", "Errore", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                controller.aggiungiRecensione(filmSel.toString(), valSel.toString(), descrizione.getText(), cliente);
                JOptionPane.showMessageDialog(null, "Recensione inviata. Grazie per il feedback.");
                controller.changeFrame(frameLocalHome);
            }
        });
    }
}
