package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;

public class Aldeano extends Unidad {

	Jugador jugador;
	final Integer PRODUCCION_ORO;
	
	private boolean trabajando;

	public Aldeano(Jugador jugador) {
		super(jugador);
		estado = new EstadoUnidad(50,25);
		PRODUCCION_ORO = 20;
	}

	public void construir(Edificio edificio,int x, int y) throws CasilleroLlenoException {
		if(trabajando){
			throw new UnidadOcupadaException("Tal vez mas tarde...");
		}
		try{
			try {
				posicion.posicionarEdificio(edificio, Mapa.getMapa());
			} catch (CasilleroNoExistenteException e) {
				//
			}
			this.posicion = posicion;
			
			this.trabajando = !trabajando;
		}catch(CasilleroLlenoException e){
			//
		}
	}

	private void recolectarOro() {
		if(trabajando){
			throw new UnidadOcupadaException("Tal vez mas tarde...");
		}
		jugador.sumarOro(PRODUCCION_ORO);
	}

	public void reparar(Edificio edificio) {
			
		if (trabajando) {
			throw new UnidadOcupadaException("Tal vez mas tarde...");
		}
		try {
			edificio.reparar();
		}catch(EdificioEnReparacionException e) {
			//
		}	
	}

	public void actualizar() {
		this.recolectarOro();
		if(!estado.saludable()) {
			this.posicion.eliminar();
			this.jugador.eliminarDePoblacion(this);
		}
		
	}

	public void nacerEn(Integer posicionHorizontal, Integer posicionVertical) throws MapaLlenoException {
		Mapa mapa = Mapa.getMapa();
		mapa.colocarEnCasilleroLibreMasCercano(this, posicionHorizontal, posicionVertical );
	}

	public boolean estaLibre() {
		return trabajando;
		
	}

}
