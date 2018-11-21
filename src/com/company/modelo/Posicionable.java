package com.company.modelo;

public interface Posicionable {

    void ubicar(Integer posicionHorizontal, Integer posicionVertical);
    void actualizar();
    void recibirDanio(Integer montoDeDanio) throws Exception;
    Boolean verificarAlianza(Posicionable otroPosicionable);
    Boolean verificarAlianza(Jugador otroJugador);
}


