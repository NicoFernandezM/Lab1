package Taller2;

public class Viaje {
    private String origen;
    private String destino;
    private int horaSalida;
    private int horaLlegada;

    public Viaje(String origen, String destino, int horaSalida, int horaLlegada) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public int getHoraLlegada() {
        return horaLlegada;
    }
}
