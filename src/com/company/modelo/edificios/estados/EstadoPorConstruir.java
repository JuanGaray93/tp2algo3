package com.company.modelo.edificios.estados;


import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.unidades.Aldeano;

public class EstadoPorConstruir extends EstadoEdificio {
    public EstadoPorConstruir(Integer vidaMax, Integer reparacion) {
        super(vidaMax,reparacion);
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioEnConstruccionException, Exception {
        EstadoEdificio nuevoEstado = new EstadoEdificioEnConstruccion(VIDA_MAXIMA,MONTO_REPARACION);
        return nuevoEstado.construir(quienLoConstruye);
    }

    @Override
    public EstadoEdificio suspenderConstruccion(Aldeano quienLoConstruye) throws Exception {
        return this;
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws Exception {
        throw new Exception("Intenta reparar edificio no construido");
    }
}
