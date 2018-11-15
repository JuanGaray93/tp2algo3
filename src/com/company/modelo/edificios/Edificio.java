package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.terreno.Mapa;
import modelo.Posicionable;

public abstract class Edificio implements Posicionable {

    protected int vida, costo, x, y;
    private Posicionable self;

    public Edificio(int posicionHorizontal, int posicionVertical) {
        this.x = posicionHorizontal;
        this.y = posicionVertical;
    }

    public void construir() throws CasilleroLlenoException {
        Mapa mapa = Mapa.getMapa();
        this.verificarCasilleros(mapa);
        mapa.ubicar(self, this.x, this.y);
    }

    private void verificarCasilleros(Mapa mapa) throws CasilleroLlenoException {

        for( int i = 0; i < this.x; i++){

            for( int j = 0; j < this.y; j++){

                if( mapa.estaOcupado(i, j) ){
                    throw new CasilleroLlenoException("Error al construir el edificio seleccionado: la posicion " + i " y " + j + " esta ocupada.")
                }
            }
        }

    }
}
