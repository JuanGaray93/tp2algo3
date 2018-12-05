package com.company.vista.gui.eventos;

import com.company.controlador.Controlador;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.unidades.Aldeano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConstruirPlazaCentralHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Controlador controlador = Controlador.getControlador();
        ClickHandler clickOrigen = new ClickHandler();
        Aldeano aldeano = (Aldeano) clickOrigen.obtenerPosicionable();
        Jugador jugador = aldeano.getJugador();
        ClickHandler clickDestino = new ClickHandler();
        /*ClickHandler clickEdificioAConstruir = new clickHandler;
        Edificio edificio = (Edificio) clickEdificioAContruir.getEdificioAContruir();*/
        PlazaCentral plazaCentral = new PlazaCentral(jugador);
        controlador.construirPlazaCentral(aldeano, plazaCentral, clickDestino.getPosicionHorizontal, clickDestino.getPosicionVertical);
    }
}
