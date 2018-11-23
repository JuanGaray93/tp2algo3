package edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.DistanciaInvalidaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.MapaLlenoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlazaCentralTest{

	private Mapa mapa = Mapa.getMapa();
	private Jugador jugador;
	private Aldeano peon;
	PlazaCentral central;

	@Before
	public void resetMapa() {
		mapa.destruir();
		mapa = Mapa.getMapa();
		jugador = new Jugador();
		peon =  new Aldeano(jugador);
		central = new PlazaCentral(jugador);
	}


	/* ESTO DEBERIA SER UN TEST EN ALDEANO
	@Test
	public void puedeSerConstruida(){
		PlazaCentral central = new PlazaCentral(jugador);
		Aldeano aldea
		central.construir();
	}
	*/

	@Test
	public void plazaCentralCrearAldeanoTestYVerificarExistencia()
			throws CasilleroNoExistenteException,
			       CasilleroLlenoException {

		mapa.ubicar(peon,16,21);
		peon.establecerCoordenadasDeNacimiento(16,21);

		try {
			peon.construir(central,16,22);
		} catch (Exception | DistanciaInvalidaException ignored) {}

		/*   21  22  23
		*
		* 16  A  pc  pc
		*
		* 17     pc  pc
		*
		* */

		try {
			central.crear(new Aldeano(jugador));
		} catch (MapaLlenoException | EdificioEnConstruccionException
				| EdificioEnReparacionException ignored) {}

		assertTrue(mapa.estaOcupado(16,21));
		assertTrue(mapa.estaOcupado(16,23));
		assertTrue(mapa.estaOcupado(17,22));
	}

	@Test
	public void recibirDanioYVerificarDanioTest() throws Exception, DistanciaInvalidaException, EdificioEnConstruccionException {

		peon.establecerCoordenadasDeNacimiento(5,3);

		peon.construir(central,5,4);

		central.recibirDanio(15);

		assertEquals(central.getVida(), (Integer) 435);
	}

	@Test
	public void verificarReparacionEnTiempoIndicadoTest() throws Exception, EdificioEnConstruccionException {

		peon.establecerCoordenadasDeNacimiento(5,3);

		try {
			peon.construir(central,5,4);
		} catch (DistanciaInvalidaException ignored) { }

		central.recibirDanio(50);

		//verificar tiempo de reparacion cuando haga el merge con turnos

		assertEquals(central.getVida(),(Integer)400);
		
	}

	@Test
	public void verificarQueNoCreaAldeanosCuandoEstaEnReparacionTest()
			throws Exception, DistanciaInvalidaException, EdificioEnConstruccionException {

		peon.establecerCoordenadasDeNacimiento(5,5);

		peon.construir(central,5,6);

		central.recibirDanio(50);

		central.reparar(peon);

		try {
			central.crear(new Aldeano(jugador));
		} catch (EdificioEnConstruccionException ignored) { }

	}
	
	//por simplicidad dura un turno la creacion de aldeano, es decir queda disponible en el sig. turno
	/*

	COMENTO ESTE TEST PORQUE NO DEBERIA HABER UN GETTER DE SI ESTA LIBRE SINO UNA EXCEPTION DE EDIFICIOOCUPADO

	@Test
	public void verificarQueNoCreaAldeanoHastaTerminarActual() {
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		plaza.crearUnidad(new Aldeano(jugador));
		
		Assert.assertFalse(plaza.estaLibre());
		try {
			plaza.crearUnidad(new Aldeano(jugador));
		}catch(EdificioOcupadoException e) {
			//
		}
		
		plaza.actualizar();
		
		Assert.assertTrue(plaza.estaLibre());
		
		plaza.crearUnidad(new Aldeano(jugador));
		
	}*/
	
}