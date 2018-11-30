package unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Espadachin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EspadachinTest {

    Mapa mapa = Mapa.getMapa();

    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();

    }

    @Test
    public void testEspadachinMoverHorizontalmenteHaciaDelante() throws
            Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon, 5,5);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);

        assertTrue( mapa.estaOcupado(7, 5) );

        espadachin.moverA(8, 5);

        assertTrue( mapa.estaOcupado(8, 5) );
        assertFalse( mapa.estaOcupado(7, 5 ) );
    }

    @Test(expected = CasilleroLlenoException.class)
    public void testEspadachinMoverHorizontalmenteHaciaAtras() throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,0, 0);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);

        assertTrue( mapa.estaOcupado(2, 0) );

        espadachin.moverA(1, 0);

        assertFalse( mapa.estaOcupado(2, 0) );

    }

    @Test
    public void testEspadachinMoverVerticalmenteHaciaArriba() throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,2, 10);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);

        assertTrue( mapa.estaOcupado(4, 10) );

        espadachin.moverA(4, 11);

        assertTrue( mapa.estaOcupado(4, 11) );
        assertFalse( mapa.estaOcupado(4, 10) );
    }

    @Test
    public void testEspadachinMoverVerticalmenteHaciaAbajo() throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,20, 9);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);

        assertTrue( mapa.estaOcupado(22, 9) );

        espadachin.moverA(22, 8);

        assertTrue( mapa.estaOcupado(22, 8) );
        assertFalse( mapa.estaOcupado(22, 9) );
    }

    @Test(expected = CasilleroLlenoException.class)
    public void testEspadachinMoverEnDiagonalHaciaArribaALaIzquierda()
            throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,17, 17);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);
        assertTrue( mapa.estaOcupado(19, 17) );

        espadachin.moverA(18,18);
        assertTrue( mapa.estaOcupado(19, 17) );
    }

    @Test
    public void testEspadachinMoverEnDiagonalHaciaArribaALaDerecha() throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,32, 9);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);

        assertTrue( mapa.estaOcupado(34, 9) );

        espadachin.moverA(35, 10);

        assertTrue( mapa.estaOcupado(35,10) );
        assertFalse( mapa.estaOcupado(34, 9) );
    }

    @Test
    public void testEspadachinMoverEnDiagonalHaciaAbajoALaIzquierda() throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,3, 5);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);

        assertTrue( mapa.estaOcupado(5,5) );

        espadachin.moverA(4,4);

        assertTrue( mapa.estaOcupado(4,4) );
        assertFalse( mapa.estaOcupado(5,5) );
    }

    @Test
    public void testEspadachinMoverEnDiagonalHaciaAbajoALaDerecha()
            throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,2,2);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);

        assertTrue( mapa.estaOcupado(4,2) );

        espadachin.moverA(5,1);

        assertTrue( mapa.estaOcupado(5,1) );
        assertFalse( mapa.estaOcupado(4,2) );
    }

    @Test
    public void testEspadachinAtacarAUnEdificioCercanoEnemigo() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,2,2);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);

        otroCuartel.construir(otroPeon, 5, 2);
        otroCuartel.actualizar();
        otroCuartel.actualizar();

        espadachin.atacarA(otroCuartel);

        assertEquals( (Integer)235, otroCuartel.getVida() );

    }

    @Test
    public void testEspadachinAtacarAUnaUnidadCercanaEnemiga() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Espadachin espadachin = new Espadachin(jugador);
        Espadachin otroEspadachin = new Espadachin(otroJugador);

        cuartel.construir(peon,3, 5);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);

        otroCuartel.construir(otroPeon, 3, 3);
        otroCuartel.actualizar();
        otroCuartel.actualizar();

        otroCuartel.crearUnidad(otroEspadachin);
        otroEspadachin.moverA(5, 4);

        espadachin.atacarA(otroEspadachin);

        assertEquals( (Integer)75, otroEspadachin.getVida() );

    }

    @Test(expected = EnemigoInvalidoException.class)
    public void testEspadachinAtacarAVariasUnidadesAmigasFalla() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Espadachin espadachin = new Espadachin(jugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon,32, 9);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);
        cuartel.crearUnidad(arquero);
        mapa.ubicar(peon, 34, 10);

        espadachin.atacarA(arquero);
        espadachin.atacarA(peon);

        assertEquals( (Integer)50, peon.getVida() );
        assertEquals( (Integer)75, arquero.getVida() );

    }

    @Test
    public void testEspadachinAtacarADosPosicionablesEnemigos() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Espadachin espadachin = new Espadachin(jugador);
        Espadachin otroEspadachin = new Espadachin(otroJugador);

        cuartel.construir(peon,32, 9);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);
        espadachin.moverA(34, 8);

        otroCuartel.construir(otroPeon, 32, 7);
        otroCuartel.actualizar();
        otroCuartel.actualizar();

        otroCuartel.crearUnidad(otroEspadachin);

        espadachin.atacarA(otroEspadachin);
        espadachin.atacarA(otroCuartel);

        assertEquals( (Integer)75, otroEspadachin.getVida() );
        assertEquals( (Integer)235, otroCuartel.getVida() );
    }

    @Test(expected = EnemigoInvalidoException.class)
    public void testEspadachinAtacarAUnEdificioEnemigoFueraDeSuRangoDeAtaque() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,2, 10);
        cuartel.actualizar();
        cuartel.actualizar();

        cuartel.crearUnidad(espadachin);

        otroCuartel.construir(otroPeon, 0, 0);
        otroCuartel.actualizar();
        otroCuartel.actualizar();

        espadachin.atacarA(otroCuartel);

        assertEquals( (Integer)250, otroCuartel.getVida() );
    }

}
