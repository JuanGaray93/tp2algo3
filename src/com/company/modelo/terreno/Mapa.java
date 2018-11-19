package com.company.modelo.terreno;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MapaLlenoException;
import com.company.modelo.unidades.Unidad;
import com.company.modelo.Posicionable;

public class Mapa {

	private static Integer numeroDeCasillerosHorizontales = 30;
	private static Integer numeroDeCasillerosVerticales = 30;
	private static Mapa instancia = new Mapa();
	private Casillero[][] casilleros;

	private Mapa() {
		casilleros = new Casillero[this.numeroDeCasillerosVerticales][this.numeroDeCasillerosHorizontales];

        for(Integer i = 0; i < numeroDeCasillerosVerticales; i++){

            for(Integer j = 0; j < numeroDeCasillerosHorizontales; j++){
                casilleros[i][j] = new Casillero();
            }

        }

	}

	/*Listo*/
	public void ubicar(Posicionable posicionable, Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException {
	    Casillero destino = obtenerCasillero(posicionHorizontal, posicionVertical);
	    destino.agregarPosicionable(posicionable);
	}
    /*Listo*/
    public Boolean estaOcupado(Integer posicionHorizontal, Integer posicionVertical) {
        try {
            Casillero casilleroAConsultar = obtenerCasillero(posicionHorizontal, posicionVertical);
            return casilleroAConsultar.estaOcupado();
        } catch (CasilleroNoExistenteException e) {
            return true;
        }
    }
    /*Listo*/
	private Casillero obtenerCasillero(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException {
	    if(!esParteDelMapa(posicionHorizontal, posicionVertical)){
	        throw new CasilleroNoExistenteException("Error al intentar obtener casillero: El casillero " + posicionHorizontal + ", " + posicionVertical + "esta fuera del mapa.");
        }
        return casilleros[posicionHorizontal][posicionVertical];
    }
    /*listo*/
    private Boolean esParteDelMapa(Integer posicionHorizontal, Integer posicionVertical){
        return (posicionHorizontal >= 0 && posicionHorizontal < numeroDeCasillerosHorizontales && posicionVertical >= 0 && posicionVertical < numeroDeCasillerosVerticales);
    }
    /*Listo*/
	public static Mapa getMapa(){

        if (instancia == null) instancia = new Mapa();

	    return instancia;
	}

	/* Ubica a la unidad en un casillero, por ende le debe decir a la unidad en dónde nació.
	 * Si no hay ningún lugar disponible en toddo el mapa, lanza una excepcion
	 * Ya sé que está recontra estructurado esto pero es una forma preliminar de encontrar el espacio vacío
	 */
	private Casillero encontrarCasilleroDisponibleEnTornoA(Integer posicionHorizontal, Integer posicionVertical, Unidad unaUnidad) throws MapaLlenoException {
	    Integer numeroDeSegmento = 1;
        Integer direccion;
        Integer iteradorHorizontal = posicionHorizontal;
        Integer iteradorVertical = posicionVertical;
        Casillero candidato = null;
        Integer numeroDeIteracion = 0;

        while(numeroDeIteracion < numeroDeCasillerosHorizontales || numeroDeIteracion < numeroDeCasillerosVerticales) {
            direccion = numeroDeSegmento % 4;

            for (Integer i = 0; i <= numeroDeSegmento; i++) {

                try {
                    candidato = obtenerCasillero(iteradorHorizontal, iteradorVertical);
                } catch (CasilleroNoExistenteException e) {
                    // Nada
                }
                if (!candidato.estaOcupado()) {
                    System.out.println(iteradorHorizontal);
                    System.out.println(iteradorVertical);
                    unaUnidad.naciEn(iteradorHorizontal, iteradorVertical);
                    return candidato;
                }
                if (direccion == 0) {
                    iteradorHorizontal++;
                } else if (direccion == 1) {
                    iteradorVertical++;
                } else if (direccion == 2) {
                    iteradorHorizontal--;
                } else {
                    iteradorVertical--;
                }
            }

            numeroDeSegmento++;
        }

        throw new MapaLlenoException("No se puede colocar una unidad en este momento porque el mapa está lleno");
	}

	public void colocarEnCasilleroLibreMasCercano(Unidad nuevaUnidad, Integer posicionHorizontal, Integer posicionVertical) throws CasilleroLlenoException{
		try {
			Casillero casilleroDisponible = encontrarCasilleroDisponibleEnTornoA(posicionHorizontal, posicionVertical, nuevaUnidad);
			casilleroDisponible.agregarPosicionable(nuevaUnidad);
		}
		catch (MapaLlenoException e) {
		    e.printStackTrace();
		}

	}

	public Posicionable conseguirOcupante(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException {
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