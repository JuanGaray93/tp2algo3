package com.company.modelo.edificios.estados;


import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoPorConstruir extends EstadoEdificio {
    public EstadoPorConstruir(Integer vidaMax, Integer reparacion) {

        super(vidaMax,reparacion);
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioOcupadoException, EdificioEnConstruccionException, EdificioEnReparacionException, EdificioDestruidoExcepcion {
        EstadoEdificio nuevoEstado = new EstadoEdificioEnConstruccion(VIDA_MAXIMA,MONTO_REPARACION);
        return nuevoEstado.construir(quienLoConstruye);
    }

    @Override
    public EstadoEdificio suspenderConstruccion(Aldeano quienLoConstruye) {
        this.trabajadorActual = null;
        return this;
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws EdificioNoConstruidoException {
        throw new EdificioNoConstruidoException("Intenta reparar edificio no construido");
    }
}
