package com.company.modelo.unidades.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.UnidadMuertaException;

public abstract class EstadoUnidad {


	protected final Integer VIDA_MAXIMA;
	protected static Integer vidaActual;

	public EstadoUnidad(Integer vidaMaxima, Integer vida_actual) {
		this.VIDA_MAXIMA = vidaMaxima;
		this.vidaActual = vida_actual;
	}

	public EstadoUnidad recibirDanio(Integer montoDeDanio)
			throws Exception, EdificioEnConstruccionException {

		if(montoDeDanio < 0){
			throw new RuntimeException("El daño recibido fue negativo todo mal.");
		}

		this.vidaActual -= montoDeDanio;

		if(this.vidaActual <= 0) {
			vidaActual = 0;
			throw new UnidadMuertaException("Esta unidad se ha muerto");
		}

		//if(this.vidaActual <= 0) return new EstadoUnidadMuerto(this.VIDA_MAXIMA);

		return this;
	}

	public Integer getVidaActual() {
		return vidaActual;
	}

	public abstract EstadoUnidad actualizar() throws Exception;
}
