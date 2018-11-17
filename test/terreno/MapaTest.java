package terreno;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.terreno.Mapa;
import edificios.PlazaCentral;
import org.junit.Before;
import org.junit.Test;
import unidades.Aldeano;

import static org.junit.Assert.assertTrue;

public class MapaTest {

    Mapa mapa = Mapa.getMapa();

    @Before
    @SuppressWarnings("annotated-static-method")
    public void resetMapa() {
        mapa.destruir();
    }

    @Test
    public void colocarPosicionableOcupaElLugarTest() {
        Aldeano aldeano = new Aldeano();
        try {
            mapa.ubicar(aldeano, 10, 10);
        } catch (CasilleroNoExistenteException e) {
            assertTrue("El casillero no existe",false);
        } catch (CasilleroLlenoException e){
            assertTrue("El casillero está lleno",false);
        }
        assertTrue(mapa.estaOcupado(10, 10));
    }

    @Test
    public void colocarPosicionablePermiteRecuperarlo() {
        PlazaCentral plazaCentral = new PlazaCentral();
        modelo.Posicionable unidadRecuperada = null;
        try {
            mapa.ubicar(plazaCentral, 10, 10);
            unidadRecuperada = mapa.conseguirOcupante(10, 10);
        } catch (CasilleroNoExistenteException e) {
            assertTrue("El casillero no existe",false);
        } catch (CasilleroLlenoException e){
            assertTrue("El casillero está lleno",false);
        }
        assertTrue("Se recupera la unidad puesta en el mapa",unidadRecuperada.getClass() == PlazaCentral.class);
    }




}
