package com.company.modelo.unidades;

import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.excepciones.EnemigoInvalidoException;
import com.company.modelo.Ataque;
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

	public void atacar(Posicionable unEnemigo) throws ArmaDesmontadaException, EnemigoInvalidoException {
		Ataque ataque = new Ataque(rangoAtaque, danioAEdifcio, danioAUnidad, jugador, posicion);
		this.estado.atacar(ataque, unEnemigo, danioAEdifcio);
	}


	public void montar() throws ArmaMontadaException {
		this.estado = estado.montar();
	}

	public void desmontar() throws ArmaDesmontadaException {
		this.estado = estado.desmontar();
	}

}
