package test.edificios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pruebasUnidades.Junit;
import pruebasUnidades.PlazaCentral;

class PlazaCentralCreaAldeanoTest {

	@Test
	void testPlazaCentralCreaAldeano() {
		
		Junit test = new Junit();
		PlazaCentral plaza_central = new PlazaCentral(5,4);
		Aldeano aldeano = plaza_central.crearAldeano();
		x = aldeano.posicionX
		y = aldeano.posicionY
		
		assertTrue(mapa.estaOcupado(x,y))
	}

}
