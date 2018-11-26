package unidades;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import org.junit.Before;
import org.junit.Test;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.ArmaAsedio;

public class AsedioTest {

	    private Mapa mapa = Mapa.getMapa();
	    private Jugador jugador;

	    @Before
	    public void resetMapa() {
	        mapa.destruir();
	        mapa = Mapa.getMapa();
	        jugador = new Jugador();
	    }

	    @Test
	    public void testAsedioMoverUnCasilleroALaDerecha() throws Exception {

			Castillo castillo = new Castillo(jugador);
	        
		    Aldeano aldeano = new Aldeano(jugador);
	        try {
	            castillo.construir(aldeano, 3, 5);
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();

			try{
	        	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
	            castillo.crear(maquinaAsedio);

	            //arma de asedio se posiciona en 7 6
	            assertTrue( mapa.estaOcupado(7, 6) );

	            maquinaAsedio.moverA(8, 6);
	        }
	        catch (CasilleroLlenoException | MapaLlenoException | EdificioEnReparacionException | ArmaMontadaException e) {
	            e.printStackTrace();
	        }
	        catch (CasilleroNoExistenteException e) {
	            e.printStackTrace();
	        }


	        assertTrue( mapa.estaOcupado(8, 6) );
			assertFalse( mapa.estaOcupado(7, 6) );


	    }

	    @Test
	    public void testAsedioMoverHorizontalmenteHaciaAtras() throws Exception {
	    	
	    	Jugador jugador = null;
			jugador = new Jugador();

			Castillo castillo = new Castillo(jugador);
			 Aldeano aldeano = new Aldeano(jugador);
		     try {
		    	 castillo.construir(aldeano, 3, 5);
		     }
		     catch (Exception e){
		    	 e.printStackTrace();
		     }
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();

			try{
		    	 ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		         castillo.crear(maquinaAsedio);

		         assertTrue( mapa.estaOcupado(7, 6) );

	             maquinaAsedio.moverA(8, 6);
				maquinaAsedio.moverA(7, 6);
	         }
	         catch (CasilleroLlenoException | MapaLlenoException | EdificioEnReparacionException | ArmaMontadaException e) {
	            e.printStackTrace();
	         }
	         catch (CasilleroNoExistenteException e) {
	        	 e.printStackTrace();
	         }

	         assertTrue( mapa.estaOcupado(7, 6) );
	         assertFalse( mapa.estaOcupado(8, 6) );

	    }

	    @Test
	    public void testAsedioMoverVerticalmenteHaciaArriba() throws Exception {
	    	
	    	Jugador jugador = null;
			jugador = new Jugador();

			Castillo castillo = new Castillo(jugador);
			Aldeano aldeano = new Aldeano(jugador);
		    try {
		    	castillo.construir(aldeano, 3, 5);
		    }
		    catch ( Exception e){
		    	e.printStackTrace();
		    }
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();

			try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(7, 6) );
	            maquinaAsedio.moverA(7, 7);
	        }
	        catch (CasilleroLlenoException | MapaLlenoException | EdificioEnReparacionException | ArmaMontadaException e) {
	            e.printStackTrace();
	        }
	        catch (CasilleroNoExistenteException e) {
	            e.printStackTrace();
	        }

	        assertTrue( mapa.estaOcupado(7, 7) );
	        assertFalse( mapa.estaOcupado(7, 6) );
	    }

	    @Test
	    public void testAsedioMoverVerticalmenteHaciaAbajo() throws Exception {
	    	
	    	Jugador jugador = null;
			jugador = new Jugador();

			Castillo castillo = new Castillo(jugador);
			Aldeano aldeano = new Aldeano(jugador);
		    try {
		        castillo.construir(aldeano, 3, 5);
		    }
		    catch ( Exception e){
		    	e.printStackTrace();
		    }
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();

			try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(7, 6) );
		            
		        maquinaAsedio.moverA(7, 5);
		    }
		    catch (CasilleroLlenoException | MapaLlenoException | EdificioEnReparacionException | ArmaMontadaException e) {
		    	e.printStackTrace();
		    }
		    catch (CasilleroNoExistenteException e) {
		    	e.printStackTrace();
		    }

		    assertTrue( mapa.estaOcupado(7, 5) );
		    assertFalse( mapa.estaOcupado(7, 6) );
	    }

	    @Test
	    public void testAsedioMoverEnDiagonalHaciaArribaALaIzquierda() throws Exception {
	    	
	    	Jugador jugador = null;
			jugador = new Jugador();

			Castillo castillo = new Castillo(jugador);
	        Aldeano aldeano = new Aldeano(jugador);
	        try {
	            castillo.construir(aldeano, 3, 5);
	        }
	        catch ( Exception e){
	            e.printStackTrace();
	        }
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();

			try{
	        	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
	            castillo.crear(maquinaAsedio);

	            assertTrue( mapa.estaOcupado(7, 6) );

	            maquinaAsedio.moverA(8, 6);
				maquinaAsedio.moverA(7, 7);
	        }
	        catch (CasilleroLlenoException | MapaLlenoException | EdificioEnReparacionException | ArmaMontadaException e) {
	            e.printStackTrace();
	        }
	        catch (CasilleroNoExistenteException e) {
	            e.printStackTrace();
	        }

	        assertTrue( mapa.estaOcupado(7, 7) );
	        assertFalse( mapa.estaOcupado(8, 6) );
	    }

	    @Test
	    public void testAsedioMoverEnDiagonalHaciaArribaALaDerecha() throws Exception {
	    	
	    	Jugador jugador = null;
			jugador = new Jugador();

			Castillo castillo = new Castillo(jugador);
			Aldeano aldeano = new Aldeano(jugador);
		    try {
		    	castillo.construir(aldeano, 3, 5);
		    }
		    catch ( Exception e){
		    	e.printStackTrace();
		    }
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();

			try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(7, 6) );

	            maquinaAsedio.moverA(8, 7);
	        }
	        catch (CasilleroLlenoException | MapaLlenoException | EdificioEnReparacionException | ArmaMontadaException e) {
	            e.printStackTrace();
	        }
	        catch (CasilleroNoExistenteException e) {
	            e.printStackTrace();
	        }

	        assertTrue( mapa.estaOcupado(8, 7) );
	        assertFalse( mapa.estaOcupado(7, 6) );
	    }

	    @Test
	    public void testAsedioMoverEnDiagonalHaciaAbajoALaIzquierda() throws Exception {
	    	
	    	Jugador jugador = null;
			jugador = new Jugador();
			Castillo castillo = new Castillo(jugador);
			Aldeano aldeano = new Aldeano(jugador);
		    try {
		    	castillo.construir(aldeano, 3, 5);
		    }
		    catch ( Exception e){
		    	e.printStackTrace();
		    }
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();

			try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(7, 6) );

	            maquinaAsedio.moverA(8, 6);
				maquinaAsedio.moverA(7, 5);
	        }
	        catch (CasilleroLlenoException | MapaLlenoException | EdificioEnReparacionException | ArmaMontadaException e) {
	            e.printStackTrace();
	        }
	        catch (CasilleroNoExistenteException e) {
	            e.printStackTrace();
	        }

	        assertTrue( mapa.estaOcupado(7, 5) );
	        assertFalse( mapa.estaOcupado(8, 6) );
	    }

	    @Test
	    public void testAsedioMoverEnDiagonalHaciaAbajoALaDerecha() throws Exception {
	    	
	    	Jugador jugador = null;
			jugador = new Jugador();

			Castillo castillo = new Castillo(jugador);
			Aldeano aldeano = new Aldeano(jugador);
		    try {
		    	castillo.construir(aldeano, 3, 5);
		    }
		    catch (Exception e){
		    	e.printStackTrace();
		    }
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();


			try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(7, 6) );
		        
		        maquinaAsedio.moverA(8, 5);
		    }
		    catch (CasilleroLlenoException | MapaLlenoException | EdificioEnReparacionException | ArmaMontadaException e) {
		    	e.printStackTrace();
		    }
		    catch (CasilleroNoExistenteException e) {
		    	e.printStackTrace();
		    }

		    assertTrue( mapa.estaOcupado(8, 5) );
		    assertFalse( mapa.estaOcupado(7, 6) );

	}
	    @Test
	    public void testAsedioMoverVerticalementeHaciaArribaMontada() throws Exception {
	    	
	    	Jugador jugador = null;
			jugador = new Jugador();

			Castillo castillo = new Castillo(jugador);
			Aldeano aldeano = new Aldeano(jugador);
		    try {
		    	castillo.construir(aldeano, 3, 5);
		    }
		    catch (Exception e){
		    	e.printStackTrace();
		    }
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();
			castillo.actualizar();

			try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(7, 6) );
		        maquinaAsedio.montar();
	            maquinaAsedio.moverA(7, 7);
	        }
	        catch (CasilleroLlenoException | MapaLlenoException | EdificioEnReparacionException | ArmaMontadaException e) {
	            e.printStackTrace();
	        }
	        catch (CasilleroNoExistenteException e) {
	            e.printStackTrace();
	        }

	        assertFalse( mapa.estaOcupado(7, 7) );
	        assertTrue( mapa.estaOcupado(7, 6) );
	    	

	    }

	@Test (expected = MovimientoInvalidoException.class)
	public void testAsedioMoverHorizontalmenteHaciaLaIzquierdaAUnCasilleroOcupado() throws Exception {

		Jugador jugador = null;
		jugador = new Jugador();

		Castillo castillo = new Castillo(jugador);
		Aldeano aldeano = new Aldeano(jugador);
		try {
			castillo.construir(aldeano, 3, 5);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		castillo.actualizar();
		castillo.actualizar();
		castillo.actualizar();
		castillo.actualizar();

		try{
			ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
			castillo.crear(maquinaAsedio);

			assertTrue( mapa.estaOcupado(7, 6) );
			maquinaAsedio.moverA(6, 6);
		}
		catch (CasilleroLlenoException | MapaLlenoException | EdificioEnReparacionException | ArmaMontadaException e) {
			e.printStackTrace();
		}
		catch (CasilleroNoExistenteException e) {
			e.printStackTrace();
		}

		assertFalse( mapa.estaOcupado(6, 6) );
		assertTrue( mapa.estaOcupado(7, 6) );


	}


}
