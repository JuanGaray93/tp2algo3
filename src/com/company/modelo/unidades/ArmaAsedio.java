package com.company.modelo.unidades;

import com.company.excepciones.*;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedio;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedioDesmontada;

public class ArmaAsedio extends UnidadAtacante {

	private EstadoArmaAsedio estado;

	public ArmaAsedio(Jugador jugador) {
		
		super(jugador);
		this.estado =  new EstadoArmaAsedioDesmontada(this);
	}

	@Override
	public void atacar(Unidad enemigo) {

	}

	//solo ataca edificios por 75 da�o y hasta distancia 5.
    public void atacar(Edificio enemigo) throws PosicionableEsAliadoException {
    	if(this.verificarAlianza(enemigo)) {
    		throw new PosicionableEsAliadoException("la unidad que quiere atacar es propia");
    	}
    	else {
    		//this.estado.atacar(enemigo);
    	}
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
	public void moverA(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroLlenoException, CasilleroNoExistenteException, ArmaMontadaException {
		estado.moverA(posicion, posicionHorizontal,posicionVertical);
	}

}
