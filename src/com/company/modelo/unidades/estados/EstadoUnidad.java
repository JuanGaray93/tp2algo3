package com.company.modelo.unidades.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.UnidadMuertaException;

public abstract class EstadoUnidad {

	protected Integer VIDA_ACTUAL;

	public EstadoUnidad(Integer vidaActual) {
		this.VIDA_ACTUAL = vidaActual;
	}
	
	public EstadoUnidad recibirDanio(Integer montoDeDanio) throws UnidadMuertaException, Exception, EdificioEnConstruccionException {

		if(montoDeDanio < 0){
			throw new RuntimeException("El daño recibido fue negativo todo mal.");
		}

		if(montoDeDanio >= VIDA_ACTUAL) {
			VIDA_ACTUAL = 0;
			throw new UnidadMuertaException("La unidad esta muerta");
		}

		VIDA_ACTUAL -= montoDeDanio;
		return this;
	}

	public Integer getVidaActual() throws UnidadMuertaException {
		return this.VIDA_ACTUAL;
	}

	public abstract EstadoUnidad actualizar() throws Exception;

}
