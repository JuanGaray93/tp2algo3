package test.unidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Test;

class MoverAldeanoTest {

	@Test
	void testMoverAldeano() {
		Aldeano aldeano = new Aldeano();
		Posicion posicion_inicial = aldeano.posicion();
		aldeano.moverNorte();
		//podria ser mover(x,y)
		Posicion posicion_final = aldeano.posicion();
		assertEquals(posicion_inicial.x, posicion_final.x);
		assertEquals(posicion_inicial.y + 1, posicion_final.y);
	}

}
