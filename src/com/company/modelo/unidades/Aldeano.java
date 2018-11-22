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

public class Aldeano extends Unidad {

	EstadoAldeano estadoActual;

	//LISTO
	public Aldeano(Jugador jugador) {
		super(jugador);
		estadoActual = new EstadoAldeanoRecolectandoOro();
	}
	//LISTO
	public void construir(Edificio edificio,Integer x, Integer y) throws OroInsuficienteException {
		estadoActual = new EstadoAldeanoConstruyendo();
		try {
			edificio.construir(this,x,y);
		} catch (EdificioEnConstruccionException e) {
			e.printStackTrace();
		} catch (CasilleroLlenoException e) {
			e.printStackTrace();
		} catch (CasilleroNoExistenteException e) {
			e.printStackTrace();
		} catch (EdificioEnReparacionException e) {
			e.printStackTrace();
		} catch (EdificioDestruidoExcepcion e) {
			e.printStackTrace();
		}
	}

	//LISTO
	public void reparar(Edificio edificio) throws Exception {

			try {
				edificio.reparar(this);
				estadoActual = new EstadoAldeanoReparando();

			} catch (EdificioReparadoException e) {
				e.printStackTrace();
			} catch (EdificioEnReparacionException e) {
				e.printStackTrace();
			} catch (EdificioEnConstruccionException e) {
				e.printStackTrace();
			} catch (EdificioDestruidoExcepcion e) {
				e.printStackTrace();
			} catch (EdificioNoConstruidoException e) {
				e.printStackTrace();
			}

	}

	public void actualizar(EstadoAldeano estado) {

		this.estadoActual =  estado;
		estadoActual.otorgarGanancia(jugador);
	}

	@Override
	public void recibirDanio(Integer montoDeDanio) {
		this.estadoActual.recibirDanio(montoDeDanio);
	}


	@Override
	public Boolean verificarAlianza(Posicionable otroPosicionable) {
		return null;
	}

	@Override
	public Boolean verificarAlianza(Jugador otroJugador) {
		return null;
	}
}
