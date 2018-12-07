package com.company.DTO;

import com.company.modelo.Jugador;
import com.company.vista.gui.GeneradorDeBotones;

public class JugadorDTO {
    private Integer numeroDeJugador;
    private Integer oro;
    private Integer poblacionCorriente;
    private Integer poblacionMaxima;

    public JugadorDTO(Jugador jugador){
        this.oro = jugador.getOro();
        this.numeroDeJugador = jugador.getNumeroDeJugador();
        this.poblacionCorriente = jugador.getPoblacion().size();
        this.poblacionMaxima = jugador.getLimitePoblacional();
    }

    public Integer getNumeroDeJugador(){
        return numeroDeJugador;
    }

    public Integer getOro(){
        return oro;
    }

    public Integer getPoblacionCorriente(){
        return poblacionCorriente;
    }

    public Integer getPoblacionMaxima() {
        return poblacionMaxima;
    }

    public void mostrarInformacion(){
        GeneradorDeBotones generadorDeBotones = GeneradorDeBotones.getGenerador();
        generadorDeBotones.mostrarInformacion(this);
    }
}
