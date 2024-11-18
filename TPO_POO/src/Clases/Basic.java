package Clases;

import Enumeraciones.Planes;
import Excepciones.CantPersonasException;
import Excepciones.FechaException;

public class Basic extends Plan {

    public Basic() {
        super();
        this.setNombre(Planes.BASIC);
        this.setCantPersonasMaxima(4);
    }

    public void controlarDias(int cantDias) throws FechaException {
        if (cantDias > 7) {
            throw new FechaException("La estadía no puede durar más de 7 días.");
        }
    }

    @Override
    public void controlarMaximoPersonas(int cantPersonas) throws CantPersonasException {
        if (cantPersonas > getCantPersonasMaxima()) {
            throw new CantPersonasException("El plan no permite más de " + getCantPersonasMaxima() + " personas.");
        }
    }

}
