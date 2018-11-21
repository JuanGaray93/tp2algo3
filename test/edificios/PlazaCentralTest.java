package edificios;

import com.company.excepciones.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.modelo.Jugador;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Espadachin;

public class PlazaCentralTest{

	private Mapa mapa;
	private Jugador jugador;

	@Before
	public void resetMapa() throws CasilleroLlenoException {
		mapa.destruir();
		mapa = Mapa.getMapa();
		jugador = new Jugador(mapa);
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
	public void plazaCentralCrearAldeanoTest() throws CasilleroNoExistenteException, CasilleroLlenoException{

		PlazaCentral central = new PlazaCentral(jugador);

		//Terreno no esta ocupado en este momento
		Assert.assertFalse(mapa.estaOcupado(16,22));
		try {
			mapa.ubicar(central, 5, 5);

		}catch(CasilleroLlenoException e) {

		}

		central.crearUnidad(new Aldeano(jugador));
		//Ahora terreno esta ocupado en posicion cercana de castillo y en castillo
		//La posicion donde se crea la maquina de asedio es random en el castillo
		// TODO probar mas casos borde!
		//Assert.assertTrue(terreno.estaOcupado(16,22));
		Assert.assertTrue(mapa.estaOcupado(15,21));
		Assert.assertTrue(mapa.estaOcupado(16,20));
	}

	@Test
	public void recibirDanioDeEspadachinYVerificarDanioTest() {
		Espadachin espadachin = new Espadachin(jugador);
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		Assert.assertTrue(plaza.comoNuevo());
		
		espadachin.atacar(plaza);
		
		Assert.assertFalse(plaza.comoNuevo());
	}

	@Test
	public void recibirDanioDeArqueroYVerificarDanioTest() {
		
		Mapa terreno = Mapa.getMapa();
		
		Arquero archer = new Arquero(jugador);
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		Assert.assertTrue(plaza.comoNuevo());
		
		archer.atacar(plaza);
		
		Assert.assertFalse(plaza.comoNuevo());
		
	}

	@Test
	public void recibirDanioDeArmaAsedioYVerificarDanioTest() {
		
		Mapa terreno = Mapa.getMapa();
		
		Arquero archer = new Arquero(jugador);
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		Assert.assertTrue(plaza.comoNuevo());
		
		archer.atacar(plaza);
		
		Assert.assertFalse(plaza.comoNuevo());
		
	}

	@Test
	public void verificarReparacionEnTiempoIndicadoTest() {
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		plaza.recibirDanio(50);

		try {
			plaza.reparar();
		} catch (EdificioReparadoException e) {
			e.printStackTrace();
		} catch (EdificioEnReparacionException e) {
			e.printStackTrace();
		}

		Assert.assertFalse(plaza.comoNuevo());
		
		plaza.actualizar();
		
		Assert.assertFalse(plaza.comoNuevo());
		
		plaza.actualizar();
		
		Assert.assertTrue(plaza.comoNuevo());
		
	}

	@Test
	public void verificarQueNoCreaAldeanosCuandoEstaEnReparacionTest() throws EdificioReparadoException, EdificioEnReparacionException {

		PlazaCentral plaza = new PlazaCentral(jugador);
		
		plaza.recibirDanio(50);
		
		plaza.reparar();
		
		Assert.assertFalse(plaza.comoNuevo());
		
		plaza.actualizar();
		
		Assert.assertFalse(plaza.comoNuevo());
		
		plaza.actualizar();
		
		Assert.assertTrue(plaza.comoNuevo());
		
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