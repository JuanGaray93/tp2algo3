package edificios;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import modelo.edificios.Cuartel;
import modelo.terreno.Mapa;

class CuartelCrearEspadachinTest {

	@Test
	void testCuartelCrearEspadachin() {
		Mapa terreno = Mapa.getMapa();
		Cuartel cuartel = new Cuartel(20,5);
		
		//Terreno no esta ocupado en este momento
		Assert.assertFalse(terreno.estaOcupado(20,5));
	
		terreno.ubicar(cuartel, 5, 5);
		
		cuartel.crearEspadachin(terreno);
		
		//Ahora terreno esta ocupado en posicion cercana de cuartel y en cuartel
		//La posicion donde se crea espadachin es random en el cuartel
		// TODO probar mas casos borde!
		Assert.assertTrue(terreno.estaOcupado(21,6));
		Assert.assertTrue(terreno.estaOcupado(21,4));
		Assert.assertTrue(terreno.estaOcupado(20,7));
		Assert.assertTrue(terreno.estaOcupado());
	}

}
