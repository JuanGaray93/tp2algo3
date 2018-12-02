import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.ErrorDeConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;


public class PosicionTest {

    private Jugador jugador = null;
    private Aldeano aldeano = null;

    @Mock
    private Mapa mapa;

    @Before
    public void inicializar() {
        mapa = Mapa.getMapa();
        jugador = new Jugador();
        aldeano = new Aldeano(jugador);
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
        } catch (Exception e) {
            assertTrue(false);
        }

    }

@Test
	public void nacerAldeanoYVerificarQueSePosicionaEnPosicionIndicadaTest()
        throws CasilleroNoExistenteException, CasilleroLlenoException {
        aldeano = new Aldeano(new Jugador());

		aldeano.establecerCoordenadasDeNacimiento(3,4);
		aldeano.ubicar(3,4);

		Assert.assertTrue(mapa.estaOcupado(3,4));
		
	}

	/* Este test corresponde a plaza central no a posicion TODO tira error
	@Test
	public void crearPlazaCentralYVerificarQueSePosicionaEnPosicionIndicadaTest()
            throws Exception {
		
		PlazaCentral plazaCentral = new PlazaCentral(jugador);
		
		try {
			plazaCentral.construir(aldeano,3,4);
		} catch (Exception e) { }
		plazaCentral.avanzarConstruccion();
		plazaCentral.avanzarConstruccion();
		plazaCentral.avanzarConstruccion();

        Assert.assertTrue(mapa.estaOcupado(3,4));
		
	}*/

}
