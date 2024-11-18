package Clases;

import Enumeraciones.Planes;
import Excepciones.CantPersonasException;
import Excepciones.FechaException;

public class Reserva {
    private int numero;
    private Plan plan;
    private int diasEstadia;
    private int cantPersonas;

    public Reserva(int numero, Plan plan) {
        this.numero = numero;
        this.plan = plan;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public int getDiasEstadia() {
        return diasEstadia;
    }

    public void agregarDiasEstadia (int diasEstadia) {
        try {
            this.plan.controlarDias(diasEstadia);
            this.diasEstadia = diasEstadia;
            System.out.println("La cantidad de días de la estadía es valida.");
        } catch (FechaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregarCantPersonas (int cantPersonas) {
        try {
            this.plan.controlarMaximoPersonas(cantPersonas);
            this.cantPersonas = cantPersonas;
            System.out.println("La cantidad de personas es valida.");
        } catch (CantPersonasException e) {
            System.out.println(e.getMessage());
        }
    }

    public Planes getPlan() {
        return this.plan.getNombre();
    }

    public int getNumero() {
        return numero;
    }

    public String puedeAcceder(ServicioPlaya servicio) {
        if (this.plan.puedeAcceder(servicio)) {
            return "puede acceder al servicio " + servicio.getServicio();
        }
        return "no puede acceder al servicio " +  servicio.getServicio();
    }

    public void cualEsMiPlan() {
        System.out.println("El plan de la reserva número " + this.getNumero() + " es " + this.getPlan() + ".");
    }

}
