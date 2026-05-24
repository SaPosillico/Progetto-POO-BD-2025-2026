package model;

import java.util.ArrayList;

public class Cliente {
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private ArrayList<Recensione> filmRecensiti;
    private ArrayList<Pagamento> elencoPagamenti;

    public Cliente(String email, String nome, String cognome, String password) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.filmRecensiti = new ArrayList<>();
        this.elencoPagamenti = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Recensione> getFilmRecensiti() {
        return filmRecensiti;
    }

    public void setFilmRecensiti(ArrayList<Recensione> filmRecensiti) {
        this.filmRecensiti = filmRecensiti;
    }

    public ArrayList<Pagamento> getElencoPagamenti() {
        return elencoPagamenti;
    }

    public void setElencoPagamenti(ArrayList<Pagamento> elencoPagamenti) {
        this.elencoPagamenti = elencoPagamenti;
    }

    public void addRecenzione(Recensione r) {
        this.filmRecensiti.add(r);
    }

    public void addPagamento(Pagamento p) {
        this.elencoPagamenti.add(p);
    }
}

