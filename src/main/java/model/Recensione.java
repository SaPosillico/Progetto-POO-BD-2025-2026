package model;

/**
 * The type Recensione.
 */
public class Recensione {
    private int idRecensione;
    private int valutazione;
    private String descrizione;
    private Cliente cliente;
    private Film film;

    /**
     * Instantiates a new Recensione.
     *
     * @param idRecensione l'id della recensione
     * @param valutazione  la valutazione
     * @param descrizione  la descrizione
     * @param cliente      il cliente
     * @param film         il film
     */
    public Recensione(int idRecensione, int valutazione, String descrizione, Cliente cliente, Film film) {
        this.idRecensione = idRecensione;
        this.valutazione = valutazione;
        this.descrizione = descrizione;
        this.cliente = cliente;
        this.film = film;
    }

    /**
     * Gets id recensione.
     *
     * @return the id recensione
     */
    public int getIdRecensione() {
        return idRecensione;
    }

    /**
     * Sets id recensione.
     *
     * @param idRecensione the id recensione
     */
    public void setIdRecensione(int idRecensione) {
        this.idRecensione = idRecensione;
    }

    /**
     * Gets valutazione.
     *
     * @return the valutazione
     */
    public int getValutazione() {
        return valutazione;
    }

    /**
     * Sets valutazione.
     *
     * @param valutazione the valutazione
     */
    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    /**
     * Gets descrizione.
     *
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Sets descrizione.
     *
     * @param descrizione the descrizione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Gets cliente.
     *
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Sets cliente.
     *
     * @param cliente the cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Gets film.
     *
     * @return the film
     */
    public Film getFilm() {
        return film;
    }

    /**
     * Sets film.
     *
     * @param film the film
     */
    public void setFilm(Film film) {
        this.film = film;
    }
}
