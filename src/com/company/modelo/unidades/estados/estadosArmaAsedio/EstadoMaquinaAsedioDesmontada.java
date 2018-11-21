package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.MaquinaDesmontadaException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.ArmaAsedio;

public class EstadoMaquinaAsedioDesmontada extends EstadoMaquinaAsedio {

    public EstadoMaquinaAsedioDesmontada(ArmaAsedio maquinaAsedio) {
        super(maquinaAsedio);
        this.VIDA_MAXIMA = 150;
        this.vidaActual = 150;
        this.COSTO = 200;
        this.montada = false;
    }

    public void desmontar() throws MaquinaDesmontadaException {
        throw new MaquinaDesmontadaException("la maquina de asedio ya esta desmontada");
    }

    public EstadoMaquinaAsedioMontada montar() {
        return new EstadoMaquinaAsedioMontada(maquinaAsedio);
    }

    @Override
    public void moverA(Integer posicionHorizontal, Integer posicionVertical) {

        maquinaAsedio.moverA(posicionHorizontal, posicionVertical);
    }

    @Override
    public void atacar(Edificio enemigo) throws MaquinaDesmontadaException {
        throw new MaquinaDesmontadaException("la maquina de asedio no puede atacar desmontada");

    }
}
