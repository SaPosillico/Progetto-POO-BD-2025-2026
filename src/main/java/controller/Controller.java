package controller;

import gui.*;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * The type Controller.
 */
public class Controller {
    private JFrame frameAttuale;
    private ArrayList<Cliente> listaClienti;
    private ArrayList<Staff> membriDelloStaff;
    private ArrayList<Film> listaFilm;
    private ArrayList<Proiezione> listaProiezioni;
    private ArrayList<Sala> listaSale;
    private ArrayList<Biglietto> bigliettiVenduti;
    private ArrayList<Posto> listaPosti;
    private ArrayList<Recensione> recensioni;
    private ArrayList<Turno> turniAssegnati;
    private ArrayList<Pagamento> elencoPagamenti;
    /**
     * Il Modello della lista è necessario per inserire i dati nella lista dei biglietti acquistati.
     */
    public static DefaultListModel<Biglietto> modelloLista;

    /**
     * Instantiates a new Controller.
     *
     * @param frameHome il frame home
     */
    public Controller(JFrame frameHome){
        frameAttuale = frameHome;
        listaClienti = new ArrayList<>();
        membriDelloStaff = new ArrayList<>();
        listaFilm = new ArrayList<>();
        listaProiezioni = new ArrayList<>();
        listaSale = new ArrayList<>();
        bigliettiVenduti = new ArrayList<>();
        listaPosti = new ArrayList<>();
        recensioni = new ArrayList<>();
        turniAssegnati = new ArrayList<>();
        elencoPagamenti = new ArrayList<>();
        inserisciDatiTest();
    }

    /**
     * Crea degli oggetti a solo scopo di test del funzionamento complessivo dell'applicativo.
     */
    public void inserisciDatiTest(){
        Cliente c1 = new Cliente("a@gmail.com","Mario","Rossi","mario.rossi");
        Cliente c2 = new Cliente("b@gmail.com","Luca","Rossi","luca.rossi");
        Cliente c3 = new Cliente("c@gmail.com","Marco","Rossi","marco.rossi");
        listaClienti.add(c1);
        listaClienti.add(c2);
        listaClienti.add(c3);

        Staff s1 = new Staff(1,"Ant","Ros",12.5);
        Staff s2 = new Staff(2,"Ant","Ter",12.5);
        Staff s3 = new Staff(3,"Sal","Pos",12.5);
        membriDelloStaff.add(s1);
        membriDelloStaff.add(s2);
        membriDelloStaff.add(s3);

        Film f1 = new Film("film1","regista1",Genere.Thriller,Rating.VM18);
        Film f2 = new Film("film2","regista1",Genere.Avventura,Rating.VM14);
        Film f3 = new Film("film3","regista2",Genere.Fantasy,Rating.PerTutti);
        listaFilm.add(f1);
        listaFilm.add(f2);
        listaFilm.add(f3);

        Sala sa1 = new Sala(1,30);
        Sala sa2 = new Sala(2,150);
        Sala sa3 = new Sala(3,75);
        listaSale.add(sa1);
        listaSale.add(sa2);
        listaSale.add(sa3);

        Proiezione p1 = new Proiezione(LocalDate.of(2026,6,12), LocalTime.of(20,30), LocalTime.of(22,30),sa1,f2);
        Proiezione p2 = new Proiezione(LocalDate.of(2026,6,13), LocalTime.of(20,30), LocalTime.of(22,30),sa2,f2);
        Proiezione p3 = new Proiezione(LocalDate.of(2026,6,20), LocalTime.of(20,30), LocalTime.of(22,30),sa1,f3);
        listaProiezioni.add(p1);
        listaProiezioni.add(p2);
        listaProiezioni.add(p3);

        Posto po1 = new Posto(1,'a',12,sa1);
        Posto po2 = new Posto(2,'a',10,sa1);
        Posto po3 = new Posto(3,'a',5,sa1);
        listaPosti.add(po1);
        listaPosti.add(po2);
        listaPosti.add(po3);

        Pagamento pag1 = new Pagamento("contante",14,LocalDate.of(2026,7,11),LocalTime.now(),c1);
        Pagamento pag2 = new Pagamento("contante",70,LocalDate.of(2026,7,21),LocalTime.now(),c2);
        Pagamento pag3 = new Pagamento("contante",35,LocalDate.of(2026,8,11),LocalTime.now(),c3);
        elencoPagamenti.add(pag1);
        elencoPagamenti.add(pag2);
        elencoPagamenti.add(pag3);

        Biglietto b1 = new Biglietto(1,7,po1,p1,s1,pag1);
        Biglietto b2 = new Biglietto(2,7,po2,p3,s2,pag2);
        Biglietto b3 = new Biglietto(3,7,po2,p1,s1,pag1);
        bigliettiVenduti.add(b1);
        bigliettiVenduti.add(b2);
        bigliettiVenduti.add(b3);

        Recensione r1 = new Recensione(5,"Bello",c1,f1);
        Recensione r2 = new Recensione(4,"Bello",c2,f1);
        Recensione r3 = new Recensione(1,"Brutto",c3,f1);
        recensioni.add(r1);
        recensioni.add(r2);
        recensioni.add(r3);

        Turno t1 = new Turno(LocalTime.now(),LocalTime.now().plusHours(8),s1,"Pulizia");
        Turno t2 = new Turno(LocalTime.now(),LocalTime.now().plusHours(8),s2,"Vendita");
        Turno t3 = new Turno(LocalTime.now(),LocalTime.now().plusHours(8),s3,"Pulizia");
        turniAssegnati.add(t1);
        turniAssegnati.add(t2);
        turniAssegnati.add(t3);

        listaClienti.getFirst().addPagamento(pag1);
        elencoPagamenti.getFirst().addBiglietto(b1);
        elencoPagamenti.getFirst().addBiglietto(b2);
        listaFilm.getFirst().addProiezione(p1);
        listaFilm.getFirst().addProiezione(p2);
        listaFilm.getFirst().addProiezione(p3);
        membriDelloStaff.getFirst().addTurniEffettuati(t1);
        membriDelloStaff.getLast().addTurniEffettuati(t2);
        membriDelloStaff.getLast().addTurniEffettuati(t3);
    }

    /**
     * Controlla i dati di accesso dei clienti e restituisce un valore booleano che permette di dare indicazioni riguardo il successo dell'operazione di accesso.
     * Inoltre, in caso positivo, cambia anche il frame con quello della pagina home per i clienti "LoggedClientGUI".
     *
     * @param email      email del cliente
     * @param password   the password del cliente
     * @param controller the controller
     * @param frameHome  the frame home
     * @return the boolean
     */
    public boolean checkClientLogInDetails(String email, String password, Controller controller, JFrame frameHome){
        for (Cliente c : listaClienti){
            if(c.getEmail().equals(email)){
                changeFrame(new LoggedClientGUI(frameHome,controller,c).getFrame());
                return true;
            }
        }
        return false;
    }

    /**
     * Controlla i dati di accesso dello staff e restituisce un valore booleano che permette di dare indicazioni riguardo il successo dell'operazione di accesso.
     * Inoltre, in caso positivo, cambia anche il frame con quello della pagina home per lo staff "TurnoGUI".
     *
     * @param user       l'user che corrisponde a Nome.cognome
     * @param matricola  la matricola
     * @param controller il controller
     * @param frameHome  il frame home
     * @return the boolean
     */
    public boolean checkAdminLogInDetails(String user, int matricola, Controller controller, JFrame frameHome){
        for(Staff s : membriDelloStaff){
            if((s.getNome()+"."+s.getCognome()).equals(user) && s.getMatricola()==matricola){
                changeFrame(new TurnoGUI(frameHome,controller,s).getFrame());
                return true;
            }
        }
        return false;
    }

    /**
     * Permette di cambiare frame aprendo quello nuovo con le dimensioni massime.
     * Esegue queste operazioni nel modo più "liscio" possibile, aprendo prima il nuovo frame e chiudendo il vecchio.
     *
     * @param nuovoFrame il nuovo frame da aprire
     */
    public void changeFrame(JFrame nuovoFrame){
        if(nuovoFrame!=null){
            JFrame frameDaChiudere = this.frameAttuale;
            this.frameAttuale = nuovoFrame;
            this.frameAttuale.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.frameAttuale.setVisible(true);
            if (frameDaChiudere != null) {
                frameDaChiudere.dispose();
            }
        }
    }

    /**
     * Prendendo in ingresso il pannello "pannelloDati", con un ciclo for, lo riempie von delle label per descrivere gli attributi di ciascun film.
     * Esegue anche una formattazione dei contenuti, separando i dati del singolo film in dei panel temporanei.
     *
     * @param pannelloDati il pannello dati
     */
    public void popolaElencoFilm(JPanel pannelloDati){
        pannelloDati.removeAll();
        pannelloDati.setLayout(new BoxLayout(pannelloDati, BoxLayout.Y_AXIS));
        for(Film f : listaFilm){
            JPanel temp = new JPanel();
            temp.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

            JLabel labelTitolo = new JLabel("Titolo: ");
            JLabel titolo = new JLabel(f.getTitolo());
            JLabel labelRegista = new JLabel("Regista: ");
            JLabel regista = new JLabel(f.getRegista());
            JLabel labelRating = new JLabel("Rating: ");
            JLabel rating = new JLabel(f.getRating().toString());
            JLabel labelGenere = new JLabel("Genere: ");
            JLabel genere = new JLabel(f.getGenere().toString());

            titolo.setFont(new Font("Segoe UI", Font.BOLD, 12));

            temp.add(labelTitolo);
            temp.add(titolo);
            temp.add(labelRegista);
            temp.add(regista);
            temp.add(labelRating);
            temp.add(rating);
            temp.add(labelGenere);
            temp.add(genere);

            temp.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
            pannelloDati.add(temp);
        }
        pannelloDati.revalidate();
        pannelloDati.repaint();
    }

    /**
     * Riempie la tabella contenente i dati di tutte le proiezioni usando un ciclo for per recuperare tutti i dati.
     *
     * @param tabella la tabella che contiene i dati.
     */
    public void aggiornaTabellaProiezioni(JTable tabella) {
        String[] colonne = {"Film", "Sala", "Data", "Inizio","Fine"};

        DefaultTableModel model = new DefaultTableModel(colonne, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Rende la tabella non modificabile con un doppio click
            }
        };

        model.addRow(colonne);

        for (Proiezione p : listaProiezioni) {
            Object[] riga = {
                    p.getFilmProiettato().getTitolo(),
                    p.getSalaProiezione().getNumeroSala(),
                    p.getDataProiezione(),
                    p.getOraInizioProiezione(),
                    p.getOraFineProiezione()
            };
            model.addRow(riga);
        }
        tabella.setModel(model);
    }

    /**
     * Riempie la lista dei biglietti acquistati da un certo cliente
     *
     * @param listaBigliettiAcquistati la lista biglietti acquistati
     * @param cliente                  il cliente corrispondente
     */
    public void aggiornaListaBiglietti(JList listaBigliettiAcquistati, Cliente cliente){
        modelloLista = new DefaultListModel<Biglietto>();
        ArrayList<Biglietto> bigliettiTrovati = new ArrayList<>();
        for(Pagamento p : cliente.getElencoPagamenti()){
            bigliettiTrovati.addAll(p.getBigliettiComprati());
        }
        modelloLista.addAll(bigliettiTrovati);
        listaBigliettiAcquistati.setModel(modelloLista);
    }

    /**
     * Aggiunge i film ad una JComboBox per poterne scegliere uno durante l'acquisto dei biglietti.
     *
     * @param filmSelector la JComboBox per scegliere il film
     */
    public void creaListaFilm(JComboBox filmSelector){
        for(Film f : listaFilm){
            filmSelector.addItem(f.getTitolo());
        }
    }

    /**
     * Crea la lista delle proiezioni partendo dal film selezionato
     *
     * @param projectionSelector la JComboBox per scegliere la proiezione
     * @param film               il film selezionato
     */
    public void creaListaProiezioni(JComboBox projectionSelector, String film){
        projectionSelector.removeAll();
        for(Film f : listaFilm){
            if(f.getTitolo().equals(film)){
                for(Proiezione p : f.getProiezioni()){
                    projectionSelector.addItem("Sala "+p.getSalaProiezione().getNumeroSala()+", data "+p.getDataProiezione()+", orario "+p.getOraInizioProiezione()+" - "+p.getOraFineProiezione());
                }
                return;
            }
        }
    }

    /**
     * Controlla i dati inseriti e conferma o no l'acquisto dei biglietti.
     *
     * @param film            il film selezioanto
     * @param proiezione      la proiezione scelta
     * @param numeroBiglietti il numero biglietti acquistati
     * @return the boolean
     */
    public boolean checkPurchaseDetails(String film, String proiezione, String numeroBiglietti){
        if(numeroBiglietti==null || numeroBiglietti.isEmpty() || film.isEmpty() || proiezione.isEmpty()){
            return false;
        }
        else{
            try{
                Integer.parseInt(numeroBiglietti);
                return true;
            }
            catch (NumberFormatException e){
                return false;
            }
        }
    }

    /**
     * Crea la lista delle possibili valutazioni per lasciare una recensione.
     *
     * @param valutazione la JComboBox per poter dare una valutazione
     */
    public void creaListaValutazione(JComboBox<String> valutazione) {
        valutazione.removeAll();
        for (int i = 0; i < 5; i++) {
            valutazione.addItem(String.valueOf(i + 1));
        }
    }

    /**
     * In base ai dati inseriti, conferma la loro conformità e inserisce la nuova recensione.
     *
     * @param film        il film recensito
     * @param valutazione la valutazione scelta
     * @param descrizione la descrizione data
     * @param cliente     il cliente che ha lasciato la recensione
     */
    public void aggiungiRecensione(String film, String valutazione, String descrizione, Cliente cliente) {
        if (film == null || valutazione == null) return;

        Film filmTrovato = null;
        for (Film f : listaFilm) {
            if (f.getTitolo().equals(film)) {
                filmTrovato = f;
                break;
            }
        }

        if (filmTrovato != null) {
            Recensione nuovaRecensione = new Recensione(Integer.parseInt(valutazione), descrizione, cliente, filmTrovato);
            cliente.addRecenzione(nuovaRecensione);
            filmTrovato.addRecensione(nuovaRecensione);
        }
    }

    /**
     * Mostra i dati dell'ultimo turno differenziando anche se si tratta di un turno ordinario o di straordinari basandosi sugli orari del turno precedente.
     *
     * @param pannelloDettagli il pannello contenente i dettagli
     * @param membro           il membro dello staff che ha eseguito il turno
     */
    public void mostraDatiTurno(JPanel pannelloDettagli, Staff membro){
        pannelloDettagli.add(new JLabel("Ora inizio:"));
        pannelloDettagli.add(new JLabel(membro.getTurniEffettuati().getLast().getOraInizioTurno().toString()));
        pannelloDettagli.add(new JLabel("Ora fine:"));
        pannelloDettagli.add(new JLabel(membro.getTurniEffettuati().getLast().getOraFineTurno().toString()));
        pannelloDettagli.add(new JLabel("Mansioni:"));
        pannelloDettagli.add(new JLabel(membro.getTurniEffettuati().getLast().getMansione()));
        pannelloDettagli.add(new JLabel("Tipologia:"));
        if(membro.getTurniEffettuati().getLast().getOraInizioTurno().equals(membro.getTurniEffettuati().get(membro.getTurniEffettuati().size()-2).getOraFineTurno())){
            pannelloDettagli.add(new Label("Straordinario, x1,5 sullo stipendio orario per questo turno."));
        }
        else{
            pannelloDettagli.add(new Label("Ordinario"));
        }
    }

    /**
     * Permette di visualizzare alcuni dei principali dati relativi alla gestione del cinema.
     *
     * @param biglietti   i biglietti venduti
     * @param valutazioni la media delle valutazioni
     * @param bestFilm    il miglior film per vendita di bigletti
     */
    public void visualizzaDati(JLabel biglietti, JLabel valutazioni, JLabel bestFilm){
        int totaleBigliettiVenduti=0, totaleRecensioni=0, sommeValutazioni=0, sommaBiglietti, migliorFilm=-1;
        String filmTrovato = "No data.";
        for(Biglietto b : bigliettiVenduti){
            totaleBigliettiVenduti+=1;
        }
        biglietti.setText(""+totaleBigliettiVenduti);

        for(Recensione r : recensioni){
            totaleRecensioni += 1;
            sommeValutazioni += r.getValutazione();
        }
        valutazioni.setText(""+(double)sommeValutazioni/totaleRecensioni);

        for(Film f : listaFilm){
            sommaBiglietti =0;
            if(f.getProiezioni() != null){
                for(Proiezione p : f.getProiezioni()){
                    if(p.getBigliettiVenduti() != null){
                        sommaBiglietti += p.getBigliettiVenduti().size();
                    }
                }
                if(sommaBiglietti>migliorFilm){
                    migliorFilm = sommaBiglietti;
                    filmTrovato = f.getTitolo();
                }
            }
        }
        bestFilm.setText(filmTrovato);
    }

    /**
     * Aggiungi valori nelle JComboBox per poter inserire un nuovo film, con una proiezione già organizzata, o una nuova proiezione riguardo un film già presente nel sistema.
     *
     * @param genere il genere
     * @param rating il rating
     * @param sala   la sala
     */
    public void aggiungiValoriPerSelezione(JComboBox genere, JComboBox rating, JComboBox sala){
        for(Genere g : Genere.values()){
            genere.addItem(g);
        }

        for(Rating r : Rating.values()){
            rating.addItem(r);
        }

        for(Sala s : listaSale){
            sala.addItem(s.getNumeroSala());
        }
    }

    /**
     * Controlla la conformità della data inserita relativa all'inserimento di una nuova proiezione.
     *
     * @param data la data
     * @return the boolean
     */
    public boolean isDataValida(String data) {
        if (data == null || data.trim().isEmpty()) {
            return false;
        }
        try {
            // Definiamo il pattern personalizzato
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(data, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Controlla la conformità dell'orario inserito relativo all'inserimento di una nuova proiezione.
     *
     * @param ora l'ora
     * @return the boolean
     */
    public boolean isLocalTimeValido(String ora) {
        if (ora == null || ora.trim().isEmpty()) {
            return false;
        }
        try {
            LocalTime.parse(ora);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Aggiungi la nuova proiezione, con i relativi dati in seguito all'inserimento dei dati nella pagina di inserimento.
     *
     * @param film      il film
     * @param giorno    il giorno
     * @param oraInizio l'ora d'inizio
     * @param oraFine   l'ora di fine
     * @param sala      la sala
     * @return the boolean
     */
    public boolean aggiungiProiezione(Film film, String giorno, String oraInizio, String oraFine, String sala){
        if (isDataValida(giorno) && isLocalTimeValido(oraInizio) && isLocalTimeValido(oraFine)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for(Sala s : listaSale){
                if(s.getNumeroSala()==Integer.parseInt(sala)){
                    Proiezione nuovaProiezione = new Proiezione(LocalDate.parse(giorno, formatter),LocalTime.parse(oraInizio),LocalTime.parse(oraFine),s,film);
                    film.addProiezione(nuovaProiezione);
                    listaProiezioni.add(nuovaProiezione);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Aggiungi un nuovo film e/o una nuova proiezione in base ai dati inseriti nella pagina d'inserimento.
     *
     * @param titolo    il titolo
     * @param regista   il regista
     * @param genere    il genere
     * @param rating    il rating
     * @param giorno    il giorno
     * @param oraInizio l'ora d'inizio
     * @param oraFine   l'ora di fine
     * @param sala      la sala
     * @return the boolean
     */
    public boolean aggiungiFilmOProiezione(String titolo, String regista, Genere genere, Rating rating, String giorno, String oraInizio, String oraFine, String sala){
        for(Film f : listaFilm){
            if(f.getTitolo().equals(titolo)){
                return aggiungiProiezione(f,giorno,oraInizio,oraFine,sala);
            }
        }
        Film nuovoFilm = new Film(titolo,regista,genere,rating);
        listaFilm.add(nuovoFilm);
        return aggiungiProiezione(nuovoFilm,giorno,oraInizio,oraFine,sala);
    }
}
