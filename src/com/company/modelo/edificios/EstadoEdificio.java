package com.company.modelo.edificios;

public class EstadoEdificio {

	private final int VIDA_MAXIMA;
	private final int PORCENTAJE_REPARACION;
	private int vidaActual;
	private final int COSTO;
	
	public EstadoEdificio(int vida,int costo, int porcentajeReparacion) {
		
		this.VIDA_MAXIMA = vida;
		this.setVidaActual(VIDA_MAXIMA);
		this.COSTO =  costo;
		this.PORCENTAJE_REPARACION = porcentajeReparacion;
	
	}
	
	public boolean comoNuevo() {
		return VIDA_MAXIMA == vidaActual;
	}
	
	private void setVidaActual(int vida) {
		vidaActual = vida;
		
	}

	public void recibirDanio(int unDanio) {
		this.vidaActual -= unDanio;
	}
	
	public void reparar() {
		this.vidaActual += PORCENTAJE_REPARACION;
	}
	
}
