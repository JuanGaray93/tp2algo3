package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Posicion;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public abstract class Edificio implements Posicionable {

    protected int vida, costo, tamanio;
    protected boolean enConstruccion;
    protected List<Posicion> posiciones = new ArrayList<>();

    public void construirEn(int posicionHorizontal, int posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException {
        Mapa mapa = Mapa.getMapa();
        this.ubicar(mapa, posicionHorizontal, posicionVertical);
    }

    private void ubicar(Mapa mapa, int posicionHorizontal, int posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException {
        int lado = tamanio / 2;

        for( int i = posicionHorizontal; i < ( posicionHorizontal + lado ); i++){

            for( int j = posicionVertical; j < ( posicionVertical + lado ); j++){
                Posicion posicion = new Posicion(i, j);
                posicion.posicionarEdificio(this, mapa);
                posiciones.add(posicion);
            }

        }

    }

    public void recibirDanio(int unDanio) {
        vida -= unDanio;
    }

    public void reparar(int unIncremento) {
        vida += unIncremento;
    }

    public void eliminar() {
        // TODO implementar el borrar del mapa
    }
}
