package Clases;

import Enumeraciones.Planes;
import Excepciones.CantPersonasException;

public class Gold extends Plan {

    public Gold() {
        super();
        this.setNombre(Planes.GOLD);
        this.setCantPersonasMaxima(6);
    }

    @Override
    public void controlarMaximoPersonas(int cantPersonas) throws CantPersonasException {
        if (cantPersonas > this.getCantPersonasMaxima()) {
            throw new CantPersonasException("El plan no permite más de " + this.getCantPersonasMaxima() + " personas.");
        }
    }

}
