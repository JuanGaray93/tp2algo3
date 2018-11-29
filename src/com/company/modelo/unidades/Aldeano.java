package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeano;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoConstruyendo;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoRecolectandoOro;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoReparando;

import java.util.ArrayList;

public class Aldeano extends Unidad {


	public Aldeano(Jugador jugador) {
		super(jugador);
		VIDA_MAXIMA = 50;
		vidaActual = VIDA_MAXIMA;
		COSTO = 25;
		this.estado = new EstadoAldeanoRecolectandoOro(jugador, vidaActual);
	}

	/*@Override
	public void moverA(Integer posicionHorizontal, Integer posicionVertical)
			throws CasilleroNoExistenteException,
			CasilleroLlenoException, MovimientoInvalidoException {
		posicion.moverA(posicionHorizontal, posicionVertical);
		try {
			estadoActual.abandonarTareaActual();
		} catch (Exception | EdificioEnConstruccionException ignored) {
		}
	}

	private boolean existentesEnRadio(Edificio e) {
		ArrayList<Posicionable> cercanos = this.posicion.buscarPosicionablesEnRadio(1);
		return cercanos.contains(e);
	}*/

	@Override
	public void recibirDanio(Integer montoDeDanio) throws Exception {
		try {
			estado.recibirDanio(montoDeDanio);
		} catch (UnidadMuertaException | EdificioEnConstruccionException e) {
			//posicion.quitarPosicionable();
			jugador.eliminarDePoblacion(this);

		}
	}


	/*public void construir(Edificio edificio, Integer x, Integer y)
			throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {
		if (posicion.esDistanciaValida(x, y)) {

			estadoActual = estadoActual.construir(edificio);

			edificio.construir(this, x, y);

		} else {
			throw new DistanciaInvalidaException("No puedo construir a esa distancia");
		}

	}

	public void reparar(Edificio edificio) throws EdificioLejanoException {
		if (existentesEnRadio(edificio)) {

			try {

				edificio.reparar(this);
				estadoActual = estadoActual.reparar(edificio);

			} catch (Exception | EdificioEnConstruccionException e) {
				//
			} catch (EdificioDestruidoExcepcion edificioDestruidoExcepcion) {
				edificioDestruidoExcepcion.printStackTrace();
			}

		} else {
			throw new EdificioLejanoException("Disculpe, esto esta muy lejos");
		}

	}*/

	public void liberar() throws Exception {
		estado = new EstadoAldeanoRecolectandoOro(jugador, vidaActual);
		estado.actualizar();
	}

	@Override
	public void actualizar() throws Exception {

		estado = estado.actualizar();

	}

}
