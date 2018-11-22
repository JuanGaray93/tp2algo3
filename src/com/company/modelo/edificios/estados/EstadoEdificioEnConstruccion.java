package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioEnConstruccion extends EstadoEdificio {


    public EstadoEdificioEnConstruccion(Integer vidaMax, Integer reparacion) {
        super(vidaMax,reparacion);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("El edificio se esta construyendo");
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioOcupadoException {
        if(trabajadorActual == null){
            trabajadorActual = quienLoConstruye;
        } else if( trabajadorActual != quienLoConstruye){
            throw new EdificioOcupadoException("No se puede construir este edificio, hay otro aldeano construyendolo!");
        }
        return this;
    }

    @Override
    public EstadoEdificio suspenderConstruccion(Aldeano quienLoConstruye){
        this.trabajadorActual = null;
        return this;
    }
}
