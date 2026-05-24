package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import controller.*;
import model.Cliente;

public class AcquistaGUI {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton acquistaButton;
    private JButton recensisciButton;
    private JButton logOutButton;
    private JComboBox filmSelector;
    private JComboBox projectionSelector;
    private JButton acquistaButton1;
    private JTextField campoNumeroBiglietti;
    private JFrame frameAcquista;

    public JFrame getFrame() {
        return this.frameAcquista;
    }

    public AcquistaGUI(JFrame frameHome, JFrame frameLocalHome, Controller controller, Cliente cliente) {
        frameAcquista= new JFrame("AcquistaGUI");
        frameAcquista.setContentPane(mainPanel);
        frameAcquista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAcquista.pack();

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameLocalHome);
            }
        });
        recensisciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new RecensioneGUI(frameHome,frameLocalHome,controller,cliente).getFrame());
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameHome);
            }
        });
        controller.creaListaFilm(filmSelector);

        filmSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object filmSelezionato = filmSelector.getSelectedItem();

                if (filmSelezionato != null && !filmSelezionato.toString().isEmpty()) {
                    controller.creaListaProiezioni(projectionSelector, filmSelezionato.toString());
                } else {
                    projectionSelector.removeAll();
                    projectionSelector.addItem("");
                }
            }
        });

        acquistaButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.checkPurchaseDetails(filmSelector.getSelectedItem().toString(),projectionSelector.getSelectedItem().toString(),campoNumeroBiglietti.getText())){
                    JOptionPane.showMessageDialog(null,"Biglietti acquistati, per il pagamento recarsi fisicamente alla cassa con almeno un'ora di anticipo rispetto l'inizio della proiezione.");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Errore durante la procedura di acquisto, ritentare.");
                }
            }
        });
    }
}
