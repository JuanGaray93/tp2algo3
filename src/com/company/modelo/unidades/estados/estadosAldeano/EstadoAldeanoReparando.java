package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.AldeanoOcupadoException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoAldeanoReparando extends EstadoAldeano {

    public EstadoAldeano construir(Edificio edificio, Integer posicionH, Integer posicionV) throws Exception, EdificioEnConstruccionException {
        throw new AldeanoOcupadoException("Estoy reparando...");
    }

    public EstadoAldeano reparar(Edificio aReparar) throws Exception {
        if (edificioATrabajar == null) {
            edificioATrabajar = aReparar;
        } else if (edificioATrabajar != aReparar) {

            edificioATrabajar.suspender();
            edificioATrabajar = aReparar;
        }

        return this;
    }

    @Override
    public EstadoAldeano actualizar() throws Exception {
        try {
            edificioATrabajar.avanzarReparacion();
        } catch (EdificioEnConstruccionException e) {
            return this;
        }

        return this;
    }
}
