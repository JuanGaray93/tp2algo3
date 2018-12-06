package com.company.vista.gui.eventos;

import com.company.controlador.Controlador;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.Espadachin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearEspadachinHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Controlador controlador = Controlador.getControlador();
        ClickHandler clickOrigen = new ClickHandler();
        Cuartel posicionable = (Cuartel) clickOrigen.obtenerPosicionable();
        Jugador jugador = posicionable.getJugador();
        Espadachin espadachin = new Espadachin(jugador);
        //TODO hay que manejar excepciones
        controlador.crearEspadachin(posicionable, espadachin);
    }
}
