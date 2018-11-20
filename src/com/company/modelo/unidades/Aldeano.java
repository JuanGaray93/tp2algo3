package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.estados.EstadoAldeano;

public class Aldeano extends Unidad {

	final private static Integer PRODUCCION_ORO = 20;

	private int turnosOcupado;

	Edificio edificioATrabajar;

	public Aldeano(Jugador jugador) {
		super(jugador);
		estado = new EstadoUnidad(50,25);
        edificioATrabajar= null;
		turnosOcupado = 0;
	}

	public void construir(Edificio edificio,Integer x, Integer y) throws CasilleroLlenoException, CasilleroNoExistenteException {
		if(edificioATrabajar!=null){
			throw new UnidadOcupadaException("Tal vez mas tarde...");
		}
		edificioATrabajar = edificio;
		turnosOcupado = 3;
		edificio.construirEn(x,y);
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
			turnosOcupado = edificioATrabajar.calcularTiempoReparacion();
			System.out.println(turnosOcupado);
			edificio.reparar();

		}catch(EdificioEnReparacionException | EdificioReparadoException e) {
			liberar();
		}
	}

	public void actualizar() {

                 if(turnosOcupado>0){
                     turnosOcupado = edificioATrabajar.actualizar();

                 }else
                 	if(turnosOcupado == 0 ){

				    	edificioATrabajar = null;
                    	recolectarOro();
                }

	}

	public boolean estaLibre() {
		return edificioATrabajar == null;
		
	}

	public void liberar(){
        edificioATrabajar = null;

	}

}
