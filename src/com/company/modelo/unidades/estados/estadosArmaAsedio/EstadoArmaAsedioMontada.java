package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.ArmaMontadaException;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoArmaAsedioMontada extends EstadoArmaAsedio {

    public EstadoArmaAsedioMontada(Integer vidaActual) {
        super(vidaActual);

    }

    public EstadoArmaAsedioDesmontada desmontar() {
        return new EstadoArmaAsedioDesmontada(VIDA_ACTUAL);
    }

    public EstadoArmaAsedioMontada montar() throws ArmaMontadaException {
        throw new ArmaMontadaException("la maquina de asedio ya esta montada");
    }

    @Override
    public EstadoUnidad actualizar() {
        return this;
    }
}
