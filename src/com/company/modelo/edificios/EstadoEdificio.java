package com.company.modelo.edificios;

import com.company.excepciones.EdificioEnReparacionException;
import com.company.excepciones.EdificioReparadoException;
import com.company.modelo.unidades.Aldeano;


public class EstadoEdificio {

	private final Integer TURNOS_CONSTRUCCION;
	private final Integer VIDA_MAXIMA;
	private final Integer PORCENTAJE_REPARACION;
	private Integer vidaActual;
	private final Integer COSTO;
	private final Integer TAMANIO;
	private boolean enReparacion;
	private boolean enConstruccion;
	private int reloj;


	public EstadoEdificio(int vida,int costo, int porcentajeReparacion,int tamanio, int turnosConst) {
		
		this.VIDA_MAXIMA = vida;
		vidaActual = VIDA_MAXIMA;
		this.COSTO =  costo;
		this.PORCENTAJE_REPARACION = porcentajeReparacion;
		this.TAMANIO = tamanio;
		TURNOS_CONSTRUCCION = turnosConst;
		enReparacion = false;
		reloj = 0;

	}


    public boolean comoNuevo() {
		return VIDA_MAXIMA == vidaActual;
	}

	public void recibirDanio(Integer unDanio) {
		this.vidaActual -= unDanio;
	}
	
	public void reparar(Aldeano peon) throws EdificioReparadoException, EdificioEnReparacionException {
      //Deberia ser edificioocupadoException, considerar el caso de construyendose
		if(this.comoNuevo()){
			throw new EdificioReparadoException();
		} if(this.enReparacion){

			throw new EdificioEnReparacionException("");
		}
			this.vidaActual += PORCENTAJE_REPARACION;
			reloj = (VIDA_MAXIMA - vidaActual)/PORCENTAJE_REPARACION;
			enReparacion = true;
	}

	public void construir(){

		reloj = TURNOS_CONSTRUCCION;
		enConstruccion = true;
	}

    public int getTamanio() {
		return TAMANIO;
    }

    public int actualizar(){

		if(enReparacion) {

			this.vidaActual += PORCENTAJE_REPARACION;
			reloj = (VIDA_MAXIMA - vidaActual)/PORCENTAJE_REPARACION;
			if (vidaActual == VIDA_MAXIMA) {
				enReparacion = false;
			}
		}else
			if(enConstruccion){
				reloj --;
				if (vidaActual == VIDA_MAXIMA) {
					enConstruccion = false;
				}
		}

		return	reloj;
	}

	public boolean estaLibre() {
	    return reloj == 0;
    }
}
/*estado puede estar reparando, construyendo o haciendo nada si esta reparando entonces hasta que no termine
;a vda del edifico  no termina si esta construyendo dura la cantidad de turnos
 */
