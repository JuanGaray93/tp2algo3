package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.unidades.Aldeano;

public class Iniciador {

    private Jugador jugador;
    private static Integer cantidadDeJugadores = 0;

    public Iniciador(Jugador unJugador){
        this.jugador = unJugador;
        cantidadDeJugadores += 1;
    }

    public void crearEntidadesIniciales() throws CasilleroNoExistenteException, CasilleroLlenoException {
        Integer posicionInicialX = 0;
		Integer posicionInicialY = 0;

		if(cantidadDeJugadores == 1){
			posicionInicialX = 1;
			posicionInicialY = 1;
		} else {
			posicionInicialX = 80;
			posicionInicialY = 80;
		}

        Castillo castillo = new Castillo(this.jugador);
        PlazaCentral plaza = new PlazaCentral(this.jugador);

        castillo.surgir(posicionInicialX, posicionInicialY);
        plaza.surgir(posicionInicialX , (posicionInicialY + 8) );

        Aldeano miPrimerAldeano = new Aldeano(this.jugador);
        Aldeano miSegundoAldeano = new Aldeano(this.jugador);
        Aldeano miTercerAldeano = new Aldeano((this.jugador));

        miPrimerAldeano.establecerCoordenadasDeNacimiento( (posicionInicialX - 1), (posicionInicialY + 7) );
        miSegundoAldeano.establecerCoordenadasDeNacimiento( (posicionInicialX - 1), (posicionInicialY + 5) );
        miTercerAldeano.establecerCoordenadasDeNacimiento( (posicionInicialX - 1), (posicionInicialY + 2) );

        jugador.agregarAPoblacion(miPrimerAldeano);
        jugador.agregarAPoblacion(miSegundoAldeano);
        jugador.agregarAPoblacion(miTercerAldeano);
    }
}
