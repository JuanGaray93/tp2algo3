package com.company.vista.terreno.entidades;

import com.company.DTO.EntidadDTO;
import com.company.vista.terreno.Casillero;
import com.company.vista.terreno.Mapa;
import javafx.scene.paint.Color;

public class EntidadViva extends Casillero {

    private EntidadDTO entidadDTO;

    public EntidadViva(Integer x, Integer y, Float dimension, Mapa mapa, EntidadDTO entidad) {
        super(x, y, dimension, mapa);
        this.entidadDTO = entidad;
        if(entidad.getJugador() == 1){
            setFill(Color.BLUE);
        } else {
            setFill(Color.RED);
        }
        establecerEtiqueta( entidad.getNombre());
    }
}
