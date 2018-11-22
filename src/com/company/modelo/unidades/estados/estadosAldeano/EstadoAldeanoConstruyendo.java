package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.AldeanoOcupadoException;
import com.company.excepciones.DistanciaInvalidaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.Aldeano;

public class EstadoAldeanoConstruyendo extends EstadoAldeano {

    public EstadoAldeanoConstruyendo(Aldeano aldeano) {
        super(aldeano);
    }

    public EstadoAldeano construir(Edificio aConstruir, Integer posicionH, Integer posicionV)
            throws Exception {
        if (edificioATrabajar == null) {
            edificioATrabajar = aConstruir;

        } else if (edificioATrabajar != aConstruir) {
            edificioATrabajar.suspender(esteAldeano);
            edificioATrabajar = aConstruir;
        }
        return this;
    }

    @Override
    public EstadoAldeano reparar(Edificio aReparar) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("El edificio esta siendo construido");
    }

    @Override
    public void otorgarGanancia(Jugador jugador) {

        throw new AldeanoOcupadoException("Ocupado construyendo");
    }

}
