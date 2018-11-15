package edificios;

import org.junit.Assert;
import org.junit.Test;

import modelo.edificios.Castillo;
import modelo.terreno.Mapa;
import modelo.unidades.MaquinaAsedio;

class CastilloCrearMaquinaAsedioTest {

	@Test
	void testCastilloCrearMaquinaAsedio() {
		
		
		Castillo castillo = new Castillo(16,22);
		Mapa terreno = Mapa.getMapa();
		
		//Terreno no esta ocupado en este momento
		Assert.assertFalse(terreno.estaOcupado());
		
		terreno.ubicar(castillo, 5, 5);
		
		castillo.crearMaquinaAsedio(terreno);
		
		//Ahora terreno esta ocupado en posicion cercana de castillo y en castillo
		//La posicion donde se crea la maquina de asedio es random en el castillo
		// TODO probar mas casos borde!
		Assert.assertTrue(terreno.estaOcupado(16,22));
		Assert.assertTrue(terreno.estaOcupado(15,21));
		Assert.assertTrue(terreno.estaOcupado(16,20));
		Assert.assertTrue(terreno.estaOcupado());
	}

}
