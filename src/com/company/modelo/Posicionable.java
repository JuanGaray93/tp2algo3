package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioReparadoException;

public abstract class Posicionable {

    protected Jugador jugador;

    public abstract void recibirDanio(Integer montoDeDanio) throws Exception;

    public abstract void actualizar() throws EdificioEnConstruccionException, EdificioReparadoException;

}