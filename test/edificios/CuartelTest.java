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
	public void posicionarCuartelOcupaElLugarQueDebeOcuparTest() throws Exception, EdificioEnConstruccionException {

		assertFalse(mapa.estaOcupado(3, 5));

		cuartel.construir(peon, 3, 5);
		cuartel.actualizar();
		cuartel.actualizar();
		cuartel.actualizar();
		cuartel.actualizar();
		assertTrue(mapa.estaOcupado(3, 5));
		assertTrue(mapa.estaOcupado(3, 6));
		assertTrue(mapa.estaOcupado(4, 5));
		assertTrue(mapa.estaOcupado(4, 6));

	}

}
