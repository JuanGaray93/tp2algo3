package com.company.vista.gui.eventos;

import com.company.controlador.Controlador;
import com.company.modelo.unidades.Unidad;
import com.company.modelo.unidades.UnidadAtacante;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AtacarHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Controlador controlador = Controlador.getControlador();
        ClickHandler clickOrigen = new ClickHandler();
        UnidadAtacante posicionable = (UnidadAtacante) clickOrigen.obtenerPosicionable();
        ClickHandler clickDestino = new ClickHandler();
        controlador.atacar(posicionable, clickDestino.getCoordenadaHorizontal, clickDestino.getCoordenadaVertical);
    }
}
