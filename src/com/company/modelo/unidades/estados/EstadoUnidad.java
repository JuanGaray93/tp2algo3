package com.company.modelo.unidades.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.UnidadMuertaException;

public abstract class EstadoUnidad {

	protected Integer vidaActual;

	public EstadoUnidad(Integer vidaActual) {
		this.vidaActual = vidaActual;
	}
	
	public EstadoUnidad recibirDanio(Integer montoDeDanio) throws UnidadMuertaException, Exception, EdificioEnConstruccionException {

		if(montoDeDanio < 0){
			throw new RuntimeException("El daño recibido fue negativo todo mal.");
		}

		if(montoDeDanio >= vidaActual) {
			this.vidaActual = 0;
			throw  new UnidadMuertaException("La unidad esta muerta");
		}

		this.vidaActual -= montoDeDanio;
		return this;
	}

	public Integer getVidaActual() throws UnidadMuertaException {
		return this.vidaActual;
	}

	public abstract EstadoUnidad actualizar() throws Exception;

}
