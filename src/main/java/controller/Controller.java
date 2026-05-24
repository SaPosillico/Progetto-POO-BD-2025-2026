package controller;

import gui.*;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
    public static DefaultListModel<Biglietto> modelloLista;

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
    }

    public boolean checkClientLogInDetails(String email, String password, Controller controller, JFrame frameHome){
        for (Cliente c : listaClienti){
            if(c.getEmail().equals(email)){
                changeFrame(new LoggedClientGUI(frameHome,controller,c).getFrame());
                return true;
            }
        }
        return false;
    }

    public boolean checkAdminLogInDetails(String user, int matricola, Controller controller, JFrame frameHome){
        for(Staff s : membriDelloStaff){
            if((s.getNome()+"."+s.getCognome()).equals(user) && s.getMatricola()==matricola){
                changeFrame(new LoggedStaffGUI(frameHome,controller,s).getFrame());
                return true;
            }
        }
        return false;
    }

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

    public void aggiornaListaBiglietti(JList listaBigliettiAcquistati, Cliente cliente){
        modelloLista = new DefaultListModel<Biglietto>();
        ArrayList<Biglietto> bigliettiTrovati = new ArrayList<>();
        for(Pagamento p : cliente.getElencoPagamenti()){
            bigliettiTrovati.addAll(p.getBigliettiComprati());
        }
        modelloLista.addAll(bigliettiTrovati);
        listaBigliettiAcquistati.setModel(modelloLista);
    }

    public void creaListaFilm(JComboBox filmSelector){
        filmSelector.addItem("");
        for(Film f : listaFilm){
            filmSelector.addItem(f.getTitolo());
        }
    }

    public void creaListaProiezioni(JComboBox projectionSelector, String film){
        projectionSelector.removeAll();
        projectionSelector.addItem("");
        for(Film f : listaFilm){
            if(f.getTitolo().equals(film)){
                for(Proiezione p : f.getProiezioni()){
                    projectionSelector.addItem("Sala "+p.getSalaProiezione().getNumeroSala()+", data "+p.getDataProiezione()+", orario "+p.getOraInizioProiezione()+" - "+p.getOraFineProiezione());
                }
                return;
            }
        }
    }

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
}
