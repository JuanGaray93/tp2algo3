package unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Unidad;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArqueroTest {

    Mapa mapa = Mapa.getMapa();

    @Before
    public void resetMapa() {
        mapa.destruir();
        mapa = Mapa.getMapa();
    }

    @Test
    public void testArqueroMoverHorizontalmenteHaciaDelante() {

        Cuartel cuartel = new Cuartel();

        try {
            cuartel.construirEn(3, 5);
        }
        catch ( CasilleroNoExistenteException e){
            e.printStackTrace();
        }
        catch ( CasilleroLlenoException e) {
            e.printStackTrace();
        }

        try{
            Arquero arquero = cuartel.crearArquero();

            assertTrue( mapa.estaOcupado(3, 7) );

            arquero.moverA(4, 7);
        }
        catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }
        catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }

        assertTrue( mapa.estaOcupado(4, 7) );
        assertFalse( mapa.estaOcupado(3, 7) );

    }

    @Test
    public void testArqueroMoverHorizontalmenteHaciaAtras() {
        
        Cuartel cuartel = new Cuartel();

        try {
            cuartel.construirEn(3, 5);
        }
        catch ( CasilleroNoExistenteException e){
            e.printStackTrace();
        }
        catch ( CasilleroLlenoException e) {
            e.printStackTrace();
        }

        try{
            Arquero arquero = cuartel.crearArquero();

            assertTrue( mapa.estaOcupado(3, 7) );

            arquero.moverA(2, 7);
        }
        catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }
        catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }

        assertTrue( mapa.estaOcupado(2, 7) );
        assertFalse( mapa.estaOcupado(3, 7) );

    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaArriba() {

        Cuartel cuartel = new Cuartel();

        try {
            cuartel.construirEn(3, 5);
        }
        catch ( CasilleroNoExistenteException e){
            e.printStackTrace();
        }
        catch ( CasilleroLlenoException e) {
            e.printStackTrace();
        }

        try{
            Arquero arquero = cuartel.crearArquero();

            assertTrue( mapa.estaOcupado(3, 7) );

            arquero.moverA(3, 8);
        }
        catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }
        catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }

        assertTrue( mapa.estaOcupado(3, 8) );
        assertFalse( mapa.estaOcupado(3, 7) );
    }

    @Test
    public void testArqueroMoverVerticalmenteHaciaAbajo() {
        //TODO contemplar el caso de que se choca con el cuartel
        Cuartel cuartel = new Cuartel();

        try {
            cuartel.construirEn(3, 5);
        }
        catch ( CasilleroNoExistenteException e){
            e.printStackTrace();
        }
        catch ( CasilleroLlenoException e) {
            e.printStackTrace();
        }

        try{
            Arquero arquero = cuartel.crearArquero();

            assertTrue( mapa.estaOcupado(3, 7) );

            //arquero.moverA(2, 7);
        }
        catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }
        catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }/*

        assertTrue( mapa.estaOcupado(2, 7) );
        assertFalse( mapa.estaOcupado(3, 7) );*/
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaIzquierda() {

        Cuartel cuartel = new Cuartel();

        try {
            cuartel.construirEn(3, 5);
        }
        catch ( CasilleroNoExistenteException e){
            e.printStackTrace();
        }
        catch ( CasilleroLlenoException e) {
            e.printStackTrace();
        }

        try{
            Arquero arquero = cuartel.crearArquero();

            assertTrue( mapa.estaOcupado(3, 7) );

            arquero.moverA(2, 8);
        }
        catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }
        catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }

        assertTrue( mapa.estaOcupado(2, 8) );
        assertFalse( mapa.estaOcupado(3, 7) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaArribaALaDerecha() {

        Cuartel cuartel = new Cuartel();

        try {
            cuartel.construirEn(3, 5);
        }
        catch ( CasilleroNoExistenteException e){
            e.printStackTrace();
        }
        catch ( CasilleroLlenoException e) {
            e.printStackTrace();
        }

        try{
            Arquero arquero = cuartel.crearArquero();

            assertTrue( mapa.estaOcupado(3, 7) );

            arquero.moverA(4, 8);
        }
        catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }
        catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }

        assertTrue( mapa.estaOcupado(4, 8) );
        assertFalse( mapa.estaOcupado(3, 7) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaIzquierda() {

        Cuartel cuartel = new Cuartel();

        try {
            cuartel.construirEn(3, 5);
        }
        catch ( CasilleroNoExistenteException e){
            e.printStackTrace();
        }
        catch ( CasilleroLlenoException e) {
            e.printStackTrace();
        }

        try{
            Arquero arquero = cuartel.crearArquero();

            assertTrue( mapa.estaOcupado(3, 7) );

            arquero.moverA(2, 6);
        }
        catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }
        catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }

        assertTrue( mapa.estaOcupado(2, 6) );
        assertFalse( mapa.estaOcupado(3, 7) );
    }

    @Test
    public void testArqueroMoverEnDiagonalHaciaAbajoALaDerecha() {
        //TODO contemplar el caso de que se choca con el cuartel
        Cuartel cuartel = new Cuartel();

        try {
            cuartel.construirEn(3, 5);
        }
        catch ( CasilleroNoExistenteException e){
            e.printStackTrace();
        }
        catch ( CasilleroLlenoException e) {
            e.printStackTrace();
        }

        try{
            Arquero arquero = cuartel.crearArquero();

            assertTrue( mapa.estaOcupado(3, 7) );

            //arquero.moverA(2, 7);
        }
        catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }
        catch (CasilleroNoExistenteException e) {
            e.printStackTrace();
        }/*

        assertTrue( mapa.estaOcupado(2, 7) );
        assertFalse( mapa.estaOcupado(3, 7) );*/
    }

}
