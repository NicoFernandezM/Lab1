package Taller2;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Bus> buses;
    private ArrayList<Conductor> conductores;

    private String rut;
    private String direccion;
    private String redSocial;

    public Empresa(String rut, String direccion, String redSocial) {
        this.buses = new ArrayList<>();
        this.conductores = new ArrayList<>();
        this.rut = rut;
        this.direccion = direccion;
        this.redSocial = redSocial;
    }

    public void agregarConductor(Conductor conductor) {
        if(!conductorExiste(conductor)) {
            this.conductores.add(conductor);
        }
    }

    public boolean conductorExiste(Conductor conductor) {
        for(Conductor c : conductores) {
            if(c.getNombre().equals(conductor.getNombre()) &&
                c.getApellido().equals(conductor.getApellido())) {

                return true;
            }
        }

        return false;
    }

    public void agregarBus(Bus bus) {
        if(!busExiste(bus.getPatente())) {
            this.buses.add(bus);
        }
    }

    private boolean busExiste(String patente) {
        for(Bus b : buses) {
            if(b.getPatente().equals(patente)) {
                return true;
            }
        }

        return false;
    }

    public void agregarViaje(Viaje viaje, Bus bus) {
        if(busExiste(bus.getPatente())) {
            bus.getViajes().add(viaje);
        }
    }

    public ArrayList<Bus> buscarBusesPorDestinoHora(int horaInicial, int horaFinal, String destino) {
        ArrayList<Bus> busesPorDestinoHora = new ArrayList<>();

        for (Bus bus : buses) {
            for (Viaje viaje : bus.getViajes()) {
                if(estaEnRango(horaInicial, horaFinal, viaje.getHoraSalida()) && viaje.getDestino().equals(destino)) {
                    busesPorDestinoHora.add(bus);
                }
            }
        }

        return busesPorDestinoHora;
    }

    private boolean estaEnRango(int horaInicial, int horaFinal, int horaActual) {
        return (horaActual >= horaInicial && horaActual <= horaFinal);
    }

    public void descontinuarBus(String patente) {
        for (Bus bus : buses) {
            if (bus.getPatente().equals(patente)) {
                this.buses.remove(bus);
                return;
            }
        }
    }

    public int contarBuses() {
        return buses.size();
    }

    public int contarViajes() {
        int numViajes = 0;
        for (Bus bus : buses) {
            numViajes += bus.getViajes().size();
        }

        return numViajes;
    }

}
