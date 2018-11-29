package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.modelo.Posicion;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public abstract class EstadoArmaAsedio extends EstadoUnidad {

    public EstadoArmaAsedio(Integer vidaActual) {
        super(vidaActual);
    }

    public abstract EstadoArmaAsedioDesmontada desmontar() throws ArmaDesmontadaException, ArmaDesmontadaException;

    public abstract EstadoArmaAsedio montar() throws ArmaMontadaException, ArmaMontadaException;

}
