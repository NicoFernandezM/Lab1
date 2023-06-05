package Taller2;

import java.util.ArrayList;

public class Bus {
    private Conductor conductor;
    private String patente;
    private String marca;
    private String modelo;
    private ArrayList<Viaje> viajes;

    public Bus(Conductor conductor, String patente, String marca, String modelo) {
        this.conductor = conductor;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.viajes = new ArrayList<>();
    }

    public Conductor getConductor() {
        return conductor;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }
}
