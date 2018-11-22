package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioEnConstruccion extends EstadoEdificio {


    public EstadoEdificioEnConstruccion(Integer vidaMax, Integer reparacion) {
        super(vidaMax,reparacion);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws Exception {
        return null;
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) {
        if(trabajadorActual == null){
            trabajadorActual = quienLoConstruye;
        } else if( trabajadorActual != quienLoConstruye){
            throw new EdificioOcupadoException("No se puede construir este edificio, hay otro aldeano construyendolo!");
        }
        return this;
    }
}
