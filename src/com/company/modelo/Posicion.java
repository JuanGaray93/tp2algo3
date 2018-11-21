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

    public void posicionar(Posicionable posicionable) throws CasilleroNoExistenteException, CasilleroLlenoException {
        mapa.ubicar(posicionable, posicionHorizontal, posicionVertical);
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

    public boolean estaOcupado(int i, int j) {
        return mapa.estaOcupado(i, j);
    }

	public ArrayList buscarEnemigosEnRadio(Integer radio) {
		ArrayList <Posicionable> posicionables = new ArrayList <>()
		for(Integer i = posicionHorizontal - radio; i <= poscionHorizontal + radio; i++) {
			for (Integer j = posicionVertical - radio; j <= posicionVertical + radio; j++) {
				if (mapa.estaOcupado(i,j)) {
					posicionables.add(mapa.conseguirOcupante(i,j));
				}
			}
		}
		return posicionables;
	}
}