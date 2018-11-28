package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.estados.EstadoUnidad;


public class EstadoAldeanoConstruyendo extends EstadoAldeano {

    private Aldeano constructor;

    public EstadoAldeanoConstruyendo() {
    }

    public EstadoAldeano construir(Aldeano constructor, Edificio aConstruir, Integer posicionH, Integer posicionV)
            throws Exception {
        if (edificioATrabajar == null) {
            edificioATrabajar = aConstruir;

        } else if (edificioATrabajar != aConstruir) {
            edificioATrabajar.suspender();
            edificioATrabajar = aConstruir;
        }

        this.constructor = constructor;

        return this;
    }

    @Override
    public EstadoAldeano reparar(Edificio aReparar) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("El edificio esta siendo construido");
    }

    @Override
    public EstadoAldeano construir(Edificio edificio, Integer posicionH, Integer posicionV)
            throws Exception {
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

        try {

            edificioATrabajar.avanzarConstruccion();

        } catch (EdificioEnConstruccionException e) {
            return this;
        }

        return this;
    }
}
