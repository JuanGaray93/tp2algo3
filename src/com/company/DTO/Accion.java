package com.company.DTO;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Accion {

    private String descripcion;
    private EventHandler<ActionEvent> handler;

    public Accion(String descripcion, EventHandler<ActionEvent> handler){
        this.descripcion = descripcion;
        this.handler = handler;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public EventHandler<ActionEvent> getHandler(){
        return handler;
    }
}
