import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MovimientoInvalidoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class JugadorTest {

    private Mapa mapa = Mapa.getMapa();

    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();
    }

    @Test
    public void verificarQueAldeanoSoloSeMueveUnCasilleroPorTurnoTest()
            throws CasilleroLlenoException, CasilleroNoExistenteException,
            MovimientoInvalidoException {

        Jugador jugador = new Jugador();
        Aldeano aldeano = new Aldeano(jugador);

    	aldeano.establecerCoordenadasDeNacimiento(5,5);
    	aldeano.moverA(5,6);

    	aldeano.moverA(5,5);
    }

    @Test
    public void verificarQueLasSituacionesInicialesSeInicializaronCorrectamenteParaAmbosJugadoresTest() throws CasilleroNoExistenteException, CasilleroLlenoException {
        Jugador primerJugador = new Jugador();
        Jugador segundoJugador = new Jugador();

        primerJugador.crearEntidadesIniciales();
        segundoJugador.crearEntidadesIniciales();

        ArrayList<Edificio> edificiosPrimerJugador = primerJugador.getEdificios();
        ArrayList<Unidad> unidadesPrimerJugador = primerJugador.getPoblacion();
        ArrayList<Edificio> edificiosSegundoJugador = segundoJugador.getEdificios();
        ArrayList<Unidad> unidadesSegundoJugador = segundoJugador.getPoblacion();

        assertTrue( mapa.estaOcupado(5, 5) );
        assertTrue( mapa.estaOcupado(5, 10) );
        assertTrue( mapa.estaOcupado(4, 7) );
        assertTrue( mapa.estaOcupado(7, 3) );
        assertTrue( mapa.estaOcupado(8, 9) );

        assertTrue( mapa.estaOcupado(18, 18) );
        assertTrue( mapa.estaOcupado(18, 23) );
        assertTrue( mapa.estaOcupado(17, 20) );
        assertTrue( mapa.estaOcupado(20, 16) );
        assertTrue( mapa.estaOcupado(21, 22) );

        assertEquals( 3, unidadesPrimerJugador.size() );
        assertEquals( 2, edificiosPrimerJugador.size() );
        assertEquals( 100, (int)primerJugador.getOro() );

        assertEquals( 3, unidadesSegundoJugador.size() );
        assertEquals( 2, edificiosSegundoJugador.size() );
        assertEquals( 100, (int)segundoJugador.getOro() );
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
