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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        if(((ClienteVIP) cliente).getPercentualeSconto()!=0){
            labelImporto.setText(""+numeroBiglietti*((ClienteVIP)cliente).getPercentualeSconto()*7);
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
                        controller.salvaDatiPagamento("Carta",Double.parseDouble(labelImporto.getText()),cliente,numeroBiglietti,datiProiezione);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Dati inseriti errati.");
                    }
                }
                else{
                    controller.salvaDatiPagamento("Contanti",Double.parseDouble(labelImporto.getText()),cliente,numeroBiglietti,datiProiezione);
                }
            }
        });
    }

}
