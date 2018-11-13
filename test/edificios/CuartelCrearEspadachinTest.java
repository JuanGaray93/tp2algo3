package test.edificios;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

class CuartelCrearEspadachinTest {

	@Test
	void testCuartelCrearEspadachin() {
		Cuartel cuartel = new Cuartel(8,12);
		/*
		En el constructor de las unidades se llama el mapa
		y se inserta en la posicion dada la unidad
		 */
		Espadachin espadachin = cuartel.crearEspadachin();
		Integer x = espadachin.posicionX;
		Integer y = espadachin.posicionY;
		
		assertTrue(mapa.estaOcupado(x,y))
	}

}
