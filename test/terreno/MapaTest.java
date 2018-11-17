package terreno;


import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MapaLlenoException;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Casillero;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapaTest {

    Mapa mapa = Mapa.getMapa();

    @Before
    public void resetMapa() {
        mapa.destruir();
    }

    @Test
    public void elMapaTieneCasillerosVaciosTest(){
        assertFalse(mapa.estaOcupado(10, 10));
    }

    @Test
    public void colocarPosicionableOcupaElLugarTest() {
        Aldeano aldeano = new Aldeano();
        try {
            mapa.ubicar(aldeano, 10, 10);
        } catch (Exception e) {
            assertTrue( e.getMessage(),false);
        }
        assertTrue(mapa.estaOcupado(10, 10));
    }

    @Test
    public void colocarPosicionableNoOcupaOtroLugarTest() {
        Aldeano aldeano = new Aldeano();
        try {
            mapa.ubicar(aldeano, 10, 10);
        } catch (Exception e) {
            assertTrue( e.getMessage(),false);
        }
        assertFalse(mapa.estaOcupado(11, 10));
    }

    @Test
    public void colocarPosicionablePermiteRecuperarloTest() {
        PlazaCentral plazaCentral = new PlazaCentral();
        Posicionable unidadRecuperada = null;
        try {
            mapa.ubicar(plazaCentral, 10, 10);
            unidadRecuperada = mapa.conseguirOcupante(10, 10);
        } catch (Exception e) {
            assertTrue( e.getMessage(),false);
        }
        assertTrue("Se recupera la unidad puesta en el mapa",unidadRecuperada == plazaCentral);
    }

    @Test
    public void colocarUnidadOcupaCasilleroVacioMasCercano(){
        /** El Reptador no se puede testear directamente por ser un objeto al que sólo puede acceder Mapa.
         *  Sin embargo, colocarUnidad es el único método que delega responsabilidades a Reptador.
         *  Que funcione bien ese método es que funcione bien el Reptador.
         *  Este test prueba entonces que funcione correctamente.
         * */

        Posicionable obtenido = null;
        Aldeano aColocar = new Aldeano();

        try {
            /* El 1! representa el lugar donde se empieza la búsqueda. El 0 el lugar vacío más cercano.
             *     _______________
             * 10  |1 |0 |1 |1 |1 |
             * 11  |1 |1 |1 |1 |1 |
             * 12  |1 |1 |1!|1 |1 |
             * 13  |1 |1 |1 |1 |1 |
             * 14  |1_|1_|1_|1_|1_|
             *     10  11 12 13 14
             * */

            //Ubico fila 10
            mapa.ubicar(new Aldeano(), 10, 10);
            // NO ubico nada en: mapa.ubicar(new Aldeano(), 10, 11);
            mapa.ubicar(new Aldeano(), 10, 12);
            mapa.ubicar(new Aldeano(), 10, 13);
            mapa.ubicar(new Aldeano(), 10, 14);
            //Fila 11
            mapa.ubicar(new Aldeano(), 11, 10);
            mapa.ubicar(new Aldeano(), 11, 11);
            mapa.ubicar(new Aldeano(), 11, 12);
            mapa.ubicar(new Aldeano(), 11, 13);
            mapa.ubicar(new Aldeano(), 11, 14);
            //Fila 12
            mapa.ubicar(new Aldeano(), 12, 10);
            mapa.ubicar(new Aldeano(), 12, 11);
            mapa.ubicar(new Aldeano(), 12, 12);
            mapa.ubicar(new Aldeano(), 12, 13);
            mapa.ubicar(new Aldeano(), 12, 14);
            // Fila 13
            mapa.ubicar(new Aldeano(), 13, 10);
            mapa.ubicar(new Aldeano(), 13, 11);
            mapa.ubicar(new Aldeano(), 13, 12);
            mapa.ubicar(new Aldeano(), 13, 13);
            mapa.ubicar(new Aldeano(), 13, 14);
            // Fila 14
            mapa.ubicar(new Aldeano(), 14, 10);
            mapa.ubicar(new Aldeano(), 14, 11);
            mapa.ubicar(new Aldeano(), 14, 12);
            mapa.ubicar(new Aldeano(), 14, 13);
            mapa.ubicar(new Aldeano(), 14, 14);

            mapa.colocarUnidad(aColocar, 12, 12);
            obtenido = mapa.conseguirOcupante(11, 10);

        } catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        } catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }catch (MapaLlenoException e) {
            e.printStackTrace();
        }

        assertEquals(aColocar, obtenido);
    }




}
