package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioEnReparacion extends EstadoEdificio{

    public EstadoEdificioEnReparacion(Integer vidaMax, Integer reparacion) {
        super(vidaMax,reparacion);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws Exception {
        if(trabajadorActual == null){
            trabajadorActual = reparador;
        }else if(trabajadorActual != null){
            throw new EdificioOcupadoException("No se puede repparar este edificio, hay otro aldeano reparandolo!");
        }
        return this;
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioEnConstruccionException, Exception {
        return null;
    }

    @Override
    public EstadoEdificio suspender(Aldeano quienLoConstruye){
        this.trabajadorActual = null;
        return this;
    }
}
