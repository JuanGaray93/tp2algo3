package com.company.modelo.edificios;


import com.company.modelo.unidades.Aldeano;

public class EstadoPorConstruir extends EstadoEdificio {
    public EstadoPorConstruir(Integer vida, Integer montoDeReparacion) {
        super(vida, montoDeReparacion);
    }

    @Override
    public EstadoEdificio construir(Aldeano quienLoConstruye) {
        EstadoEdificio nuevoEstado = new EstadoEnConstruccion(vidaActual, MONTO_REPARACION);
        return nuevoEstado.construir(quienLoConstruye);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws Exception {
        throw new Exception("Intenta reparar edificio no construido");
    }
}
