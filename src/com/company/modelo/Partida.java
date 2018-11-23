package com.company.modelo;

public class Partida {

	private Turno turno;
	private static Integer NUMERO_DE_JUGADORES = 2;


	public Partida(){
		turno = new Turno();
		for(Integer i = 0; i < NUMERO_DE_JUGADORES; i++){
			turno.sumarJugador(new Jugador());
		}
	}

	public void correr() throws Exception{
		Jugador jugadorCorriente = turno.obtenerJugadorCorriente();
		
		// jugadorCorriente.ejecutarAcciones();
		/*

		Acá podríamos recibir del controller un objeto acción - no sé bien cómo hacer.

		 */
		turno.pasar();
	}
}
