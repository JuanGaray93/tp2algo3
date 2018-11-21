package com.company.modelo.unidades.estados;

public class EstadoUnidad {

	private final int VIDA_MAXIMA;
	private int vidaActual;
	private final int COSTO;
	
	public EstadoUnidad(int vida,int costo) {
		
		this.VIDA_MAXIMA = vida;
		this.setVidaActual(VIDA_MAXIMA);
		this.COSTO =  costo;
	
	}
	
	public void recibirDanio(int unDanio) {
		this.vidaActual -= unDanio;
	}
	
	public int getVIDAMAXIMA() {
		return this.VIDA_MAXIMA;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public int getCOSTO() {
		return COSTO;
	}

	public boolean estaSaludable() {
		return VIDA_MAXIMA == vidaActual;
	}

	public boolean vivo() {
		return this.vidaActual>0;
	}
}
