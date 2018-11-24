package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MapaLlenoException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Unidad;

import java.util.ArrayList;

public class Posicion {

    private Integer posicionHorizontal;
    private Integer posicionVertical;
    Mapa mapa = Mapa.getMapa();

    public Posicion(Integer posicionHorizontal, Integer posicionVertical) {
        this.posicionHorizontal = posicionHorizontal;
        this.posicionVertical = posicionVertical;
    }

    public void posicionar(Edificio edificio) throws CasilleroNoExistenteException, CasilleroLlenoException {
        mapa.ubicar(edificio, posicionHorizontal, posicionVertical);
    }

    public void posicionar(Unidad unidad) throws CasilleroNoExistenteException, CasilleroLlenoException, MapaLlenoException {
        mapa.colocarEnCasilleroLibreMasCercano(unidad, posicionHorizontal, posicionVertical);
    }

    public void colocarEnCasilleroLibreMasCercano(Unidad unaUnidad) throws MapaLlenoException, CasilleroNoExistenteException, CasilleroLlenoException {
        mapa.colocarEnCasilleroLibreMasCercano(unaUnidad, this.posicionHorizontal, this.posicionVertical);
    }

    public void eliminar() {
        try {
            mapa.quitar(posicionHorizontal, posicionVertical);
        } catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }
    }

    public boolean estaOcupado(Integer i, Integer j) {
        return mapa.estaOcupado(i, j);
    }

    public boolean posicionEnRadio(Integer x, Integer y){
        return (posicionHorizontal == x-1 || posicionHorizontal == x+1 || posicionHorizontal == x) &&
                (posicionVertical == y-1 || posicionVertical == y+1 || posicionVertical == y);
    }

    public ArrayList buscarEnRadio(Integer radio) {
        ArrayList<Posicionable> posicionables = new ArrayList<>();

        for (Integer i = this.posicionHorizontal - radio; i <= this.posicionHorizontal + radio; i++) {

            for (Integer j = this.posicionVertical - radio; j <= this.posicionVertical + radio; j++) {
                try {

                    if (mapa.estaOcupado(i, j)) {
                        posicionables.add(mapa.conseguirOcupante(i, j));
                    }

                } catch (CasilleroNoExistenteException e) {

                }


            }

        }
        return posicionables;
    }
}
