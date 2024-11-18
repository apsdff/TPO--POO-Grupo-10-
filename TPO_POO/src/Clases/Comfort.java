package Clases;

import Enumeraciones.Planes;
import Excepciones.FechaException;

public class Comfort extends Basic {

    public Comfort() {
        super();
        this.setNombre(Planes.COMFORT);
    }

    @Override
    public void controlarDias(int cantDias) throws FechaException {
        if (cantDias > 30) {
            throw new FechaException("La estadía no puede durar más de 30 días.");
        }
    }

}
