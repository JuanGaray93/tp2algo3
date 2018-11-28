package unidades;

import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.MovimientoInvalidoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Espadachin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EspadachinTest {
    Mapa mapa = Mapa.getMapa();

    Jugador jugador = new Jugador();
    Espadachin espadachin = new Espadachin(jugador);
    Cuartel cuartel = new Cuartel(jugador);

    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();

    }

    @Test
    public void testArqueroMoverHorizontalmenteHaciaDelante() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(6, 6);

        assertTrue( mapa.estaOcupado(6, 6) );
    }

    @Test
    public void testArqueroMoverHorizontalmenteHaciaAtras() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

       espadachin.moverA(6, 6);
       espadachin.moverA(5, 6);

        assertTrue( mapa.estaOcupado(5, 6) );
        assertFalse( mapa.estaOcupado(6, 6) );

    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaArriba() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(5, 7);

        assertTrue( mapa.estaOcupado(5, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaAbajo() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);
        assertTrue( mapa.estaOcupado(5, 6) );

       espadachin.moverA(5, 5);

        assertTrue( mapa.estaOcupado(5, 5) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaIzquierda()
            throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(4, 7);
        assertTrue( mapa.estaOcupado(4, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaDerecha() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(5, 7);

        assertTrue( mapa.estaOcupado(5, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaIzquierda() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(6, 6);
        espadachin.moverA(5, 5);

        assertTrue( mapa.estaOcupado(5, 5) );
        assertFalse( mapa.estaOcupado(6, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaDerecha()
            throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(6, 5);

        assertTrue( mapa.estaOcupado(6, 5) );
    }

    @Test (expected = MovimientoInvalidoException.class)
    public void testArqueroHorizontalmenteALaIzquierdaACasilleroOcupado()
            throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        Espadachin espadachin2 = new Espadachin(jugador);
        espadachin2.establecerCoordenadasDeNacimiento(4,6);
        mapa.ubicar(espadachin2,4,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(4, 6);

        assertTrue( mapa.estaOcupado(5, 6) );
    }
}
