package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.estados.EstadoUnidad;
import com.company.modelo.unidades.estados.EstadoUnidadInactivo;

public abstract class Unidad extends Posicionable {


    protected static Integer VIDA_MAXIMA;
    protected static Integer COSTO;
    protected static Integer vidaActual;

    protected Posicion posicion;
    protected EstadoUnidad estado;

    public Unidad(Jugador jugador) {
        this.jugador = jugador;
        this.posicion = null;
        this.estado = new EstadoUnidadInactivo(VIDA_MAXIMA);
    }

    public void establecerCoordenadasDeNacimiento(Integer posicionHorizontal, Integer posicionVertical) {
        posicion = new Posicion(posicionHorizontal, posicionVertical);
    }

    public void moverA(Integer posicionHorizontal, Integer posicionVertical)
            throws CasilleroNoExistenteException, CasilleroLlenoException,
            ArmaMontadaException, MovimientoInvalidoException {

        posicion.moverA(posicionHorizontal, posicionVertical);
    }

    public void recibirDanio(Integer montoDeDanio) throws Exception, EdificioEnConstruccionException {
        try {
            estado.recibirDanio(montoDeDanio);
        } catch (Exception ignored) {
        }
    }

    private void eliminarDePosicion() {
        if (posicion != null) {
            posicion.quitarPosicionable();
        }
    }

    @Override
    public void ubicar(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException {
        posicion.posicionar(this);
    }

    public Integer getVida() throws UnidadMuertaException {
        return this.estado.getVidaActual();
    }

    public void actualizar() throws Exception {
        estado = estado.actualizar();
    }
}
