package test.unidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pruebasReparacion.Aldeano;
import pruebasReparacion.Junit;
import pruebasReparacion.PlazaCentral;

class RepararPlazaCentralTest {

	@Test
	void testRepararPlazaCentral() {
		Junit test = new Junit();
		PlazaCentral plaza_central = new PlazaCentral;
		Aldeano aldeano = new Aldeano();
		plaza_central.vida = 425;
		aldeano.reparar(plaza_central);
		assertEquals(plaza_central.vida, 450);
	}

}
