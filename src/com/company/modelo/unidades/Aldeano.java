package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeano;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoRecolectandoOro;

import java.util.ArrayList;

public class Aldeano extends Unidad {

    private EstadoAldeano estadoActual;

    public Aldeano(Jugador jugador) {
        super(jugador);
        estadoActual = new EstadoAldeanoRecolectandoOro(jugador);
    }

    @Override
    public void moverA(Integer posicionHorizontal, Integer posicionVertical)
            throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {
        posicion.moverA(posicionHorizontal, posicionVertical);
        try {
            estadoActual.abandonarTareaActual();
        } catch (Exception ignored) {}
    }

    private boolean existentesEnRadio(Edificio e) {
        ArrayList<Posicionable> cercanos = this.posicion.buscarEnRadio(1);
        return cercanos.contains(e);
    }

    @Override
    public void recibirDanio(Integer montoDeDanio) throws Exception {
        try{
            estadoActual.recibirDanio(montoDeDanio);
        }catch(UnidadMuertaException e){
            posicion.quitarPosicionable();
            jugador.eliminarDePoblacion(this);

        }
    }


    public void construir(Edificio edificio, Integer x, Integer y)
            throws Exception, DistanciaInvalidaException {
        if (posicion.esDistanciaValida(x, y)) {

                estadoActual = estadoActual.construir(edificio, x, y);

                edificio.construir(this, x, y);

        } else {
            throw new DistanciaInvalidaException("No puedo construir a esa distancia");
        }

    }

    public void reparar(Edificio edificio) throws EdificioLejanoException {
        if (existentesEnRadio(edificio)) {

            try {

                edificio.reparar(this);
                estadoActual = estadoActual.reparar(edificio);

            } catch (Exception e) {
                //
            }

        } else {
            throw new EdificioLejanoException("Disculpe, esto esta muy lejos");
        }

    }

    public void liberar() throws Exception {
        estadoActual = new EstadoAldeanoRecolectandoOro(jugador);
        estadoActual.actualizar();
    }

    @Override
    public void actualizar() throws Exception {
     ;
        estadoActual = estadoActual.actualizar();

    }
}
