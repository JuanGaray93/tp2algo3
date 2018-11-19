package com.company.modelo.edificios;

import com.company.excepciones.EdificioEnReparacionException;
import com.company.excepciones.EdificioReparadoException;

public class EstadoEdificio {

	private final int VIDA_MAXIMA;
	private final int PORCENTAJE_REPARACION;
	private int vidaActual;
	private Boolean enReparacion = false;
	private final Integer COSTO;
	
	public EstadoEdificio(Integer vida,Integer costo, Integer porcentajeReparacion) {
		
		this.VIDA_MAXIMA = vida;
		this.setVidaActual(VIDA_MAXIMA);
		this.COSTO =  costo;
		this.PORCENTAJE_REPARACION = porcentajeReparacion;
	
	}
	
	public boolean comoNuevo() {
		return VIDA_MAXIMA == vidaActual;
	}
	
	private void setVidaActual(Integer vida) {
		vidaActual = vida;
		
	}

	public void recibirDanio(Integer unDanio) {
		this.vidaActual -= unDanio;
	}
	
	public void reparar() throws EdificioReparadoException, EdificioEnReparacionException {

		if(this.comoNuevo()){
			throw new EdificioReparadoException();
		} if(this.enReparacion){
			throw new EdificioEnReparacionException("");
		}

		this.vidaActual += PORCENTAJE_REPARACION;

	}
	
}
