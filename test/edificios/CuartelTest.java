package edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Espadachin;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CuartelTest {

	Mapa mapa = Mapa.getMapa();
	Jugador jugador;
	
	@Before
	public void resetMapa() {
		mapa.destruir();
		mapa = Mapa.getMapa();
		
	}

	@Test
	public void testCuartelCrearArquero() throws CasilleroLlenoException {
		
		 jugador  = new Jugador(mapa);
		Cuartel cuartel = new Cuartel(jugador);

		Aldeano peon = new Aldeano(jugador);

		assertFalse( mapa.estaOcupado(3,5) );

		try {
			cuartel.construirEn(3, 5);
		} catch ( CasilleroLlenoException e) {
			e.printStackTrace();
		}

		assertTrue( mapa.estaOcupado(3, 5) );
		assertTrue( mapa.estaOcupado(3, 6) );
		assertTrue( mapa.estaOcupado(4, 5) );
		assertTrue( mapa.estaOcupado(4, 6) );

		cuartel.crear(new Arquero(jugador));

		assertTrue( mapa.estaOcupado(3, 7) );
		assertFalse( mapa.estaOcupado(4, 7) );
		assertFalse( mapa.estaOcupado(3, 4) );

		/*//Ahora terreno esta ocupado en posicion cercana de cuartel y en cuartel
		//La posicion donde se crea espadachin es random en el cuartel
		// TODO probar mas casos borde!
		Assert.assertTrue(terreno.estaOcupado(21,6));
		Assert.assertTrue(terreno.estaOcupado(21,4));
		Assert.assertTrue(terreno.estaOcupado(20,7));
		Assert.assertTrue(terreno.estaOcupado());*/
	}

    @Test
    public void testCuartelCrearEspadachin() throws CasilleroLlenoException{
    	
    	jugador  = new Jugador(mapa);
        Cuartel cuartel = new Cuartel(jugador);

		Aldeano peon = new Aldeano(jugador);

        assertFalse( mapa.estaOcupado(20,20) );

        try {
            cuartel.construirEn(20, 20);
        } catch ( CasilleroLlenoException e) {
            e.printStackTrace();
        }

        assertTrue( mapa.estaOcupado(20, 20) );
		assertTrue( mapa.estaOcupado(20, 21) );
		assertTrue( mapa.estaOcupado(21, 20) );
		assertTrue( mapa.estaOcupado(21, 21) );

        cuartel.crear(new Espadachin(jugador));

        assertTrue( mapa.estaOcupado(21, 20) );
    }

}
