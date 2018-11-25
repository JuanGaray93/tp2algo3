package com.company.modelo.unidades;

import com.company.excepciones.*;
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

	public void establecerCoordenadasDeNacimiento(Integer posicionHorizontal, Integer posicionVertical) {
		posicion = new Posicion(posicionHorizontal, posicionVertical);
	}

	public void moverA(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {
		posicion.moverA(posicionHorizontal, posicionVertical);
	}

	@Override
	public void recibirDanio(Integer montoDeDanio) {
		estado.recibirDanio(montoDeDanio);
	}

	/*private void eliminarDePosicion() throws CasilleroNoExistenteException {
		if(posicion != null){
			posicion.quitarPosicionable();
		}
	}*/

	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical){

	}
}
