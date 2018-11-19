package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public class Posicion {

    private int x, y;

    public Posicion(int posicionHorizontal, int posicionVertical) {
        this.x = posicionHorizontal;
        this.y = posicionVertical;
    }

	/*public boolean contiene(Posicionable posicionable) {
		// TODO Auto-generated method stub
		return false;
	}*/

    public int obtenerPosicionHorizontal(){
        return this.x;
    }

	/*public ArrayList<Posicion> encontrarAreaLibre(int dimension) {
		// TODO Auto-generated method stub
		return null;
	}*/

    public int obtenerPosicionVertical(){
        return this.y;
    }

    public void posicionarUnidad(Unidad unaUnidad) throws CasilleroLlenoException {
        Mapa mapa = Mapa.getMapa();
        //mapa.colocarEnCasilleroLibreMasCercano(unaUnidad, this.x, this.y);
    }

    public void posicionarEdificio(Edificio unEdificio, Mapa mapa) throws CasilleroNoExistenteException, CasilleroLlenoException {
        mapa.ubicar(unEdificio, this.x, this.y);
    }

    public void eliminar(){
        //TODO implementar el borrar del mapa
    }

	public boolean contiene(Posicionable posicionable) {
		// TODO Auto-generated method stub
		return false;
	}

}
