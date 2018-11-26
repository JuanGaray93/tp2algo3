package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.AldeanoOcupadoException;
import com.company.excepciones.DistanciaInvalidaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoAldeanoConstruyendo extends EstadoAldeano {

    private Edificio edificioSiendoConstruido;
    private Aldeano constructor;

    public EstadoAldeanoConstruyendo(Aldeano constructor, Edificio edificioSiendoConstruido){
        this.constructor = constructor;
        this.edificioSiendoConstruido = edificioSiendoConstruido;
    }

    public EstadoAldeano construir(Aldeano constructor, Edificio aConstruir, Integer posicionH, Integer posicionV)
            throws Exception, EdificioEnConstruccionException { // TODO nunca se usan las posiciones. por que?
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
    public EstadoAldeano otorgarGanancia(Jugador jugador) {

        throw new AldeanoOcupadoException("Ocupado construyendo");
    }

    @Override
    public EstadoAldeano construir(Edificio edificio, Integer posicionH, Integer posicionV) throws Exception, DistanciaInvalidaException {
        return new EstadoAldeanoConstruyendo(constructor, edificio);
    }

    @Override
    public EstadoUnidad actualizar() throws Exception {
        try{
            edificioSiendoConstruido.avanzarConstruccion(constructor);
        } catch (EdificioEnConstruccionException e){
            return this;
        }

        return this;
    }
}
