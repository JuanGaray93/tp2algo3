package com.company.modelo;

public abstract class Posicionable {

    protected Jugador jugador;

    // Queda abstracto porque los edificios y las unidades se ubican de formas distintas
    public abstract void ubicar(Integer posicionHorizontal, Integer posicionVertical);

    public abstract void recibirDanio(Integer montoDeDanio) throws Exception;

    public Boolean verificarAlianza(Posicionable otroPosicionable){
        return ( otroPosicionable.verificarAlianza(this.jugador) );
    }
    public Boolean verificarAlianza(Jugador otroJugador){
        return(this.jugador == otroJugador);
    }
}

