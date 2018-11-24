import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.Assert.assertTrue;


public class PosicionTest {

    private Jugador jugador;

    @Mock
    private Mapa mapa;

    @Before
    public void inicializar() {
        jugador = new Jugador();
    }

    @Test
    public void posicionarUnidadIndicaAMapaQuePosicione() {

        Posicion posicion = new Posicion(3, 5);
        try {
            posicion.posicionar(new Aldeano(jugador));

            ArgumentCaptor<Mapa> capturador = ArgumentCaptor.forClass(Mapa.class);
            //Mockito.verify(mapa).colocarEnCasilleroLibreMasCercano(capturador.capture());
            // Ver cómo usar mockito verify con esto
            Logger logger = Logger.getLogger("");

            logger.info(capturador.getAllValues().toString());
        } catch (Exception e) {
            assertTrue(false);
        }

    }

}
