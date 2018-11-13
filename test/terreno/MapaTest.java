package terreno;

import com.company.modelo.terreno.Casillero;
import com.company.modelo.terreno.Mapa;
import edificios.PlazaCentral;
import modelo.Posicion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import unidades.Aldeano;

import static org.junit.Assert.assertTrue;

public class MapaTest {

    @Mock
    private Casillero casilleroLibre;

    @Before
    private void setup(){
        Mockito.when(casilleroLibre.estaLibre()).thenReturn(true);
    }

    @Test
    void colocarAldeanoTest() {
        Mapa mapa = Mapa.getMapa();
        Aldeano aldeano = new Aldeano();
        modelo.Posicion posicion = new Posicion();
        mapa.colocarUnidad(aldeano, posicion);
        assertTrue(mapa.estaOcupado(posicion));
    }

    @Test
    void colocarPlazaCentralTest() {
        Mapa mapa = new mapa(10, 12);
        PlazaCentral plaza_central = new PlazaCentral;
        mapa.colocarEdificio(2, 2, 3, 3 , plaza_central);
        // los segundos dos numeros los pense como la posicion desde donde se construye
        assertTrue(mapa.ocupado(1, 1))
        assertTrue(mapa.ocupado(1, 2))
        assertTrue(mapa.ocupado(2, 2))
        assertTrue(mapa.ocupado(2, 1))
    }




}
