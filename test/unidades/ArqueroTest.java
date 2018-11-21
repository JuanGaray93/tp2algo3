package unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Arquero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArqueroTest {

    Mapa mapa = Mapa.getMapa();

    Jugador jugador = new Jugador();
    Aldeano peon = new Aldeano(jugador);
    Arquero arquero = new Arquero(jugador);
    Cuartel cuartel = new Cuartel(jugador);

    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();

    }

    @Test
    public void testArqueroMoverHorizontalmenteHaciaDelante() throws
            Exception, EdificioEnConstruccionException {

        Cuartel cuartel = new Cuartel(jugador);

        cuartel.construir(peon, 5,5);

        cuartel.crearUnidad(arquero);

        assertTrue( mapa.estaOcupado(3, 7) );

        arquero.moverA(4, 7);

        assertTrue( mapa.estaOcupado(4, 7) );
    }

        @Test
    public void testArqueroMoverHorizontalmenteHaciaAtras() throws Exception, EdificioEnConstruccionException {

        cuartel.construir(peon,3, 5);

        cuartel.crearUnidad(arquero);

        assertTrue( mapa.estaOcupado(3, 7) );

        arquero.moverA(2, 7);

        assertTrue( mapa.estaOcupado(2, 7) );
        assertFalse( mapa.estaOcupado(3, 7) );

    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaArriba() throws Exception, EdificioEnConstruccionException {

        cuartel.construir(peon,3, 5);

        cuartel.crearUnidad(arquero);

        assertTrue( mapa.estaOcupado(3, 7) );

        arquero.moverA(3, 8);

        assertTrue( mapa.estaOcupado(3, 8) );
        assertFalse( mapa.estaOcupado(3, 7) );
    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaAbajo() throws Exception, EdificioEnConstruccionException {
        //TODO contemplar el caso de que se choca con el cuartel

        cuartel.construir(peon,3, 5);

		cuartel.crearUnidad(arquero);

		assertTrue( mapa.estaOcupado(3, 7) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaIzquierda()
            throws Exception, EdificioEnConstruccionException {

        cuartel.construir(peon,3, 5);

        Arquero arquero = new Arquero(jugador);
        cuartel.crearUnidad(arquero);
        assertTrue( mapa.estaOcupado(3, 7) );

        arquero.moverA(2, 8);
        assertTrue( mapa.estaOcupado(2, 8) );
        assertFalse( mapa.estaOcupado(3, 7) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaDerecha() throws Exception, EdificioEnConstruccionException {

        cuartel.construir(peon,3, 5);

        Arquero arquero = new Arquero(jugador);
        cuartel.crearUnidad(arquero);

        assertTrue( mapa.estaOcupado(3, 7) );

        arquero.moverA(4, 8);

        assertTrue( mapa.estaOcupado(4, 8) );
        assertFalse( mapa.estaOcupado(3, 7) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaIzquierda() throws Exception, EdificioEnConstruccionException {

        cuartel.construir(peon,3, 5);

        Arquero arquero = new Arquero(jugador);
        cuartel.crearUnidad(arquero);

        assertTrue( mapa.estaOcupado(3, 7) );

        arquero.moverA(2, 6);

        assertTrue( mapa.estaOcupado(2, 6) );
        assertFalse( mapa.estaOcupado(3, 7) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaDerecha()
            throws Exception, EdificioEnConstruccionException {
        //TODO contemplar el caso de que se choca con el cuartel

        cuartel.construir(peon,3, 5);

		cuartel.crearUnidad(arquero);

		assertTrue( mapa.estaOcupado(3, 7) );
    }

}
