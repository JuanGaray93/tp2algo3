package terreno;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.terreno.Mapa;
import edificios.PlazaCentral;
import org.junit.BeforeClass;
import org.junit.Test;
import unidades.Aldeano;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

public class MapaTest {

    @BeforeClass
    public static void resetMapa() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Mapa.class.getDeclaredField("instancia");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void colocarPosicionableOcupaElLugarTest() {
        Mapa mapa =  Mapa.getMapa();
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
        Mapa mapa =  Mapa.getMapa();
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
