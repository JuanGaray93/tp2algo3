package com.company.DTO;

import java.util.ArrayList;

public class EntidadDTO {

    private Integer jugador;
    private String nombre;
    private ArrayList<Accion> acciones;
    
    public EntidadDTO(Integer jugador, String nombre, ArrayList<Accion> acciones){
        this.jugador = jugador;
        this.nombre = nombre;
        this.acciones = acciones;
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList<Accion> getAcciones(){
        return acciones;
    }

    public Integer getJugador(){
        return jugador;
    }
}
