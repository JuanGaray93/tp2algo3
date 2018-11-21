package com.company.modelo.unidades.estados;

import com.company.excepciones.AldeanoOcupadoException;

public class EstadoAldeanoReparando extends EstadoAldeano {

        public EstadoAldeanoReparando(){
            this.nombreEstado += "REPARANDO";
        }

        public EstadoAldeanoReparando ejecutarAccion(){
            return new EstadoAldeanoReparando();
        }

    @Override
    public Integer getGanancia(){
        throw new AldeanoOcupadoException("Ahora no!, estoy ocupado");
    }

}
