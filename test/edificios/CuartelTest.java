package edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
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

	Jugador jugador  = new Jugador();
	Cuartel cuartel = new Cuartel(jugador);
	Aldeano peon = new Aldeano(jugador);

	@Before
	public void resetMapa() {
		mapa.destruir();
		mapa = Mapa.getMapa();

	}

	@Test
	public void testCuartelCrearArquero() throws Exception, EdificioEnConstruccionException {

		assertFalse( mapa.estaOcupado(3,5) );

		cuartel.construir(peon,3, 5);
		assertTrue( mapa.estaOcupado(3, 5) );
		assertTrue( mapa.estaOcupado(3, 6) );
		assertTrue( mapa.estaOcupado(4, 5) );
		assertTrue( mapa.estaOcupado(4, 6) );

		cuartel.crearUnidad(new Arquero(jugador));

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
    public void testCuartelCrearEspadachin() throws Exception, EdificioEnConstruccionException {

        assertFalse( mapa.estaOcupado(20,20) );

        cuartel.construir(peon,20, 20);

        assertTrue( mapa.estaOcupado(20, 20) );
		assertTrue( mapa.estaOcupado(20, 21) );
		assertTrue( mapa.estaOcupado(21, 20) );
		assertTrue( mapa.estaOcupado(21, 21) );

        cuartel.crearUnidad(new Espadachin(jugador));

        assertTrue( mapa.estaOcupado(21, 20) );
    }

}
