package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.*;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioInactivo extends EstadoEdificio { // TODO
    public EstadoEdificioInactivo(Integer vida, Integer monto) {
        super(vida, monto);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws EdificioOcupadoException, EdificioReparadoException, EdificioNoConstruidoException, EdificioDestruidoExcepcion, EdificioEnConstruccionException, EdificioEnReparacionException {
        EstadoEdificio nuevoEstado = new EstadoEdificioEnReparacion(VIDA_MAXIMA,MONTO_REPARACION);
        return nuevoEstado.reparar(reparador, montoDeReparacion);
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioTerminadoException {
        throw new EdificioTerminadoException("El edificio esta construido, no se pudo construir");
    }

    @Override
    public EstadoEdificio suspenderConstruccion(Aldeano quienLoConstruye) throws EdificioTerminadoException {
        throw new EdificioTerminadoException("No se puede suspender la reparacion, el edificio esta terminado.");
    }
}
