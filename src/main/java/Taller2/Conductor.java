package Taller2;

public class Conductor {
    private String nombre;
    private String apellido;
    private int numeroTelefonico;
    private String tipoLicencia;
    private Bus bus;

    public Conductor(String nombre, String apellido, int numeroTelefonico, String tipoLicencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefonico = numeroTelefonico;
        this.tipoLicencia = tipoLicencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
