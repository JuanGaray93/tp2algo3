package edificios;

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

public class PlazaCentralTest {

    private Mapa mapa = Mapa.getMapa();
    private Jugador jugador = null;
    PlazaCentral central = null;
    Aldeano peon = null;


    @Before
    public void resetMapa() throws CasilleroLlenoException {
        mapa.destruir();
        mapa = Mapa.getMapa();
        jugador = new Jugador();
        central = new PlazaCentral(jugador);
        peon = new Aldeano(jugador);
    }

	@Test
	public void plazaCentralCrearAldeanoTest() throws CasilleroLlenoException, CasilleroNoExistenteException {

		//Terreno no esta ocupado en este momento
		assertFalse(mapa.estaOcupado(16,22));
		try {
			mapa.ubicar(central, 5, 5);

		}catch(CasilleroLlenoException e) {

		} catch (CasilleroNoExistenteException e) {
            //
        }

        central.crearUnidad(peon);
		/*//Ahora terreno esta ocupado en posicion cercana de castillo y en castillo
		//La posicion donde se crea la maquina de asedio es random en el castillo
		// TODO probar mas casos borde!
		//Assert.assertTrue(terreno.estaOcupado(16,22));
		assertTrue(mapa.estaOcupado(15,21));
		assertTrue(mapa.estaOcupado(16,20));*/
	}
/*
	@Test
	public void recibirDanioDeEspadachinYVerificarDanioTest() {
		Espadachin espadachin = new Espadachin(jugador);
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
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
		
	}*/

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