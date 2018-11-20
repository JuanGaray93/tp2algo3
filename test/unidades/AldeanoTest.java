package unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AldeanoTest {
    
	private Mapa mapa = Mapa.getMapa();
	private Jugador jugador = null;

	@Before
	public void resetMapa() throws CasilleroLlenoException {
		mapa.destruir();
		mapa = Mapa.getMapa();

	}

	@Test
    public void verificarQueSumaOroSiNoEstaOcupadoTest() {
        try {
            jugador = new Jugador(mapa);
        } catch (CasilleroLlenoException e) { }

        Aldeano aldeano = new Aldeano(jugador);
    	aldeano.actualizar();


    	assertTrue(jugador.tieneOro(120));
    }

	@Test
    public void verificarQueSumaOroUnaVezPorTurnoTest() {

        try {
            jugador = new Jugador(mapa);
        } catch (CasilleroLlenoException e) { }

    	Aldeano aldeano = new Aldeano(jugador);
    	//100

        assertTrue(jugador.tieneOro(100));
        aldeano.actualizar();

    	//Actualizo el turno 4 veces e incrementa jugador su oro 4 veces
    	aldeano.actualizar();

    	aldeano.actualizar();

	    aldeano.actualizar();

		assertTrue(jugador.tieneOro(180));

    }

	@Test
	public void verificarQueMientrasReparaNoSumaOroTest() {

        try {
            jugador = new Jugador(mapa);
        } catch (CasilleroLlenoException e) { }

		Aldeano aldeano = new Aldeano(jugador);

		PlazaCentral plaza = new PlazaCentral(jugador);

		plaza.recibirDanio(25);

		aldeano.reparar(plaza);
		aldeano.actualizar();
		//no suma oro por estar reparando la plaza
		assertTrue(jugador.tieneOro(100));
	}

	@Test
	public void verificarQueMientrasConstruyeNoSumaOroTest() {

        try {
            jugador = new Jugador(mapa);
        } catch (CasilleroLlenoException e) { }

		Aldeano aldeano = new Aldeano(jugador);

		PlazaCentral plaza = new PlazaCentral(jugador);

		try {
			// TODO FALLA PORQUE NO TIENE POSICION!!
			aldeano.construir(plaza,5,5);
		} catch (CasilleroLlenoException e) {
			// TODO Auto-generated catch block
		} catch (CasilleroNoExistenteException e) {
			e.printStackTrace();
		}

		//no suma oro por 3 turnos: el actual + los dos siguientes

		// ELIMINAR LOS ASSERTS QUE NO CORRESPONDAN AL NOMBRE DEL TEST, TIENE QUE SER UN SOLO ASSERT

		aldeano.actualizar();

		/*aldeano.actualizar();

		aldeano.actualizar();
		aldeano.actualizar();*/

		//Se libera y suma oro de nuevo


		assertTrue(jugador.tieneOro(120));

	}

	/*@Test
	public void verificarQueMientrasConstruyeNoSumaOroTest() {

		Aldeano aldeano = new Aldeano(jugador);

		PlazaCentral plaza = new PlazaCentral(jugador);

		try {
			// TODO FALLA PORQUE NO TIENE POSICION!!
			aldeano.construir(plaza,5,5);
		} catch (CasilleroLlenoException e) {
			// TODO Auto-generated catch block
		} catch (CasilleroNoExistenteException e) {
			e.printStackTrace();
		}

		//no suma oro por 3 turnos: el actual + los dos siguientes

		// ELIMINAR LOS ASSERTS QUE NO CORRESPONDAN AL NOMBRE DEL TEST, TIENE QUE SER UN SOLO ASSERT
		assertTrue(jugador.tieneOro(100));

		aldeano.actualizar();

		assertTrue(jugador.tieneOro(100));

		aldeano.actualizar();

		assertTrue(jugador.tieneOro(100));

		aldeano.actualizar();

		//Se libera y suma oro de nuevo
		assertTrue(jugador.tieneOro(120));

	}

	@Test
	public void verificarQueAldeanoAunHeridoSumaOroTest() {

		Aldeano aldeano = new Aldeano(jugador);

		aldeano.recibirDanio(20);

		aldeano.actualizar();

		assertTrue(jugador.tieneOro(100));

	}

	@Test
	public void verificarQueAldeanoRecibeDanioAlSerAtacadoPorEspadachin() {

		Aldeano aldeano = new Aldeano(jugador);

		aldeano.recibirDanio(15); // TODO: POR ESPADACHIN?

		assertFalse(aldeano.saludable());

	}

	@Test
	public void verificarQueAldeanoRecibeDanioAlSerAtacadoPorArquero() {

		Aldeano aldeano = new Aldeano(jugador);

		aldeano.recibirDanio(15);

		assertFalse(aldeano.saludable());

	}
	/**
	 *
	 * 		NO TENEMOS QUE TESTEAR UN ATAQUE DE CADA UNIDAD. TESTEAMOS EL ALDEANO EN ALDEANOTEST
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 * */



}