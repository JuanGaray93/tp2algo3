package unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.ArmaAsedio;

import unidades.Before;
import unidades.Test;

public class AsedioTest {

	    Mapa mapa = Mapa.getMapa();

	    @Before
	    public void resetMapa() {
	        mapa.destruir();
	        mapa = Mapa.getMapa();
	    }

	    @Test
	    public void testAsedioMoverHorizontalmenteHaciaDelante() {
	    	
	    	Jugador jugador = null;
			try {
				jugador = new Jugador(mapa);
			} catch (CasilleroLlenoException e) {
				
			}

	        Castillo castillo = new Castillo(jugador);

	        try {
	            castillo.construirEn(3, 5);
	        }
	        catch ( CasilleroNoExistenteException e){
	            e.printStackTrace();
	        }
	        catch ( CasilleroLlenoException e) {
	            e.printStackTrace();
	        }

	        try{
	        	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
	            castillo.crear(maquinaAsedio);

	            assertTrue( mapa.estaOcupado(3, 7) );

	            maquinaAsedio.moverA(4, 7);
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
	    public void testAsedioMoverHorizontalmenteHaciaAtras() {
	    	
	    	Jugador jugador = null;
			try {
				jugador = new Jugador(mapa);
			} catch (CasilleroLlenoException e) {
				// 
			}
	        
			 Castillo castillo = new Castillo(jugador);

		     try {
		    	 castillo.construirEn(3, 5);
		     }
		     catch ( CasilleroNoExistenteException e){
		    	 e.printStackTrace();
		     }
		     catch ( CasilleroLlenoException e) {
		    	 e.printStackTrace();
		     }

		     try{
		    	 ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		         castillo.crear(maquinaAsedio);

		         assertTrue( mapa.estaOcupado(3, 7) );

	             maquinaAsedio.moverA(2, 7);
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
	    public void testAsedioMoverVerticalmenteHaciaArriba() {
	    	
	    	Jugador jugador = null;
			try {
				jugador = new Jugador(mapa);
			} catch (CasilleroLlenoException e) {
				
			}

			Castillo castillo = new Castillo(jugador);

		    try {
		    	castillo.construirEn(3, 5);
		    }
		    catch ( CasilleroNoExistenteException e){
		    	e.printStackTrace();
		    }
		    catch ( CasilleroLlenoException e) {
		    	e.printStackTrace();
		    }

		    try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(3, 7) );
	            maquinaAsedio.moverA(3, 8);
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
	    public void testAsedioMoverVerticalmenteHaciaAbajo() throws CasilleroLlenoException, CasilleroNoExistenteException {
	    	
	    	Jugador jugador = null;
			try {
				jugador = new Jugador(mapa);
			} catch (CasilleroLlenoException e) {
				
			}
	    	
			Castillo castillo = new Castillo(jugador);

		    try {
		        castillo.construirEn(3, 5);
		    }
		    catch ( CasilleroNoExistenteException e){
		    	e.printStackTrace();
		    }
		    catch ( CasilleroLlenoException e) {
		    	e.printStackTrace();
		    }

		    try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(3, 7) );
		            
		        maquinaAsedio.moverA(3, 6);
		    }
		    catch (CasilleroLlenoException e) {
		    	e.printStackTrace();
		    }
		    catch (CasilleroNoExistenteException e) {
		    	e.printStackTrace();
		    }

		    assertTrue( mapa.estaOcupado(3, 6) );
		    assertFalse( mapa.estaOcupado(3, 7) );
	    }

	    @Test
	    public void testAsedioMoverEnDiagonalHaciaArribaALaIzquierda() {
	    	
	    	Jugador jugador = null;
			try {
				jugador = new Jugador(mapa);
			} catch (CasilleroLlenoException e) {
				
			}

	        Castillo castillo = new Castillo(jugador);

	        try {
	            castillo.construirEn(3, 5);
	        }
	        catch ( CasilleroNoExistenteException e){
	            e.printStackTrace();
	        }
	        catch ( CasilleroLlenoException e) {
	            e.printStackTrace();
	        }

	        try{
	        	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
	            castillo.crear(maquinaAsedio);

	            assertTrue( mapa.estaOcupado(3, 7) );

	            maquinaAsedio.moverA(2, 8);
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
	    public void testAsedioMoverEnDiagonalHaciaArribaALaDerecha() {
	    	
	    	Jugador jugador = null;
			try {
				jugador = new Jugador(mapa);
			} catch (CasilleroLlenoException e) {
			
			}

			Castillo castillo = new Castillo(jugador);

		    try {
		    	castillo.construirEn(3, 5);
		    }
		    catch ( CasilleroNoExistenteException e){
		    	e.printStackTrace();
		    }
		    catch ( CasilleroLlenoException e) {
		    	e.printStackTrace();
		    }

		    try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(3, 7) );

	            maquinaAsedio.moverA(4, 8);
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
	    public void testAsedioMoverEnDiagonalHaciaAbajoALaIzquierda() {
	    	
	    	Jugador jugador = null;
			try {
				jugador = new Jugador(mapa);
			} catch (CasilleroLlenoException e) {
				// 
			}
			Castillo castillo = new Castillo(jugador);

		    try {
		    	castillo.construirEn(3, 5);
		    }
		    catch ( CasilleroNoExistenteException e){
		    	e.printStackTrace();
		    }
		    catch ( CasilleroLlenoException e) {
		    	e.printStackTrace();
		    }

		    try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(3, 7) );

	            maquinaAsedio.moverA(2, 6);
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
	    public void testAsedioMoverEnDiagonalHaciaAbajoALaDerecha() throws CasilleroLlenoException, CasilleroNoExistenteException {
	    	
	    	Jugador jugador = null;
			try {
				jugador = new Jugador(mapa);
			} catch (CasilleroLlenoException e) {
				
			}
	    	
			Castillo castillo = new Castillo(jugador);

		    try {
		    	castillo.construirEn(3, 5);
		    }
		    catch ( CasilleroNoExistenteException e){
		    	e.printStackTrace();
		    }
		    catch ( CasilleroLlenoException e) {
		    	e.printStackTrace();
		    }

		    try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(3, 7) );
		        
		        maquinaAsedio.moverA(4, 6);
		    }
		    catch (CasilleroLlenoException e) {
		    	e.printStackTrace();
		    }
		    catch (CasilleroNoExistenteException e) {
		    	e.printStackTrace();
		    }

		    assertTrue( mapa.estaOcupado(4, 6) );
		    assertFalse( mapa.estaOcupado(3, 7) );

	}
	    @Test
	    public void testAsedioMoverVerticalementeHaciaArribaMontada() throws CasilleroLlenoException, CasilleroNoExistenteException {
	    	
	    	Jugador jugador = null;
			try {
				jugador = new Jugador(mapa);
			} catch (CasilleroLlenoException e) {
				
			}

			Castillo castillo = new Castillo(jugador);

		    try {
		    	castillo.construirEn(3, 5);
		    }
		    catch ( CasilleroNoExistenteException e){
		    	e.printStackTrace();
		    }
		    catch ( CasilleroLlenoException e) {
		    	e.printStackTrace();
		    }

		    try{
		    	ArmaAsedio maquinaAsedio = new ArmaAsedio(jugador);
		        castillo.crear(maquinaAsedio);

		        assertTrue( mapa.estaOcupado(3, 7) );
		        maquinaAsedio.montar();
	            maquinaAsedio.moverA(3, 8);
	        }
	        catch (CasilleroLlenoException e) {
	            e.printStackTrace();
	        }
	        catch (CasilleroNoExistenteException e) {
	            e.printStackTrace();
	        }

	        assertFalse( mapa.estaOcupado(3, 8) );
	        assertTrue( mapa.estaOcupado(3, 7) );
	    	

	    }   
	    

}
