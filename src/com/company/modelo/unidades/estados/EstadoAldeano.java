package com.company.modelo.unidades.estados;

import com.company.modelo.unidades.EstadoUnidad;

public class EstadoAldeano extends EstadoUnidad {

    private Integer vida;

    public EstadoAldeano(int vida, int costo) {
        super(vida, costo);

    }


    //Esto se debería hacer con polimorfismo y varios estados.
    public void recolectarOro(){
        if(this.vida > 0){
            
        }
    }
}
