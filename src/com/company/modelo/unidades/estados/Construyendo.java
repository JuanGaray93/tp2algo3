package com.company.modelo.unidades.estados;

public class Construyendo extends EstadoAldeano{

    public Construyendo(){

    }

    public EstadoAldeano ejecutarAccion(){
        return new Construyendo();
    }

    public void mover(){

    }

}
