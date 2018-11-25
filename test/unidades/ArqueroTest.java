package unidades;

import com.company.excepciones.ArmaMontadaException;
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
            Exception, EdificioEnConstruccionException, ArmaMontadaException {

        Cuartel cuartel = new Cuartel(jugador);

        cuartel.construir(peon, 3,5);
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crear(arquero);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(6, 6);

        assertTrue( mapa.estaOcupado(6, 6) );
    }

        @Test
    public void testArqueroMoverHorizontalmenteHaciaAtras() throws Exception, EdificioEnConstruccionException, ArmaMontadaException {

        cuartel.construir(peon,3, 5);
            cuartel.actualizar();
            cuartel.actualizar();
            cuartel.actualizar();
            cuartel.actualizar();

        cuartel.crear(arquero);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(6, 6);
        arquero.moverA(5, 6);

        assertTrue( mapa.estaOcupado(5, 6) );
        assertFalse( mapa.estaOcupado(6, 6) );

    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaArriba() throws Exception, EdificioEnConstruccionException, ArmaMontadaException {

        cuartel.construir(peon,3, 5);
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crear(arquero);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(5, 7);

        assertTrue( mapa.estaOcupado(5, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaAbajo() throws Exception, EdificioEnConstruccionException, ArmaMontadaException {

        cuartel.construir(peon,3, 5);
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();

		cuartel.crear(arquero);

		assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(5, 5);

        assertTrue( mapa.estaOcupado(5, 5) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaIzquierda()
            throws Exception, EdificioEnConstruccionException, ArmaMontadaException {

        cuartel.construir(peon,3, 5);
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();

        Arquero arquero = new Arquero(jugador);
        cuartel.crear(arquero);
        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(4, 7);
        assertTrue( mapa.estaOcupado(4, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaDerecha() throws Exception, EdificioEnConstruccionException, ArmaMontadaException {

        cuartel.construir(peon,3, 5);
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();

        Arquero arquero = new Arquero(jugador);
        cuartel.crear(arquero);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(5, 7);

        assertTrue( mapa.estaOcupado(5, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaIzquierda() throws Exception, EdificioEnConstruccionException, ArmaMontadaException {

        cuartel.construir(peon,3, 5);
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();

        Arquero arquero = new Arquero(jugador);
        cuartel.crear(arquero);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(6, 6);
        arquero.moverA(5, 5);

        assertTrue( mapa.estaOcupado(5, 5) );
        assertFalse( mapa.estaOcupado(6, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaDerecha()
            throws Exception, EdificioEnConstruccionException, ArmaMontadaException {

        cuartel.construir(peon,3, 5);
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();
        cuartel.actualizar();

		cuartel.crear(arquero);

		assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(6, 5);

        assertTrue( mapa.estaOcupado(6, 5) );
    }

}
