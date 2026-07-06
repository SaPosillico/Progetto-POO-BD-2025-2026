package gui;

import controller.*;
import model.Staff;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Turno gui.
 */
public class TurnoGUI {
    private JPanel mainPanel;
    private JButton dettagliTurnoButton;
    private JButton visualizzaDatiButton;
    private JButton inserisciDatiButton;
    private JButton logOutButton;
    private JPanel pannelloDettagli;
    private JFrame frameTurno;

    /**
     * Restituisce il frame.
     *
     * @return il frame
     */
    public JFrame getFrame(){
        return this.frameTurno;
    }

    /**
     * Instantiates a new Turno gui.
     *
     * @param frameHome  the frame home
     * @param controller the controller
     * @param membro     the membro
     */
    public TurnoGUI(JFrame frameHome, Controller controller, Staff membro) {
        frameTurno = new JFrame("LoggedStaffGUI");
        frameTurno.setContentPane(mainPanel);
        frameTurno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTurno.pack();

        visualizzaDatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeFrame(new VisualizzaDatiGUI(frameHome,controller,membro).getFrame());
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

        controller.mostraDatiTurno(pannelloDettagli,membro);
    }
}
