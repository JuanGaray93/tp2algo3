package edificios;

import org.junit.Assert;
import org.junit.Test;

import modelo.edificios.Castillo;
import modelo.edificios.Cuartel;
import modelo.terreno.Mapa;
import modelo.unidades.Arquero;

class CuartelCrearArqueroTest {

	@Test
	void testCuartelCrearArquero() {
		
		Mapa terreno = Mapa.getMapa();
		Cuartel cuartel = new Cuartel(20,5);
		
		//Terreno no esta ocupado en este momento
		Assert.assertFalse(terreno.estaOcupado(20,5));
	
		terreno.ubicar(cuartel, 5, 5);
		
		cuartel.crearArquero(terreno);
		
		//Ahora terreno esta ocupado en posicion cercana de cuartel y en cuartel
		//La posicion donde se crea espadachin es random en el cuartel
		// TODO probar mas casos borde!
		Assert.assertTrue(terreno.estaOcupado(21,6));
		Assert.assertTrue(terreno.estaOcupado(21,4));
		Assert.assertTrue(terreno.estaOcupado(20,7));
		Assert.assertTrue(terreno.estaOcupado());
	}

}
