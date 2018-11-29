package com.company.modelo.unidades;

import com.company.excepciones.*;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedio;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedioDesmontada;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedioMontada;

public class ArmaAsedio extends UnidadAtacante {

	private EstadoArmaAsedio estado;
	private Integer VIDA_MAXIMA = 150;

	public ArmaAsedio(Jugador jugador) {
		
		super(jugador);
		COSTO = 200;
		this.estado =  new EstadoArmaAsedioDesmontada(this,VIDA_MAXIMA);
	}

	//solo ataca edificios por 75 danio y hasta distancia 5.
    public void atacar(Edificio enemigo) throws PosicionableEsAliadoException {
    	if(this.verificarAlianza(enemigo)) {
    		throw new PosicionableEsAliadoException("la unidad que quiere atacar es propia");
    	}
    	else {
    		//this.estado.atacar(enemigo);
    	}
    }

    @Override
	public void atacarA(Unidad enemigo) throws EnemigoInvalidoException, ArmaDesmontadaException {
		if (estado instanceof EstadoArmaAsedioMontada) {
			throw new EnemigoInvalidoException("El arma asedio no puede atacar unidades");
		}
		throw new ArmaDesmontadaException("el arma no puede atacar desmontada");
	}

	@Override
	public void atacarA(Edificio enemigo)
			throws ArmaDesmontadaException, PosicionableEsAliadoException {
		if (estado instanceof EstadoArmaAsedioMontada) {
			atacar(enemigo);
		}
		throw new ArmaDesmontadaException("el arma no puede atacar desmontada");
	}


	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

	}

	public Boolean verificarAlianza(Posicionable otroPosicionable) {
		return null;
	}

	public Boolean verificarAlianza(Jugador otroJugador) {
		return null;
	}
	
	//toma 1 turno montar/desmontar, si esta montada puede atacar pero no moverse.
	
	public void montar() throws ArmaMontadaException {
		this.estado = estado.montar();
	}
	
	public void desmontar() throws ArmaDesmontadaException {
		this.estado = estado.desmontar();
	}

	@Override
	public void moverA(Integer posicionHorizontal, Integer posicionVertical)
			throws CasilleroLlenoException, CasilleroNoExistenteException, ArmaMontadaException, MovimientoInvalidoException {
		estado.moverA(posicion, posicionHorizontal,posicionVertical);
	}

}
