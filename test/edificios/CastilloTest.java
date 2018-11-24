package edificios;

import org.junit.Assert;
import org.junit.Test;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.MaquinaAsedio;

import static org.junit.Assert.assertTrue;

public class CastilloTest {

	@Test
	public void crearCastilloOcupaElTerrenoQueDebeOcuparTest() throws CasilleroLlenoException {
		
		Castillo castillo = new Castillo(new Jugador());
		Mapa terreno = Mapa.getMapa();
		
		try {
			terreno.ubicar(castillo, 5, 5);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		//Ahora terreno esta ocupado en posicion cercana de castillo y en castillo
		//La posicion donde se crea la maquina de asedio es random en el castillo
		// TODO probar mas casos borde!

		/* El 1! representa el lugar donde se ubica el castillo. 0 = lugares vacios
		 *     _______________
		 * 5  |1!|1 |1 |1 |0 |
		 * 6  |1 |1 |1 |1 |0 |
		 * 7  |1 |1 |1 |1 |0 |
		 * 8  |1 |1 |1 |1 |0 |
		 * 9  |0_|0 |0_|0_|0_|
		 *      5  6  7  8  9
		 */


		assertTrue(terreno.estaOcupado(5,5));
		assertTrue(terreno.estaOcupado(5,6));
		assertTrue(terreno.estaOcupado(5,7));
		assertTrue(terreno.estaOcupado(5,8));

		assertTrue(terreno.estaOcupado(6,5));
		assertTrue(terreno.estaOcupado(6,6));
		assertTrue(terreno.estaOcupado(6,7));
		assertTrue(terreno.estaOcupado(6,8));

		assertTrue(terreno.estaOcupado(7,5));
		assertTrue(terreno.estaOcupado(7,6));
		assertTrue(terreno.estaOcupado(7,7));
		assertTrue(terreno.estaOcupado(7,8));

		assertTrue(terreno.estaOcupado(8,5));
		assertTrue(terreno.estaOcupado(8,6));
		assertTrue(terreno.estaOcupado(8,7));
		assertTrue(terreno.estaOcupado(8,8));
	}
}
