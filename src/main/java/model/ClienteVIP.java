package model;

/**
 * The type Cliente vip.
 */
public class ClienteVIP extends Cliente{
    private double percentualeSconto;

    /**
     * Instantiates a new Cliente vip.
     *
     * @param email             l'email
     * @param nome              il nome
     * @param cognome           il cognome
     * @param percentualeSconto la percentuale sconto
     * @param password          la password
     */
    public ClienteVIP(String email, String nome, String cognome, double percentualeSconto, String password) {
        super(email, nome, cognome, password);
        this.percentualeSconto = percentualeSconto;
    }

    /**
     * Gets percentuale sconto.
     *
     * @return the percentuale sconto
     */
    public double getPercentualeSconto() {
        return percentualeSconto;
    }

    /**
     * Sets percentuale sconto.
     *
     * @param percentualeSconto the percentuale sconto
     */
    public void setPercentualeSconto(double percentualeSconto) {
        this.percentualeSconto = percentualeSconto;
    }

    @Override
    public String getTipo() {
        return "VIP";
    }
}
