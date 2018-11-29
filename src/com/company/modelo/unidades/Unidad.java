package com.company.modelo.unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.MovimientoInvalidoException;
import com.company.excepciones.UnidadMuertaException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.estados.EstadoUnidad;
import com.company.modelo.unidades.estados.EstadoUnidadInactivo;

public abstract class Unidad extends Posicionable {

	protected static Integer VIDA_MAXIMA;
	protected static Integer COSTO;
	protected static Integer vidaActual;

	protected Posicion posicion;
	protected EstadoUnidad estado;

	public Unidad(Jugador jugador) {
		this.jugador = jugador;
		this.posicion = null;
	}

	public void establecerCoordenadasDeNacimiento(int posicionHorizontal, int posicionVertical) {
		posicion = new Posicion(posicionHorizontal, posicionVertical);
	}

	public void moverA(int posicionHorizontal, int posicionVertical) throws CasilleroLlenoException,
			CasilleroNoExistenteException, MovimientoInvalidoException {

		if( posicion.seEncuentraEnRadio(posicionHorizontal, posicionVertical) ){
			this.eliminarDePosicion();
			posicion = new Posicion(posicionHorizontal, posicionVertical);
			posicion.posicionar(this);
		}

		else throw new MovimientoInvalidoException("No es posible moverse a ese casillero");

	}

	public Integer getVida() throws UnidadMuertaException {
		return this.estado.getVidaActual();
	}

	@Override
	public void recibirDanio(Integer montoDeDanio) throws Exception, EdificioEnConstruccionException {
		estado = estado.recibirDanio(montoDeDanio);
	}

	private void eliminarDePosicion() {
		if(posicion != null){
			posicion.eliminar();
		}
	}

	public void ubicar(Integer posicionHorizontal, Integer posicionVertical){
		// TODO
	}

	@Override
	public void actualizar() throws Exception {
		estado = estado.actualizar();
	}

	public Integer getCosto(){
		return COSTO;
	}
}
