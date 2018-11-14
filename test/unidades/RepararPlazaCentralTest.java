package unidades;

import org.junit.Assert;
import org.junit.Test;

import modelo.edificios.PlazaCentral;
import modelo.unidades.Aldeano;

class RepararPlazaCentralTest {

	@Test
	void testRepararPlazaCentral() {
		
		PlazaCentral plaza_central = new PlazaCentral(10,10);
		Aldeano aldeano = new Aldeano();
		
		plaza_central.reducirVida(25);
		
		Assert.assertEquals(plaza_central.getVida(),425);
		
		aldeano.reparar(plaza_central);
		Assert.assertEquals(plaza_central.getVida(), 450);
		Assert.assertNotEquals(plaza_central.getVida(), 425);
	}

}
