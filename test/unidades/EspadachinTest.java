package unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioNoDisponibleException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Espadachin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EspadachinTest {

    Mapa mapa = Mapa.getMapa();
    Jugador jugador = new Jugador();
    Espadachin espadachin = new Espadachin(jugador);

    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();

    }

    @Test
    public void testArqueroMoverHorizontalmenteHaciaLaIzquierda() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException, MovimientoInvalidoException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(6, 6);

        assertTrue( mapa.estaOcupado(6, 6) );
    }

    @Test
    public void testArqueroMoverHorizontalmenteHaciaLaDerecha() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException, MovimientoInvalidoException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(6, 6);
        espadachin.moverA(5, 6);

        assertTrue( mapa.estaOcupado(5, 6) );
        assertFalse( mapa.estaOcupado(6, 6) );

    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaArriba() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException, MovimientoInvalidoException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(5, 7);

        assertTrue( mapa.estaOcupado(5, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaAbajo() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException, MovimientoInvalidoException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);
        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(5, 5);

        assertTrue( mapa.estaOcupado(5, 5) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaIzquierda()
            throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException, MovimientoInvalidoException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(4, 7);
        assertTrue( mapa.estaOcupado(4, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaDerecha() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException, MovimientoInvalidoException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(5, 7);

        assertTrue( mapa.estaOcupado(5, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaIzquierda() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException, MovimientoInvalidoException {

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
            throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException, MovimientoInvalidoException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(6, 5);

        assertTrue( mapa.estaOcupado(6, 5) );
    }

    @Test (expected = MovimientoInvalidoException.class)
    public void testArqueroHorizontalmenteALaIzquierdaACasilleroOcupado()
            throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException, MovimientoInvalidoException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        Espadachin espadachin2 = new Espadachin(jugador);
        espadachin2.establecerCoordenadasDeNacimiento(4,6);
        mapa.ubicar(espadachin2,4,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        espadachin.moverA(4, 6);

        assertTrue( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testEspadachinAtacarAUnEdificioCercanoEnemigo() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException, com.company.excepciones.Edificio.EdificioNoDisponibleException, ArmaDesmontadaException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,2,2);

        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();

        cuartel.crear(espadachin);

        otroCuartel.construir(otroPeon, 5, 2);
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();


        espadachin.atacarA(otroCuartel);

        assertEquals( (Integer)235, otroCuartel.getVida() );

    }

    @Test
    public void testEspadachinAtacarAUnaUnidadCercanaEnemiga() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException, com.company.excepciones.Edificio.EdificioNoDisponibleException, ArmaMontadaException, ArmaDesmontadaException {

        espadachin.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(espadachin,5,6);

        Espadachin otroEspadachin = new Espadachin(jugador);
        otroEspadachin.establecerCoordenadasDeNacimiento(4,6);
        mapa.ubicar(otroEspadachin,4,6);

        espadachin.atacarA(otroEspadachin);

        //assertEquals( (Integer)75, otroEspadachin.getVida() );

    }

    @Test (expected = EnemigoInvalidoException.class)
    public void testEspadachinAtacarAUnaUnidadAmiga() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException, com.company.excepciones.Edificio.EdificioNoDisponibleException, ArmaDesmontadaException {

        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,32, 9);
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();

        cuartel.crear(espadachin);

        espadachin.atacarA(cuartel);

        assertEquals( (Integer)250, cuartel.getVida() );
    }

    @Test
    public void testEspadachinAtacarADosPosicionablesEnemigos() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException, EdificioNoDisponibleException, ArmaMontadaException, ArmaDesmontadaException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Espadachin espadachin = new Espadachin(jugador);
        Espadachin otroEspadachin = new Espadachin(otroJugador);

        cuartel.construir(peon,32, 9);
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();

        cuartel.crear(espadachin);
        espadachin.moverA(34, 8);

        otroCuartel.construir(otroPeon, 32, 7);
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();

        otroCuartel.crear(otroEspadachin);

        espadachin.atacarA(otroEspadachin);
        espadachin.atacarA(otroCuartel);

        assertEquals( (Integer)75, otroEspadachin.getVida() );
        assertEquals( (Integer)235, otroCuartel.getVida() );
    }

    @Test(expected = EnemigoInvalidoException.class)
    public void testEspadachinAtacarAUnEdificioEnemigoFueraDeSuRangoDeAtaque()
            throws Exception, com.company.excepciones.Edificio.EdificioNoDisponibleException, ArmaDesmontadaException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Espadachin espadachin = new Espadachin(jugador);

        cuartel.construir(peon,2, 10);
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();

        cuartel.crear(espadachin);

        otroCuartel.construir(otroPeon, 0, 0);
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();

        espadachin.atacarA(otroCuartel);

        assertEquals( (Integer)250, otroCuartel.getVida() );
    }
}
