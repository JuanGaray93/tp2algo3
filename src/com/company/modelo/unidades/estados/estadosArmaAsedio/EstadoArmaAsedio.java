package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Posicion;
import com.company.modelo.unidades.estados.EstadoUnidad;
import com.company.modelo.unidades.ArmaAsedio;

public abstract class EstadoArmaAsedio extends EstadoUnidad {

    ArmaAsedio maquinaAsedio;
    protected static Integer DISTANCIA_MAX_ATQ = 5;
    protected static Integer VIDA_MAXIMA;
    protected static Integer vidaActual;
    protected static Integer COSTO;

    public EstadoArmaAsedio(ArmaAsedio maquinaAsedio) {
        this.maquinaAsedio = maquinaAsedio;
    }

    public abstract EstadoArmaAsedioDesmontada desmontar() throws ArmaDesmontadaException;

    public abstract EstadoArmaAsedio montar() throws ArmaMontadaException;

    public abstract void moverA(Posicion posicion, Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException;
}
