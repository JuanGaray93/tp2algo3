package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.EnemigoInvalidoException;
import com.company.modelo.Ataque;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.Unidad;
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
    public void atacar(Ataque unAtaque, Posicionable unEnemigo, Integer unDanio) throws ArmaDesmontadaException, EnemigoInvalidoException {
        if(unEnemigo instanceof Unidad) {
            throw new EnemigoInvalidoException("El arma asedio no puede atacar unidades");
        }

        unAtaque.atacar(unEnemigo, unDanio);
    }

    @Override
    public EstadoUnidad actualizar() {
        return this;
    }
}
