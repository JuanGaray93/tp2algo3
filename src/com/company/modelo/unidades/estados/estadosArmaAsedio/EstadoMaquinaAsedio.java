package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.MaquinaMontadaException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.Ataque;
import com.company.modelo.unidades.estados.EstadoUnidad;

public abstract class EstadoMaquinaAsedio extends EstadoUnidad {

    protected Boolean montada;
    ArmaAsedio maquinaAsedio;
    protected Ataque ataque;
    protected static Integer DISTANCIA_MAX_ATQ = 5;
    protected static Integer VIDA_MAXIMA;
    protected static Integer vidaActual;
    protected static Integer COSTO;

    public EstadoMaquinaAsedio(ArmaAsedio maquinaAsedio) {
        ataque = new Ataque(75, 0);
        this.maquinaAsedio = maquinaAsedio;
    }

    public abstract void moverA(Integer x, Integer y) throws MaquinaMontadaException;

    public abstract void atacar(Edificio enemigo) throws Exception;

    public boolean estaMontada() {
        return montada;
    }

}
