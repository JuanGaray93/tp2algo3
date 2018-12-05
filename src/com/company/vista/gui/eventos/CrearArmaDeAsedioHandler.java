package com.company.vista.gui.eventos;

import com.company.controlador.Controlador;
import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CrearArmaDeAsedioHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event){
        Controlador controlador = Controlador.getControlador();
        ClickHandler clickOrigen = new ClickHandler();
        Castillo posicionable = (Castillo) clickOrigen.obtenerPosicionable();
        Jugador jugador = posicionable.getJugador();
        ArmaAsedio armaAsedio = new ArmaAsedio(jugador);
        //TODO hay que manejar excepciones
        controlador.crearArmaDeAsedio(posicionable, armaAsedio);
    }
}
