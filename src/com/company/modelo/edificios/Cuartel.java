package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioNoDisponibleException;
import com.company.excepciones.MapaLlenoException;
import com.company.excepciones.UnidadErroneaException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.estados.EstadoEdificioInactivo;
import com.company.modelo.edificios.estados.EstadoPorConstruir;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Espadachin;
import com.company.modelo.unidades.Unidad;

public class Cuartel extends Edificio {

    Integer vida = 0;

    public Cuartel(Jugador jugador) {

        super(jugador);
        COSTO = 50;
        MONTO_DE_REPARACION = 50;
        BLOQUES_DE_ANCHO = 2;
        BLOQUES_DE_ALTO = 2;
        VIDA_MAXIMA = 250;

        try {
            this.estado = new EstadoPorConstruir(this.VIDA_MAXIMA,this.vida, MONTO_DE_REPARACION);
        } catch (Exception ignored) { }
    }

    @Override
    public void construir(Aldeano quienLoConstruye, Integer posicionHorizontal, Integer posicionVertical)
            throws Exception {

        jugador.cobrar(this.COSTO);

        this.ubicar(posicionHorizontal, posicionVertical);

        estado = estado.construir(quienLoConstruye);


    }

	@Override
	public void crear(Unidad unidad)
            throws EdificioNoDisponibleException, UnidadErroneaException,
            CasilleroNoExistenteException, CasilleroLlenoException, MapaLlenoException {

		if( !(estado instanceof EstadoEdificioInactivo) )
		    throw new EdificioNoDisponibleException("El edificio no esta disponible");

		if( !( unidad instanceof Espadachin) && !( unidad instanceof Arquero) ) {
			throw new UnidadErroneaException("Imposible crear ese tipo de unidad");
		}

		posiciones.get(0).colocarEnCasilleroLibreMasCercano(unidad);
        jugador.cobrar(unidad.getCosto());
		jugador.agregarAPoblacion(unidad);
	}

}
