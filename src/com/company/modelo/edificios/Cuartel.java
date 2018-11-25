package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.MapaLlenoException;
import com.company.excepciones.UnidadErroneaException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoPorConstruir;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public class Cuartel extends Edificio {

	public Cuartel(Jugador jugador) {

		super(jugador);
		COSTO = 50;
		MONTO_DE_REPARACION = 50;
		BLOQUES_DE_ANCHO = 2;
		BLOQUES_DE_ALTO = 2;
		VIDA_MAXIMA = 250;

		this.estado = new EstadoPorConstruir(VIDA_MAXIMA,MONTO_DE_REPARACION);
	}

	@Override
	public void construir(Aldeano quienLoConstruye, Integer posicionHorizontal, Integer posicionVertical)
			throws EdificioEnConstruccionException, Exception {

		jugador.cobrar(this.COSTO);

		this.ubicar(posicionHorizontal,posicionVertical);

		estado = estado.construir(quienLoConstruye);
	}

	@Override
	public void actualizar() throws Exception {
		estado = estado.ejecutarAccion();
	}

}
