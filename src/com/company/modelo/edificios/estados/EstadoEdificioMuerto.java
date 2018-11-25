package com.company.modelo.edificios.estados;

import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioMuerto extends EstadoEdificio {
    public EstadoEdificioMuerto(Integer vidaMaxima, Integer montoDeReparacion) {
        super(vidaMaxima, montoDeReparacion);
        this.VIDA_ACTUAL = 0;
    }

    @Override
    public EstadoEdificio ejecutarAccion() {
        return this;
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
    public EstadoEdificio suspenderConstruccion() throws EdificioDestruidoExcepcion {
        throw new EdificioDestruidoExcepcion("El edificio esta destruido!");
    }

    @Override
    public Integer getVidaActual() throws EdificioDestruidoExcepcion {
        throw new EdificioDestruidoExcepcion("El edificio esta destruido");
    }

    @Override
    public EstadoEdificio recibirDanio(Integer danio){
        throw new RuntimeException("El edifico no existe, no recibe danio");
    }
}
