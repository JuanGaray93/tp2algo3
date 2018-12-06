package com.company.vista.gui.eventos;

import com.company.vista.gui.eventos.selecciones.GestorDeSelecciones;
import com.company.vista.terreno.Mapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CambiarTurnoHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {

        Mapa mapa = Mapa.getMapa();
        mapa.actualizarCasilleros();
        GestorDeSelecciones.pasarTurno();
    }
}
