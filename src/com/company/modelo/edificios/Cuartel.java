package com.company.modelo.edificios;

import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Espadachin;
import com.company.modelo.unidades.Arquero;

public class Cuartel extends Edificio {
	
	public Cuartel(int posicionHorizontal, int posicionVertical) {
		super(posicionHorizontal, posicionVertical);
		this.vida = 250;
		this.costo = 50;
	}
	
	public Espadachin crearEspadachin(int posicionHorizontal, int posicionVertical) {
		Espadachin espadachin = new Espadachin(posicionHorizontal, posicionVertical);
		espadachin.nacer();
		return espadachin;
	}
	
	public Arquero crearArquero(int posicionHorizontal, int posicionVertical) {
		Arquero arquero = new Arquero(posicionHorizontal, posicionVertical);
		arquero.nacer();
		return arquero;
	}

}
