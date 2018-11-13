package test.edificios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CuartelCrearArqueroTest {

	@Test
	void testCuartelCrearArquero() {
		
		Junit test = new Junit();
		Cuartel cuartel = new Cuartel(20,5);
		Arquero arquero = cuartel.crearArquero();
		x = arquero.posicionX
		y = arquero.posicionY
		
		assertTrue(terreno.estaOcupado(x,y))
	}

}
