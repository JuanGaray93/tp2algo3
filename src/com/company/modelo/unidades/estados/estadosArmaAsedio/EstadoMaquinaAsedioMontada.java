package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.MaquinaMontadaException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.ArmaAsedio;

public class EstadoMaquinaAsedioMontada extends EstadoMaquinaAsedio {

    public EstadoMaquinaAsedioMontada(ArmaAsedio armaAsedio) {
        super(armaAsedio);
        VIDA_MAXIMA = 150;
        vidaActual = 150;
        EstadoMaquinaAsedio.COSTO = 200;
        montada = true;

    }

    public EstadoMaquinaAsedioDesmontada desmontar() {
        return new EstadoMaquinaAsedioDesmontada(maquinaAsedio);
    }

    public void montar() throws MaquinaMontadaException {
        throw new MaquinaMontadaException("la maquina de asedio ya esta montada");

    }

    @Override
    public void moverA(Integer x, Integer y) throws MaquinaMontadaException {
        throw new MaquinaMontadaException("la maquina de asedio no se puede mover porque esta montada");
    }

    @Override
    public void atacar(Edificio enemigo) throws Exception {
        ataque.atacar(enemigo);
    }

}
