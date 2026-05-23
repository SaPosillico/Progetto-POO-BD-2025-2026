package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton homeButton;
    private JButton filmButton;
    private JButton proiezioniButton;
    private JButton logInButton;
    private JTextArea areaDescrizione;
    private static JFrame frameHome;
    private Controller controller;

    public static void main(String[] args) {
        frameHome = new JFrame("Home");
        frameHome.setContentPane(new Home().mainPanel);
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHome.pack();
        frameHome.setVisible(true);
        frameHome.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public JFrame getFrame() {
        return this.frameHome;
    }

    public Home() {
        controller = new Controller(frameHome);
        // Add action listeners or other initialization code here

        areaDescrizione.setText("""
    ============================================================
    CINEUNIVERSE - La magia del grande schermo, dal vivo!
    ============================================================
    
    Benvenuti al CineUniverse, il punto di riferimento in città per tutti gli 
    amanti della settima arte. Il nostro obiettivo è trasformare ogni proiezione 
    in un'esperienza indimenticabile, unendo la tecnologia più avanzata al 
    massimo del comfort.
    
    I NOSTRI SERVIZI ESCLUSIVI:
    ------------------------------------------------------------
       Tecnologia Laser 4K & Dolby Atmos: 
       Tutte le nostre 5 sale sono dotate di proiettori di ultima generazione 
       e sistemi audio immersivi per farti sentire al centro dell'azione.
       
       Comfort Premium: 
       Dimentica i vecchi sedili stretti. Al CineUniverse trovi solo poltrone VIP 
       in pelle, extra-large e completamente reclinabili.
       
       Popcorn Corner: 
       Un'area ristoro fornitissima con popcorn caldi (salati e caramellati), 
       snack artigianali, dolci e un'ampia selezione di bevande.
    
    INFORMAZIONI DI SERVIZIO:
    ------------------------------------------------------------
       Dove siamo: Via del Cinema 42, Città della Luce.
       Orari di apertura: Lunedì - Domenica dalle 15:30 alle 23:30 
       (Nei giorni festivi l'apertura è anticipata alle 10:00).
    
    PROMOZIONI DELLA SETTIMANA:
    ------------------------------------------------------------
       Mercoledì Universitario: Biglietto ridotto a soli 5,00€ per tutti gli studenti.
       Family Pack: 2 Adulti + 2 Bambini a soli 22,00€ (Popcorn incluso!).
    """);
        areaDescrizione.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        filmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //PaginaFilmGUI paginaFilm = new PaginaFilmGUI(frameHome,controller);
                controller.changeFrame(new PaginaFilmGUI(frameHome,controller).getFrame());
            }
        });
        proiezioniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //PaginaProiezioniGUI paginaProiezioni = new PaginaProiezioniGUI(frameHome,controller);
                controller.changeFrame(new PaginaProiezioniGUI(frameHome,controller).getFrame());
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //PaginaLogInGUI paginaLogIn = new PaginaLogInGUI(frameHome,controller);
                controller.changeFrame(new PaginaLogInGUI(frameHome,controller).getFrame());
            }
        });
        areaDescrizione.setSize(1920,1080);
    }
}
