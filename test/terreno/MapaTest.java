package terreno;

import com.company.modelo.terreno.Casillero;
import com.company.modelo.terreno.Mapa;
import edificios.PlazaCentral;
import modelo.Posicionable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    void colocarAldeanoOcupaElLugarTest() {
        Aldeano aldeano = new Aldeano();
        aldeano.nacerEn(10, 10);
        assertTrue(mapa.estaOcupado(10, 10));
    }

    @Test
    void colocarPlazaCentralOcupaElEjeDeLaPlazaTest() {
        PlazaCentral plazaCentral = new PlazaCentral();
        plazaCentral.colocarEn(10, 10);
        // los segundos dos numeros los pense como la posicion desde donde se construye
        assertTrue(mapa.estaOcupado(10, 10));
    }




}
