package Taller2;

import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("23","Francisco salazar","EmpresaTemuco");
        Conductor conductor = new Conductor("Oscar", "Fuentes", 43544385, "A5");
        Bus bus = new Bus(conductor,"ADCD54", "Toyota", "H5");
        Viaje viaje = new Viaje("Pucon", "Temuco", 1600, 1800);
        Viaje viaje1 = new Viaje("Santiago", "Temuco", 2100, 700);
        Viaje viaje2 = new Viaje("Villarrica", "Temuco", 1500, 1600);

        Bus bus2 = new Bus(conductor,"SDAJ67", "Mercedes-Benz", "G7");

        empresa.agregarConductor(conductor);
        empresa.agregarBus(bus);
        empresa.agregarBus(bus2);
        ArrayList<Viaje> viajes = bus.getViajes();
        empresa.agregarViaje(viaje, bus);
        empresa.agregarViaje(viaje1, bus2);
        empresa.agregarViaje(viaje2, bus2);

        for(Viaje v : viajes) {
            System.out.println(v.getDestino());
        }

        ArrayList<Bus> buses = empresa.buscarBusesPorDestinoHora(1200, 1800, "Temuco");

        for(Bus b : buses) {
            System.out.println(b.getPatente());
        }

        System.out.println(empresa.contarBuses());
        System.out.println(empresa.contarViajes());
    }

}
