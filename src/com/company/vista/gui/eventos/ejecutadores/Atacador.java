package com.company.vista.gui.eventos.ejecutadores;

import com.company.controlador.Controlador;
import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.EnemigoInvalidoException;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.UnidadAtacante;

public class Atacador implements Ejecutador {
    @Override
    public void ejecutar(Integer xOrigen, Integer yOrigen, Integer xDestino, Integer yDestino) throws CasilleroNoExistenteException, ArmaDesmontadaException, EnemigoInvalidoException {
        Controlador controlador = Controlador.getControlador();
        Mapa mapa = Mapa.getMapa();
        UnidadAtacante unidad = (UnidadAtacante) mapa.conseguirOcupante(xOrigen,yOrigen);
        controlador.atacar(unidad,xDestino,yDestino);
    }
}
