package edificios;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.ArmaAsedio;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Espadachin;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class CastilloTest {

    Mapa mapa = Mapa.getMapa();

    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();
    }

    @Test
    public void testCastilloOcupaElmapaQueDebeOcuparCuandoSeLoCrea() throws CasilleroLlenoException, CasilleroNoExistenteException {

        Jugador jugador = new Jugador();
        Castillo castillo = new Castillo(jugador);

        castillo.surgir(5, 5);

        assertTrue(mapa.estaOcupado(5, 5));
        assertTrue(mapa.estaOcupado(5, 6));
        assertTrue(mapa.estaOcupado(5, 7));
        assertTrue(mapa.estaOcupado(5, 8));

        assertTrue(mapa.estaOcupado(6, 5));
        assertTrue(mapa.estaOcupado(6, 6));
        assertTrue(mapa.estaOcupado(6, 7));
        assertTrue(mapa.estaOcupado(6, 8));

        assertTrue(mapa.estaOcupado(7, 5));
        assertTrue(mapa.estaOcupado(7, 6));
        assertTrue(mapa.estaOcupado(7, 7));
        assertTrue(mapa.estaOcupado(7, 8));

        assertTrue(mapa.estaOcupado(8, 5));
        assertTrue(mapa.estaOcupado(8, 6));
        assertTrue(mapa.estaOcupado(8, 7));
        assertTrue(mapa.estaOcupado(8, 8));
    }

    @Test
    public void testCastilloCrearMaquinaAsedio() throws Exception{

        Jugador jugador = new Jugador();
        Castillo castillo = new Castillo(jugador);

        castillo.surgir(5, 5);

        ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);

        castillo.crear(maquinaAsedio);

        assertTrue(mapa.estaOcupado(9, 5));

    }

    @Test
    public void testCastilloAtacarAUnidadesEnemigasConDistanciaIgualATres() throws CasilleroNoExistenteException, CasilleroLlenoException, UnidadMuertaException, EnemigoInvalidoException {

        Jugador jugador = new Jugador();
        Jugador jugadorEnemigo = new Jugador();
        Castillo castillo = new Castillo(jugador);
        Aldeano aldeanoEnemigo = new Aldeano(jugadorEnemigo);
        Espadachin espadachinEnemigo = new Espadachin(jugadorEnemigo);
        Arquero arqueroEnemigo = new Arquero(jugadorEnemigo);

        castillo.surgir(8, 10);

        mapa.ubicar(aldeanoEnemigo, 5, 10);
        mapa.ubicar(espadachinEnemigo, 18, 14);
        mapa.ubicar(arqueroEnemigo, 12, 7);

        castillo.atacarA(aldeanoEnemigo);
        castillo.atacarA(espadachinEnemigo);
        castillo.atacarA(arqueroEnemigo);

        assertEquals((Integer) 30, aldeanoEnemigo.getVida());
        assertEquals((Integer) 80, espadachinEnemigo.getVida());
        assertEquals((Integer) 55, arqueroEnemigo.getVida());

    }

}
