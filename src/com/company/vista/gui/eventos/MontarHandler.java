package com.company.vista.gui.eventos;

import com.company.controlador.Controlador;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.unidades.ArmaAsedio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MontarHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Controlador controlador = Controlador.getControlador();
        ClickHandler clickOrigen = new ClickHandler();
        ArmaAsedio posicionable = (ArmaAsedio) clickOrigen.obtenerPosicionable();
        //TODO hay que manejar excepciones
        controlador.montar(posicionable);
    }
}
