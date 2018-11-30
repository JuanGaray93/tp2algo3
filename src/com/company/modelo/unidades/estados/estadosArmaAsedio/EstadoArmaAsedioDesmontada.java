package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.ArmaDesmontadaException;
import com.company.modelo.Ataque;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoArmaAsedioDesmontada extends EstadoArmaAsedio {

    public EstadoArmaAsedioDesmontada(Integer vidaActual) {
        super(vidaActual);
    }

    public EstadoArmaAsedioDesmontada desmontar() throws ArmaDesmontadaException {
        throw new ArmaDesmontadaException("la maquina de asedio ya esta desmontada");
    }

    public EstadoArmaAsedio montar() {
        return new EstadoArmaAsedioMontada(VIDA_ACTUAL);
    }

    @Override
    public void atacar(Ataque unAtaque, Posicionable unEnemigo, Integer unDanio) throws ArmaDesmontadaException {
        throw new ArmaDesmontadaException("el arma no puede atacar desmontada");
    }

    @Override
    public EstadoUnidad actualizar() {
        return this;
    }
}
