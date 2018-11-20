package com.company.modelo.edificios;


import java.util.ArrayList;
import java.util.List;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.EdificioEnReparacionException;
import com.company.excepciones.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public abstract class Edificio implements Posicionable {

    protected EstadoEdificio estado;
    Jugador jugador;

    protected boolean construyendo;
    protected Posicion posicion;
	private Mapa mapa;

    public Edificio(Jugador jugador){
		this.jugador = jugador;
	}
	
	public void recibirDanio(int unDanio) {
		estado.recibirDanio(unDanio);
	}

	public boolean libre() {
		return estado.estaLibre();
	}
	
    public void construirEn(int posicionHorizontal, int posicionVertical)
                            throws CasilleroLlenoException {
         estado.construir();
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
