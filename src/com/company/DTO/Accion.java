package com.company.DTO;

import com.company.vista.gui.eventos.ejecutadores.Ejecutador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Accion {

    private String descripcion;
    private EventHandler<ActionEvent> handlerDelBoton;
    private Ejecutador ejecutador;

    public Accion(String descripcion, EventHandler<ActionEvent> handlerDelBoton, Ejecutador ejecutador){
        this.descripcion = descripcion;
        this.handlerDelBoton = handlerDelBoton;
        this.ejecutador = ejecutador;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public EventHandler<ActionEvent> getHandlerDelBoton(){
        return handlerDelBoton;
    }

    public void llamarAccion(Integer xOrigen, Integer yOrigen, Integer xDestino, Integer yDestino){
        ejecutador.ejecutar(xOrigen, yOrigen, xDestino, yDestino);
    }
}
