package com.company.modelo.unidades;

import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.excepciones.EnemigoInvalidoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedio;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedioDesmontada;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedioMontada;

public class ArmaAsedio extends UnidadAtacante {

	private EstadoArmaAsedio estado;

	public ArmaAsedio(Jugador jugador) {
		super(jugador);
		this.rangoAtaque = 5;
		this.danioAEdifcio = 75;
		this.danioAUnidad = 0;
		VIDA_MAXIMA = 150;
		vidaActual = VIDA_MAXIMA;
		COSTO = 200;
		this.estado =  new EstadoArmaAsedioDesmontada(VIDA_MAXIMA);
	}

	@Override
	public void atacarA(Unidad enemigo) throws EnemigoInvalidoException, ArmaDesmontadaException {
		if (estado instanceof EstadoArmaAsedioMontada) {
			throw new EnemigoInvalidoException("El arma asedio no puede atacar unidades");
		}
		throw new ArmaDesmontadaException("el arma no puede atacar desmontada");
	}

	@Override
	public void atacarA(Edificio enemigo) throws EnemigoInvalidoException, ArmaDesmontadaException {
		if (estado instanceof EstadoArmaAsedioMontada) {
			atacar(enemigo, danioAEdifcio);
		}
		throw new ArmaDesmontadaException("el arma no puede atacar desmontada");
	}


	public void montar() throws ArmaMontadaException {
		this.estado = estado.montar();
	}

	public void desmontar() throws ArmaDesmontadaException {
		this.estado = estado.desmontar();
	}

}
