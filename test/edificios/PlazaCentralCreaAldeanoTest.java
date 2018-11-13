package test.edificios;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Test;

import pruebasUnidades.Junit;
import pruebasUnidades.PlazaCentral;

class PlazaCentralCreaAldeanoTest {

	@Test
	void testPlazaCentralCreaAldeano() {
		PlazaCentral plaza_central = new PlazaCentral(5,4);
		Aldeano aldeano = plaza_central.crearAldeano();
		Integer x = aldeano.posicionX;
		Integer y = aldeano.posicionY;
		
		assertTrue(mapa.estaOcupado(x,y));
	}

}
