package com.company.modelo.terreno;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MapaLlenoException;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.Unidad;

public class Mapa {

	private static Integer numeroDeCasillerosHorizontales = 30;
	private static Integer numeroDeCasillerosVerticales = 30;
	private static Mapa instancia = new Mapa();
	private Casillero[][] casilleros;

	private Mapa() {
	    casilleros = new Casillero[numeroDeCasillerosVerticales][numeroDeCasillerosHorizontales];
	    for(Integer i = 0; i < numeroDeCasillerosVerticales; i++){
	        for(Integer j = 0; j < numeroDeCasillerosHorizontales; j++){
	            casilleros[i][j] = new Casillero();
            }
        }
	}

	public void ubicar(Posicionable posicionable, Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException {
        Casillero destino = obtenerCasillero(posicionHorizontal, posicionVertical);
        destino.agregarPosicionable(posicionable);
    }

    public Boolean estaOcupado(Integer posicionHorizontal, Integer posicionVertical) {
        try {
            Casillero casilleroAConsultar = obtenerCasillero(posicionHorizontal, posicionVertical);
            return casilleroAConsultar.estaOcupado();
        } catch (CasilleroNoExistenteException e) {
            return true;
        }
    }
    /*Listo*/
	protected Casillero obtenerCasillero(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException {
	    if(!esParteDelMapa(posicionHorizontal, posicionVertical)){
	        throw new CasilleroNoExistenteException("Error al intentar obtener casillero: El casillero " + posicionHorizontal + ", " + posicionVertical + "esta fuera del mapa.");
        }
        return casilleros[posicionHorizontal][posicionVertical];
    }

    private Boolean esParteDelMapa(Integer posicionHorizontal, Integer posicionVertical){
        return (posicionHorizontal >= 0 && posicionHorizontal < numeroDeCasillerosHorizontales && posicionVertical >= 0 && posicionVertical < numeroDeCasillerosVerticales);
    }

	public static Mapa getMapa(){
        if (instancia == null){
            instancia = new Mapa();
        }
		return instancia;
	}

	/* Ubica a la unidad en un casillero
	 * Si no hay ningún lugar disponible en toddo el mapa, lanza una excepcion
	 * Ya sé que está recontra estructurado esto pero es una forma preliminar de encontrar el espacio vacío
	 */
	private Casillero encontrarCasilleroDisponibleEnTornoA (Integer posicionHorizontal, Integer posicionVertical) throws MapaLlenoException {

        Casillero candidato = null;

        Reptador reptador = new Reptador(posicionHorizontal, posicionVertical, this);
        while(candidato == null){
            candidato = reptador.buscar();
        }
        return candidato;
	}

	public void colocarEnCasilleroLibreMasCercano(Unidad nuevaUnidad, Integer posicionHorizontal, Integer posicionVertical) throws MapaLlenoException {
		try {
			Casillero casilleroDisponible = encontrarCasilleroDisponibleEnTornoA(posicionHorizontal, posicionVertical);
			casilleroDisponible.agregarPosicionable(nuevaUnidad);
		} catch (CasilleroLlenoException e){
            e.printStackTrace();
        }
	}

	public Posicionable conseguirOcupante(Integer posicionHorizontal, Integer posicionVertical ) throws CasilleroNoExistenteException {
        Casillero contenedor = obtenerCasillero(posicionHorizontal, posicionVertical);
        return contenedor.obtenerPosicionable();
    }

    public void destruir(){
	    instancia = null;
    }

    public Integer obtenerTamanio(){
	    return (this.numeroDeCasillerosHorizontales * this.numeroDeCasillerosVerticales);
    }

    public void quitar(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException {
	    Casillero aModificar = obtenerCasillero(posicionHorizontal,posicionVertical);
	    aModificar.quitarPosicionable();
    }
}