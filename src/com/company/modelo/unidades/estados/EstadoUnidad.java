package com.company.modelo.unidades.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.UnidadMuertaException;

public abstract class EstadoUnidad {

	protected Integer VIDA_MAXIMA;
	protected Integer vidaActual;

	public EstadoUnidad(Integer vidaMaxima) {
		this.VIDA_MAXIMA = vidaMaxima;
		this.vidaActual = vidaMaxima;
	}

	public EstadoUnidad recibirDanio(Integer montoDeDanio) throws Exception, EdificioEnConstruccionException {

		if(montoDeDanio < 0){
			throw new RuntimeException("El daño recibido fue negativo todo mal.");
		}

		this.vidaActual -= montoDeDanio;

		//if(this.vidaActual <= 0) return new EstadoUnidadMuerto(this.VIDA_MAXIMA);

		return this;
	}

	public Integer getVidaActual() throws UnidadMuertaException {
		return this.vidaActual;
	}

	public abstract EstadoUnidad actualizar() throws Exception;
}
