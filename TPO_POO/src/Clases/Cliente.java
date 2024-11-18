package Clases;

import Excepciones.PuntosException;
import Excepciones.ReservaInvalidaException;
import Interfaces.Puntuable;

import java.util.ArrayList;

public class Cliente implements Puntuable {

    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private ArrayList<Reserva> reservas;
    private ArrayList<Integer> puntos;

    public Cliente(String nombre, String apellido, String dni, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.reservas = new ArrayList<Reserva>();
        this.puntos = new ArrayList<Integer>();
    }

    public void reservaInvalida(Reserva reserva) throws ReservaInvalidaException {
        if (reserva.getCantPersonas() <= 0 || reserva.getDiasEstadia() <= 0) {
            throw new ReservaInvalidaException("La reserva no se puede realizar porque los datos son inválidos.");
        }
    }

    public void existeReserva(Reserva reserva) throws ReservaInvalidaException {
        if (!reservas.contains(reserva)) {
            throw new ReservaInvalidaException("La reserva " + reserva.getNumero() + " no pertenece al cliente " + nombre + " " + apellido + ".");
        }
    }

    public void realizarReserva(Reserva reserva) {
        try {
            reservaInvalida(reserva);
            reservas.add(reserva);
        } catch (ReservaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void puedeAcceder(ServicioPlaya servicio, Reserva reserva) {
        try {
            existeReserva(reserva);
            System.out.println("El cliente " + nombre + " " + apellido + " " + reserva.puedeAcceder(servicio) + ".");
        } catch (ReservaInvalidaException e) {
            System.out.println(e.getMessage());
        }
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
            System.out.println("El cliente " + nombre + " " + apellido + " tiene " + cantPuntos + " puntos.");
        } catch (ArithmeticException e) {
            System.out.println("El cliente " + nombre + " " + apellido + " nunca fue puntuado.");
        }
    }

}
