package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.*;

public class Aldeano extends Unidad {

	private final Integer VIDA = 50;
	private final Integer COSTO = 25;

	EstadoAldeano estadoActual;

	//LISTO
	public Aldeano(Jugador jugador) {
		super(jugador);
		estadoActual = new EstadoAldeanoInactivo();
	}
	//LISTO
	public void construir(Edificio edificio,Integer x, Integer y) throws OroInsuficienteException {
		estadoActual = new EstadoAldeanoConstruyendo();
		try {
			edificio.construir(this,x,y);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//LISTO
	private void recolectarOro() {

		if(estado.vivo()) {

			jugador.sumarOro(estadoActual.getGanancia());
		}
	}
	//LISTO
	public void reparar(Edificio edificio) {

			try {
				edificio.reparar(edificio);
				estadoActual = new EstadoAldeanoReparando();
			} catch (EdificioReparadoException e) {
				//manejar
			} catch (EdificioEnReparacionException e) {
				//manejar
			}

	}
	//???
	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {
		//this.estadoActual = ;
	}

	public void actualizar() {
		this.estadoActual =  estadoActual.ejecutarAccion();
	}

	@Override
	public void recibirDanio(Integer montoDeDanio) {
		this.estadoActual.recibirDanio(montoDeDanio);
	}

	public boolean estaLibre() {
		return this.estadoActual.tieneEstado("INACTIVO");
	}

	public void liberar(){
		estadoActual = new EstadoAldeanoInactivo();
	}

}
