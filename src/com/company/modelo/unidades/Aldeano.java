package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeano;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoConstruyendo;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoRecolectandoOro;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoReparando;

import java.util.ArrayList;

public class Aldeano extends Unidad {

	EstadoAldeano estadoActual;

	//LISTO
	public Aldeano(Jugador jugador) {
		super(jugador);
		estadoActual = new EstadoAldeanoRecolectandoOro();
	}

	private boolean existeEnRadio(Edificio edificio) {
		ArrayList<Posicionable> cercanos = this.posicion.buscarEnRadioPosicionables(1);
		return cercanos.contains(edificio);
	}

	public void construir(Edificio edificio, Integer posicionHorizontal, Integer posicionVertical) throws DistanciaInvalidaException {

		if (posicion.seEncuentraEnRadio(posicionHorizontal, posicionVertical)) {
			try {
				edificio.construir(this, posicionHorizontal, posicionVertical);
				estadoActual = estadoActual.construir(edificio, posicionHorizontal, posicionVertical);
			} catch (EdificioEnConstruccionException e) {
			} catch (CasilleroLlenoException e) {
			} catch (CasilleroNoExistenteException e) {
			} catch (EdificioDestruidoExcepcion e) {
			} catch (EdificioNoConstruidoException e) {
			} catch (ErrorDeConstruccionException e) {
			} catch (EdificioEnReparacionException e) {
			}
		}

		else throw new DistanciaInvalidaException("No puedo construir a esa distancia");

	}

	//LISTO
	public void reparar(Edificio edificio) throws EdificioLejanoException {

			if (existeEnRadio(edificio)) {
				try {
					edificio.reparar(this);
					estadoActual = new EstadoAldeanoReparando();
				} catch (EdificioReparadoException e) {
					e.printStackTrace();
				} catch (EdificioEnReparacionException e) {
				} catch (EdificioEnConstruccionException e) {
				} catch (EdificioDestruidoExcepcion e) {
				} catch (EdificioNoConstruidoException e) {
				}
			}

			else throw new EdificioLejanoException("Disculpe, esto esta muy lejos");

	}

	public void liberar(){
		estadoActual = new EstadoAldeanoRecolectandoOro();
		estadoActual.otorgarGanancia(jugador);
	}

	@Override
	public void recibirDanio(Integer montoDeDanio) throws UnidadMuertaException {
		this.estadoActual.recibirDanio(montoDeDanio);
	}

	@Override
	public void actualizar() {
		try {
			estadoActual.otorgarGanancia(jugador);
		} catch (AldeanoOcupadoException e) {
			//si esta ocupado no hace nada, no suma oro
		}
	}

}
