package unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.EdificioDestruidoExcepcion;
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
    /*
    Jugador jugador = new Jugador();
    Aldeano peon = new Aldeano(jugador);
    Arquero arquero = new Arquero(jugador);
    Cuartel cuartel = new Cuartel(jugador);*/

    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();

    }

    @Test
    public void testArqueroMoverHorizontalmenteHaciaDelante() throws
            Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon, 5,5);

        cuartel.crearUnidad(arquero);

        assertTrue( mapa.estaOcupado(7, 5) );

        arquero.moverA(8, 5);

        assertTrue( mapa.estaOcupado(8, 5) );
        assertFalse( mapa.estaOcupado(7, 5 ) );
    }

    @Test(expected = CasilleroLlenoException.class)
    public void testArqueroMoverHorizontalmenteHaciaAtras() throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon,0, 0);

        cuartel.crearUnidad(arquero);

        assertTrue( mapa.estaOcupado(2, 0) );

        arquero.moverA(1, 0);

        assertFalse( mapa.estaOcupado(2, 0) );

    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaArriba() throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon,2, 10);

        cuartel.crearUnidad(arquero);

        assertTrue( mapa.estaOcupado(4, 10) );

        arquero.moverA(4, 11);

        assertTrue( mapa.estaOcupado(4, 11) );
        assertFalse( mapa.estaOcupado(4, 10) );
    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaAbajo() throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon,20, 9);

		cuartel.crearUnidad(arquero);

		assertTrue( mapa.estaOcupado(22, 9) );

        arquero.moverA(22, 8);

        assertTrue( mapa.estaOcupado(22, 8) );
        assertFalse( mapa.estaOcupado(22, 9) );
    }

    @Test(expected = CasilleroLlenoException.class)
    public void testArqueroMoverEnDiagonalHaciaArribaALaIzquierda()
            throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon,17, 17);

        cuartel.crearUnidad(arquero);
        assertTrue( mapa.estaOcupado(19, 17) );

        arquero.moverA(18,18);
        assertTrue( mapa.estaOcupado(19, 17) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaDerecha() throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon,32, 9);

        cuartel.crearUnidad(arquero);

        assertTrue( mapa.estaOcupado(34, 9) );

        arquero.moverA(35, 10);

        assertTrue( mapa.estaOcupado(35,10) );
        assertFalse( mapa.estaOcupado(34, 9) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaIzquierda() throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon,3, 5);

        cuartel.crearUnidad(arquero);

        assertTrue( mapa.estaOcupado(5,5) );

        arquero.moverA(4,4);

        assertTrue( mapa.estaOcupado(4,4) );
        assertFalse( mapa.estaOcupado(5,5) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaDerecha()
            throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon,2,2);

		cuartel.crearUnidad(arquero);

		assertTrue( mapa.estaOcupado(4,2) );

        arquero.moverA(5,1);

        assertTrue( mapa.estaOcupado(5,1) );
        assertFalse( mapa.estaOcupado(4,2) );
    }

}
