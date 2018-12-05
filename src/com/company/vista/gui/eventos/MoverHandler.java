package com.company.vista.gui.eventos;

import com.company.DTO.EntidadDTO;
import com.company.controlador.Controlador;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoverHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Controlador controlador = Controlador.getControlador();
        ClickHandler clickOrigen = new ClickHandler();
        Unidad posicionable = (Unidad)clickOrigen.obtenerPosicionable();
        ClickHandler clickDestino = new ClickHandler();
        controlador.mover(posicionable, clickDestino.getCoordenadaHorizontal(), clickDestino.getCoordenadaVertical() );
    }

}
