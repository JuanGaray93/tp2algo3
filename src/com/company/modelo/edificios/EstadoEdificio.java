package com.company.modelo.edificios;

import com.company.excepciones.EdificioEnReparacionException;
import com.company.excepciones.EdificioReparadoException;

public class EstadoEdificio {

	private final Integer TURNOS_CONSTRUCCION;
	private final int VIDA_MAXIMA;
	private final Integer PORCENTAJE_REPARACION;
	public Integer vidaActual;
	private final Integer COSTO;
	private final Integer TAMANIO;
	private boolean enReparacion;
	private boolean enConstruccion;
	private int reloj;


	public EstadoEdificio(int vida,int costo, int porcentajeReparacion,int tamanio, int turnosConst) {
		
		this.VIDA_MAXIMA = vida;
		vidaActual = vida;
		this.COSTO =  costo;
		this.PORCENTAJE_REPARACION = porcentajeReparacion;
		this.TAMANIO = tamanio;
		TURNOS_CONSTRUCCION = turnosConst;
		enReparacion = false;
		enConstruccion = false;
		reloj = 0;

	}

	public int getVida(){
		return vidaActual;
	}

    public boolean comoNuevo() {

		return (vidaActual == VIDA_MAXIMA);

	}

	public void recibirDanio(Integer unDanio) {

			this.vidaActual -= unDanio;

	}
	
	public void reparar() throws EdificioReparadoException, EdificioEnReparacionException {

      //Deberia ser edificioocupadoException, considerar el caso de construyendose
		if(this.comoNuevo()){
			throw new EdificioReparadoException();
		} if(this.enReparacion){

			throw new EdificioEnReparacionException("");
		}

			this.vidaActual += PORCENTAJE_REPARACION;
		System.out.println("porc " + PORCENTAJE_REPARACION);
		reloj = calcularTiempoReparacion();
		System.out.println("reloj " + reloj);
		if(reloj > 0){
			enReparacion = true;
		}
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

			if (reloj == 0) {
				enReparacion = false;
				return reloj;
			}
			if(vidaActual >= VIDA_MAXIMA){
				vidaActual = VIDA_MAXIMA;
				return 0;
			}
            this.vidaActual += PORCENTAJE_REPARACION;
            reloj = ((VIDA_MAXIMA - vidaActual)/PORCENTAJE_REPARACION)  ;

		}else
			if(enConstruccion){

				if (reloj == 0) {
					enConstruccion = false;
					return reloj;
				}
                reloj --;
		}

		return	reloj;
	}

	public boolean estaLibre() {
	    return reloj == 0;
    }

    public int calcularTiempoReparacion() {
        return ((VIDA_MAXIMA - vidaActual)/PORCENTAJE_REPARACION) + (1);
    }
}
/*estado puede estar reparando, construyendo o haciendo nada si esta reparando entonces hasta que no termine
;a vda del edifico  no termina si esta construyendo dura la cantidad de turnos
 */
