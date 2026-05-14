package model;

public class ClienteVIP extends Cliente{
    private double percentualeSconto;

    public ClienteVIP(String email, String nome, String cognome, double percentualeSconto) {
        super(email, nome, cognome);
        this.percentualeSconto = percentualeSconto;
    }

    public double getPercentualeSconto() {
        return percentualeSconto;
    }

    public void setPercentualeSconto(double percentualeSconto) {
        this.percentualeSconto = percentualeSconto;
    }
}
