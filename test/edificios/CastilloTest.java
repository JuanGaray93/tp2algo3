package edificios;

import org.junit.Assert;
import org.junit.Test;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.MaquinaAsedio;

public class CastilloTest {

	@Test
	void testCastilloCrearMaquinaAsedio() throws CasilleroLlenoException {
		
		Castillo castillo = new Castillo(new Jugador(Mapa.getMapa()));
		Mapa terreno = Mapa.getMapa();
		
		//Terreno no esta ocupado en este momento
		Assert.assertFalse(terreno.estaOcupado(1, 2));
		
		try {
			terreno.ubicar(castillo, 5, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
		try {
			castillo.crear(new MaquinaAsedio(new Jugador(Mapa.getMapa())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
		//Ahora terreno esta ocupado en posicion cercana de castillo y en castillo
		//La posicion donde se crea la maquina de asedio es random en el castillo
		// TODO probar mas casos borde!
		Assert.assertTrue(terreno.estaOcupado(16,22));
		Assert.assertTrue(terreno.estaOcupado(15,21));
		Assert.assertTrue(terreno.estaOcupado(16,20));
		Assert.assertTrue(terreno.estaOcupado(4,5));
	}
}
