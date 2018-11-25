package com.company.modelo.edificios;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoEdificioInactivo;
import com.company.modelo.edificios.estados.EstadoPorConstruir;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

import java.util.ArrayList;

public class Castillo extends Edificio {


    public Castillo(Jugador jugador) {
        super(jugador);
        VIDA_MAXIMA = 1000;
        MONTO_DE_REPARACION = 15;
        COSTO = 0;
        BLOQUES_DE_ALTO = 4;
        BLOQUES_DE_ANCHO = 4;
        estado = new EstadoPorConstruir(VIDA_MAXIMA, MONTO_DE_REPARACION);
        //ataque = new Ataque(20,20);
        //this.estado = new EstadoEdificioInactivo(VIDA_MAXIMA,VIDA_MAXIMA,MONTO_DE_REPARACION);
    }

    @Override
    public void construir(Aldeano quienLoConstruye, Integer posicionHorizontal, Integer posicionVertical)
            throws EdificioEnConstruccionException, Exception {

        jugador.cobrar(this.COSTO);

        this.ubicar(posicionHorizontal, posicionVertical);

        estado = estado.construir(quienLoConstruye);

    }

    public void actualizar() throws Exception {
        estado = estado.ejecutarAccion();
    }

    public void atacar(Unidad enemigo) {
        // TODO
    }

    public void atacar(Edificio enemigo) {
        // TODO
    }

    /*
    public void ataque() throws PosicionableEsAliadoException {

        ArrayList<Posicionable> posicionablesCercanos = new ArrayList <>();
        for(Posicion posicion: this.posiciones) {
            posicionablesCercanos.addAll(posicion.buscarEnRadio(3));
        }
        for(Posicionable cercano: posicionablesCercanos) {
            if(this.verificarAlianza(cercano)) {
                throw new PosicionableEsAliadoException("la unidad que quiere atacar es propia");
            }
            else {
                //cambiar ATAQUE
                //ataque.atacar(cercano);
            }

        }

    }*/


}
