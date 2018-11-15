package com.company.modelo.unidades;

import com.company.modelo.Posicionable;
import com.company.modelo.terreno.Mapa;

public abstract class Unidad implements Posicionable {

	protected int vida, costo, x, y;
	private Unidad self;

	public Unidad(int posicionHorizontal, int posicionVertical) {
		this.x = posicionHorizontal;
		this.y = posicionVertical;
	}

	public void nacer() {
		Mapa mapa = Mapa.getMapa();
		mapa.colocarUnidad(self, this.x, this.y);
	}
}
