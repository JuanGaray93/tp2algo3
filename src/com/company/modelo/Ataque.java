package com.company.modelo;

import com.company.excepciones.EnemigoInvalidoException;

import java.util.ArrayList;

public class Ataque {

    private Integer rangoAtaque;
    private Integer danioAEdificio;
    private Integer danioAUnidad;
    private Jugador jugador;
    private Posicion posicion;

    public Ataque(Integer rangoDeAtaque, Integer danioAEdificio, Integer danioAUnidad, Jugador jugador, Posicion posicion){
        this.rangoAtaque = rangoDeAtaque;
        this.danioAEdificio = danioAEdificio;
        this.danioAUnidad = danioAUnidad;
        this.jugador = jugador;
        this.posicion = posicion;
    }

    public void atacar(Posicionable unEnemigo, Integer unDanio) throws EnemigoInvalidoException {
        ArrayList atacables = this.buscarAtacables(this.rangoAtaque);
        this.eliminarPosicionablesAmigos(atacables);

        if( !atacables.contains(unEnemigo) ) throw new EnemigoInvalidoException("No se pudo atacar al enemigo");

        try{
            unEnemigo.recibirDanio(unDanio);
        } catch (Exception e) {

        }
    }

    private void eliminarPosicionablesAmigos(ArrayList<Posicionable> atacables){
        ArrayList edificios = jugador.getEdificios();
        ArrayList poblacion = jugador.getPoblacion();

        for(int i = atacables.size() - 1; i >= 0; i--){
            Posicionable unPosicionable = atacables.get(i);

            if( edificios.contains(unPosicionable) || poblacion.contains(unPosicionable) ){
                atacables.remove(unPosicionable);
            }

        }

    }

    private ArrayList buscarAtacables(Integer unRadio){
        return posicion.buscarEnRadioPosicionables(unRadio);
    }

}
