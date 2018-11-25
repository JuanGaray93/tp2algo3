package com.company.modelo.unidades.estados;

import com.company.modelo.Posicionable;

public class EstadoUnidadAtacando extends EstadoUnidad {

    private Posicionable enemigo;

    public EstadoUnidadAtacando(Integer vida){
        super(vida);
        enemigo = null;
    }

    public EstadoUnidad atacar(Posicionable unEnemigo){
        this.enemigo = unEnemigo;
        return this;
    }

    public EstadoUnidad dejarDeAtacar(){
        this.enemigo = null;
        return this;
    }

}
