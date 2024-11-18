import Clases.*;
import Enumeraciones.Servicio;

public class Main {

    public static void main(String[] args) {

        // creamos los planes del hotel

        Plan basic = new Basic();
        Plan comfort = new Comfort();
        Plan gold = new Gold();
        Plan luxury = new Luxury();

        // creamos servicios del hotel (en el hotel y en la playa)

        ServicioHotel gimnasio = new ServicioHotel(Servicio.GIMNASIO);
        ServicioHotel pileta = new ServicioHotel(Servicio.PILETA);
        ServicioHotel desayuno = new ServicioHotel(Servicio.DESAYUNO);
        ServicioHotel lavanderia = new ServicioHotel(Servicio.LAVANDERIA);
        ServicioHotel spa = new ServicioHotel(Servicio.SPA);
        ServicioHotel servicioHabitacion24hs =new ServicioHotel(Servicio.SERVICIO_HABITACION_24HS);
        ServicioHotel estacionamiento = new ServicioHotel(Servicio.ESTACIONAMIENTO);

        ServicioPlaya parador = new ServicioPlaya(Servicio.PARADOR);
        ServicioPlaya alquilerSombrillas = new ServicioPlaya(Servicio.ALQUILER_SOMBRILLAS);
        ServicioPlaya carpaPrivada= new ServicioPlaya(Servicio.CARPA_PRIVADA);

        // agregamos los servicios que le corresponden a cada plan

        basic.agregarServicio(gimnasio);
        basic.agregarServicio(pileta);
        basic.agregarServicio(alquilerSombrillas);

        comfort.agregarServicio(gimnasio);
        comfort.agregarServicio(pileta);
        comfort.agregarServicio(alquilerSombrillas);
        comfort.agregarServicio(desayuno);
        comfort.agregarServicio(lavanderia);

        gold.agregarServicio(gimnasio);
        gold.agregarServicio(pileta);
        gold.agregarServicio(alquilerSombrillas);
        gold.agregarServicio(desayuno);
        gold.agregarServicio(lavanderia);
        gold.agregarServicio(spa);
        gold.agregarServicio(parador);

        luxury.agregarServicio(gimnasio);
        luxury.agregarServicio(pileta);
        luxury.agregarServicio(alquilerSombrillas);
        luxury.agregarServicio(desayuno);
        luxury.agregarServicio(lavanderia);
        luxury.agregarServicio(spa);
        luxury.agregarServicio(servicioHabitacion24hs);
        luxury.agregarServicio(estacionamiento);
        luxury.agregarServicio(carpaPrivada);

        // ejemplo de cliente con reserva básica

        Cliente cliente1 = new Cliente("Jorge", "Lopez", "12345678", "direccion1");
        Reserva reserva1 = new Reserva(1, basic);
        reserva1.agregarDiasEstadia(10); // excepción
        reserva1.agregarCantPersonas(5); // excepción
        reserva1.agregarDiasEstadia(5);
        reserva1.agregarCantPersonas(4);
        cliente1.realizarReserva(reserva1);
        reserva1.cualEsMiPlan();

        cliente1.puedeAcceder(pileta, reserva1); // true
        cliente1.puedeAcceder(estacionamiento, reserva1); // false

        cliente1.cuantosPuntosTiene(); // excepción por división por cero (no tiene puntos ingresados)
        cliente1.puntuar(10);
        cliente1.cuantosPuntosTiene();

        pileta.puntuar(15); // excepción fuera de rango (1-10)
        pileta.puntuar(8);
        estacionamiento.cuantosPuntosTiene(); // excepción porque nunca se calificó el estacionamiento
        pileta.cuantosPuntosTiene();

        System.out.println();

        // ejemplo mismo cliente con otra reserva de tipo comfort

        Reserva reserva2 = new Reserva(2, comfort);
        reserva2.agregarDiasEstadia(20);
        reserva2.agregarCantPersonas(9); // false
        reserva2.agregarCantPersonas(0); // false, la reserva queda sin personas ingresadas

        // la reserva no se realizar por error en la cantidad de personas

        cliente1.realizarReserva(reserva2);
        cliente1.puedeAcceder(desayuno, reserva2); // false
        cliente1.puedeAcceder(pileta, reserva2); // false

        // se modifica la reserva para que se agregue

        reserva2.agregarCantPersonas(4);
        cliente1.realizarReserva(reserva2);
        reserva2.cualEsMiPlan();

        cliente1.puedeAcceder(desayuno, reserva2); // true
        cliente1.puedeAcceder(parador, reserva2); // false

        cliente1.puntuar(5);
        cliente1.cuantosPuntosTiene();

        pileta.puntuar(10);
        pileta.cuantosPuntosTiene();

        System.out.println();

        // ejemplo de cliente con reserva gold

        Cliente cliente2 = new Cliente("María", "Perez", "87654321", "direccion2");
        Reserva reserva3 = new Reserva(3, gold);
        reserva3.agregarDiasEstadia(15);
        reserva3.agregarCantPersonas(7); // excepción
        reserva3.agregarCantPersonas(6);
        cliente2.realizarReserva(reserva3);
        reserva3.cualEsMiPlan();

        cliente2.puedeAcceder(carpaPrivada, reserva2); // false, porque la reserva no pertenece a ese cliente
        cliente2.puedeAcceder(carpaPrivada, reserva3); // también da false
        cliente2.puedeAcceder(desayuno, reserva3); // true

        cliente2.puntuar(1);
        cliente2.cuantosPuntosTiene();
        desayuno.puntuar(6);
        desayuno.cuantosPuntosTiene();

    }
}