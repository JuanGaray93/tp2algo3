package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Unidad;

import java.util.ArrayList;

public class Posicion {

    private Integer posicionHorizontal, posicionVertical;
    private Mapa mapa = Mapa.getMapa();

    public Posicion(int posicionHorizontal, int posicionVertical) {
        this.posicionHorizontal = posicionHorizontal;
        this.posicionVertical = posicionVertical;
    }

    public Integer obtenerPosicionHorizontal(){
        return this.posicionHorizontal;
    }

    public Integer obtenerPosicionVertical(){
        return this.posicionVertical;
    }

    public void colocarEnCasilleroLibreMasCercano(Unidad unaUnidad) throws CasilleroLlenoException {
        mapa.colocarEnCasilleroLibreMasCercano(unaUnidad, this.posicionHorizontal, this.posicionVertical);
    }

    public void posicionar(Posicionable unPosicionable) throws CasilleroNoExistenteException, CasilleroLlenoException {
        mapa.ubicar(unPosicionable, this.posicionHorizontal, this.posicionVertical);
    }

    public void eliminar() {
        try {
            mapa.quitar(posicionHorizontal, posicionVertical);
        } catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }
    }

    public boolean estaOcupado(Integer posicionHorizontal, Integer posicionVertical) {
        return mapa.estaOcupado(posicionHorizontal, posicionVertical);
    }

    public ArrayList buscarEnemigosEnRadio(Integer radio) {
        ArrayList <Posicionable> posicionables = new ArrayList <>();

        for(Integer i = this.posicionHorizontal - radio; i <= this.posicionHorizontal + radio; i++) {

            for (Integer j = this.posicionVertical - radio; j <= this.posicionVertical + radio; j++) {
                try {

                    if (mapa.estaOcupado(i, j)) {
                        posicionables.add(mapa.conseguirOcupante(i, j));
                    }

                }
                catch (CasilleroNoExistenteException e){
                    e.printStackTrace();
                }
            }

        }

        return posicionables;
    }

}
