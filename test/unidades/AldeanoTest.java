package unidades;

import com.company.excepciones.AldeanoOcupadoException;
import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.DistanciaInvalidaException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoConstruyendo;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoRecolectandoOro;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoReparando;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AldeanoTest {

	private Mapa mapa = Mapa.getMapa();
	private Jugador jugador = null;

	@Before
	public void resetMapa() {
		mapa.destruir();
		mapa = Mapa.getMapa();
		jugador = new Jugador();
	}

	@Test
	public void verificarQueSumaOroSiNoEstaOcupadoTest() {

		Aldeano aldeano = new Aldeano(jugador);
		aldeano.actualizar();
		assertEquals(jugador.getOro(), (Integer) 120);
	}

	@Test
	public void verificarQueSumaOroUnaVezPorTurnoTest() {

		Aldeano aldeano = new Aldeano(jugador);

		aldeano.actualizar();

		//Actualizo el turno 4 veces e incrementa jugador su oro 4 veces
		aldeano.actualizar();

		aldeano.actualizar();

		aldeano.actualizar();

		assertEquals(jugador.getOro(), (Integer) 180);

	}

    @Test
    public void verificarQueMientrasReparaNoSumaOroTest() throws Exception, DistanciaInvalidaException {

        Aldeano aldeano = new Aldeano(jugador);
        PlazaCentral plaza = new PlazaCentral(jugador);
        aldeano.establecerCoordenadasDeNacimiento(5,4);
        mapa.ubicar(aldeano,5,4);

        aldeano.construir(plaza, 5, 5);
        plaza.recibirDanio(25);

        /*aldeano.reparar(plaza);
        try {
            aldeano.actualizar();
        } catch (AldeanoOcupadoException e) {
        }
        //no suma oro por estar reparando la plaza
        assertEquals(jugador.getOro(), (Integer) 0);*/

    }
/*
	@Test
	public void verificarQueMientrasConstruyeNoSumaOroTest() {

		Aldeano aldeano = new Aldeano(jugador);

        try {
            aldeano.establecerCoordenadasDeNacimiento(5,4);
        } catch (CasilleroNoExistenteException e) {

        } catch (CasilleroLlenoException e) {

        }

        PlazaCentral plaza = new PlazaCentral(jugador);
		try {

			aldeano.construir(plaza, 5, 5);

			//no suma oro por 3 turnos: el actual + los dos siguientes
			aldeano.actualizar();

		} catch (Exception e) {

		} catch (DistanciaInvalidaException e) {

        }

        try {

			aldeano.actualizar();

		} catch (AldeanoOcupadoException e) { }

		try {

			aldeano.actualizar();

		} catch (AldeanoOcupadoException e) {
		}

		try {

			aldeano.actualizar();

		} catch (AldeanoOcupadoException e) {
		}

		//Se libera y suma oro de nuevo
		assertEquals(jugador.getOro(), (Integer) 20);

	}*/

	@Test
	public void verificarQueAldeanoAunHeridoSumaOroTest() {

		Aldeano aldeano = new Aldeano(jugador);

		aldeano.recibirDanio(20);

		aldeano.actualizar();

		assertEquals(jugador.getOro(), (Integer) 120);

	}
/*
	@Test
	public void construirCuartelYVerificarConstruccionTest() {

		Aldeano aldeano = new Aldeano(jugador);

		Posicion posicion = new Posicion(5, 5);

		Cuartel cuartel = new Cuartel(jugador);

		assertFalse(posicion.estaOcupado(5, 5));
		try {
			aldeano.construir(cuartel, 5, 5);

			aldeano.actualizar();

			aldeano.actualizar();
			aldeano.actualizar();
		} catch (Exception e) {
			assertTrue(false);
		}

		try {

		} catch (AldeanoOcupadoException e) {
		}

		try {
			aldeano.actualizar();
		} catch (AldeanoOcupadoException e) {
		}

		assertTrue(posicion.estaOcupado(5, 5));
	}

	@Test
	public void construirPlazaCentralTestYVerificarConstruccionTest() {

		Aldeano aldeano = new Aldeano(jugador);

		Posicion posicion = new Posicion(5, 5);

		PlazaCentral plazaCentral = new PlazaCentral(jugador);

		assertFalse(posicion.estaOcupado(5, 5));

		try {
			aldeano.construir(plazaCentral, 5, 5);
			aldeano.actualizar();
			aldeano.actualizar();
			aldeano.actualizar();
			aldeano.actualizar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(posicion.estaOcupado(5, 5));

	}
*/
	@Test
	public void repararCastilloTest() throws Exception {
		Castillo castillo = new Castillo(jugador);
		Aldeano aldeano = new Aldeano(jugador);

		try {
			castillo.recibirDanio(15);
		} catch (Exception e) {
			//
		}

		try {
			aldeano.reparar(castillo);
		} catch (Exception e) {
			//
		}

		assertEquals((Integer) 1000, castillo.getVida());
	}
/*
	@Test
	public void repararPlazaCentralTest() throws Exception {

		Aldeano aldeano = new Aldeano(jugador);

		PlazaCentral plazaCentral = new PlazaCentral(jugador);

		aldeano.construir(plazaCentral,5,5);

		plazaCentral.recibirDanio(60);

		aldeano.reparar(plazaCentral);

		try {
			aldeano.actualizar();
		}catch(AldeanoOcupadoException e){}

		assertEquals((Integer)450,plazaCentral.getVida());
	}

	@Test
	public void repararCuartelTest() throws Exception {

		Aldeano aldeano = new Aldeano(jugador);

		Cuartel cuartel = new Cuartel(jugador);

		aldeano.construir(cuartel,5,5);


		cuartel.recibirDanio(60);

		aldeano.reparar(cuartel);

		try {
			aldeano.actualizar();
		}catch(AldeanoOcupadoException e){}

		assertEquals((Integer)250,cuartel.getVida());
	}
*/

}

