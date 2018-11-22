package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioEnReparacion extends EstadoEdificio {

    public EstadoEdificioEnReparacion(Integer vidaMax, Integer reparacion) {

        super(vidaMax,reparacion);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws EdificioReparadoException, EdificioOcupadoException {

        if (this.vidaActual == this.VIDA_MAXIMA) throw new EdificioReparadoException("El edificio esta reparado");

        if( trabajadorActual != reparador){
            throw new EdificioOcupadoException("No se puede reparar este edificio, hay otro aldeano reparandolo!");
        }

        if(trabajadorActual == null) trabajadorActual = reparador;

        this.vidaActual += montoDeReparacion;
        return this;
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioEnReparacionException {
        throw new EdificioEnReparacionException("No se puede construir, el edificio esta en reparación");
    }

    @Override
    public EstadoEdificio suspenderConstruccion(Aldeano quienLoConstruye) throws EdificioDestruidoExcepcion, EdificioNoConstruidoException {
        return null;
    }
}
