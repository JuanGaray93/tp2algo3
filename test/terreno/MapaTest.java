package terreno;

import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Unidad;
import edificios.PlazaCentral;
import org.junit.Before;
import org.junit.Test;
import unidades.Aldeano;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

public class MapaTest {

    private Mapa mapa =  Mapa.getMapa();

    @Before
    public void resetMapa() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Mapa.class.getDeclaredField("instancia");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    void colocarUnidadOcupaElLugarTest() {
        Aldeano aldeano = new Aldeano();
        // El aldeano llama al singleton Mapa y se coloca en esa posicion
        Mapa.ubicar(aldeano, 10, 10);
        assertTrue(mapa.estaOcupado(10, 10));
    }

    @Test
    void colocarUnidadPermiteRecuperarla() {
        PlazaCentral plazaCentral = new PlazaCentral();
        plazaCentral.colocarEn(10, 10);
        Unidad unidadRecuperada = Mapa.conseguirOcupante(10, 10);
        assertTrue("Se recupera la unidad puesta en el mapa",unidadRecuperada.getClass() == PlazaCentral.class);
    }




}
