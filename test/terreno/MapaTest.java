package terreno;


import com.company.modelo.terreno.Mapa;
import edificios.PlazaCentral;
import org.junit.Before;
import org.junit.Test;
import unidades.Aldeano;

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
        Aldeano aldeano = new Aldeano();
        try {
            mapa.ubicar(aldeano, 10, 10);
        } catch (Exception e) {
            assertTrue( e.getMessage(),false);
        }
        assertTrue(mapa.estaOcupado(10, 10));
    }

    @Test
    public void colocarPosicionableNoOcupaOtroLugarTest() {
        Aldeano aldeano = new Aldeano();
        try {
            mapa.ubicar(aldeano, 10, 10);
        } catch (Exception e) {
            assertTrue( e.getMessage(),false);
        }
        assertFalse(mapa.estaOcupado(11, 10));
    }

    @Test
    public void colocarPosicionablePermiteRecuperarloTest() {
        PlazaCentral plazaCentral = new PlazaCentral();
        modelo.Posicionable unidadRecuperada = null;
        try {
            mapa.ubicar(plazaCentral, 10, 10);
            unidadRecuperada = mapa.conseguirOcupante(10, 10);
        } catch (Exception e) {
            assertTrue( e.getMessage(),false);
        }
        assertTrue("Se recupera la unidad puesta en el mapa",unidadRecuperada == plazaCentral);
    }




}
