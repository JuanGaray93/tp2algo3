package com.company.modelo.edificios;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoCastillo;
import com.company.modelo.unidades.Unidad;

public class Castillo extends Edificio {

    EstadoCastillo estado;

    public Castillo(Jugador jugador) {
        super(jugador);
        VIDA_MAXIMA = 1000;
        vidaActual = 1000;
        estado = new EstadoCastillo(VIDA_MAXIMA);
    }

    @Override
    public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

    }

    public void actualizar() {

    }

    @Override
    public Boolean verificarAlianza(Posicionable otroPosicionable) {
        return null;
    }

    @Override
    public Boolean verificarAlianza(Jugador otroJugador) {
        return null;
    }

	/*public void crearMaquinaAsedio() throws Exception {
		try {
			posiciones.get(1).ubicar(new MaquinaAsedio(this.jugador));
		} catch (CasilleroLlenoException e) {
			// 
		}
	}*/

    public void atacar(Unidad enemigo) {
        // TODO
    }

    public void atacar(Edificio enemigo) {
        // TODO
    }


}
