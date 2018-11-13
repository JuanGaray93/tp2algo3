package test.mapa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pruebasUnidades.Aldeano;

class ColocarAldeanoTest {

	@Test
	void test() {
		Junit test = new Junit();
		Mapa mapa = new mapa(10, 12);
		Aldeano aldeano = new Aldeano();
		mapa.colocarUnidad(1, 2, aldeano)
		assertTrue(mapa.ocupado(1, 2))
	}

}
