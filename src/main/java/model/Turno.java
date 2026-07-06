package model;

import java.time.LocalTime;

/**
 * The type Turno.
 */
public class Turno {
    private int idTurno;
    private LocalTime oraInizioTurno;
    private LocalTime oraFineTurno;
    private Staff membro;
    private String mansione;

    /**
     * Instantiates a new Turno.
     *
     * @param idTurno        l'id del turno
     * @param oraInizioTurno l'ora inizio turno
     * @param oraFineTurno   l'ora fine turno
     * @param membro         il membro dello staff a cui è assegnato il turno
     * @param mansione       la mansione
     */
    public Turno(int idTurno, LocalTime oraInizioTurno, LocalTime oraFineTurno, Staff membro, String mansione) {
        this.idTurno = idTurno;
        this.oraInizioTurno = oraInizioTurno;
        this.oraFineTurno = oraFineTurno;
        this.membro = membro;
        this.mansione = mansione;
    }

    /**
     * Gets id turno.
     *
     * @return the id turno
     */
    public int getIdTurno() {
        return idTurno;
    }

    /**
     * Sets id turno.
     *
     * @param idTurno the id turno
     */
    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    /**
     * Gets ora inizio turno.
     *
     * @return the ora inizio turno
     */
    public LocalTime getOraInizioTurno() {
        return oraInizioTurno;
    }

    /**
     * Sets ora inizio turno.
     *
     * @param oraInizioTurno the ora inizio turno
     */
    public void setOraInizioTurno(LocalTime oraInizioTurno) {
        this.oraInizioTurno = oraInizioTurno;
    }

    /**
     * Gets ora fine turno.
     *
     * @return the ora fine turno
     */
    public LocalTime getOraFineTurno() {
        return oraFineTurno;
    }

    /**
     * Sets ora fine turno.
     *
     * @param oraFineTurno the ora fine turno
     */
    public void setOraFineTurno(LocalTime oraFineTurno) {
        this.oraFineTurno = oraFineTurno;
    }

    /**
     * Gets membro.
     *
     * @return the membro
     */
    public Staff getMembro() {
        return membro;
    }

    /**
     * Sets membro.
     *
     * @param membro the membro
     */
    public void setMembro(Staff membro) {
        this.membro = membro;
    }

    /**
     * Gets mansione.
     *
     * @return the mansione
     */
    public String getMansione() {
        return mansione;
    }

    /**
     * Sets mansione.
     *
     * @param mansione the mansione
     */
    public void setMansione(String mansione) {
        this.mansione = mansione;
    }
}
