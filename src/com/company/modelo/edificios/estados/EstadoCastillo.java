package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioTerminadoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoCastillo extends EstadoEdificio {

    protected static Integer SIN_COSTO = 0;
    protected Aldeano trabajadorActual = null;

    public EstadoCastillo(Integer vida_maxima) {
        super(vida_maxima,SIN_COSTO);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) {

        return null;
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioTerminadoException {
        throw new EdificioTerminadoException("no se pueden construir castillos");
    }

    @Override
    public EstadoEdificio suspenderConstruccion(Aldeano quienLoConstruye) {
        return null;
    }
}