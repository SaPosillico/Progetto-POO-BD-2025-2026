package model;

public class Recensione {
    private int valutazione;
    private String descrizione;
    private Cliente cliente;
    private Film film;

    public Recensione(int valutazione, String descrizione, Cliente cliente, Film film) {
        this.valutazione = valutazione;
        this.descrizione = descrizione;
        this.cliente = cliente;
        this.film = film;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
