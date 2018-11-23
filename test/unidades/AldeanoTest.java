package unidades;

import com.company.excepciones.AldeanoOcupadoException;
import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.DistanciaInvalidaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
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
	public void resetMapa() throws CasilleroLlenoException {
		mapa.destruir();
		mapa = Mapa.getMapa();

		jugador = new Jugador();
	}
/*
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
    public void verificarQueMientrasReparaNoSumaOroTest() throws Exception, DistanciaInvalidaException, EdificioEnConstruccionException {

        Aldeano aldeano = new Aldeano(jugador);
        PlazaCentral plaza = new PlazaCentral(jugador);
        aldeano.establecerCoordenadasDeNacimiento(5,4);
        mapa.ubicar(aldeano,5,4);

        aldeano.construir(plaza, 5, 5);
        plaza.recibirDanio(25);

        aldeano.reparar(plaza);
        try {
            aldeano.actualizar();
        } catch (AldeanoOcupadoException e) {
        }
        //no suma oro por estar reparando la plaza
        assertEquals(jugador.getOro(), (Integer) 0);

    }

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

	}

	@Test
	public void verificarQueAldeanoAunHeridoSumaOroTest() {

		Aldeano aldeano = new Aldeano(jugador);

		aldeano.recibirDanio(20);

		aldeano.actualizar();

		assertEquals(jugador.getOro(), (Integer) 120);

	}

	@Test
	public void construirCuartelYVerificarConstruccionTest()
            throws CasilleroNoExistenteException, CasilleroLlenoException {

		Aldeano aldeano = new Aldeano(jugador);

		aldeano.establecerCoordenadasDeNacimiento(5,5);

        mapa.ubicar(aldeano,5,5);

		Cuartel cuartel = new Cuartel(jugador);

        assertFalse(mapa.estaOcupado(5, 6));
		try {
			aldeano.construir(cuartel, 5, 5);

		} catch (Exception e) { }
		catch (DistanciaInvalidaException e) { }

		assertTrue(mapa.estaOcupado(5, 5));
	}

	@Test
	public void construirPlazaCentralTestYVerificarConstruccionTest() {

		Aldeano aldeano = new Aldeano(jugador);

        try {
            aldeano.establecerCoordenadasDeNacimiento(5,5);
        } catch (CasilleroNoExistenteException e) { }
          catch (CasilleroLlenoException e) { }

        PlazaCentral plazaCentral = new PlazaCentral(jugador);


		assertFalse(mapa.estaOcupado(5,6));

		try {
			aldeano.construir(plazaCentral, 5, 6);

		} catch (Exception e) {

		} catch (DistanciaInvalidaException e) {

        }
        assertTrue(mapa.estaOcupado(5,6));

	}*/
	/*
	@Test
	public void repararCastilloTest() throws Exception, EdificioEnConstruccionException {
		Castillo castillo = new Castillo(jugador);
		Aldeano aldeano = new Aldeano(jugador);

		aldeano.establecerCoordenadasDeNacimiento(5,5);
		mapa.ubicar(castillo,5,6);
		try {
			aldeano.construir(castillo,5,6);
		} catch (DistanciaInvalidaException ignored) { }

		try {
			castillo.recibirDanio(15);
		} catch (Exception e) { }

		try {
			aldeano.reparar(castillo);
		} catch (Exception e) {
			//
		}

		assertEquals((Integer) 1000, castillo.getVida());
	}
*/
	/*
	@Test
	public void repararPlazaCentralTest() throws Exception, EdificioEnConstruccionException {

		Aldeano aldeano = new Aldeano(jugador);

		PlazaCentral plazaCentral = new PlazaCentral(jugador);

		aldeano.establecerCoordenadasDeNacimiento(5,5);

        try {
            aldeano.construir(plazaCentral,5,5);
        } catch (DistanciaInvalidaException e) { }

        plazaCentral.recibirDanio(60);

		aldeano.reparar(plazaCentral);

		try {
			aldeano.actualizar();
		}catch(AldeanoOcupadoException e){}

		assertEquals((Integer)450,plazaCentral.getVida());
	}*/

	@Test
	public void repararCuartelTest() throws Exception, EdificioEnConstruccionException {

		Aldeano aldeano = new Aldeano(jugador);

		PlazaCentral plaza = new PlazaCentral(jugador);

		aldeano.establecerCoordenadasDeNacimiento(5,5);

        try {
            aldeano.construir(plaza,5,5);
        } catch (DistanciaInvalidaException e) { }

		System.out.println(plaza.getVida());

        plaza.actualizar();

		plaza.actualizar();

		plaza.actualizar();
		//System.out.println(plaza.getVida());

		/*plaza.recibirDanio(60);

		aldeano.reparar(plaza);

		try {
			aldeano.actualizar();
		}catch(AldeanoOcupadoException e){}

		assertEquals((Integer)250,plaza.getVida());*/

	}

}

