package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.estados.EstadoAldeano;

public class Aldeano extends Unidad {

	final private static Integer PRODUCCION_ORO = 20;
	final private static Integer VIDA_MAXIMA = 50;

	private Integer vida;
	
	private boolean trabajando;

	public Aldeano(Jugador jugador) {
		super(jugador);
		trabajando = false;
		estado = new EstadoAldeano(VIDA_MAXIMA,25);

		this.vida = VIDA_MAXIMA;
	}

	public void construir(Edificio edificio,int x, int y) throws CasilleroLlenoException, CasilleroNoExistenteException {
		if(trabajando){
			throw new UnidadOcupadaException("Tal vez mas tarde...");
		}

		posicion.posicionarEdificio(edificio, Mapa.getMapa());
			
		this.trabajando = !trabajando;
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
			// Cambiar estado
		}	
	}

	public void actualizar() {
		if(this.vida > 0) {
			jugador.sumarOro(PRODUCCION_ORO);
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
