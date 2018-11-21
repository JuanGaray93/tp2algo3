package com.company.modelo.edificios;

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
    protected Jugador jugador;
    protected Posicion[] posiciones;

    public Edificio(Jugador jugador){
		this.jugador = jugador;
	}
	
	public void recibirDanio(int unDanio) {
		estado.recibirDanio(unDanio);
	}

	public boolean estaLibre() {
		return estado.estaLibre();
	}
	
    public abstract void construir(Aldeano quienLoConstruye, Integer posicionHorizontal, Integer posicionVertical)
                            throws CasilleroLlenoException;

    public void crearUnidad(Unidad unidad) throws CasilleroLlenoException {
    	posiciones[1].posicionar(unidad);
    }
    
    public void reparar() throws EdificioReparadoException, EdificioEnReparacionException {

        this.estado.reparar();
    }
    
	public boolean comoNuevo() {
		return this.estado.comoNuevo();
	}

    public void eliminar() throws CasilleroNoExistenteException{
        for(Posicion posicion: posiciones){
            posicion.eliminar(this);
        }

        this.jugador.eliminarDeConstrucciones(this);
    }

    public void actualizar(){
        estado.actualizar();
     }

    public int calcularTiempoReparacion(){
        return this.estado.calcularTiempoReparacion();
    }
}
