package gui;

import controller.*;
import model.Staff;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Visualizza dati gui.
 */
public class VisualizzaDatiGUI {
    private JPanel mainPanel;
    private JButton dettagliTurnoButton;
    private JButton visualizzaDatiButton;
    private JButton inserisciDatiButton;
    private JButton logOutButton;
    private JLabel totBiglietti;
    private JLabel valutazioniMedie;
    private JLabel bestFilm;
    private JFrame frameVisualizzaDati;

    /**
     * Restituisce il frame.
     *
     * @return il frame
     */
    public JFrame getFrame(){
        return this.frameVisualizzaDati;
    }

    /**
     * Instantiates a new Visualizza dati gui.
     *
     * @param frameHome  the frame home
     * @param controller the controller
     * @param membro     the membro
     */
    public VisualizzaDatiGUI(JFrame frameHome, Controller controller, Staff membro) {
        frameVisualizzaDati = new JFrame("LoggedStaffGUI");
        frameVisualizzaDati.setContentPane(mainPanel);
        frameVisualizzaDati.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameVisualizzaDati.pack();

        dettagliTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new TurnoGUI(frameHome,controller,membro).getFrame());
            }
        });
        inserisciDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new InserisciDatiGUI(frameHome,controller,membro).getFrame());
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(frameHome);
            }
        });

        controller.visualizzaDati(totBiglietti,valutazioniMedie,bestFilm);
    }
}
