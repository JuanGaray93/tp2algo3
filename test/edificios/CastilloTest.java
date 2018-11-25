package edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.ArmaAsedio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CastilloTest {
	
	Mapa mapa = Mapa.getMapa();
	Jugador jugador;
	
	@Before
	public void resetMapa() throws CasilleroLlenoException {
		mapa.destruir();
		mapa = Mapa.getMapa();
		jugador  = new Jugador();
	}
	
	@Test
	public void castilloColocacionTest() throws CasilleroLlenoException {
		
		jugador.sumarOro(1400);
		Castillo castillo = new Castillo(jugador);
		Aldeano aldeano = new Aldeano(jugador);

		try {
			castillo.construir(aldeano, 3, 5);
		}
		catch ( Exception e){
			e.printStackTrace();
		}

		assertTrue( mapa.estaOcupado(3, 5) );
		assertTrue( mapa.estaOcupado(3, 6) );
		assertTrue( mapa.estaOcupado(3, 7) );
		assertTrue( mapa.estaOcupado(3, 8) );
		assertTrue( mapa.estaOcupado(4, 5) );
		assertTrue( mapa.estaOcupado(4, 6) );
		assertTrue( mapa.estaOcupado(4, 7) );
		assertTrue( mapa.estaOcupado(4, 8) );
		assertTrue( mapa.estaOcupado(5, 5) );
		assertTrue( mapa.estaOcupado(5, 6) );
		assertTrue( mapa.estaOcupado(5, 7) );
		assertTrue( mapa.estaOcupado(5, 8) );
		assertTrue( mapa.estaOcupado(6, 5) );
		assertTrue( mapa.estaOcupado(6, 6) );
		assertTrue( mapa.estaOcupado(6, 7) );
		assertTrue( mapa.estaOcupado(6, 8) );

	}

	@Test
	public void castilloCrearMaquinaAsedioTest() throws Exception {
		
		jugador.sumarOro(1400);
		Castillo castillo = new Castillo(jugador);
		Aldeano aldeano = new Aldeano(jugador);
		castillo.construir(aldeano,3, 5);
		ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		castillo.actualizar();
		castillo.actualizar();
		castillo.actualizar();
		castillo.actualizar();
		castillo.crear(maquinaAsedio);
		

		assertTrue(jugador.estaEnPoblacion(maquinaAsedio));

	}

}
