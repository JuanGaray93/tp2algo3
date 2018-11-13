package test.mapa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Test;

import pruebasUnidades.Aldeano;

class ColocarAldeanoTest {

	@Test
	void test() {
		Mapa mapa = Mapa.getMapa();
		Aldeano aldeano = new Aldeano();
		mapa.colocarUnidad(1, 2, aldeano)
		assertTrue(mapa.ocupado(1, 2))
	}

}
