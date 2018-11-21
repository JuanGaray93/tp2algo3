package com.company.modelo.edificios;

import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoEnConstruccion extends EstadoEdificio {


    public EstadoEnConstruccion(Integer vida, Integer montoDeReparacion) {
        super(vida, costoDeConstruccion, montoDeReparacion);
    }

    @Override
    public EstadoEdificio construir(Aldeano quienLoConstruye) {
        if(trabajadorActual == null){
            trabajadorActual = quienLoConstruye;
        } else if( trabajadorActual != quienLoConstruye){
            throw new EdificioOcupadoException("No se puede construir este edificio, hay otro aldeano construyendolo!");
        }


    }
}
