package test.edificios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CuartelCrearEspadachinTest {

	@Test
	void testCuartelCrearEspadachin() {

		Junit test = new Junit();
		Cuartel cuartel = new Cuartel(8,12);
		Espadachin espadachin = cuartel.crearEspadachin();
		x = espadachin.posicionX
		y = espadachin.posicionY
		
		assertTrue(mapa.estaOcupado(x,y))
	}

}
