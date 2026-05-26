package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The type Pagamento.
 */
public class Pagamento {
    private String metodoDiPagamento;
    private double importo;
    private LocalDate dataPagamento;
    private LocalTime oraPagamento;
    private ArrayList<Biglietto> bigliettiComprati;
    private Cliente clientePagante;

    /**
     * Instantiates a new Pagamento.
     *
     * @param metodoDiPagamento the metodo di pagamento
     * @param importo           the importo
     * @param dataPagamento     the data pagamento
     * @param oraPagamento      the ora pagamento
     * @param clientePagante    the cliente pagante
     */
    public Pagamento(String metodoDiPagamento, double importo, LocalDate dataPagamento, LocalTime oraPagamento, Cliente clientePagante) {
        this.metodoDiPagamento = metodoDiPagamento;
        this.importo = importo;
        this.dataPagamento = dataPagamento;
        this.oraPagamento = oraPagamento;
        this.bigliettiComprati = new  ArrayList<>();
        this.clientePagante = clientePagante;
    }

    /**
     * Gets metodo di pagamento.
     *
     * @return the metodo di pagamento
     */
    public String getMetodoDiPagamento() {
        return metodoDiPagamento;
    }

    /**
     * Sets metodo di pagamento.
     *
     * @param metodoDiPagamento the metodo di pagamento
     */
    public void setMetodoDiPagamento(String metodoDiPagamento) {
        this.metodoDiPagamento = metodoDiPagamento;
    }

    /**
     * Gets importo.
     *
     * @return the importo
     */
    public double getImporto() {
        return importo;
    }

    /**
     * Sets importo.
     *
     * @param importo the importo
     */
    public void setImporto(double importo) {
        this.importo = importo;
    }

    /**
     * Gets data pagamento.
     *
     * @return the data pagamento
     */
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    /**
     * Sets data pagamento.
     *
     * @param dataPagamento the data pagamento
     */
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * Gets ora pagamento.
     *
     * @return the ora pagamento
     */
    public LocalTime getOraPagamento() {
        return oraPagamento;
    }

    /**
     * Sets ora pagamento.
     *
     * @param oraPagamento the ora pagamento
     */
    public void setOraPagamento(LocalTime oraPagamento) {
        this.oraPagamento = oraPagamento;
    }

    /**
     * Gets biglietti comprati.
     *
     * @return the biglietti comprati
     */
    public ArrayList<Biglietto> getBigliettiComprati() {
        return bigliettiComprati;
    }

    /**
     * Sets biglietti comprati.
     *
     * @param bigliettiComprati the biglietti comprati
     */
    public void setBigliettiComprati(ArrayList<Biglietto> bigliettiComprati) {
        this.bigliettiComprati = bigliettiComprati;
    }

    /**
     * Gets cliente pagante.
     *
     * @return the cliente pagante
     */
    public Cliente getClientePagante() {
        return clientePagante;
    }

    /**
     * Sets cliente pagante.
     *
     * @param clientePagante the cliente pagante
     */
    public void setClientePagante(Cliente clientePagante) {
        this.clientePagante = clientePagante;
    }

    /**
     * Add biglietto.
     *
     * @param biglietto the biglietto
     */
    public void addBiglietto(Biglietto biglietto) {
        this.bigliettiComprati.add(biglietto);
    }
}
