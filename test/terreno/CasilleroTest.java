package terreno;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Jugador;
import com.company.modelo.terreno.Casillero;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CasilleroTest {
	
	Mapa mapa = Mapa.getMapa();
	
    @Test
    public void casilleroRecienCreadoEstaVacioTest(){
        Casillero casillero = new Casillero();
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void casilleroVacioPermiteInsercionTest() throws CasilleroLlenoException {
        Casillero casillero = new Casillero();
        Aldeano aldeano = null;
        aldeano = new Aldeano(new Jugador());

        try {
            casillero.agregarPosicionable(aldeano);
        } catch (CasilleroLlenoException e) {
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    public void casilleroEstaLlenoLuegoDeInsercionTest() throws CasilleroLlenoException {
        Casillero casillero = new Casillero();
        Aldeano aldeano = null;
        aldeano = new Aldeano(new Jugador());

        try {
            casillero.agregarPosicionable(aldeano);
        } catch (CasilleroLlenoException e) {
            assertTrue(false);
        }
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void luegoDeQuitarPosicionableElCasilleroEstaVacioNuevamenteTest() throws CasilleroLlenoException {
        Casillero casillero = new Casillero();
        Aldeano aldeano = null;
        aldeano = new Aldeano(new Jugador());

        try {
            casillero.agregarPosicionable(aldeano);
        } catch (CasilleroLlenoException e) {
            assertTrue(false);
        }
        casillero.quitarPosicionable();
        assertFalse(casillero.estaOcupado());
    }

}
