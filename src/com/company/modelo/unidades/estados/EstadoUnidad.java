package com.company.modelo.unidades.estados;

public class EstadoUnidad {

	private final Integer VIDA_MAXIMA;
	private Integer vidaActual;
	private final Integer COSTO;
	
	public EstadoUnidad(int vida,int costo) {
		
		this.VIDA_MAXIMA = vida;
		this.setVidaActual(VIDA_MAXIMA);
		this.COSTO =  costo;
	
	}
	
	public void recibirDanio(Integer montoDeDanio) {
		this.vidaActual -= montoDeDanio;
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
