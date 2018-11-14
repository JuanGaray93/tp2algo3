package com.company.modelo.terreno;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.unidades.Unidad;

public class Casillero {

    private Unidad habitante;

    public Casillero(){
        habitante = null;
    }

    public Boolean estaLibre() {
        return ( habitante == null );
    }

    public void agregarUnidad(Unidad unidadNueva) throws CasilleroLlenoException {
        if(this.estaLibre()){
            habitante = unidadNueva;
        } else {
            throw new CasilleroLlenoException("Se intentó llenar un casillero ocupado");
        }
    }
}
