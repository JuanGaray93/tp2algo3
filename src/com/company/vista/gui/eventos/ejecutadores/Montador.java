package com.company.vista.gui.eventos.ejecutadores;

import com.company.controlador.Controlador;
import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioNoDisponibleException;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.ArmaAsedio;

public class Montador implements Ejecutador {
    @Override
    public void ejecutar(Integer xOrigen, Integer yOrigen, Integer xDestino, Integer yDestino) throws Exception, ArmaDesmontadaException, ArmaMontadaException, EdificioEnConstruccionException, EdificioNoDisponibleException {
        Mapa mapa = Mapa.getMapa();
        Controlador controlador = Controlador.getControlador();
        ArmaAsedio armaAsedio =(ArmaAsedio)mapa.conseguirOcupante(xOrigen,xDestino);
        controlador.montar(armaAsedio);
    }
}
