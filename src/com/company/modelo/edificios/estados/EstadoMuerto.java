package com.company.modelo.edificios.estados;

import com.company.modelo.unidades.Aldeano;

public class EstadoMuerto extends EstadoEdificio {
    public EstadoMuerto(Integer vida, Integer montoDeReparacion) {
        super(vida,montoDeReparacion);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws Exception {
        return null;
    }

    @Override
    public EstadoEnConstruccion construir(Aldeano quienLoConstruye) {
        return null;
    }
}
