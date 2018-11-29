package unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioNoDisponibleException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Arquero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArqueroTest {

    Mapa mapa = Mapa.getMapa();
    Jugador jugador = new Jugador();
    Arquero arquero = new Arquero(jugador);

    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();

    }

    @Test
    public void testArqueroMoverHorizontalmenteHaciaLaDerecha() throws
            Exception, EdificioEnConstruccionException, ArmaMontadaException, EdificioNoDisponibleException {

        arquero.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(arquero,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(6, 6);

        assertTrue( mapa.estaOcupado(6, 6) );
    }

    @Test
    public void testArqueroMoverHorizontalmenteHaciaLaIzquierda() throws Exception, EdificioEnConstruccionException, ArmaMontadaException, EdificioNoDisponibleException {

        arquero.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(arquero,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(6, 6);
        arquero.moverA(5, 6);

        assertTrue( mapa.estaOcupado(5, 6) );
        assertFalse( mapa.estaOcupado(6, 6) );

    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaArriba() throws Exception, EdificioEnConstruccionException, ArmaMontadaException, EdificioNoDisponibleException {

        arquero.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(arquero,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(5, 7);

        assertTrue( mapa.estaOcupado(5, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaAbajo() throws Exception, EdificioEnConstruccionException, ArmaMontadaException, EdificioNoDisponibleException {

        arquero.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(arquero,5,6);
        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(5, 5);

        assertTrue( mapa.estaOcupado(5, 5) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaIzquierda()
            throws Exception, EdificioEnConstruccionException, ArmaMontadaException, EdificioNoDisponibleException {

        arquero.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(arquero,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(4, 7);
        assertTrue( mapa.estaOcupado(4, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaDerecha() throws Exception, EdificioEnConstruccionException, ArmaMontadaException, EdificioNoDisponibleException {

        arquero.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(arquero,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(5, 7);

        assertTrue( mapa.estaOcupado(5, 7) );
        assertFalse( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaIzquierda() throws Exception, EdificioEnConstruccionException, ArmaMontadaException, EdificioNoDisponibleException {

        arquero.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(arquero,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(6, 6);
        arquero.moverA(5, 5);

        assertTrue( mapa.estaOcupado(5, 5) );
        assertFalse( mapa.estaOcupado(6, 6) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaDerecha()
            throws Exception, EdificioEnConstruccionException, ArmaMontadaException, EdificioNoDisponibleException {

        arquero.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(arquero,5,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(6, 5);

        assertTrue( mapa.estaOcupado(6, 5) );
    }

    @Test (expected = MovimientoInvalidoException.class)
    public void testArqueroHorizontalmenteALaIzquierdaACasilleroOcupado()
            throws Exception, EdificioEnConstruccionException, ArmaMontadaException, EdificioNoDisponibleException {

        arquero.establecerCoordenadasDeNacimiento(5,6);
        mapa.ubicar(arquero,5,6);

        Arquero arquero2 = new Arquero(jugador);
        arquero2.establecerCoordenadasDeNacimiento(4,6);
        mapa.ubicar(arquero2,4,6);

        assertTrue( mapa.estaOcupado(5, 6) );

        arquero.moverA(4, 6);

        assertTrue( mapa.estaOcupado(5, 6) );
    }

    @Test
    public void testArqueroAtacarAUnEdificioCercanoEnemigoConDistanciaIgualATres()
            throws Exception, EdificioNoDisponibleException, ArmaDesmontadaException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon, 2, 2);
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();

        cuartel.crear(arquero);

        otroCuartel.construir(otroPeon, 7, 2);
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();

        arquero.atacarA(otroCuartel);

        assertEquals((Integer) 240, otroCuartel.getVida());

    }

    @Test
    public void testArqueroAtacarAUnaUnidadCercanaEnemigaConDistanciaIgualADos()
            throws Exception, EdificioNoDisponibleException, ArmaDesmontadaException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Arquero arquero = new Arquero(jugador);
        Arquero otroArquero = new Arquero(otroJugador);

        cuartel.construir(peon, 3, 5);
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();

        cuartel.crear(arquero);

        otroCuartel.construir(otroPeon, 3, 3);
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();

        otroCuartel.crear(otroArquero);

        arquero.atacarA(otroArquero);

        assertEquals((Integer) 60, otroArquero.getVida());

    }

    @Test(expected = EnemigoInvalidoException.class)
    public void testArqueroAtacarAUnaUnidadAmigaConDistanciaIgualAUno()
            throws Exception, EdificioNoDisponibleException, ArmaDesmontadaException {

        Cuartel cuartel = new Cuartel(jugador);
        Aldeano peon = new Aldeano(jugador);

        cuartel.construir(peon, 32, 9);
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();

        cuartel.crear(arquero);

        arquero.atacarA(cuartel);

        assertEquals((Integer) 250, cuartel.getVida());
    }

    @Test
    public void testArqueroAtacarADosPosicionablesEnemigosConDistanciasDistintas() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException, EdificioNoDisponibleException, ArmaDesmontadaException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Arquero arquero = new Arquero(jugador);
        Arquero otroArquero = new Arquero(otroJugador);

        cuartel.construir(peon, 32, 9);
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();

        cuartel.crear(arquero);

        otroCuartel.construir(otroPeon, 32, 7);
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();

        otroCuartel.crear(otroArquero);

        arquero.atacarA(otroArquero);
        arquero.atacarA(otroCuartel);

        assertEquals((Integer) 60, otroArquero.getVida());
        assertEquals((Integer) 240, otroCuartel.getVida());
    }

    @Test(expected = EnemigoInvalidoException.class)
    public void testArqueroAtacarAUnEdificioEnemigoFueraDeSuRangoDeAtaque()
            throws Exception, EdificioNoDisponibleException, ArmaDesmontadaException {

        Jugador jugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Cuartel cuartel = new Cuartel(jugador);
        Cuartel otroCuartel = new Cuartel(otroJugador);
        Aldeano peon = new Aldeano(jugador);
        Aldeano otroPeon = new Aldeano(otroJugador);
        Arquero arquero = new Arquero(jugador);

        cuartel.construir(peon, 2, 10);
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();
        cuartel.avanzarConstruccion();

        cuartel.crear(arquero);

        otroCuartel.construir(otroPeon, 0, 0);
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();
        otroCuartel.avanzarConstruccion();

        arquero.atacarA(otroCuartel);

        assertEquals((Integer) 250, otroCuartel.getVida());
    }

}
