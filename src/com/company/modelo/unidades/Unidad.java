package com.company.modelo.unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.estados.EstadoUnidad;

public abstract class Unidad extends Posicionable {

	protected Posicion posicion;
	protected EstadoUnidad estado;

	public Unidad(Jugador jugador) {
		this.jugador = jugador;
	}

	public void establecerCoordenadasDeNacimiento(int posicionHorizontal, int posicionVertical) {
		posicion = new Posicion(posicionHorizontal, posicionVertical);
	}

	public void moverA(int posicionHorizontal, int posicionVertical) throws CasilleroLlenoException, CasilleroNoExistenteException {
		this.eliminarDePosicion();
		posicion = new Posicion(posicionHorizontal, posicionVertical);
		posicion.posicionar(this);
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
		// TODO
	}
}
