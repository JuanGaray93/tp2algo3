package com.company.modelo.edificios;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioTerminadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoCastillo;
import com.company.modelo.edificios.estados.EstadoEdificio;
import com.company.modelo.edificios.estados.EstadoEnConstruccion;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Ataque;
import com.company.modelo.unidades.Unidad;

import edificios.ArrayList;
import edificios.CasilleroLlenoException;
import edificios.MaquinaAsedio;
import edificios.Posicion;
import edificios.PosicionableEsAliadoException;

public class Castillo extends Edificio {

    private Ataque ataque;

    EstadoCastillo estado;

    public Castillo(Jugador jugador) {
        super(jugador);
        VIDA_MAXIMA = 1000;
        vidaActual = 1000;
        MONTO_REPARACION = 15;
        estado = new EstadoCastillo(VIDA_MAXIMA);
		ataque = new Ataque(20,20);
    }
    
    public void construirArmaAsedio(){
		
		MaquinaAsedio maquinaAsedio = new MaquinaAsedio(jugador)
		Posicion posicion = posiciones.get(0);
		try {
			posicion.posicionar(maquinaAsedio);
		} catch (CasilleroLlenoException e) {
			
		}
		jugador.agregarAPoblacion(maquinaAsedio);
	}

    @Override
    public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

    }

    public void actualizar() {

    }

    @Override
    public Boolean verificarAlianza(Posicionable otroPosicionable) {
        return null;
    }

    @Override
    public Boolean verificarAlianza(Jugador otroJugador) {
        return null;
    }
    
    public void ataque() throws PosicionableEsAliadoException {
		
		ArrayList <Posicionable> posicionablesCercanos = new ArrayList <>();
		for(Posicion posicion: this.posiciones) {
			posicionablesCercanos.addAll(posicion.buscarEnemigosEnRadio(3));
		}
		for(Posicionable cercano: posicionablesCercanos) {
			if(this.verificarAlianza(cercano.jugador)) {
	    		throw new PosicionableEsAliadoException("la unidad que quiere atacar es propia");
	    	}
	    	else {
	    		ataque.atacar(cercano);
	    	}
		
		}
		
	}

	

}
