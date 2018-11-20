package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MapaLlenoException;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public class Posicion {

    private Integer posicionHorizontal;
    private Integer posicionVertical;
    Mapa mapa = Mapa.getMapa();
;
    public Posicion(int posicionHorizontal, int posicionVertical) {
        this.posicionHorizontal = posicionHorizontal;
        this.posicionVertical = posicionVertical;
    }

    public int obtenerPosicionHorizontal(){
        return this.posicionHorizontal;
    }

    public int obtenerPosicionVertical(){
        return this.posicionVertical;
    }

    public void posicionar(Unidad unaUnidad) throws CasilleroLlenoException {

        try {
            mapa.colocarEnCasilleroLibreMasCercano(unaUnidad, this.posicionHorizontal, this.posicionVertical);
        } catch (MapaLlenoException e) {

        }
    }

    public void posicionar(Edificio edificio) throws CasilleroLlenoException {

        int lado = edificio.getTamanio() / 2;

        for( int i = this.posicionHorizontal; i < ( this.posicionHorizontal + lado ); i++){

            for( int j = this.posicionVertical; j < ( this.posicionVertical + lado ); j++){
                try {
                    mapa.ubicar(edificio,i,j);
                } catch (CasilleroNoExistenteException e) {

                }

            }

        }

    }

    public void eliminar(){
        try {
            mapa.quitar(posicionHorizontal,posicionVertical);
        } catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Edificio edificio){

        int lado = edificio.getTamanio() / 2;

        for( int i = posicionHorizontal; i < ( posicionHorizontal + lado ); i++){

            for( int j = posicionVertical; j < ( posicionVertical + lado ); j++){
                try {
                    mapa.quitar(i,j);
                } catch (CasilleroNoExistenteException e) {

                }

            }

        }

        Mapa mapa = Mapa.getMapa();
        try {
            mapa.quitar(posicionHorizontal,posicionVertical);
        } catch (CasilleroNoExistenteException e) {

        }
    }

    public boolean estaOcupado(int i, int j) {
        return mapa.estaOcupado(i,j);
    }
}
