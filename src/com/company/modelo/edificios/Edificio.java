package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.EdificioEnReparacionException;
import com.company.excepciones.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public abstract class Edificio implements Posicionable {

    protected EstadoEdificio estado;


    protected Posicion posicion;

    public Edificio(Jugador jugador){
		this.jugador = jugador;
	}
	
	public void recibirDanio(int unDanio) {
		estado.recibirDanio(unDanio);
	}

	public boolean estaLibre() {
		return estado.estaLibre();
	}
	
    public void construir(Aldeano quienLoConstruye, int posicionHorizontal, int posicionVertical)
                            throws CasilleroLlenoException {
         estado.construir(quienLoConstruye);
         this.posicion = new Posicion(posicionHorizontal, posicionVertical);
         posicion.posicionar(this);


    }

    public int getTamanio(){
	    return estado.getTamanio();
    }

    public void crear(Unidad unidad) {
    	
    }
    
    public void reparar() throws EdificioReparadoException, EdificioEnReparacionException {

        this.estado.reparar();
    }
    
	public boolean comoNuevo() {
		return this.estado.comoNuevo();
	}

    public void eliminar() throws CasilleroNoExistenteException{
        posicion.eliminar(this);
        this.jugador.eliminarDeConstrucciones(this);
    }

    public int actualizar(){
        return this.estado.actualizar();
     }

    public int calcularTiempoReparacion(){
        return this.estado.calcularTiempoReparacion();
    }
}
