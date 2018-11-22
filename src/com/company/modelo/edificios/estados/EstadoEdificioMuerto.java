package com.company.modelo.edificios.estados;

import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioMuerto extends EstadoEdificio {
    public EstadoEdificioMuerto(Integer vida, Integer montoDeReparacion) {
        super(vida,montoDeReparacion);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws EdificioDestruidoExcepcion {
        throw new EdificioDestruidoExcepcion("El edificio esta destruido!");
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioDestruidoExcepcion {
        throw new EdificioDestruidoExcepcion("El edificio esta destruido!");
    }

    @Override
    public EstadoEdificio suspenderConstruccion(Aldeano quienLoConstruye) throws EdificioDestruidoExcepcion {
        throw new EdificioDestruidoExcepcion("El edificio esta destruido!");
    }
}
