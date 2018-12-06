package com.company.vista.gui.eventos;

import com.company.controlador.Controlador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RepararHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Controlador controlador = Controlador.getControlador();
        ClickHandler clickOrigen = new ClickHandler();
        Aldeano aldeano = (Aldeano) clickOrigen.obtenerPosicionable();
        ClickHandler clickDestino = new ClickHandler();
        Edificio edificioAReparar = (Edificio) clickDestino.obtenerPosicionable();
        controlador.reparar(aldeano,edificioAReparar);
    }
}
