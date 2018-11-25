package com.company.modelo.unidades.estados.estadosArmaAsedio;

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

    public abstract EstadoMaquinaAsedioDesmontada desmontar();

    public abstract EstadoArmaAsedio montar();
}
