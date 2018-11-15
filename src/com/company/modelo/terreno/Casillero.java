package com.company.modelo.terreno;
import com.company.excepciones.CasilleroLlenoException;

public class Casillero {

    private modelo.Posicionable habitante;

    public Casillero(){
        habitante = null;
    }

    public Boolean estaOcupado() {
        return ( habitante != null );
    }

    public void agregarUnidad(modelo.Posicionable entidadNueva) throws CasilleroLlenoException {
        if(this.estaLibre()){
            habitante = entidadNueva;
        } else {
            throw new CasilleroLlenoException("Se intentó llenar un casillero ocupado");
        }
    }
}
