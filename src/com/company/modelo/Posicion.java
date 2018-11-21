package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MapaLlenoException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Unidad;

public class Posicion {

    private Integer posicionHorizontal;
    private Integer posicionVertical;
    Mapa mapa = Mapa.getMapa();

    public Posicion(int posicionHorizontal, int posicionVertical) {
        this.posicionHorizontal = posicionHorizontal;
        this.posicionVertical = posicionVertical;
    }

    public void posicionar(Unidad unaUnidad) throws CasilleroNoExistenteException, CasilleroLlenoException {
        mapa.ubicar(unaUnidad, posicionHorizontal, posicionVertical);
    }

    public void colocarEnCasilleroLibreMasCercano(Unidad unaUnidad) throws MapaLlenoException {
        mapa.colocarEnCasilleroLibreMasCercano(unaUnidad, this.posicionHorizontal, this.posicionVertical);
    }

    public void eliminar() {
        try {
            mapa.quitar(posicionHorizontal, posicionVertical);
        } catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Edificio edificio) throws CasilleroNoExistenteException {
        mapa.quitar(posicionHorizontal, posicionVertical);
    }

    public boolean estaOcupado(int i, int j) {
        return mapa.estaOcupado(i, j);
    }
}
