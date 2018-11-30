package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.EnemigoInvalidoException;
import com.company.modelo.Ataque;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public abstract class EstadoArmaAsedio extends EstadoUnidad {

    public EstadoArmaAsedio(Integer vidaActual) {
        super(vidaActual);
    }

    public abstract EstadoArmaAsedioDesmontada desmontar() throws ArmaDesmontadaException, ArmaDesmontadaException;

    public abstract EstadoArmaAsedio montar() throws ArmaMontadaException, ArmaMontadaException;

    public abstract void atacar(Ataque unAtaque, Posicionable unEnemigo, Integer unDanio) throws ArmaDesmontadaException, EnemigoInvalidoException;

}
