package model;

import java.util.ArrayList;

/**
 * The type Cliente.
 */
public class Cliente {
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private ArrayList<Recensione> filmRecensiti;
    private ArrayList<Pagamento> elencoPagamenti;

    /**
     * Instantiates a new Cliente.
     *
     * @param email    the email
     * @param nome     the nome
     * @param cognome  the cognome
     * @param password the password
     */
    public Cliente(String email, String nome, String cognome, String password) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.filmRecensiti = new ArrayList<>();
        this.elencoPagamenti = new ArrayList<>();
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets cognome.
     *
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Sets cognome.
     *
     * @param cognome the cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets film recensiti.
     *
     * @return the film recensiti
     */
    public ArrayList<Recensione> getFilmRecensiti() {
        return filmRecensiti;
    }

    /**
     * Sets film recensiti.
     *
     * @param filmRecensiti the film recensiti
     */
    public void setFilmRecensiti(ArrayList<Recensione> filmRecensiti) {
        this.filmRecensiti = filmRecensiti;
    }

    /**
     * Gets elenco pagamenti.
     *
     * @return the elenco pagamenti
     */
    public ArrayList<Pagamento> getElencoPagamenti() {
        return elencoPagamenti;
    }

    /**
     * Sets elenco pagamenti.
     *
     * @param elencoPagamenti the elenco pagamenti
     */
    public void setElencoPagamenti(ArrayList<Pagamento> elencoPagamenti) {
        this.elencoPagamenti = elencoPagamenti;
    }

    /**
     * Add recenzione.
     *
     * @param r the r
     */
    public void addRecenzione(Recensione r) {
        this.filmRecensiti.add(r);
    }

    /**
     * Add pagamento.
     *
     * @param p the p
     */
    public void addPagamento(Pagamento p) {
        this.elencoPagamenti.add(p);
    }
}

