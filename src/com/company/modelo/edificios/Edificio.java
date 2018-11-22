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
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

import java.util.ArrayList;

public abstract class Edificio extends Posicionable {

    protected static Integer VIDA_MAXIMA;
    protected static Integer COSTO;
    protected static Integer MONTO_DE_REPARACION;
    protected static Integer BLOQUES_DE_ANCHO ;
    protected static Integer BLOQUES_DE_ALTO;
    protected static Integer vidaActual;

    protected ArrayList<Posicion> posiciones;
    protected EstadoEdificio estado;
    protected Jugador jugador;

    public Edificio(Jugador jugador){

        posiciones = new ArrayList<>();

        this.jugador = jugador;
	}

	@Override
	public void recibirDanio(Integer unDanio) throws Exception {
		estado = estado.recibirDanio(unDanio);
	}

    public void construir(Aldeano quienLoConstruye, Integer posicionHorizontal, Integer posicionVertical)
            throws EdificioEnConstruccionException, CasilleroNoExistenteException, CasilleroLlenoException, EdificioEnReparacionException, EdificioDestruidoExcepcion {

        /*TODO: manejo de posiciones.*/

        jugador.cobrar(this.COSTO);
        this.ubicar(posicionHorizontal, posicionVertical);
        estado = estado.construir(quienLoConstruye);
    }

    public void suspenderConstruccion(Aldeano quienLoConstruye) throws EdificioDestruidoExcepcion, EdificioNoConstruidoException {
        estado = estado.suspenderConstruccion(quienLoConstruye);
    }

    //@Override
    private void ubicar(Integer posicionHorizontal, Integer posicionVertical)
            throws CasilleroNoExistenteException, CasilleroLlenoException {

        for( int i = posicionHorizontal; i < ( posicionHorizontal + BLOQUES_DE_ANCHO ); i++)
            for (int j = posicionVertical; j < (posicionVertical + BLOQUES_DE_ALTO); j++) {
                Posicion posicion = new Posicion(i, j);
                posicion.posicionar(this);
                posiciones.add(posicion);
            }

    }

    public Integer getVida() {
        return this.vidaActual;
    }

    public void crearUnidad(Unidad unidad) throws CasilleroNoExistenteException, CasilleroLlenoException, MapaLlenoException {
        posiciones.get(0).colocarEnCasilleroLibreMasCercano(unidad);
        jugador.agregarAPoblacion(unidad);
    }
    
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
