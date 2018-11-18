package com.company.modelo.unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.Posicion;

public abstract class Unidad implements Posicionable {

	protected int vida, costo;
	protected Posicion posicion;

	public void nacerEn(int posicionHorizontal, int posicionVertical) throws CasilleroLlenoException {
		posicion = new Posicion(posicionHorizontal, posicionVertical);
		posicion.posicionarUnidad(this);
	}

	public void moverA(int posicionHorizontal, int posicionVertical) throws CasilleroLlenoException {
		posicion.eliminar();
		posicion = new Posicion(posicionHorizontal, posicionVertical);
		posicion.posicionarUnidad(this);
	}

	public void recibirDanio(int unDanio){
		vida -= unDanio;
	}

	public abstract void atacarEdificio(Edificio unEdificio);

	public abstract void atacarUnidad(Unidad unaUnidad);
}
