package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;

public abstract class Posicionable {

    protected Jugador jugador;

    // Queda abstracto porque los edificios y las unidades se ubican de formas distintas
    public abstract void ubicar(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException;

    public abstract void recibirDanio(Integer montoDeDanio) throws Exception;

    public abstract void actualizar();
}

