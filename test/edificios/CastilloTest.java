package edificios;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.EdificioNoDisponibleException;
import org.junit.Test;
import org.junit.Before;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.ArmaAsedio;

import static org.junit.Assert.assertTrue;

public class CastilloTest {

	Mapa mapa = Mapa.getMapa();

	@Before
	public void resetMapa() {
		mapa.destruir();
		mapa = Mapa.getMapa();
	}

	@Test
	public void crearCastilloOcupaElmapaQueDebeOcuparTest() throws CasilleroLlenoException, CasilleroNoExistenteException {

		Jugador jugador = new Jugador();
		Castillo castillo = new Castillo(jugador);

		castillo.surgir(5, 5);

		
		//Ahora mapa esta ocupado en posicion cercana de castillo y en castillo
		//La posicion donde se crea la maquina de asedio es random en el castillo

		/* El 1! representa el lugar donde se ubica el castillo. 0 = lugares vacios
		 *     _______________
		 * 5  |1!|1 |1 |1 |0 |
		 * 6  |1 |1 |1 |1 |0 |
		 * 7  |1 |1 |1 |1 |0 |
		 * 8  |1 |1 |1 |1 |0 |
		 * 9  |0_|0 |0_|0_|0_|
		 *      5  6  7  8  9
		 */
		assertTrue(mapa.estaOcupado(5,5));
		assertTrue(mapa.estaOcupado(5,6));
		assertTrue(mapa.estaOcupado(5,7));
		assertTrue(mapa.estaOcupado(5,8));

		assertTrue(mapa.estaOcupado(6,5));
		assertTrue(mapa.estaOcupado(6,6));
		assertTrue(mapa.estaOcupado(6,7));
		assertTrue(mapa.estaOcupado(6,8));

		assertTrue(mapa.estaOcupado(7,5));
		assertTrue(mapa.estaOcupado(7,6));
		assertTrue(mapa.estaOcupado(7,7));
		assertTrue(mapa.estaOcupado(7,8));

		assertTrue(mapa.estaOcupado(8,5));
		assertTrue(mapa.estaOcupado(8,6));
		assertTrue(mapa.estaOcupado(8,7));
		assertTrue(mapa.estaOcupado(8,8));
	}

	@Test
	public void castilloCrearMaquinaAsedioTest() throws Exception, EdificioNoDisponibleException, EdificioEnConstruccionException {

		Jugador jugador = new Jugador();
		Castillo castillo = new Castillo(jugador);

		castillo.surgir(5, 5);

		ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);

		castillo.crearUnidad(maquinaAsedio);

		assertTrue( mapa.estaOcupado(9, 5) );

	}
}
