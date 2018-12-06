package com.company.vista.gui.eventos;

import com.company.DTO.EntidadDTO;
import com.company.controlador.Controlador;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Posicionable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.awt.event.MouseEvent;

public class ClickHandler implements EventHandler<ActionEvent> {

    private Integer posicionHorizontal;
    private Integer posicionVertical;

    public ClickHandler(Integer posicionHorizontal, Integer posicionVertical){
        this.posicionHorizontal = posicionHorizontal;
        this.posicionVertical = posicionVertical;
    }
    
    public EntidadDTO obtenerEntidadDTO() throws CasilleroNoExistenteException {
        Controlador controlador = Controlador.getControlador();
        return controlador.buscarContenidoDelCasillero(posicionHorizontal, posicionVertical);
    }

    public Posicionable obtenerPosicionable() throws CasilleroNoExistenteException {
        Controlador controlador = Controlador.getControlador();
        return controlador.obtenerContenidoDelCasillero(posicionHorizontal, posicionVertical);
    }

    public Integer getPosicionHorizontal(){
        return posicionHorizontal;
    }

    public Integer getPosicionVertical(){
        return posicionVertical;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
