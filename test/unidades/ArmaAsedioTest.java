package unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Espadachin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArmaAsedioTest {

    private Mapa mapa = Mapa.getMapa();
    private Jugador jugador;


    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();
        jugador = new Jugador();
    }

    @Test
    public void testAsedioMoverUnCasilleroALaDerecha() throws Exception, EdificioNoDisponibleException, ArmaMontadaException {

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
        maquinaAsedio.establecerCoordenadasDeNacimiento(7,6);
        mapa.ubicar(maquinaAsedio,7,6);

        //arma de asedio se posiciona en 7 6
        assertTrue( mapa.estaOcupado(7, 6) );

        maquinaAsedio.moverA(8, 6);


        assertTrue( mapa.estaOcupado(8, 6) );
        assertFalse( mapa.estaOcupado(7, 6) );

    }

    @Test
    public void testAsedioMoverHorizontalmenteHaciaAtras() throws Exception, EdificioNoDisponibleException, ArmaMontadaException {

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
        maquinaAsedio.establecerCoordenadasDeNacimiento(7,6);
        mapa.ubicar(maquinaAsedio,7,6);

        assertTrue( mapa.estaOcupado(7, 6) );

        maquinaAsedio.moverA(8, 6);
        maquinaAsedio.moverA(7, 6);

        assertTrue( mapa.estaOcupado(7, 6) );
        assertFalse( mapa.estaOcupado(8, 6) );

    }

    @Test
    public void testAsedioMoverVerticalmenteHaciaArriba() throws Exception, EdificioNoDisponibleException, ArmaMontadaException {

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
        maquinaAsedio.establecerCoordenadasDeNacimiento(7,6);
        mapa.ubicar(maquinaAsedio,7,6);

        assertTrue( mapa.estaOcupado(7, 6) );
        maquinaAsedio.moverA(7, 7);

        assertTrue( mapa.estaOcupado(7, 7) );
        assertFalse( mapa.estaOcupado(7, 6) );
    }

    @Test
    public void testAsedioMoverVerticalmenteHaciaAbajo() throws Exception, EdificioNoDisponibleException, ArmaMontadaException {

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
        maquinaAsedio.establecerCoordenadasDeNacimiento(7,6);
        mapa.ubicar(maquinaAsedio,7,6);

        assertTrue( mapa.estaOcupado(7, 6) );

        maquinaAsedio.moverA(7, 5);

        assertTrue( mapa.estaOcupado(7, 5) );
        assertFalse( mapa.estaOcupado(7, 6) );
    }

    @Test
    public void testAsedioMoverEnDiagonalHaciaArribaALaIzquierda() throws Exception, EdificioNoDisponibleException, ArmaMontadaException {

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
        maquinaAsedio.establecerCoordenadasDeNacimiento(7,6);
        mapa.ubicar(maquinaAsedio,7,6);
        assertTrue( mapa.estaOcupado(7, 6) );

        maquinaAsedio.moverA(8, 6);
        maquinaAsedio.moverA(7, 7);

        assertTrue( mapa.estaOcupado(7, 7) );
        assertFalse( mapa.estaOcupado(8, 6) );
    }

    @Test
    public void testAsedioMoverEnDiagonalHaciaArribaALaDerecha() throws Exception, EdificioNoDisponibleException, ArmaMontadaException {

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
        maquinaAsedio.establecerCoordenadasDeNacimiento(7,6);
        mapa.ubicar(maquinaAsedio,7,6);
        assertTrue( mapa.estaOcupado(7, 6) );

        maquinaAsedio.moverA(8, 7);

        assertTrue( mapa.estaOcupado(8, 7) );
        assertFalse( mapa.estaOcupado(7, 6) );
    }

    @Test
    public void testAsedioMoverEnDiagonalHaciaAbajoALaIzquierda() throws Exception, EdificioNoDisponibleException, ArmaMontadaException {

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
        maquinaAsedio.establecerCoordenadasDeNacimiento(7,6);
        mapa.ubicar(maquinaAsedio,7,6);

        assertTrue( mapa.estaOcupado(7, 6) );

        maquinaAsedio.moverA(8, 6);
        maquinaAsedio.moverA(7, 5);

        assertTrue( mapa.estaOcupado(7, 5) );
        assertFalse( mapa.estaOcupado(8, 6) );
    }

    @Test
    public void testAsedioMoverEnDiagonalHaciaAbajoALaDerecha() throws Exception, EdificioNoDisponibleException, ArmaMontadaException {

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
        maquinaAsedio.establecerCoordenadasDeNacimiento(7,6);
        mapa.ubicar(maquinaAsedio,7,6);
        assertTrue( mapa.estaOcupado(7, 6) );

        maquinaAsedio.moverA(8, 5);

        assertTrue( mapa.estaOcupado(8, 5) );
        assertFalse( mapa.estaOcupado(7, 6) );

    }

    @Test (expected = ArmaMontadaException.class)
    public void testAsedioMoverVerticalementeHaciaArribaMontada() throws Exception, EdificioNoDisponibleException, ArmaMontadaException {

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
        maquinaAsedio.establecerCoordenadasDeNacimiento(7,6);
        mapa.ubicar(maquinaAsedio,7,6);

        assertTrue( mapa.estaOcupado(7, 6) );
        maquinaAsedio.montar();
        maquinaAsedio.moverA(7, 7);

        assertFalse( mapa.estaOcupado(7, 7) );
        assertTrue( mapa.estaOcupado(7, 6) );


    }

    @Test (expected = MovimientoInvalidoException.class)
    public void testAsedioMoverHorizontalmenteHaciaLaIzquierdaAUnCasilleroOcupado() throws Exception, EdificioNoDisponibleException, ArmaMontadaException {

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
        ArmaAsedio maquinaAsedio2 = new ArmaAsedio(jugador);
        maquinaAsedio.establecerCoordenadasDeNacimiento(7,6);
        mapa.ubicar(maquinaAsedio,7,6);
        maquinaAsedio2.establecerCoordenadasDeNacimiento(6,6);
        mapa.ubicar(maquinaAsedio2,6,6);

        assertTrue( mapa.estaOcupado(7, 6) );
        maquinaAsedio.moverA(6, 6);

        assertFalse( mapa.estaOcupado(6, 6) );
        assertTrue( mapa.estaOcupado(7, 6) );

    }

    @Test
    public void testArmaAsedioAtacarAEdificiosEnemigosConDistanciaIgualACinco() throws Exception, EdificioDestruidoExcepcion, EdificioEnConstruccionException, ArmaMontadaException, ArmaDesmontadaException {

        Jugador jugador = new Jugador();
        ArmaAsedio asedio = new ArmaAsedio(jugador);
        Jugador jugadorEnemigo = new Jugador();
        Aldeano aldeanoEnemigo = new Aldeano(jugadorEnemigo);
        Castillo castilloEnemigo = new Castillo(jugadorEnemigo);
        Cuartel cuartelEnemigo =  new Cuartel(jugadorEnemigo);
        PlazaCentral plazaEnemiga = new PlazaCentral(jugadorEnemigo);

        asedio.establecerCoordenadasDeNacimiento(10 ,10);
        mapa.ubicar(asedio, 10, 10);
        asedio.montar();
        castilloEnemigo.surgir(15, 10);
        plazaEnemiga.surgir(4, 10);
        cuartelEnemigo.construir(aldeanoEnemigo, 10, 4);
        //cuartelEnemigo.actualizar();
        //cuartelEnemigo.actualizar();

        asedio.atacarA(castilloEnemigo);
        asedio.atacarA(plazaEnemiga);
        asedio.atacarA(cuartelEnemigo);

        assertEquals( (Integer)925, castilloEnemigo.getVida() );
        assertEquals( (Integer)175, cuartelEnemigo.getVida() );
        assertEquals( (Integer)375, plazaEnemiga.getVida() );

    }

    @Test(expected = EnemigoInvalidoException.class)
    public void testArmaAsedioAtacarUnidadesEnemigasEsInvalido() throws CasilleroNoExistenteException, CasilleroLlenoException, ArmaMontadaException, ArmaDesmontadaException, EnemigoInvalidoException, UnidadMuertaException {

        Jugador jugador = new Jugador();
        ArmaAsedio asedio = new ArmaAsedio(jugador);
        Jugador jugadorEnemigo = new Jugador();
        Aldeano aldeanoEnemigo = new Aldeano(jugadorEnemigo);
        Espadachin espadachinEnemigo = new Espadachin(jugadorEnemigo);
        Arquero arqueroEnemigo = new Arquero(jugadorEnemigo);

        asedio.establecerCoordenadasDeNacimiento(10 ,10);
        mapa.ubicar(asedio, 10, 10);
        asedio.montar();
        mapa.ubicar(aldeanoEnemigo, 9, 9);
        mapa.ubicar(espadachinEnemigo, 8, 8);
        mapa.ubicar(arqueroEnemigo, 11, 11);

        asedio.atacarA(aldeanoEnemigo);
        asedio.atacarA(espadachinEnemigo);
        asedio.atacarA(arqueroEnemigo);

        assertEquals( (Integer)50, aldeanoEnemigo.getVida() );
        assertEquals( (Integer)100, espadachinEnemigo.getVida() );
        assertEquals( (Integer)75, arqueroEnemigo.getVida() );
    }
}