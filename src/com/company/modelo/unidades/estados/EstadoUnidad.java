package com.company.modelo.unidades.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.UnidadMuertaException;

public abstract class EstadoUnidad {

<<<<<<< HEAD
	protected final Integer VIDA_MAXIMA;
	protected static Integer vidaActual;

	public EstadoUnidad(Integer vidaMaxima, Integer vida_actual) {
		this.VIDA_MAXIMA = vidaMaxima;
		this.vidaActual = vida_actual;

=======
	protected Integer VIDA_MAXIMA;
	protected Integer vidaActual;

	public EstadoUnidad(Integer vidaMaxima) {
		this.VIDA_MAXIMA = vidaMaxima;
		this.vidaActual = vidaMaxima;
>>>>>>> 969c90a9dda6186e07f0f11e981377a586b86c23
	}

	public EstadoUnidad recibirDanio(Integer montoDeDanio)
			throws Exception, EdificioEnConstruccionException {

		if(montoDeDanio < 0){
			throw new RuntimeException("El daño recibido fue negativo todo mal.");
		}

		this.vidaActual -= montoDeDanio;

<<<<<<< HEAD
		if(this.vidaActual <= 0) {
			vidaActual = 0;
			throw new UnidadMuertaException("Esta unidad se ha muerto");
		}
=======
		//if(this.vidaActual <= 0) return new EstadoUnidadMuerto(this.VIDA_MAXIMA);
>>>>>>> 969c90a9dda6186e07f0f11e981377a586b86c23

		return this;
	}

<<<<<<< HEAD
	public Integer getVidaActual(){
		return vidaActual;
=======
	public Integer getVidaActual() throws UnidadMuertaException {
		return this.vidaActual;
>>>>>>> 969c90a9dda6186e07f0f11e981377a586b86c23
	}

	public abstract EstadoUnidad actualizar() throws Exception;
}
