package gui;

import controller.Controller;
import dao.BigliettoDAO;
import implementazionePostgresDAO.BigliettoImplementazionePostgresDAO;
import model.Cliente;
import model.ClienteVIP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchedaPagamento {
    private JPanel mainPanel;
    private JRadioButton cashButton;
    private JRadioButton cartaRadioButton;
    private JTextField numeroCarta;
    private JTextField scadenzaCarta;
    private JTextField CVVCarta;
    private JButton compraButton;
    private JLabel labelImporto;

    public SchedaPagamento(JFrame frameLocalHome, Controller controller, Cliente cliente, int numeroBiglietti, String datiProiezione) {
        JFrame frame = new JFrame("SchedaPagamento");
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);

        if(((ClienteVIP) cliente).getPercentualeSconto()!=0){
            labelImporto.setText(""+(numeroBiglietti*7-numeroBiglietti*((ClienteVIP)cliente).getPercentualeSconto()*7));
        }
        else{
            labelImporto.setText(""+numeroBiglietti*7);
        }

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(cashButton);
        buttonGroup.add(cartaRadioButton);

        numeroCarta.setEnabled(false);
        CVVCarta.setEnabled(false);
        scadenzaCarta.setEnabled(false);

        cartaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selezionato = cartaRadioButton.isSelected();

                numeroCarta.setEnabled(selezionato);
                CVVCarta.setEnabled(selezionato);
                scadenzaCarta.setEnabled(selezionato);

                if (!selezionato) {
                    numeroCarta.setText("");
                    CVVCarta.setText("");
                    scadenzaCarta.setText("");
                }
            }
        });

        compraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cartaRadioButton.isSelected()){
                    if(controller.checkCardDetails(numeroCarta.getText(),CVVCarta.getText(),scadenzaCarta.getText())){
                        if(controller.salvaDatiPagamento("Carta",Double.parseDouble(labelImporto.getText()),cliente,numeroBiglietti,datiProiezione)){
                            JOptionPane.showMessageDialog(null,"Biglietti acquistati correttamente.");
                            controller.changeFrame(frameLocalHome);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Errore nell'acquisto dei biglietti.");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Dati inseriti errati.");
                    }
                }
                else{
                    if(controller.salvaDatiPagamento("Contanti",Double.parseDouble(labelImporto.getText()),cliente,numeroBiglietti,datiProiezione)){
                        JOptionPane.showMessageDialog(null,"I biglietti sono stati prenotati, per l'acquisto effettivo, recarsi alla cassa al massimo 30 minuti prima dell'inizio della proiezione.");
                        controller.changeFrame(frameLocalHome);
                        frame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Errore nell'acquisto dei biglietti.");
                    }
                }
            }
        });
    }

}
