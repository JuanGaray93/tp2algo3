package com.company.modelo.unidades.estados;

public class EstadoUnidad {

	protected static Integer VIDA_MAXIMA;
	protected static Integer COSTO;
	protected static Integer vidaActual;

	public EstadoUnidad() {

	}
	
	public void recibirDanio(Integer montoDeDanio) {
		this.vidaActual -= montoDeDanio;
	}
}
