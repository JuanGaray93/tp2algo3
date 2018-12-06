package com.company.vista.gui.eventos.ejecutadores;

import com.company.controlador.Controlador;
import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioNoDisponibleException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Espadachin;

public class CreadorDeEspadachin implements Ejecutador {
    @Override
    public void ejecutar(Integer xOrigen, Integer yOrigen, Integer xDestino, Integer yDestino) throws Exception, ArmaDesmontadaException, ArmaMontadaException, EdificioEnConstruccionException, EdificioNoDisponibleException {
        Controlador controlador = Controlador.getControlador();
        Mapa mapa = Mapa.getMapa();
        Cuartel cuartel = (Cuartel) mapa.conseguirOcupante(xOrigen,yOrigen);
        Jugador jugador = cuartel.getJugador();
        Espadachin espadachin = new Espadachin(jugador);
        controlador.crearEspadachin(cuartel, espadachin);
    }
}
