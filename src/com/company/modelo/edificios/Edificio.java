package com.company.modelo.edificios;

import com.company.excepciones.*;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public abstract class Edificio implements Posicionable {

    protected final Integer VIDA_MAXIMA;
    protected final Integer COSTO;
    protected final Integer MONTO_DE_REPARACION;
    protected final Integer BLOQUES_DE_ANCHO;
    protected final Integer BLOQUES_DE_ALTO;

    protected Posicion[] posiciones;
    protected EstadoEdificio estado;
    protected Jugador jugador;

    public Edificio(Jugador jugador, Integer costo, Integer montoDeReparacion, Integer bloquesDeAncho, Integer bloquesDeAlto, Integer vidaMax){
        this.jugador = jugador;
        VIDA_MAXIMA = vidaMax;
        COSTO = costo;
        MONTO_DE_REPARACION = montoDeReparacion;
        BLOQUES_DE_ANCHO = bloquesDeAncho;
        BLOQUES_DE_ALTO = bloquesDeAlto;
	}

	@Override
	public void recibirDanio(Integer unDanio) throws Exception {
		estado = estado.recibirDanio(unDanio);
	}
	
    public void construir(Aldeano quienLoConstruye, Integer posicionHorizontal, Integer posicionVertical)
            throws Exception, OroInsuficienteException {

        /*TODO: manejo de posiciones.*/

        jugador.cobrar(this.COSTO);
        estado.construir(quienLoConstruye);
    }

    public void ubicar(){

    }

    public void crearUnidad(Unidad unidad) throws CasilleroNoExistenteException, CasilleroLlenoException {
    	posiciones[1].posicionar(unidad);
    }
    
    public void reparar(Aldeano reparador) throws Exception {
        this.estado.reparar(reparador, MONTO_DE_REPARACION);
    }

    public void eliminar() throws CasilleroNoExistenteException{
        for(Posicion posicion: posiciones){
            posicion.eliminar(this);
        }

        this.jugador.eliminarDeConstrucciones(this);
    }

    public abstract void actualizar();
}
