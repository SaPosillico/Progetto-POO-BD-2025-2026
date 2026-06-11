package controller;

import dao.*;
import database.ConnessioneDatabase;
import gui.*;
import implementazionePostgresDAO.*;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
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

    private BigliettoDAO bigliettoDAO;
    private ClienteDAO clienteDAO;
    private FilmDAO filmDAO;
    private ProiezioneDAO proiezioneDAO;
    private SalaDAO salaDAO;
    private RecensioneDAO recensioneDAO;
    private TurnoDAO turnoDAO;
    private PagamentoDAO pagamentoDAO;
    private PostoDAO postoDAO;
    private StaffDAO staffDAO;
    private Connection connection;
    public static final Staff VENDITA_ONLINE = new Staff(0, "Sistema", "Automatico",0);

    //Biglietto
    private ArrayList<String> codiceBiglietto = new ArrayList<>(),  codicePostoBiglietto = new ArrayList<>();
    private ArrayList<Integer> idProiezioneBiglietto = new ArrayList<>(), idPagamentoBiglietto = new ArrayList<>(), matricolaBiglietto = new ArrayList<>();
    private ArrayList<Double> prezzo = new ArrayList<>();

    //Cliente
    private ArrayList<String> email = new ArrayList<>(), nomeCliente = new ArrayList<>(), cognomeCliente = new ArrayList<>(), password = new ArrayList<>(), tipo = new ArrayList<>();
    private ArrayList<Double> percentualeSconto = new ArrayList<>();

    //Film
    private ArrayList<Integer> idFilm = new ArrayList<>();
    private ArrayList<String> titolo = new ArrayList<>(), regista = new ArrayList<>(), rating = new ArrayList<>(), genere = new ArrayList<>();

    //Pagamento
    private ArrayList<Integer> idPagamento = new ArrayList<>();
    private ArrayList<String> metodo = new ArrayList<>(), emailPagamento = new ArrayList<>();
    private ArrayList<Double> importo = new ArrayList<>();
    private ArrayList<LocalDate> data = new ArrayList<>();
    private ArrayList<LocalTime> ora = new ArrayList<>();

    //Posto
    private ArrayList<String> codicePosto = new ArrayList<>();
    private ArrayList<Character> fila = new ArrayList<>();
    private ArrayList<Integer> numero = new ArrayList<>(), numeroSalaPosto = new ArrayList<>();

    //Proiezione
    private ArrayList<Integer> idProiezione = new ArrayList<>(), idFilmProiezione = new ArrayList<>(), numeroSalaProiezione = new ArrayList<>();
    private ArrayList<LocalDate> dataProiezione = new ArrayList<>();
    private ArrayList<LocalTime> ora_inizio = new ArrayList<>(), ora_fine = new ArrayList<>();

    //Recensione
    private ArrayList<Integer> idRecensione = new ArrayList<>(), idFilmRecensione = new ArrayList<>(), valutazione = new ArrayList<>();
    private ArrayList<String> emailRecensione = new ArrayList<>(), descrizione = new ArrayList<>();

    //Sala
    private ArrayList<Integer> numeroSala = new ArrayList<>(), capienza = new ArrayList<>();

    //Staff
    private ArrayList<Integer> matricola = new ArrayList<>();
    private ArrayList<String> nome = new ArrayList<>(), cognome = new ArrayList<>();
    private ArrayList<Double> stipendio = new ArrayList<>();

    //Turno
    private ArrayList<Integer> idTurno = new ArrayList<>(), matricolaTurno = new ArrayList<>();
    private ArrayList<LocalTime> oraInizio = new ArrayList<>(), oraFine = new ArrayList<>();
    private ArrayList<String> mansioni = new ArrayList<>();

    //Staff - Sala
    private ArrayList<Integer> Matricola_Sala = new ArrayList<>(), Sala_matricola = new ArrayList<>();

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

        inizializzaConnessioneDB();
        bigliettoDAO = new BigliettoImplementazionePostgresDAO(this.connection);
        clienteDAO = new ClienteImplementazionePostgresDAO(this.connection);
        filmDAO = new FilmImplementazionePostgresDAO(this.connection);
        recensioneDAO = new RecensioneImplementazionePostgresDAO(this.connection);
        pagamentoDAO = new PagamentoImplementazionePostgresDAO(this.connection);
        postoDAO = new PostoImplementazionePostgresDAO(this.connection);
        staffDAO = new StaffImplementazionePostgresDAO(this.connection);
        proiezioneDAO = new ProiezioneImplementazionePostgresDAO(this.connection);
        salaDAO = new SalaImplementazionePostgresDAO(this.connection);
        turnoDAO = new TurnoImplementazionePostgresDAO(this.connection);
        inizializzaListe();
        daArrayListAOggetti();
    }


    private void inizializzaConnessioneDB() {
        try {
            this.connection = ConnessioneDatabase.getInstance().connection;

            if (this.connection == null || this.connection.isClosed()) {
                System.out.println("[Controller] Errore durante la connessione.");
            }
        } catch (SQLException e) {
            System.err.println("[Controller] Errore critico: Impossibile connettersi al database!");
            e.printStackTrace();
        }
    }
    /**
     * Crea degli oggetti a solo scopo di test del funzionamento complessivo dell'applicativo.
     */
    public void inizializzaListe(){
        bigliettoDAO.recupperaBiglietti(codiceBiglietto,idProiezioneBiglietto,codicePostoBiglietto,idPagamentoBiglietto,matricolaBiglietto,prezzo);
        clienteDAO.recuperaClienti(email,nomeCliente,cognomeCliente,password,tipo,percentualeSconto);
        filmDAO.recuperaFilm(idFilm,titolo,regista,rating,genere);
        pagamentoDAO.recuperaPagamenti(idPagamento,metodo,importo,data,ora,emailPagamento);
        postoDAO.recuperaPosti(codicePosto,fila,numero,numeroSalaPosto);
        proiezioneDAO.recuperaProiezioni(idProiezione,dataProiezione,ora_inizio,ora_fine,idFilmProiezione,numeroSalaProiezione);
        recensioneDAO.recuperaRecensioni(idRecensione,idFilmRecensione,emailRecensione,descrizione,valutazione);
        salaDAO.recuperaSale(numeroSala,capienza);
        staffDAO.recuperaStaff(matricola,nome,cognome,stipendio);
        turnoDAO.recuperaTurni(idTurno,oraInizio,oraFine,mansioni,matricolaTurno);
        salaDAO.recuperaDatiStaffSAle(Matricola_Sala,Sala_matricola);
    }

    public void daArrayListAOggetti(){
        //Cliente
        for(int i=0; i< email.size(); i++){
            if(tipo.get(i).equals("Ordinario")){
                Cliente nuovoCliente = new Cliente(email.get(i), nomeCliente.get(i), cognomeCliente.get(i), password.get(i));
                listaClienti.add(nuovoCliente);
            }
            else{
                ClienteVIP nuovoCliente = new ClienteVIP(email.get(i), nomeCliente.get(i), cognomeCliente.get(i), percentualeSconto.get(i), password.get(i));
                listaClienti.add(nuovoCliente);
            }
        }

        //Film
        for(int i=0; i< idFilm.size(); i++){
            Film nuovoFilm = new Film(idFilm.get(i), titolo.get(i), regista.get(i), Genere.valueOf(genere.get(i)), Rating.valueOf(rating.get(i)));
            listaFilm.add(nuovoFilm);
        }

        //Sala
        for(int i=0; i< numeroSala.size(); i++){
            Sala nuovaSala = new Sala(numeroSala.get(i),capienza.get(i));
            listaSale.add(nuovaSala);
        }

        //Staff
        for(int i=0; i< matricola.size(); i++){
            Staff nuovoMembro = new Staff(matricola.get(i), nome.get(i), cognome.get(i), stipendio.get(i));
            membriDelloStaff.add(nuovoMembro);
        }

        //Recensione
        for(int i=0; i< idRecensione.size(); i++){
            Film filmRecensito = null;
            Cliente clienteRecensore = null;

            for(Cliente c: listaClienti){
                if(c.getEmail().equals(emailRecensione.get(i))){
                    clienteRecensore=c;
                    break;
                }
            }

            for(Film f: listaFilm){
                if(f.getIdFilm()==idFilmRecensione.get(i)){
                    filmRecensito=f;
                    break;
                }
            }
            Recensione nuovaRecensione= new Recensione(idRecensione.get(i), valutazione.get(i), descrizione.get(i), clienteRecensore, filmRecensito);
            recensioni.add(nuovaRecensione);
        }

        //Turno
        for(int i=0; i< idTurno.size(); i++){
            Staff membro=null;
            for(Staff s:  membriDelloStaff){
                if(s.getMatricola()==matricolaTurno.get(i)){
                    membro=s;
                    break;
                }
            }
            Turno nuovoTurno = new Turno(idTurno.get(i),oraInizio.get(i),oraFine.get(i),membro,mansioni.get(i));
            turniAssegnati.add(nuovoTurno);
        }

        //Pagamento
        for(int i=0; i< idPagamento.size(); i++){
            Cliente clientePagante=null;
            for(Cliente c: listaClienti){
                if(c.getEmail().equals(emailPagamento.get(i))){
                    clientePagante=c;
                    break;
                }
            }
            Pagamento nuovoPagamento = new Pagamento(idPagamento.get(i),metodo.get(i),importo.get(i),data.get(i),ora.get(i),clientePagante);
            elencoPagamenti.add(nuovoPagamento);
        }

        //Posto
        for(int i=0; i< codicePosto.size(); i++){
            Sala salaOspite = null;
            for(Sala s: listaSale){
                if(s.getNumeroSala()==numeroSalaPosto.get(i)){
                    salaOspite=s;
                    break;
                }
            }
            Posto nuovoPosto = new Posto(codicePosto.get(i),fila.get(i),numero.get(i),salaOspite);
            listaPosti.add(nuovoPosto);
        }

        //Proiezione
        for(int i=0; i<idProiezione.size(); i++){
            Sala salaOspite = null;
            Film filmProiettato = null;
            for(Sala s: listaSale){
                if(s.getNumeroSala()==numeroSalaProiezione.get(i)){
                    salaOspite=s;
                    break;
                }
            }

            for(Film f: listaFilm){
                if(f.getIdFilm()==idFilmProiezione.get(i)){
                    filmProiettato=f;
                    break;
                }
            }
            Proiezione nuovaProiezione = new Proiezione(idProiezione.get(i),dataProiezione.get(i),ora_inizio.get(i),ora_fine.get(i),salaOspite,filmProiettato);
            listaProiezioni.add(nuovaProiezione);
        }

        //Biglietto
        for(int i=0; i< codiceBiglietto.size(); i++){
            Posto postoAssegnato = null;
            Proiezione proiezioneAssegnata = null;
            Staff responsabile = null;
            Pagamento pagamentoEffettuato = null;

            for(Proiezione p: listaProiezioni){
                if(p.getIdProiezione()==idProiezioneBiglietto.get(i)){
                    proiezioneAssegnata = p;
                    break;
                }
            }
            for(Posto p : listaPosti){
                if(p.getCodicePosto().equals(codicePostoBiglietto.get(i))){
                    postoAssegnato = p;
                    break;
                }
            }
            for(Staff s : membriDelloStaff){
                if(s.getMatricola()==matricolaBiglietto.get(i)){
                    responsabile = s;
                    break;
                }
            }
            for(Pagamento p : elencoPagamenti){
                if(p.getIdPagamento()==idPagamentoBiglietto.get(i)){
                    pagamentoEffettuato = p;
                    break;
                }
            }
            Biglietto nuovoBiglietto = new Biglietto(codiceBiglietto.get(i), prezzo.get(i), postoAssegnato,proiezioneAssegnata,responsabile,pagamentoEffettuato);
            bigliettiVenduti.add(nuovoBiglietto);
        }

        //Cliente -> Recensione e Pagamento
        for(Cliente c : listaClienti){
            for(Recensione r : recensioni){
                if(r.getCliente().equals(c)){
                    c.addRecenzione(r);
                }
            }
            for(Pagamento p : elencoPagamenti){
                if(p.getClientePagante().equals(c)){
                    c.addPagamento(p);
                }
            }
        }

        //Film -> Recensione e Proiezione
        for(Film f : listaFilm){
            for(Recensione r : recensioni){
                if(r.getFilm().equals(f)){
                    f.addRecensione(r);
                }
            }
            for(Proiezione p : listaProiezioni){
                if(p.getFilmProiettato().equals(f)){
                    f.addProiezione(p);
                }
            }
        }

        //Pagamento -> Biglietto
        for(Pagamento p : elencoPagamenti){
            for(Biglietto b : bigliettiVenduti){
                if(b.getAcquisto().equals(p)){
                    p.addBiglietto(b);
                }
            }
        }

        //Posto -> Biglietto
        for(Posto p : listaPosti){
            for(Biglietto b : bigliettiVenduti){
                if(b.getNumeroPosto().equals(p)){
                    p.addBiglietto(b);
                }
            }
        }

        //Proiezione -> Biglietto
        for(Proiezione p : listaProiezioni){
            for(Biglietto b : bigliettiVenduti){
                if(b.getProiezioneRiferita().equals(p)){
                    p.addBiglietto(b);
                }
            }
        }

        //Sala -> Posto, Proiezione, Staff
        for(Sala s : listaSale){
            for(Posto p : listaPosti){
                if(p.getNumeroSala().equals(s)){
                    s.addPostiPresenti(p);
                }
            }
            for(Proiezione p : listaProiezioni){
                if(p.getSalaProiezione().equals(s)){
                    s.addProiezione(p);
                }
            }
            for(Staff st : membriDelloStaff){
                for(Sala sala : st.getSalePulite()){
                    if(sala.equals(s)){
                        s.addStaffDiSala(st);
                    }
                }
            }
        }

        //Staff -> Turno, Biglietto
        for(Staff s : membriDelloStaff){
            for(Turno t : turniAssegnati){
                if(t.getMembro().equals(s)){
                    s.addTurniEffettuati(t);
                }
            }
            for(Biglietto b : bigliettiVenduti){
                if(b == null || b.getVenditoreResponsabile() == null){
                    continue;
                }

                if(b.getVenditoreResponsabile().equals(s)){
                    s.addBiglietto(b);
                }
            }
        }

        //Staff -> Sala e Sala -> Staff
        for(int i=0; i< Matricola_Sala.size(); i++){
            for(Staff s: membriDelloStaff){
                if(s.getMatricola()==Matricola_Sala.get(i)){
                    for(Sala sa : listaSale){
                        if(sa.getNumeroSala()==Sala_matricola.get(i)){
                            s.addSala(sa);
                            sa.addStaffDiSala(s);
                            break;
                        }
                    }
                    break;
                }
            }
        }
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
        filmSelector.addItem(" ");
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

    public void creaListaProiezioni(JComboBox<String> projectionSelector, String film){
        DefaultComboBoxModel<String> nuovoModello = new DefaultComboBoxModel<>();

        if (film != null && !film.trim().isEmpty()) {
            for (Proiezione p : listaProiezioni) {
                if (p.getFilmProiettato() != null && p.getFilmProiettato().getTitolo().equals(film)) {
                    String elementoDellaLista = "Sala " + p.getSalaProiezione().getNumeroSala() +
                            ", data " + p.getDataProiezione() +
                            ", orario " + p.getOraInizioProiezione() +
                            " - " + p.getOraFineProiezione();

                    nuovoModello.addElement(elementoDellaLista);
                }
            }
        }

        if (nuovoModello.getSize() == 0) {
            nuovoModello.addElement("Nessuna proiezione disponibile.");
        }

        projectionSelector.setModel(nuovoModello);
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

    public boolean checkCardDetails(String numeroCarta, String CVVCarta, String scadenzaCarta){
        if (numeroCarta == null || CVVCarta == null || scadenzaCarta == null) return false;
        numeroCarta = numeroCarta.replace(" ", "").replace("-", "");

        if (!CVVCarta.matches("\\d{3,4}")) {
            return false;
        }

        try {
            String[] partiData = scadenzaCarta.split("/");
            if (partiData.length != 2) return false;

            int mese = Integer.parseInt(partiData[0].trim());
            int anno = Integer.parseInt(partiData[1].trim());

            if (anno < 100) anno += 2000;

            if (mese < 1 || mese > 12) return false;

            LocalDate oggi = LocalDate.now();
            LocalDate ultimoGiornoMeseScadenza = LocalDate.of(anno, mese, 1).plusMonths(1).minusDays(1);

            if (ultimoGiornoMeseScadenza.isBefore(oggi)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        int sommaCifre = 0;
        boolean raddoppia = false;
        for(int i=numeroCarta.length()-1; i>=0; i--){
            char c = numeroCarta.charAt(i);
            int cifra = Character.getNumericValue(c);

            if (raddoppia) {
                cifra *= 2;
                if (cifra > 9) {
                    cifra -= 9;
                }
            }

            sommaCifre += cifra;
            raddoppia = !raddoppia;
        }

        return sommaCifre % 10 == 0;
    }

    public boolean salvaDatiPagamento(String metodo, double importo, Cliente cliente, int numeroBiglietti, String datiProiezione){
        try{
            Proiezione proiezioneSelezionata = null;

            for(Proiezione p : listaProiezioni){
                if(("Sala " + p.getSalaProiezione().getNumeroSala() + ", data " + p.getDataProiezione() + ", orario " + p.getOraInizioProiezione() + " - " + p.getOraFineProiezione()).equals(datiProiezione)){
                    proiezioneSelezionata = p;
                    break;
                }
            }

            ArrayList<Posto> postoLiberoTrovato = new ArrayList<>();
            for(int i=0; i<numeroBiglietti; i++){
                for (Posto posto : listaPosti) {
                    if (posto.getNumeroSala().getNumeroSala() == proiezioneSelezionata.getSalaProiezione().getNumeroSala()) {
                        if(postoLiberoTrovato.contains(posto))
                            continue;

                        boolean giaOccupato = false;
                        for (Biglietto b : bigliettiVenduti) {
                            if (b.getProiezioneRiferita().getIdProiezione() == proiezioneSelezionata.getIdProiezione() &&
                                    b.getNumeroPosto().getCodicePosto().equals(posto.getCodicePosto())) {
                                giaOccupato = true;
                                break;
                            }
                        }

                        if (!giaOccupato) {
                            postoLiberoTrovato.add(posto);
                            break;
                        }
                    }
                }
            }
            if (postoLiberoTrovato.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Sold Out: Non ci sono più posti disponibili per questa proiezione.");
                return false;
            }
            else if(postoLiberoTrovato.size()<numeroBiglietti) {
                JOptionPane.showMessageDialog(null, "I posti disponibili per questa proiezione "+postoLiberoTrovato.size()+", sono inferiori a quelli richiesti "+numeroBiglietti+".");
                return false;
            }

            pagamentoDAO.inserisciPagamento(metodo,importo,LocalDate.now(),LocalTime.now(), cliente.getEmail());
            int idPagamentoEffettuato = pagamentoDAO.getNewestId();
            if(idPagamentoEffettuato==-1)
                return false;
            Pagamento nuovoPagamento = new Pagamento(idPagamentoEffettuato,metodo,importo,LocalDate.now(),LocalTime.now(),cliente);
            elencoPagamenti.add(nuovoPagamento);

            for(Posto p : postoLiberoTrovato){
                inserisciNuovoBiglietto(nuovoPagamento,proiezioneSelezionata,p,(importo/numeroBiglietti));
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void inserisciNuovoBiglietto(Pagamento nuovoPagamento, Proiezione proiezioneSelezionata, Posto posto, double importo){
        String codiceBiglietto = "B"+posto.getCodicePosto()+nuovoPagamento.getIdPagamento()+proiezioneSelezionata.getIdProiezione();
        bigliettoDAO.inserisciNuovoBiglietto(codiceBiglietto, proiezioneSelezionata.getIdProiezione(), posto.getCodicePosto(), nuovoPagamento.getIdPagamento(), null, importo);

        Biglietto nuovoBiglietto = new Biglietto(codiceBiglietto, importo, posto, proiezioneSelezionata, null, nuovoPagamento);
        bigliettiVenduti.add(nuovoBiglietto);
        posto.addBiglietto(nuovoBiglietto);
        proiezioneSelezionata.addBiglietto(nuovoBiglietto);
        nuovoPagamento.addBiglietto(nuovoBiglietto);
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
    public boolean aggiungiRecensione(String film, String valutazione, String descrizione, Cliente cliente) {
        if (film == null || valutazione == null) return false;

        Film filmTrovato = null;
        for (Film f : listaFilm) {
            if (f.getTitolo().equals(film)) {
                filmTrovato = f;
                break;
            }
        }

        if (filmTrovato != null) {

            Recensione nuovaRecensione = new Recensione(0, Integer.parseInt(valutazione), descrizione, cliente, filmTrovato);
            recensioneDAO.inserisciRecensione(filmTrovato.getIdFilm(), cliente.getEmail(), descrizione, Integer.parseInt(valutazione));
            cliente.addRecenzione(nuovaRecensione);
            filmTrovato.addRecensione(nuovaRecensione);
            this.recensioni.add(nuovaRecensione);
            return true;
        }
        return false;
    }

    /**
     * Mostra i dati dell'ultimo turno differenziando anche se si tratta di un turno ordinario o di straordinari basandosi sugli orari del turno precedente.
     *
     * @param pannelloDettagli il pannello contenente i dettagli
     * @param membro           il membro dello staff che ha eseguito il turno
     */
    public void mostraDatiTurno(JPanel pannelloDettagli, Staff membro){
        Turno ultimoTurno = membro.getTurniEffettuati().getLast();
        pannelloDettagli.add(new JLabel("Ora inizio:"));
        pannelloDettagli.add(new JLabel(membro.getTurniEffettuati().getLast().getOraInizioTurno().toString()));
        pannelloDettagli.add(new JLabel("Ora fine:"));
        pannelloDettagli.add(new JLabel(membro.getTurniEffettuati().getLast().getOraFineTurno().toString()));
        pannelloDettagli.add(new JLabel("Mansioni:"));
        pannelloDettagli.add(new JLabel(membro.getTurniEffettuati().getLast().getMansione()));
        pannelloDettagli.add(new JLabel("Tipologia:"));
        if (membro.getTurniEffettuati().size() >= 2) {
            Turno penultimoTurno = membro.getTurniEffettuati().get(membro.getTurniEffettuati().size() - 2);

            if (ultimoTurno.getOraInizioTurno().equals(penultimoTurno.getOraFineTurno())) {
                pannelloDettagli.add(new JLabel("Straordinario, x1,5 sullo stipendio orario per questo turno."));
            } else {
                pannelloDettagli.add(new JLabel("Ordinario"));
            }
        } else {
            pannelloDettagli.add(new JLabel("Ordinario"));
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
            LocalDate dataConvertita = LocalDate.parse(giorno, formatter);
            LocalTime inizioConvertito = LocalTime.parse(oraInizio);
            LocalTime fineConvertito = LocalTime.parse(oraFine);
            for(Sala s : listaSale){
                if(s.getNumeroSala() == Integer.parseInt(sala)){
                    Proiezione nuovaProiezione = new Proiezione(0, LocalDate.parse(giorno, formatter), LocalTime.parse(oraInizio), LocalTime.parse(oraFine), s, film);
                    proiezioneDAO.inserisciProiezione(LocalDate.parse(giorno),LocalTime.parse(oraInizio),LocalTime.parse(oraFine), film.getIdFilm(), Integer.parseInt(sala));
                    film.addProiezione(nuovaProiezione);
                    listaProiezioni.add(nuovaProiezione);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean aggiungiFilmOProiezione(String titolo, String regista, Genere genere, Rating rating, String giorno, String oraInizio, String oraFine, String sala){
        for(Film f : listaFilm){
            if(f.getTitolo().equals(titolo)){
                return aggiungiProiezione(f, giorno, oraInizio, oraFine, sala);
            }
        }

        Film nuovoFilm = new Film(0, titolo, regista, genere, rating);
        filmDAO.inserisciFilm(titolo,regista,rating.toString(),genere.toString());
        listaFilm.add(nuovoFilm);
        return aggiungiProiezione(nuovoFilm, giorno, oraInizio, oraFine, sala);
    }
}
