package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class Aldeano extends Unidad {

	final private static Integer PRODUCCION_ORO = 20;

	private int turnosOcupado;

	Edificio edificioATrabajar;

	boolean trabajando;

	public Aldeano(Jugador jugador) {
		super(jugador);
		estado = new EstadoUnidad(50,25);
        edificioATrabajar= null;
		trabajando  = false;
	}

	public void construir(Edificio edificio,Integer x, Integer y) throws CasilleroLlenoException, CasilleroNoExistenteException {
		if(edificioATrabajar!=null){
			throw new UnidadOcupadaException("Tal vez mas tarde...");
		}
		edificioATrabajar = edificio;
		turnosOcupado = 3;
		edificio.construir(x,y);
	}

	private void recolectarOro() {

		if(estado.vivo()) {

			jugador.sumarOro(PRODUCCION_ORO);
		}
	}

	public void reparar(Edificio edificio) {
			
		if (edificioATrabajar != null) {
			throw new UnidadOcupadaException("Tal vez mas tarde...");
		}
		try {

			edificioATrabajar = edificio;
			// NO! El state lo tiene que manejar  turnosOcupado = edificioATrabajar.calcularTiempoReparacion();

			edificio.reparar();

		}catch(EdificioEnReparacionException | EdificioReparadoException e) {
			liberar();
		}
	}

	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {
		// TODO
	}

	public void actualizar() {

                 if(turnosOcupado>1){

                     turnosOcupado = edificioATrabajar.actualizar();

                 }else
                 	if(turnosOcupado == 0 ){

				    	edificioATrabajar = null;
                    	recolectarOro();
                }else
                	if(	turnosOcupado == 1){
						turnosOcupado = edificioATrabajar.actualizar();
                		this.liberar();
					}

	}


	public boolean estaLibre() {
		return edificioATrabajar == null;
		
	}

	public void liberar(){
        edificioATrabajar = null;

	}

}
