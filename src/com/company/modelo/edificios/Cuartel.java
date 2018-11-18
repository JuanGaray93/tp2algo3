package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Espadachin;
import com.company.modelo.unidades.Arquero;

public class Cuartel extends Edificio {
	
	public Cuartel() {
		this.vida = 250;
		this.costo = 50;
		this.tamanio = 4;
	}
	
	public Espadachin crearEspadachin(int posicionHorizontal, int posicionVertical) throws CasilleroLlenoException {
		Espadachin espadachin = new Espadachin();
		espadachin.nacerEn(posicionHorizontal, posicionVertical);
		return espadachin;
	}
	
	public Arquero crearArquero(int posicionHorizontal, int posicionVertical) throws CasilleroLlenoException {
		Arquero arquero = new Arquero();
		arquero.nacerEn(posicionHorizontal, posicionVertical);
		return arquero;
	}

}
