package com.company.vista.gui.eventos.ejecutadores;

import com.company.controlador.Controlador;
import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;

public class ConstructorDePlazaCentral implements Ejecutador {
    @Override
    public void ejecutar(Integer xOrigen, Integer yOrigen, Integer xDestino, Integer yDestino) throws Exception, ArmaDesmontadaException, ArmaMontadaException, EdificioEnConstruccionException {
        Controlador controlador = Controlador.getControlador();
        Mapa mapa = Mapa.getMapa();
        Aldeano aldeano = (Aldeano) mapa.conseguirOcupante(xOrigen,yOrigen);
        Jugador jugador = aldeano.getJugador();
        PlazaCentral plazaCentral = new PlazaCentral(jugador);
        controlador.construirPlazaCentral(aldeano,plazaCentral,xDestino,yDestino);
    }
}
