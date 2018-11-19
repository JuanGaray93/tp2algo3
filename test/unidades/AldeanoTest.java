package unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.MaquinaAsedio;

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
		jugador = new Jugador(mapa);
	}

	@Test
    public void verificarQueSumaOroSiNoEstaOcupadoTest() {
    	Aldeano aldeano = new Aldeano(jugador);
    	aldeano.actualizar();
    	assertTrue(jugador.tieneOro(120));
    }

	@Test
    public void verificarQueSumaOroUnaVezPorTurnoTest() {

    	Aldeano aldeano = new Aldeano(jugador);
    	aldeano.actualizar();
    	//Actualizo el turno 4 veces e incrementa jugador su oro 4 veces
    	aldeano.actualizar();
    	aldeano.actualizar();
    	aldeano.actualizar();
    	aldeano.actualizar();
    	
    	assertTrue(jugador.tieneOro(200));
    }

	@Test
    public void verificarQueMientrasReparaNoSumaOroTest() {
    	
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
	@Test
    public void verificarQueAldeanoNORecibeDanioAlSerAtacadoPorArmaAsedio() {
    	
    	Aldeano aldeano = new Aldeano(jugador);
    	
    	assertTrue(aldeano.saludable());
    	
    	MaquinaAsedio armaAsedio = new MaquinaAsedio(jugador);
    	
    	armaAsedio.atacar(aldeano);
    	
    	assertTrue(aldeano.saludable());
    	
    }

	@Test
	public void construirCuartelYVerificarConstruccionTest() {
		
		Aldeano aldeano = new Aldeano(jugador);
		
		Posicion posicion = new Posicion( 5, 5);
		
		Cuartel cuartel = new Cuartel(jugador);
	
		try {

			/* FALLA PORQUE NO TIENE POSICION
			*
			* */
			aldeano.construir(cuartel,5,5);
		} catch (CasilleroLlenoException e) {
			// 
		} catch (CasilleroNoExistenteException e) {
			e.printStackTrace();
		}

		aldeano.actualizar();
		
		assertFalse(aldeano.estaLibre());
		
		assertFalse(posicion.contiene(cuartel));
		
		aldeano.actualizar();
		
		assertFalse(aldeano.estaLibre());
		
		assertFalse(posicion.contiene(cuartel));
		
		aldeano.actualizar();
		
		assertTrue(aldeano.estaLibre());
		
		assertTrue(posicion.contiene(cuartel));
	}

	@Test
	public void construirPlazaCentralTestYVerificarConstruccionTest() {

		Aldeano aldeano = new Aldeano(jugador);
		
		Posicion posicion = new Posicion( 5, 5);
		
		PlazaCentral plazaCentral = new PlazaCentral(jugador);
	
		try {
			aldeano.construir(plazaCentral,5,5);
		} catch (CasilleroLlenoException e) {
			//
		} catch (CasilleroNoExistenteException e) {
			e.printStackTrace();
		}

		aldeano.actualizar();
		
		assertFalse(aldeano.estaLibre());
		
		assertFalse(posicion.contiene(plazaCentral));
		
		aldeano.actualizar();
		
		assertFalse(aldeano.estaLibre());
		
		assertFalse(posicion.contiene(plazaCentral));
		
		aldeano.actualizar();
		
		assertTrue(aldeano.estaLibre());
		
		assertTrue(posicion.contiene(plazaCentral));
		
	}

	@Test
	public void repararCastilloTest() {
		Castillo castillo = new Castillo(jugador);
		Aldeano aldeano = new Aldeano(jugador);
		
		/*danio Total= 15, vida Castillo inicial = 1000
		recupera 15 de vida por turno*/
		
		castillo.recibirDanio(15);
		
		assertFalse(castillo.comoNuevo());
		
		assertTrue(aldeano.estaLibre());
		
		aldeano.reparar(castillo);
		
		castillo.actualizar(); // INNECESARIO
		aldeano.actualizar();
		
		assertTrue(aldeano.estaLibre());
		assertTrue(castillo.comoNuevo());
	}

	@Test
	public void repararCuartelTest() {
		
		Cuartel cuartel = new Cuartel(jugador);
		Aldeano aldeano = new Aldeano(jugador);
		
		/*danio Total= 15, vida Cuartel inicial = 75
		se cura con 50 de vida por turno*/
		
		cuartel.recibirDanio(15);
		
		assertFalse(cuartel.comoNuevo());
		
		assertTrue(aldeano.estaLibre());
		
		aldeano.reparar(cuartel);
		
		cuartel.actualizar();
		aldeano.actualizar();
		
		assertTrue(aldeano.estaLibre());
		assertTrue(cuartel.comoNuevo());
	}

	@Test
	public void repararPlazaCentralTest() {
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		Aldeano aldeano = new Aldeano(jugador);
		
		/*danio Total= 15, vida Plaza inicial = 450
		  se cura con +25  de vida por turno*/
		
		plaza.recibirDanio(15);
		
		assertFalse(plaza.comoNuevo());
		
		assertTrue(aldeano.estaLibre());
		
		aldeano.reparar(plaza);
		
		plaza.actualizar();
		aldeano.actualizar();
		
		assertTrue(aldeano.estaLibre());
		assertTrue(plaza.comoNuevo());
	}

}