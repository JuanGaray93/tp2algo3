package edificios;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Espadachin;

import edificios.Before;

public class CastilloTest {
	
	Mapa mapa = Mapa.getMapa();
	Jugador jugador;
	
	@Before
	public void resetMapa() {
		mapa.destruir();
		mapa = Mapa.getMapa();
		
	}
	
	@Test
	void CastilloColocacionTest() {
		
		jugador  = new Jugador(mapa);
		Castillo castillo = new Castillo(jugador);

		try {
			castillo.construirEn(3, 5);
		}
		catch ( CasilleroNoExistenteException e){
			e.printStackTrace();
		}
		catch ( CasilleroLlenoException e) {
			e.printStackTrace();
		}

		assertTrue( mapa.estaOcupado(3, 5) );
		assertTrue( mapa.estaOcupado(3, 6) );
		assertTrue( mapa.estaOcupado(4, 5) );
		assertTrue( mapa.estaOcupado(4, 6) );
		assertTrue( mapa.estaOcupado(5, 6) );
		assertTrue( mapa.estaOcupado(5, 7) );
		assertTrue( mapa.estaOcupado(6, 7) );
		assertTrue( mapa.estaOcupado(6, 8) );
		assertTrue( mapa.estaOcupado(7, 8) );
		assertTrue( mapa.estaOcupado(7, 9) );
		assertTrue( mapa.estaOcupado(8, 9) );
		assertTrue( mapa.estaOcupado(8, 10) );
		assertTrue( mapa.estaOcupado(9, 10) );
		assertTrue( mapa.estaOcupado(9, 11) );
		assertTrue( mapa.estaOcupado(10, 11) );
		assertTrue( mapa.estaOcupado(11, 12) );
	}

	@Test
	void CastilloCrearMaquinaAsedioTest() {
		
		
		jugador  = new Jugador(mapa);
		Castillo castillo = new Castillo(jugador);
		
		castillo.construirEn(3, 5);
		MaquinaAsedio maquinaAsedio = new MaquinaAsedio(jugador)
		castillo.crear(maquinaAsedio);
		
		assertTrue(jugador.estaEnPoblacion(maquinaAsedio))
	}

}
