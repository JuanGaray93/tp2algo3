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
    protected final Integer COSTO;
    protected final Integer PORCENTAJE_DE_REPARACION;

    public Edificio(Jugador jugador, Integer costo, Integer porcentajeDeReparacion){

        this.jugador = jugador;
        this.COSTO = costo;
        this.PORCENTAJE_DE_REPARACION = porcentajeDeReparacion;
	}
	
	public void recibirDanio(int unDanio) {
		estado.recibirDanio(unDanio);
	}
	
    public void construir(Aldeano quienLoConstruye, Integer posicionHorizontal, Integer posicionVertical)
                            throws CasilleroLlenoException{


        /*TODO: manejo de posiciones.*/
        jugador.cobrar(this.COSTO);
        estado.construir(quienLoConstruye);

    }

    public void crearUnidad(Unidad unidad) throws CasilleroLlenoException {
    	posiciones[1].posicionar(unidad);
    }
    
    public void reparar() throws EdificioReparadoException, EdificioEnReparacionException {
        this.estado.reparar(PORCENTAJE_DE_REPARACION);
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
     
    public void construirEn(){

    }
}
