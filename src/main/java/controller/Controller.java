package controller;

import gui.LoggedClientGUI;
import gui.LoggedStaffGUI;
import model.*;
import javax.swing.*;
import java.awt.*;
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
    private ArrayList<Turno> turniDisponibili;

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
        turniDisponibili = new ArrayList<>();
        inserisciDatiTest();
    }

    public void inserisciDatiTest(){
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
    }

    public boolean checkClientLogInDetails(String email, String password, Controller controller, JFrame frameHome){
        for (Cliente c : listaClienti){
            if(c.getEmail().equals(email)){
                changeFrame(new LoggedClientGUI(frameHome,controller).getFrame());
                return true;
            }
        }
        return false;
    }

    public boolean checkAdminLogInDetails(String user, int matricola, Controller controller, JFrame frameHome){
        for(Staff s : membriDelloStaff){
            if((s.getNome()+"."+s.getCognome()).equals(user) && s.getMatricola()==matricola){
                changeFrame(new LoggedStaffGUI(frameHome,controller).getFrame());
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

}
