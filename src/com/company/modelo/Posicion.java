package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MapaLlenoException;
import com.company.excepciones.MovimientoInvalidoException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Unidad;

import java.util.ArrayList;

public class Posicion {

    private Integer posicionHorizontal;
    private Integer posicionVertical;
    Mapa mapa = Mapa.getMapa();

    public Posicion(int posicionHorizontal, int posicionVertical) {
        this.posicionHorizontal = posicionHorizontal;
        this.posicionVertical = posicionVertical;
    }

    public void posicionar(Posicionable posicionable) throws CasilleroNoExistenteException, CasilleroLlenoException {
        mapa.ubicar(posicionable, posicionHorizontal, posicionVertical);
    }

    public void colocarEnCasilleroLibreMasCercano(Unidad unaUnidad) throws MapaLlenoException, CasilleroNoExistenteException, CasilleroLlenoException, MovimientoInvalidoException {
        mapa.colocarEnCasilleroLibreMasCercano(unaUnidad, this.posicionHorizontal, this.posicionVertical);
    }

    public void eliminar() {
        try {
            mapa.quitar(posicionHorizontal, posicionVertical);
        } catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }
    }

    public boolean seEncuentraEnRadio(Integer posHorizontal, Integer posVertical){
        boolean condicionIzquierdaODerecha = (this.posicionHorizontal == posHorizontal - 1) || (this.posicionHorizontal == posHorizontal + 1);
        boolean condicionArribaOABajo = (this.posicionVertical == posVertical - 1) || (this.posicionVertical == posVertical + 1);
        boolean condicionHorizontal = this.posicionHorizontal == posHorizontal;
        boolean condicionVertical = this.posicionVertical == posVertical;

        return ( condicionIzquierdaODerecha || condicionHorizontal ) && ( condicionArribaOABajo || condicionVertical );
    }

    public ArrayList buscarEnRadioPosicionables(Integer radio) {
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

    public boolean estaOcupado(int i, int j) {
        return mapa.estaOcupado(i, j);
    }
}
