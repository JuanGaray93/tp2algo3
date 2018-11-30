import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MovimientoInvalidoException;
import com.company.modelo.Jugador;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import org.junit.Before;
import org.junit.Test;

public class JugadorTest {

    private Mapa mapa = Mapa.getMapa();
    private Jugador jugador = null;
    Aldeano aldeano = null;

    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();
        jugador = new Jugador();
        aldeano = new Aldeano(jugador);
    }

    @Test
    public void verificarQueAldeanoSoloSeMueveUnCasilleroPorTurnoTest()
            throws CasilleroLlenoException, CasilleroNoExistenteException,
            MovimientoInvalidoException {
    	aldeano.establecerCoordenadasDeNacimiento(5,5);
    	aldeano.moverA(5,6);

    	aldeano.moverA(5,5);
    }

    @Test
    public void indicarPosicionAldeanoYVerificarQueSeMovioALaPosicionIndicadaTest() {
    	
    }

    @Test
    public void verificarQueAldeanoNoPuedeOcuparPosicionOcupadaPorEdificioTest() {
    	
    }

    @Test
    public void verificarQueAldeanoNoPuedeRepararEdificioEnReparacionTest() {
    	
    }

    @Test
    public void verificarQueAldeanoNoPuedeConstruirEdificioEnConstruccionTest() {
    	
    }

    @Test
    public void verificarQueAldeanoNoPuedeSalirDelMapaTest() {
    	
    }

    @Test
    public void verificarQueAldeanoSeConstruyeAlrededorDePlazaCentralTest() {
    	
    }
}
