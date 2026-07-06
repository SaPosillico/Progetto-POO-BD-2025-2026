package gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;
import model.Cliente;

/**
 * The type Logged client gui.
 */
public class LoggedClientGUI {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton acquistaButton;
    private JButton recensisciButton;
    private JButton logOutButton;
    private JLabel labelBenvenuto;
    private JList listaBigliettiAcquistati;
    private JLabel validaBiglietto;
    private JFrame frameLoggedClient;

    /**
     * Restituisce il frame.
     *
     * @return il frame
     */
    public JFrame getFrame(){
        return this.frameLoggedClient;
    }

    /**
     * Instantiates a new Logged client gui.
     *
     * @param frameHome  the frame home
     * @param controller the controller
     * @param cliente    the cliente
     */
    public LoggedClientGUI(JFrame frameHome, Controller controller, Cliente cliente) {
        frameLoggedClient = new JFrame("LoggedClientGUI");
        frameLoggedClient.setContentPane(mainPanel);
        frameLoggedClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLoggedClient.pack();

        acquistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new AcquistaGUI(frameHome,frameLoggedClient,controller,cliente).getFrame());
            }
        });
        recensisciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new RecensioneGUI(frameHome,frameLoggedClient,controller,cliente).getFrame());
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameHome);
            }
        });
        listaBigliettiAcquistati.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String valore = listaBigliettiAcquistati.getSelectedValue().toString();

                    if (valore != null) {
                        if (controller.controllaValiditaBiglietto(valore)) {
                            validaBiglietto.setText("Valido.");
                        }
                        else{
                            validaBiglietto.setText("Scaduto.");
                        }
                    }
                }
            }
        });
        labelBenvenuto.setText("Benvenuto, "+cliente.getNome()+"!");
        controller.aggiornaListaBiglietti(listaBigliettiAcquistati,cliente);
    }
}
