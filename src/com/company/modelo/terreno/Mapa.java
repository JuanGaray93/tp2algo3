package com.company.modelo.terreno;

import com.company.modelo.unidades.Unidad;

public class Mapa {

	private static Integer numeroDeCasillerosHorizontales = 30;
	private static Integer numeroDeCasillerosVerticales = 30;

	private static Mapa mapa = new Mapa();

	private Mapa() {}


	public void ubicar(modelo.Posicionable posicionable, modelo.Posicion pos) {
	}

	public static Mapa getMapa(){
		return mapa;
	}

	public boolean estaOcupado(modelo.Posicion posicion) {
		return true;
	}

	public void colocarUnidad(Unidad nuevaUnidad, modelo.Posicion posicion){
		Casillero casilleroDisponible = this.encontrarCasilleroDisponibleEnTornoA(posicion);
	}

	/*Si no hay ningún lugar disponible en toddo el mapa, lanza una excepcion*/
	private Casillero encontrarCasilleroDisponibleEnTornoA throws MapaLlenoException(Posicion posicion){
		// TODO implementar que busque el casillero más cercano a la posición pasada por parámetro
	}

}
