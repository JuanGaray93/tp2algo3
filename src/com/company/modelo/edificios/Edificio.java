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
import com.company.modelo.unidades.Unidad;

public abstract class Edificio implements Posicionable {

    protected int tamanio;
    protected EstadoEdificio estado;
    Jugador jugador;
    protected boolean construyendo;
    protected List<Posicion> posiciones = new ArrayList<>();
	private Mapa mapa;
	
	public Edificio(Jugador jugador){
		this.jugador = jugador;
	}
	
	public void recibirDanio(int unDanio) {
		estado.recibirDanio(unDanio);
	}

	public boolean libre() {
		return construyendo;
	}
	
    public void construirEn(int posicionHorizontal, int posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException {
        this.ubicar(posicionHorizontal, posicionVertical);
    }

    private void ubicar(int posicionHorizontal, int posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException {
        int lado = tamanio / 2;

        for( int i = posicionHorizontal; i < ( posicionHorizontal + lado ); i++){

            for( int j = posicionVertical; j < ( posicionVertical + lado ); j++){
                Posicion posicion = new Posicion(i, j);
                posicion.posicionarEdificio(this,mapa);
                posiciones.add(posicion);
            }

        }

    }

    public void crear(Unidad unidad) {
    	
    }
    
    public void reparar() throws EdificioReparadoException, EdificioEnReparacionException {
    	this.estado.reparar();
    }
    
	public boolean comoNuevo() {
		return this.estado.comoNuevo();
	}

    public void eliminar() throws CasilleroNoExistenteException {
        int longitud = posiciones.size();

        for (int i = longitud - 1; i >= 0; i--) {
            Posicion posicion = posiciones.remove(i);
            posicion.eliminar();
        }

    }
}
