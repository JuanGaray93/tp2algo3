package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.AldeanoOcupadoException;
import com.company.excepciones.DistanciaInvalidaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;

public class EstadoAldeanoConstruyendo extends EstadoAldeano{

    public EstadoAldeanoConstruyendo(){
        super(50);
    }

    @Override
    public EstadoAldeano otorgarGanancia(Jugador jugador) {
        throw new AldeanoOcupadoException("Ocupado construyendo");
    }

    @Override
    public EstadoAldeano construir(Edificio aConstruir, Integer posicionH, Integer posicionV) throws DistanciaInvalidaException,
            EdificioNoConstruidoException, EdificioDestruidoExcepcion {
        if (edificioATrabajar == null) {
            edificioATrabajar = aConstruir;

        } else if (edificioATrabajar != aConstruir) {
            edificioATrabajar.suspenderConstruccion();
            edificioATrabajar = aConstruir;
        }
        return this;
    }

    @Override
    public EstadoAldeano reparar(Edificio edificio) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("El edificio esta siendo construido");
    }

}
