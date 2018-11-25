package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;

import com.company.excepciones.MaquinaDesmontadaException;
import com.company.excepciones.MapaLlenoException;
import com.company.excepciones.MaquinaDesmontadaException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.ArmaAsedio;

public class EstadoMaquinaAsedioDesmontada extends EstadoArmaAsedio {
    ArmaAsedio maquinaAsedio;

    public EstadoMaquinaAsedioDesmontada(ArmaAsedio armaAsedio) {
        super(armaAsedio);
        maquinaAsedio = armaAsedio;
        //super(maquinaAsedio);
        this.VIDA_MAXIMA = 150;
        this.vidaActual = 150;
        this.COSTO = 200;
    }

    public EstadoMaquinaAsedioDesmontada desmontar() {
        try {
			throw new MaquinaDesmontadaException("la maquina de asedio ya esta desmontada");
		} catch (MaquinaDesmontadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    public EstadoArmaAsedio montar() {
        return new EstadoMaquinaAsedioMontada(maquinaAsedio);
    }

    public void moverA(Integer posicionHorizontal, Integer posicionVertical) throws MapaLlenoException {

        try {
			maquinaAsedio.moverA(posicionHorizontal, posicionVertical);
		} catch (CasilleroLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CasilleroNoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void atacar(Edificio enemigo) throws MaquinaDesmontadaException {
        throw new MaquinaDesmontadaException("la maquina de asedio no puede atacar desmontada");

    }
}
