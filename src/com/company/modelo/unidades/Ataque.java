package com.company.modelo.unidades;

import com.company.modelo.edificios.Edificio;

public class Ataque {
	
	private final int ATAQUE_EDIFICIO;
	private final int ATAQUE_UNIDAD;
	
	public Ataque(int edificio, int unidad) {
		
		ATAQUE_EDIFICIO = edificio;
		ATAQUE_UNIDAD = unidad;
	}
	
	public void atacar(Unidad enemigo) {
		enemigo.recibirDanio(ATAQUE_UNIDAD);
	}
	
	public void atacar(Edificio enemigo) {
		enemigo.recibirDanio(ATAQUE_EDIFICIO);
	}
}
