package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioTerminadoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioInactivo extends EstadoEdificio { // TODO
    public EstadoEdificioInactivo(Integer vida, Integer monto) {
        super(vida, monto);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws Exception {
        return null;
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioEnConstruccionException, EdificioTerminadoException {
        return null;
    }

    @Override
    public EstadoEdificio suspender(Aldeano quienLoConstruye) {
        return this;
    }
}
