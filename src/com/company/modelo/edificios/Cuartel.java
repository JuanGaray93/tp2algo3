package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Posicion;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Espadachin;
import com.company.modelo.unidades.Arquero;

public class Cuartel extends Edificio {
	
	public Cuartel() {
		this.vida = 250;
		this.costo = 50;
		this.tamanio = 4;
	}
	
	public Espadachin crearEspadachin() throws CasilleroLlenoException {
		Posicion posicion = posiciones.get(0);
		Espadachin espadachin = new Espadachin();
		posicion.posicionarUnidad(espadachin);
		return espadachin;
	}
	
	public Arquero crearArquero() throws CasilleroLlenoException {
		Posicion posicion = posiciones.get(0);
		Arquero arquero = new Arquero();
		posicion.posicionarUnidad(arquero);
		return arquero;
	}

}
