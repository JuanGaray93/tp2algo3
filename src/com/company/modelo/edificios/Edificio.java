package com.company.modelo.edificios;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoEdificio;
import com.company.modelo.edificios.estados.EstadoEdificioEnConstruccion;
import com.company.modelo.edificios.estados.EstadoEdificioInactivo;
import com.company.modelo.edificios.estados.EstadoPorConstruir;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Unidad;

import java.util.ArrayList;

public abstract class Edificio extends Posicionable {

    protected static Integer VIDA_MAXIMA;
    protected static Integer COSTO;
    protected static Integer MONTO_DE_REPARACION;
    protected static Integer BLOQUES_DE_ANCHO ;
    protected static Integer BLOQUES_DE_ALTO;

    protected ArrayList<Posicion> posiciones;
    protected EstadoEdificio estado;
    protected Jugador jugador;

    public Edificio(Jugador jugador){
        posiciones = new ArrayList<>();
        this.jugador = jugador;
        this.estado = new EstadoPorConstruir(VIDA_MAXIMA, MONTO_DE_REPARACION);
	}

	@Override
	public void recibirDanio(Integer unDanio) throws Exception {
		estado = estado.recibirDanio(unDanio);
	}

    public void construir(Aldeano quienLoConstruye, Integer posicionHorizontal, Integer posicionVertical)
            throws EdificioEnConstruccionException, CasilleroNoExistenteException, CasilleroLlenoException,
            EdificioEnReparacionException, EdificioDestruidoExcepcion, ErrorDeConstruccionException {
        jugador.cobrar(this.COSTO);
        this.ubicar(posicionHorizontal, posicionVertical);
        estado = estado.construir(quienLoConstruye);
        jugador.agregarAEdificios(this);
    }

    public void suspenderConstruccion() throws
            EdificioNoConstruidoException, EdificioDestruidoExcepcion {
        estado = estado.suspenderConstruccion();
    }

    private void ubicar(Integer posicionHorizontal, Integer posicionVertical)
            throws CasilleroNoExistenteException, CasilleroLlenoException {

        for( int i = posicionHorizontal; i < ( posicionHorizontal + BLOQUES_DE_ANCHO ); i++)
            for (int j = posicionVertical; j < (posicionVertical + BLOQUES_DE_ALTO); j++) {
                Posicion posicion = new Posicion(i, j);
                posicion.posicionar(this);
                posiciones.add(posicion);
            }

    }

    public Integer getVida() throws EdificioEnReparacionException, EdificioDestruidoExcepcion, EdificioEnConstruccionException, EdificioNoConstruidoException {
        return this.estado.getVidaActual();
    }

    public abstract void crearUnidad(Unidad unidad) throws CasilleroNoExistenteException, CasilleroLlenoException,
            MapaLlenoException, UnidadErroneaException, MovimientoInvalidoException, EdificioNoDisponibleException;

    public void reparar(Aldeano reparador)
            throws EdificioEnConstruccionException, EdificioDestruidoExcepcion, EdificioReparadoException,
            EdificioEnReparacionException, EdificioNoConstruidoException {
       this.estado = this.estado.reparar(reparador, MONTO_DE_REPARACION);
    }

    public void eliminar() {
        int longitud = posiciones.size();

        for (int i = longitud - 1; i >= 0; i--) {
            Posicion posicion = posiciones.remove(i);
            posicion.eliminar();
        }
    }

}
