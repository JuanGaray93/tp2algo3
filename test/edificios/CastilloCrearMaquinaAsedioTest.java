package test.edificios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CastilloCrearMaquinaAsedioTest {

	@Test
	void testCastilloCrearMaquinaAsedio() {
		
		Junit test = new Junit();
		Castillo castillo = new Castillo(16,22);
		MaquinaAsedio maquina_asedio = castillo.crearMaquinaAsedio();
		x = maquina_asedio.posicionX
		y = maquina_asedio.posicionY
		
		assertTrue(mapa.estaOcupado(x,y))
	}

}
