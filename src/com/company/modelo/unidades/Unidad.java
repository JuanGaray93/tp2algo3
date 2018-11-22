package com.company.modelo.unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MovimientoInvalidoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.estados.EstadoUnidad;

public abstract class Unidad extends Posicionable {

	protected Posicion posicion;
	protected EstadoUnidad estado;
	protected String nombre;

	public Unidad(Jugador jugador) {
		this.jugador = jugador;
	}

	public void establecerCoordenadasDeNacimiento(int posicionHorizontal, int posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException {
		posicion = new Posicion(posicionHorizontal, posicionVertical);
	}

	public void moverA(int posicionHorizontal, int posicionVertical)
			throws CasilleroLlenoException, CasilleroNoExistenteException,
			MovimientoInvalidoException {
		if(posicion.posicionEnRadio(posicionHorizontal,posicionVertical)){
			this.eliminarDePosicion();
			posicion = new Posicion(posicionHorizontal, posicionVertical);
			posicion.posicionar(this);
		}else {
			throw new MovimientoInvalidoException("No es posible moverse a ese casillero");
		}
	}

	@Override
	public void recibirDanio(Integer montoDeDanio) {
		estado.recibirDanio(montoDeDanio);
	}

	private void eliminarDePosicion() throws CasilleroNoExistenteException {
		if(posicion != null){
			posicion.eliminar();
		}
	}

	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical){

	}

    public boolean seLlama(String nombre) {
		return this.nombre == nombre;
    }
}
