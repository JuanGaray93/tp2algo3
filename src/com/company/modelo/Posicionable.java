package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;

public abstract class Posicionable {

    protected Jugador jugador;

    public abstract void recibirDanio(Integer montoDeDanio) throws Exception;

    public Boolean verificarAlianza(Posicionable otroPosicionable){
        return ( otroPosicionable.verificarAlianza(this.jugador) );
    }
    public Boolean verificarAlianza(Jugador otroJugador){
        return(this.jugador == otroJugador);
    }
}

