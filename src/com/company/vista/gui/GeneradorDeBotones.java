package com.company.vista.gui;

import com.company.DTO.EntidadDTO;

public class GeneradorDeBotones {

    private static GeneradorDeBotones instancia;

    public static GeneradorDeBotones getGenerador() {
        if(instancia == null){
            instancia = new GeneradorDeBotones();
        }
        return instancia;
    }

}
