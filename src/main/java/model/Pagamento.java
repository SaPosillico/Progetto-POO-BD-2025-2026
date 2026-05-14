package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Pagamento {
    private String metodoDiPagamento;
    private double importo;
    private LocalDate dataPagamento;
    private LocalTime oraPagamento;
    private ArrayList<Biglietto> bigliettiComprati;
    private Cliente clientePagante;

    public Pagamento(String metodoDiPagamento, double importo, LocalDate dataPagamento, LocalTime oraPagamento, Cliente clientePagante) {
        this.metodoDiPagamento = metodoDiPagamento;
        this.importo = importo;
        this.dataPagamento = dataPagamento;
        this.oraPagamento = oraPagamento;
        this.bigliettiComprati = new  ArrayList<>();
        this.clientePagante = clientePagante;
    }

    public String getMetodoDiPagamento() {
        return metodoDiPagamento;
    }

    public void setMetodoDiPagamento(String metodoDiPagamento) {
        this.metodoDiPagamento = metodoDiPagamento;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalTime getOraPagamento() {
        return oraPagamento;
    }

    public void setOraPagamento(LocalTime oraPagamento) {
        this.oraPagamento = oraPagamento;
    }

    public ArrayList<Biglietto> getBigliettiComprati() {
        return bigliettiComprati;
    }

    public void setBigliettiComprati(ArrayList<Biglietto> bigliettiComprati) {
        this.bigliettiComprati = bigliettiComprati;
    }

    public Cliente getClientePagante() {
        return clientePagante;
    }

    public void setClientePagante(Cliente clientePagante) {
        this.clientePagante = clientePagante;
    }

    public void addBiglietto(Biglietto biglietto) {
        this.bigliettiComprati.add(biglietto);
    }
}
