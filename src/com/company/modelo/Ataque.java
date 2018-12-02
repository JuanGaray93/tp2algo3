package com.company.modelo;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EnemigoInvalidoException;

import java.util.ArrayList;

public class Ataque {

    private Integer rangoAtaque;
    private Jugador jugador;
    private Posicion posicion;

    public Ataque(Integer rangoDeAtaque, Jugador jugador, Posicion posicion){
        this.rangoAtaque = rangoDeAtaque;
        this.jugador = jugador;
        this.posicion = posicion;
    }

    public void atacar(Posicionable unEnemigo, Integer unDanio)
            throws EnemigoInvalidoException {

        ArrayList atacables = this.buscarAtacables(this.rangoAtaque);

        this.eliminarPosicionablesAmigos(atacables);

        if(!atacables.contains(unEnemigo) )
            throw new EnemigoInvalidoException("No se pudo atacar al enemigo");

        try{

            unEnemigo.recibirDanio(unDanio);
            return;

        } catch (Exception | EdificioEnConstruccionException
                | EdificioDestruidoExcepcion ignored) {
        }
    }

    public void atacarATodos(Integer danio) throws EnemigoInvalidoException {
        ArrayList <Posicionable> vector = posicion.buscarPosicionablesEnRadio(rangoAtaque);
        ArrayList <Posicionable> vector2 = new ArrayList();
        for (Posicionable x : vector) {
            if(! (vector2.contains(x))) {
                vector2.add(x);
            }
        }
        for(Posicionable y : vector2) {
            atacar(y, danio);
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

        return posicion.buscarPosicionablesEnRadio(unRadio);
    }

}
