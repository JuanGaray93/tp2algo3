package com.company.vista.gui.eventos.ejecutadores;

import com.company.controlador.Controlador;
import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.ArmaAsedio;

public class Desmontador implements Ejecutador {
    @Override
    public void ejecutar(Integer xOrigen, Integer yOrigen, Integer xDestino, Integer yDestino) throws CasilleroNoExistenteException, ArmaDesmontadaException, ArmaMontadaException {
        Mapa mapa = Mapa.getMapa();
        Controlador controlador = Controlador.getControlador();
        ArmaAsedio armaAsedio =(ArmaAsedio)mapa.conseguirOcupante(xOrigen,xDestino);
        controlador.desmontar(armaAsedio);
    }
}
