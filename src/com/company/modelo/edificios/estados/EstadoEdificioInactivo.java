package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.*;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioInactivo extends EstadoEdificio {
    public EstadoEdificioInactivo(Integer vidaMaxima, Integer montoReparacion, Integer vidaAtual) {
        super(vidaMaxima, montoReparacion);
        this.VIDA_ACTUAL = vidaAtual;
    }

    @Override
    public EstadoEdificio ejecutarAccion() {
        return this;
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws EdificioOcupadoException, EdificioReparadoException, EdificioNoConstruidoException, EdificioDestruidoExcepcion, EdificioEnConstruccionException, EdificioEnReparacionException {
        EstadoEdificio nuevoEstado = new EstadoEdificioEnReparacion(this.VIDA_MAXIMA, this.MONTO_REPARACION, this.VIDA_ACTUAL);
        return nuevoEstado.reparar(reparador, montoDeReparacion);
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioTerminadoException {
        throw new EdificioTerminadoException("El edificio esta construido, no se pudo construir");
    }

    @Override
    public EstadoEdificio suspenderConstruccion() throws EdificioTerminadoException {
        throw new EdificioTerminadoException("No se puede suspender la reparacion, el edificio esta terminado.");
    }

    @Override
    public Integer getVidaActual() {
            return this.VIDA_ACTUAL;
    }
}
