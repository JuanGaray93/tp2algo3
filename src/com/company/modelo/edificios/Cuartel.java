package com.company.modelo.edificios;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoEdificioInactivo;
import com.company.modelo.edificios.estados.EstadoPorConstruir;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Espadachin;
import com.company.modelo.unidades.Unidad;

public class Cuartel extends Edificio {

	public Cuartel(Jugador jugador) {

		super(jugador);
		COSTO = 50;
		MONTO_DE_REPARACION = 50;
		BLOQUES_DE_ANCHO = 2;
		BLOQUES_DE_ALTO = 2;
		VIDA_MAXIMA = 250;
	}

	@Override
	public void actualizar() throws EdificioEnConstruccionException, EdificioReparadoException {
		estado = estado.ejecutarAccion();
	}

	@Override
	public void crearUnidad(Unidad unidad) throws CasilleroNoExistenteException, CasilleroLlenoException, MapaLlenoException, UnidadErroneaException, MovimientoInvalidoException, EdificioNoDisponibleException {

		if( !(estado instanceof EstadoEdificioInactivo) ) throw new EdificioNoDisponibleException("El edificio no esta disponible");

		if( !( unidad instanceof Espadachin ) && !( unidad instanceof Arquero ) ) {
			throw new UnidadErroneaException("Imposible crear ese tipo de unidad");
		}

		posiciones.get(0).colocarEnCasilleroLibreMasCercano(unidad);
		jugador.agregarAPoblacion(unidad);
	}
}
