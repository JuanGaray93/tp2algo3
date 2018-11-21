package com.company.modelo.unidades.estados;

import com.company.excepciones.AldeanoOcupadoException;

public class EstadoAldeanoConstruyendo extends EstadoAldeano{

    public EstadoAldeanoConstruyendo(){
        this.nombreEstado += "CONSTRUYENDO";
    }

    public EstadoAldeano ejecutarAccion(){
        return new EstadoAldeanoConstruyendo();
    }

    @Override
    public Integer getGanancia(){
        throw new AldeanoOcupadoException("Ahora no!, estoy ocupado");
    }

    public void mover(){

    }

}
