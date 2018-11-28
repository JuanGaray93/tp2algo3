package com.company.modelo.unidades.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.UnidadMuertaException;

public abstract class EstadoUnidad {

	protected static Integer VIDA_MAXIMA;
	protected static Integer COSTO;
	protected static Integer vidaActual;

	/*public EstadoUnidad() {
		VIDA_MAXIMA = vida_maxima;
		COSTO = costo;
		vidaActual = vida_maxima;
	}
	*/

	public EstadoUnidad recibirDanio(Integer montoDeDanio) throws Exception, EdificioEnConstruccionException {

		if(montoDeDanio < 0){
			throw new RuntimeException("El daño recibido fue negativo todo mal.");
		}

		this.vidaActual -= montoDeDanio;

		if(this.vidaActual <= 0) return new EstadoUnidadMuerto(VIDA_MAXIMA,COSTO);

		return this;
	}

	public Integer getVidaActual() throws UnidadMuertaException{
		return vidaActual;
	}

    public abstract EstadoUnidad actualizar() throws Exception;
}
