package com.company.DTO;

import com.company.modelo.Jugador;

public class JugadorDTO {
    private Integer numeroDeJugador;
    private Integer oro;
    private Integer poblacionCorriente;
    private Integer poblacionMaxima;

    public JugadorDTO(Jugador jugador){
        this.oro = jugador.getOro();
        this.numeroDeJugador = jugador.getNumeroDeJugador();
        this.poblacionCorriente = jugador.getPoblacion().size();
        this.poblacionMaxima = 50; // TODO ALTO HARDCODE
    }
}
