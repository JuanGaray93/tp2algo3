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
		COSTO = 200;
		this.estado =  new EstadoArmaAsedioDesmontada(this);
	}

	@Override
	public void atacarA(Unidad enemigo) throws EnemigoInvalidoException, ArmaDesmontadaException {
		if ( !(estado instanceof EstadoArmaAsedioMontada) ) {
			throw new ArmaDesmontadaException("el arma no puede atacar desmontada");
		}

		throw new EnemigoInvalidoException("El arma asedio no puede atacar unidades");
	}

	@Override
	public void atacarA(Edificio enemigo) throws EnemigoInvalidoException, ArmaDesmontadaException {
		if ( !(estado instanceof EstadoArmaAsedioMontada) ) {
			throw new ArmaDesmontadaException("el arma no puede atacar desmontada");
		}

		this.atacar(enemigo, this.danioAEdifcio);
	}


	public void montar() throws ArmaMontadaException {
		this.estado = estado.montar();
	}

	public void desmontar() throws ArmaDesmontadaException {
		this.estado = estado.desmontar();
	}

}
