package com.company.vista.gui.eventos.ejecutadores;

import com.company.controlador.Controlador;
import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.EnemigoInvalidoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;

public class ConstructorDeCuartel implements Ejecutador {
    @Override
    public void ejecutar(Integer xOrigen, Integer yOrigen, Integer xDestino, Integer yDestino) throws Exception, ArmaDesmontadaException, ArmaMontadaException, EdificioEnConstruccionException {
        Controlador controlador = Controlador.getControlador();
        Mapa mapa = Mapa.getMapa();
        Aldeano aldeano = (Aldeano) mapa.conseguirOcupante(xOrigen,yOrigen);
        Jugador jugador = aldeano.getJugador();
        Cuartel cuartel = new Cuartel(jugador);
        controlador.construirCuartel(aldeano,cuartel,xDestino,yDestino);
    }
}
