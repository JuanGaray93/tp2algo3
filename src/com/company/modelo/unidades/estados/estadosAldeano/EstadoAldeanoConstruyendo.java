package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.AldeanoOcupadoException;
import com.company.modelo.Jugador;

public class EstadoAldeanoConstruyendo extends EstadoAldeano{

    public EstadoAldeanoConstruyendo(){
        this.nombreEstado += "CONSTRUYENDO";
    }

    public EstadoAldeano ejecutarAccion(){
        return this;
    }

    @Override
    public void otorgarGanancia(Jugador jugador) {

        throw new AldeanoOcupadoException("Ocupado construyendo");
    }

    public void mover(){

    }

}
