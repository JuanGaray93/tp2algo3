package unidades;

import modelo.terreno.Mapa;
import modelo.unidades.Aldeano;

public class AldeanoTest {
	
	public void moverAldeano() {
			
		Mapa terreno = Mapa.getMapa();
		
		Aldeano aldeano = new Aldeano(5,6);
		
		aldeano.moverDerecha(terreno);
		
	}
    
	/*
    Pruebas de movimiento y dirección
    (1 casillero por turno en las 8 posibles direcciones,
    siempre y cuando no intenten ir más allá del terreno)
     */

    /*
    verificar construcción de cuartel y plaza central
    verificar que se haga en los turnos propios al jugador
    verificar que no suma oro
    */

    /*
    verificar reparación
    verificar que se finalizada la reparación, sume oro
     */
}
