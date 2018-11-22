package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.UnidadErroneaException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoPorConstruir;
import com.company.modelo.unidades.Unidad;

public class Cuartel extends Edificio {

	public Cuartel(Jugador jugador) {

		super(jugador);
		COSTO = 50;
		MONTO_DE_REPARACION = 50;
		BLOQUES_DE_ANCHO = 2;
		BLOQUES_DE_ALTO = 2;
		VIDA_MAXIMA = 250;
		vidaActual = VIDA_MAXIMA;
		this.estado = new EstadoPorConstruir(VIDA_MAXIMA,MONTO_DE_REPARACION);
	}

	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

	}

	@Override
	public void crear(Unidad unidad) throws CasilleroNoExistenteException, CasilleroLlenoException {
		 if(!unidad.seLlama("ARQUERO") || !unidad.seLlama("ESPADACHIN")){
		 	throw new UnidadErroneaException("Imposible crear ese tipo de unidad");
		 }
		 posiciones.get(1).posicionar(unidad);

	}

	@Override
	public void actualizar() {

	}

}
