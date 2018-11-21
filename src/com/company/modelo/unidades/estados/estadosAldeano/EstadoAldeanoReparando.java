package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.AldeanoOcupadoException;
import com.company.modelo.Jugador;

public class EstadoAldeanoReparando extends EstadoAldeano {

        public EstadoAldeanoReparando(){
            this.nombreEstado += "REPARANDO";
        }

        public EstadoAldeanoReparando ejecutarAccion(){
            return new EstadoAldeanoReparando();
        }

    @Override
    public void otorgarGanancia(Jugador jugador) {
        throw new AldeanoOcupadoException("... reparando");
    }


}
