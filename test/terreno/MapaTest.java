package test.terreno;


import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapaTest {

    Mapa mapa = Mapa.getMapa();

    @Before
    public void resetMapa() {
        mapa.destruir();
    }

    @Test
    public void elMapaTieneCasillerosVaciosTest(){
        assertFalse(mapa.estaOcupado(10, 10));
    }

    @Test
    public void colocarPosicionableOcupaElLugarTest() {
        Aldeano aldeano = null;
		try {
			aldeano = new Aldeano(new Jugador(mapa));
		} catch (CasilleroLlenoException e1) {
			//
		}
        try {
            mapa.ubicar(aldeano, 10, 10);
        } catch (Exception e) {
            assertTrue( e.getMessage(),false);
        }
        assertTrue(mapa.estaOcupado(10, 10));
    }

    @Test
    public void colocarPosicionableNoOcupaOtroLugarTest() {
        Aldeano aldeano = null;
		try {
			aldeano = new Aldeano(new Jugador(mapa));
		} catch (CasilleroLlenoException e1) {
			// 
		}
        try {
            mapa.ubicar(aldeano, 10, 10);
        } catch (Exception e) {
            assertTrue( e.getMessage(),false);
        }
        assertFalse(mapa.estaOcupado(11, 10));
    }

    @Test
    public void colocarPosicionablePermiteRecuperarloTest() {
    	Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e1) {
			// 
		}
        PlazaCentral plazaCentral = new PlazaCentral(jugador);
       
       Posicionable unidadRecuperada = null;
        try {
            mapa.ubicar(plazaCentral, 10, 10);
            unidadRecuperada = mapa.conseguirOcupante(10, 10);
        } catch (Exception e) {
            assertTrue( e.getMessage(),false);
        }
        assertTrue("Se recupera la unidad puesta en el mapa",unidadRecuperada == plazaCentral);
    }




}