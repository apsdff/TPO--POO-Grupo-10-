package Clases;

import Enumeraciones.Planes;
import Excepciones.FechaException;

import java.util.ArrayList;

public abstract class Plan {

    private Planes nombre;
    private ArrayList<ServicioPlaya> servicios;
    private int cantPersonasMaxima;

    public Plan() {
        this.servicios = new ArrayList<>();
    }

    public Planes getNombre() {
        return nombre;
    }

    public void setNombre(Planes nombre) {
        this.nombre = nombre;
    }

    public int getCantPersonasMaxima() {
        return cantPersonasMaxima;
    }

    public void setCantPersonasMaxima(int cantPersonasMaxima) {
        this.cantPersonasMaxima = cantPersonasMaxima;
    }

    public void controlarDias(int cantDias) throws FechaException {
        if (cantDias <= 0) {
            throw new FechaException("Valor ingresado para la estadía incorrecto.");
        }
    }

    abstract public void controlarMaximoPersonas(int cantPersonas) throws FechaException;

    public void agregarServicio(ServicioPlaya servicio) {
        this.servicios.add(servicio);
    }

    public boolean puedeAcceder(ServicioPlaya servicio) {
        if (this.servicios.contains(servicio)) {
            return true;
        }
        return false;
    }

}
