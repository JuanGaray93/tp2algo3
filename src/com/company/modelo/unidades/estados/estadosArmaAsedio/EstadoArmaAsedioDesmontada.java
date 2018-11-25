package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.*;

import com.company.modelo.Posicion;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoArmaAsedioDesmontada extends EstadoArmaAsedio {
    ArmaAsedio maquinaAsedio;

    public EstadoArmaAsedioDesmontada(ArmaAsedio armaAsedio) {
        super(armaAsedio);
        maquinaAsedio = armaAsedio;
        //super(maquinaAsedio);
        this.VIDA_MAXIMA = 150;
        this.vidaActual = 150;
        this.COSTO = 200;
    }

    public EstadoArmaAsedioDesmontada desmontar() throws ArmaDesmontadaException {
        throw new ArmaDesmontadaException("la maquina de asedio ya esta desmontada");
    }

    public EstadoArmaAsedio montar() {

        return new EstadoArmaAsedioMontada(maquinaAsedio);
    }

    public void moverA(Posicion posicion, Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException {

			posicion.moverA(posicionHorizontal, posicionVertical);

    }

    public void atacar(Edificio enemigo) throws ArmaDesmontadaException {
        throw new ArmaDesmontadaException("la maquina de asedio no puede atacar desmontada");

    }

    @Override
    public EstadoUnidad actualizar() {
        return this;
    }
}
