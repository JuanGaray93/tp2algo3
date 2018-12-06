package com.company.vista.gui.eventos.ejecutadores;

import com.company.controlador.Controlador;
import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioNoDisponibleException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.terreno.Mapa;

public class CreadorDeArmaDeAsedio implements Ejecutador {
    @Override
    public void ejecutar(Integer xOrigen, Integer yOrigen, Integer xDestino, Integer yDestino) throws Exception, ArmaDesmontadaException, ArmaMontadaException, EdificioEnConstruccionException, EdificioNoDisponibleException {
        Controlador controlador = Controlador.getControlador();
        Mapa mapa = Mapa.getMapa();
        Castillo castillo = (Castillo) mapa.conseguirOcupante(xOrigen,yOrigen);
        Jugador jugador = castillo.getJugador();
        ArmaAsedio armaAsedio = new ArmaAsedio(jugador);
        controlador.crearArmaDeAsedio(castillo, armaAsedio);
    }
}
