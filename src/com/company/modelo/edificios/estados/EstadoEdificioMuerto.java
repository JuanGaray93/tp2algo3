package com.company.modelo.edificios.estados;

import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioMuerto extends EstadoEdificio {
    public EstadoEdificioMuerto(Integer vida, Integer montoDeReparacion) {
        super(vida,montoDeReparacion);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws Exception {
        return null;
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) {
        return null;
    }
}
