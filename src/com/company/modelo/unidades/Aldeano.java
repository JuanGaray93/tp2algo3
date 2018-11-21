package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoAldeano;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class Aldeano extends Unidad {

	private final Integer VIDA = 50;
	private final Integer COSTO = 25;

	Edificio edificioATrabajar;

	EstadoAldeano estadoActual;

	public Aldeano(Jugador jugador) {
		super(jugador);
		estado = new EstadoUnidad(VIDA,COSTO);
       estadoActual = new Inactivo();
	}

	public void construir(Edificio edificio,Integer x, Integer y) throws CasilleroLlenoException, CasilleroNoExistenteException {
		
		edificio.construir(this,x,y);
	}

	private void recolectarOro() {

		if(estado.vivo()) {

			jugador.sumarOro(PRODUCCION_ORO);
		}
	}

	public void reparar(Edificio edificio) {
		
			edificioATrabajar = edificio;
			turnosOcupado = edificioATrabajar.calcularTiempoReparacion();

			edificio.reparar();

		}catch(EdificioEnReparacionException | EdificioReparadoException e) {
			liberar();
		}
	}

	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

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

	@Override
	public void recibirDanio(Integer montoDeDanio) {

	}

	public boolean estaLibre() {
		return edificioATrabajar == null;
		
	}

	public void liberar(){
        edificioATrabajar = null;

	}

}
