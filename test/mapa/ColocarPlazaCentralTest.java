package test.mapa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ColocarPlazaCentralTest {

	@Test
	void testColocarPlazaCentral() {
		Mapa mapa = new mapa(10, 12);
		PlazaCentral plaza_central = new PlazaCentral;
		mapa.colocarEdificio(2, 2, 3, 3 , plaza_central);
		// los segundos dos numeros los pense como la posicion desde donde se construye
		assertTrue(mapa.ocupado(1, 1))
		assertTrue(mapa.ocupado(1, 2))
		assertTrue(mapa.ocupado(2, 2))
		assertTrue(mapa.ocupado(2, 1))
	}

}
