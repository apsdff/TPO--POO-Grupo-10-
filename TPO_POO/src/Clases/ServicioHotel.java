package Clases;

import Enumeraciones.Servicio;
import Excepciones.PuntosException;
import Interfaces.Puntuable;

import java.util.ArrayList;

public class ServicioHotel extends ServicioPlaya implements Puntuable {

    private ArrayList<Integer> puntos;

    public ServicioHotel(Servicio servicio) {
        super(servicio);
        this.puntos = new ArrayList<Integer>();
    }

    public void puntosFueraRango(int p) throws PuntosException {
        if (p < 0 || p > 10) {
            throw new PuntosException("El puntaje ingresado no está dentro del rango permitido (1-10).");
        }
    }

    @Override
    public void puntuar(int p) {
        try {
            puntosFueraRango(p);
            puntos.add(p);
        } catch (PuntosException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void cuantosPuntosTiene() {
        try {
            int suma = 0;
            for (int i = 0; i < puntos.size(); i++) {
                suma += puntos.get(i);
            }
            int cantPuntos = suma / puntos.size();
            System.out.println("El servicio " + getServicio() + " tiene " + cantPuntos + " puntos.");
        } catch (ArithmeticException e) {
            System.out.println("El servicio " + getServicio() + " nunca fue puntuado.");
        }
    }

}
