package model;

import java.time.LocalTime;

public class Turno {
    private LocalTime oraInizioTurno;
    private LocalTime oraFineTurno;
    private Staff membro;

    public Turno(LocalTime oraInizioTurno, LocalTime oraFineTurno, Staff membro) {
        this.oraInizioTurno = oraInizioTurno;
        this.oraFineTurno = oraFineTurno;
        this.membro = membro;
    }

    public LocalTime getOraInizioTurno() {
        return oraInizioTurno;
    }

    public void setOraInizioTurno(LocalTime oraInizioTurno) {
        this.oraInizioTurno = oraInizioTurno;
    }

    public LocalTime getOraFineTurno() {
        return oraFineTurno;
    }

    public void setOraFineTurno(LocalTime oraFineTurno) {
        this.oraFineTurno = oraFineTurno;
    }

    public Staff getMembro() {
        return membro;
    }

    public void setMembro(Staff membro) {
        this.membro = membro;
    }
}
