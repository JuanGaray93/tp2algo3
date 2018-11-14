package edificios;

import org.junit.Assert;
import org.junit.Test;
import modelo.edificios.PlazaCentral;
import modelo.terreno.Mapa;

class PlazaCentralCreaAldeanoTest {

	@Test
	public void testPlazaCentraCrearAldeanoTest(){
		PlazaCentral central = new PlazaCentral(16,22);
		Mapa terreno = Mapa.getMapa();
		
		
		//Terreno no esta ocupado en este momento
		Assert.assertFalse(terreno.estaOcupado(16,22));
		
		terreno.ubicar(central, 5, 5);
		
		central.crearAldeano(terreno);
		//Ahora terreno esta ocupado en posicion cercana de castillo y en castillo
		//La posicion donde se crea la maquina de asedio es random en el castillo
		// TODO probar mas casos borde!
		Assert.assertTrue(terreno.estaOcupado(16,22));
		Assert.assertTrue(terreno.estaOcupado(15,21));
		Assert.assertTrue(terreno.estaOcupado(16,20));
		Assert.assertTrue(terreno.estaOcupado());
	}

}
