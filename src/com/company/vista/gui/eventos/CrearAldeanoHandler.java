package com.company.vista.gui.eventos;

import com.company.controlador.Controlador;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Arquero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearAldeanoHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Controlador controlador = Controlador.getControlador();
        ClickHandler clickOrigen = new ClickHandler();
        PlazaCentral posicionable = (PlazaCentral) clickOrigen.obtenerPosicionable();
        Jugador jugador = posicionable.getJugador();
        Aldeano aldeano = new Aldeano(jugador);
        //TODO hay que manejar excepciones
        controlador.crearAldeano(posicionable, aldeano);
    }
}
