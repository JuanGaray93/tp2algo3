package test.unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Espadachin;
import com.company.modelo.unidades.MaquinaAsedio;

import org.junit.Assert;

public class AldeanoTest {
    
	Mapa mapa = Mapa.getMapa();
	
    public void verificarQueSumaOroSinoEstaOcupadoTest() {
    	
    	Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
    	
    	Aldeano aldeano = new Aldeano(jugador);
    	
    	Assert.assertTrue(jugador.tieneOro(100));
    	
    	aldeano.actualizar();
    	
    	Assert.assertTrue(jugador.tieneOro(120));
    	
    	Assert.assertFalse(jugador.tieneOro(110));
    	
    	aldeano.actualizar();
    	
    	Assert.assertTrue(jugador.tieneOro(140));
    	
    }

    public void verificarQueSumaOroUnaVezPorTurnoTest() {
    	
    	Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
    	
    	Aldeano aldeano = new Aldeano(jugador);
    	
    	Assert.assertTrue(jugador.tieneOro(100));
    	
    	aldeano.actualizar();
    	
    	Assert.assertTrue(jugador.tieneOro(120));
    	
    	//Actualizo el turno 4 veces e incrementa jugador su oro 4 veces
    	aldeano.actualizar();
    	aldeano.actualizar();
    	aldeano.actualizar();
    	aldeano.actualizar();
    	
    	Assert.assertTrue(jugador.tieneOro(200));
    	
    	Assert.assertFalse(jugador.tieneOro(120));
    	
    }
    
    public void verificarQueMientrasReparaNoSumaOroTest() {
    	
    	Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
    	
    	Aldeano aldeano = new Aldeano(jugador);
    	
    	PlazaCentral plaza = new PlazaCentral(jugador);
    	
    	plaza.recibirDanio(25);
    	
    	aldeano.reparar(plaza);
    	
    	//no suma oro por estar reparando la plaza
    	Assert.assertTrue(jugador.tieneOro(100));
    	
    	aldeano.actualizar();
    	//se libera y suma oro nuevamente
    	Assert.assertTrue(jugador.tieneOro(120));
    	
    	
    }
    
    public void verificarQueMientrasConstruyeNoSumaOroTest() {
    	
    	Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
    	
    	Aldeano aldeano = new Aldeano(jugador);
    	
    	PlazaCentral plaza = new PlazaCentral(jugador);
    	
    	try {
			aldeano.construir(plaza,5,5);
		} catch (CasilleroLlenoException e) {
			// TODO Auto-generated catch block
		}
    	
    	//no suma oro por 3 turnos: el actual + los dos siguientes
    	
    	Assert.assertTrue(jugador.tieneOro(100));
    	
    	aldeano.actualizar();
    	
    	Assert.assertTrue(jugador.tieneOro(100));
    	
    	aldeano.actualizar();
    	
    	Assert.assertTrue(jugador.tieneOro(100));
    	
    	aldeano.actualizar();
    	
    	//Se libera y suma oro de nuevo
    	Assert.assertTrue(jugador.tieneOro(120));
    	
    }
    
    public void verificarQueAldeanoAunHeridoSumaOroTest() {
    	
    	Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
    	
    	Aldeano aldeano = new Aldeano(jugador);
    
    	Assert.assertTrue(jugador.tieneOro(100));
    	
    	aldeano.recibirDanio(20);
    	
    	aldeano.actualizar();
    	
    	Assert.assertTrue(jugador.tieneOro(100));
    	
    }
    
    public void verificarQueAldeanoRecibeDanioAlSerAtacadoPorEspadachin() {
    	
    	Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
    	
    	Aldeano aldeano = new Aldeano(jugador);
    	
    	Assert.assertTrue(aldeano.saludable());
    	
    	aldeano.recibirDanio(15);
    	
    	Assert.assertFalse(aldeano.saludable());
    	
    }
    
    public void verificarQueAldeanoRecibeDanioAlSerAtacadoPorArquero() {
    	
    	Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
    	
    	Aldeano aldeano = new Aldeano(jugador);
    	
    	Assert.assertTrue(aldeano.saludable());
    	
    	aldeano.recibirDanio(15);
    	
    	Assert.assertFalse(aldeano.saludable());
    	
    }
    
    public void verificarQueAldeanoNORecibeDanioAlSerAtacadoPorArmaAsedio() {
    	
    	Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
    	
    	Aldeano aldeano = new Aldeano(jugador);
    	
    	Assert.assertTrue(aldeano.saludable());
    	
    	MaquinaAsedio armaAsedio = new MaquinaAsedio(jugador);
    	
    	armaAsedio.atacar(aldeano);
    	
    	Assert.assertTrue(aldeano.saludable());
    	
    }
    
	void ConstruirCuartelYVerificarConstruccionTest() {
		
		Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		Aldeano aldeano = new Aldeano(jugador);
		
		Posicion posicion = new Posicion( 5, 5);
		
		Cuartel cuartel = new Cuartel(jugador);
	
		try {
			aldeano.construir(cuartel,5,5);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		aldeano.actualizar();
		
		Assert.assertFalse(aldeano.estaLibre());
		
		Assert.assertFalse(posicion.contiene(cuartel));
		
		aldeano.actualizar();
		
		Assert.assertFalse(aldeano.estaLibre());
		
		Assert.assertFalse(posicion.contiene(cuartel));
		
		aldeano.actualizar();
		
		Assert.assertTrue(aldeano.estaLibre());
		
		Assert.assertTrue(posicion.contiene(cuartel));
	}
	
	void ConstruirPlazaCentralTestYVerificarConstruccionTest() {
		
		Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}

		Aldeano aldeano = new Aldeano(jugador);
		
		Posicion posicion = new Posicion( 5, 5);
		
		PlazaCentral plazaCentral = new PlazaCentral(jugador);
	
		try {
			aldeano.construir(plazaCentral,5,5);
		} catch (CasilleroLlenoException e) {
			//
		}
		
		aldeano.actualizar();
		
		Assert.assertFalse(aldeano.estaLibre());
		
		Assert.assertFalse(posicion.contiene(plazaCentral));
		
		aldeano.actualizar();
		
		Assert.assertFalse(aldeano.estaLibre());
		
		Assert.assertFalse(posicion.contiene(plazaCentral));
		
		aldeano.actualizar();
		
		Assert.assertTrue(aldeano.estaLibre());
		
		Assert.assertTrue(posicion.contiene(plazaCentral));
		
	}
	
	void RepararCastilloTest() {
		
		Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		Castillo castillo = new Castillo(jugador);
		Aldeano aldeano = new Aldeano(jugador);
		
		/*danio Total= 15, vida Castillo inicial = 1000
		recupera 15 de vida por turno*/
		
		castillo.recibirDanio(15);
		
		Assert.assertFalse(castillo.comoNuevo());
		
		Assert.assertTrue(aldeano.estaLibre());
		
		aldeano.reparar(castillo);
		
		castillo.actualizar();
		aldeano.actualizar();
		
		Assert.assertTrue(aldeano.estaLibre());
		Assert.assertTrue(castillo.comoNuevo());
	}
	
	void RepararCuartelTest() {
		
		Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		Cuartel cuartel = new Cuartel(jugador);
		Aldeano aldeano = new Aldeano(jugador);
		
		/*danio Total= 15, vida Cuartel inicial = 75
		se cura con 50 de vida por turno*/
		
		cuartel.recibirDanio(15);
		
		Assert.assertFalse(cuartel.comoNuevo());
		
		Assert.assertTrue(aldeano.estaLibre());
		
		aldeano.reparar(cuartel);
		
		cuartel.actualizar();
		aldeano.actualizar();
		
		Assert.assertTrue(aldeano.estaLibre());
		Assert.assertTrue(cuartel.comoNuevo());
	}
	
	
	void RepararPlazaCentralTest() {
		
		Jugador jugador = null;
		try {
			jugador = new Jugador(mapa);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		Aldeano aldeano = new Aldeano(jugador);
		
		/*danio Total= 15, vida Plaza inicial = 450
		  se cura con +25  de vida por turno*/
		
		plaza.recibirDanio(15);
		
		Assert.assertFalse(plaza.comoNuevo());
		
		Assert.assertTrue(aldeano.estaLibre());
		
		aldeano.reparar(plaza);
		
		plaza.actualizar();
		aldeano.actualizar();
		
		Assert.assertTrue(aldeano.estaLibre());
		Assert.assertTrue(plaza.comoNuevo());
	}

}