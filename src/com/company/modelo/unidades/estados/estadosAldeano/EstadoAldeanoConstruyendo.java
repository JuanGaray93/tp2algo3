package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.AldeanoOcupadoException;
import com.company.excepciones.DistanciaInvalidaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoAldeanoConstruyendo extends EstadoAldeano{

    public EstadoAldeanoConstruyendo(Integer vidaActual){
        super(vidaActual);
    }

    @Override
    public EstadoAldeano reparar(Edificio aReparar) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("El edificio esta siendo construido");
    }

    @Override
    public EstadoAldeano construir(Edificio edificio)
            throws Exception, EdificioEnConstruccionException {
        if (edificioATrabajar == null) {
            edificioATrabajar = edificio;
        } else if (edificioATrabajar != edificio) {
            edificioATrabajar.suspender();
            edificioATrabajar = edificio;
        }

        return this;
    }

    @Override
    public EstadoAldeano actualizar() throws Exception {

        edificioATrabajar.avanzarConstruccion();

        return this;
    }
}
