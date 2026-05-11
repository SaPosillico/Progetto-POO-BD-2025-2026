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
}
