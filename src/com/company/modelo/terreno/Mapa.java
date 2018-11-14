package com.company.modelo.terreno;

import com.company.excepciones.MapaLlenoException;
import com.company.modelo.unidades.Unidad;
import modelo.Posicionable;

public class Mapa {

	private static Integer numeroDeCasillerosHorizontales = 30;
	private static Integer numeroDeCasillerosVerticales = 30;

	private static Mapa instancia = new Mapa();

	private Mapa() {}


	public void ubicar(Posicionable posicionable, Casillero casillero) {
	}

	public static Mapa getMapa(){
		return instancia;
	}

	public boolean estaOcupado(Integer posicionHorizontal, Integer posicionVertical) {
		return true;
	}

	/*Si no hay ningún lugar disponible en toddo el mapa, lanza una excepcion*/
	private Casillero encontrarCasilleroDisponibleEnTornoA (Integer posicionHorizontal, Integer posicionVertical) throws MapaLlenoException {
		// TODO implementar que busque el casillero más cercano a la posición pasada por parámetro
		return new Casillero();
	}

	public void colocarUnidad(Unidad nuevaUnidad, Integer posicionHorizontal, Integer posicionVertical){
		try {
			Casillero casilleroDisponible = encontrarCasilleroDisponibleEnTornoA(posicionHorizontal, posicionVertical);
		} catch (MapaLlenoException e) {
			// Juego juego = Juego.getJuego();
			// juego.alertar("La unidad no se pudo crear porque el mapa está lleno.
			// Se creará cuando el mapa esté más vacío.");
			e.printStackTrace();
		}
	}


}
