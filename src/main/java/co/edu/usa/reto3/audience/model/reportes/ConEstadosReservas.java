package co.edu.usa.reto3.audience.model.reportes;

public class ConEstadosReservas {
    private int completadas;
    private int canceladas;

    public ConEstadosReservas(int completadas, int canceladas) {
        this.completadas = completadas;
        this.canceladas = canceladas;
    }

    public int getCompletadas() {
        return completadas;
    }

    public void setCompletadas(int completadas) {
        this.completadas = completadas;
    }

    public int getCanceladas() {
        return canceladas;
    }

    public void setCanceladas(int canceladas) {
        this.canceladas = canceladas;
    }
}
