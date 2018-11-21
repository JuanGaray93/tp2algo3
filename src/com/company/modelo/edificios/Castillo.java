package com.company.modelo.edificios;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioTerminadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoCastillo;
import com.company.modelo.edificios.estados.EstadoEdificio;
import com.company.modelo.edificios.estados.EstadoEnConstruccion;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Ataque;
import com.company.modelo.unidades.Unidad;

public class Castillo extends Edificio {

    private Ataque ataque;

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
        ataque.atacar(enemigo);
    }


}
