package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedio;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedioDesmontada;

import unidades.EstadoMaquinaAsedioDesmontada;
import unidades.PosicionableEsAliadoException;

public class ArmaAsedio extends Unidad {
	
	

	public ArmaAsedio(Jugador jugador) {
		
		super(jugador);
		this.estado =  new EstadoMaquinaAsedioDesmontada(150,200, this);
	   	this.montada = false;
		
	}
	
	//solo ataca edificios por 75 da�o y hasta distancia 5.
    public void atacar(Edificio enemigo) throws PosicionableEsAliadoException {
    	if(this.verificarAlianza(enemigo.jugador)) {
    		throw new PosicionableEsAliadoException("la unidad que quiere atacar es propia");
    	}
    	else {
    		this.estado.atacar(enemigo);
    	}
    }
    
	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

	}

	//@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean verificarAlianza(Posicionable otroPosicionable) {
		return null;
	}

	@Override
	public Boolean verificarAlianza(Jugador otroJugador) {
		return null;
	}
	
	//toma 1 turno montar/desmontar, si esta montada puede atacar pero no moverse.
	
	public void montar() {
		this.estado = estado.montar();
	}

	public void desmontar() {
		this.estado.desmontar();
	}
	
	public void moverA(Integer posicionHorizontal, Integer posicionVertical) {
		super.moverA(posicionHorizontal, posicionVertical);
	}

}
