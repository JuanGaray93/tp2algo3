package terreno;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.terreno.Casillero;
import org.junit.Test;
import unidades.Aldeano;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CasilleroTest {

    @Test
    public void casilleroRecienCreadoEstaVacioTest(){
        Casillero casillero = new Casillero();
        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void casilleroVacioPermiteInsercion(){
        Casillero casillero = new Casillero();
        Aldeano aldeano = new Aldeano();

        try {
            casillero.agregarPosicionable(aldeano);
        } catch (CasilleroLlenoException e) {
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    public void casilleroEstaLlenoLuegoDeInsercion(){
        Casillero casillero = new Casillero();
        Aldeano aldeano = new Aldeano();

        try {
            casillero.agregarPosicionable(aldeano);
        } catch (CasilleroLlenoException e) {
            assertTrue(false);
        }
        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void luegoDeQuitarPosicionableElCasilleroEstaVacioNuevamente(){
        Casillero casillero = new Casillero();
        Aldeano aldeano = new Aldeano();

        try {
            casillero.agregarPosicionable(aldeano);
        } catch (CasilleroLlenoException e) {
            assertTrue(false);
        }
        casillero.quitarPosicionable();
        assertFalse(casillero.estaOcupado());
    }

}
