package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.MaquinaMontadaException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.ArmaAsedio;

public class EstadoMaquinaAsedioMontada extends EstadoArmaAsedio {

    public EstadoMaquinaAsedioMontada(ArmaAsedio armaAsedio) {
        super(armaAsedio);
        VIDA_MAXIMA = 150;
        vidaActual = 150;
        EstadoArmaAsedio.COSTO = 200;

    }

    public EstadoMaquinaAsedioDesmontada desmontar() {
        return new EstadoMaquinaAsedioDesmontada(maquinaAsedio);
    }

    public EstadoMaquinaAsedioMontada montar() {
        try {
			throw new MaquinaMontadaException("la maquina de asedio ya esta montada");
		} catch (MaquinaMontadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

    }

    public void moverA(Integer x, Integer y) throws MaquinaMontadaException {
        throw new MaquinaMontadaException("la maquina de asedio no se puede mover porque esta montada");
    }


    public void atacar(Edificio enemigo) throws Exception {
        //ataque.atacar(enemigo);
    }

}
