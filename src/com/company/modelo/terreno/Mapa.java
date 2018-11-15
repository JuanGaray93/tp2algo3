package com.company.modelo.terreno;

import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MapaLlenoException;
import com.company.modelo.unidades.Unidad;
import modelo.Posicionable;

public class Mapa {

	private static Integer numeroDeCasillerosHorizontales = 30;
	private static Integer numeroDeCasillerosVerticales = 30;
	private static Mapa instancia = new Mapa();
	private Casillero[][] casilleros;

	private Mapa() {
		casilleros = new Casillero[this.numeroDeCasillerosVerticales][this.numeroDeCasillerosHorizontales];
	}


	public void ubicar(Posicionable posicionable, Integer posicionHorizontal, Integer posicionVertical) {
		Casillero destino = obtenerCasillero(posicionHorizontal, posicionVertical);
	    try {

        } catch(Exception e){

        }
	}

    public boolean estaOcupado(Integer posicionHorizontal, Integer posicionVertical) {
        return true;
    }

	private Casillero obtenerCasillero(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException {
	    if(posicionHorizontal < 1 || posicionHorizontal > numeroDeCasillerosHorizontales){
	        throw new CasilleroNoExistenteException("Error al intentar obtener casillero: El casillero " + posicionHorizontal + ", " + posicionVertical + "esta fuera del mapa.");
        }
    }

	public static Mapa getMapa(){
		return instancia;
	}



	/* Ubica a la unidad en un casillero
	 * Si no hay ningún lugar disponible en toddo el mapa, lanza una excepcion*/
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
