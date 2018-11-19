package test.edificios;

import com.company.excepciones.*;
import org.junit.Assert;
import org.junit.Test;

import com.company.modelo.Jugador;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Espadachin;

public class PlazaCentralTest{
	
	Mapa terreno = Mapa.getMapa();
	Jugador jugador ;
	
	@Test
	public void PlazaCentralCrearAldeanoTest() throws CasilleroNoExistenteException, CasilleroLlenoException{
		
		try {
			jugador = new Jugador(terreno);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		PlazaCentral central = new PlazaCentral(jugador);
		//Terreno no esta ocupado en este momento
		Assert.assertFalse(terreno.estaOcupado(16,22));
		try {
			terreno.ubicar(central, 5, 5);
			
		}catch(CasilleroLlenoException e) {
			
		}
		
		central.crear(new Aldeano(jugador));
		//Ahora terreno esta ocupado en posicion cercana de castillo y en castillo
		//La posicion donde se crea la maquina de asedio es random en el castillo
		// TODO probar mas casos borde!
		Assert.assertTrue(terreno.estaOcupado(16,22));
		Assert.assertTrue(terreno.estaOcupado(15,21));
		Assert.assertTrue(terreno.estaOcupado(16,20));
	}
	
	public void recibirDanioDeEspadachinYVerificarDanioTest() {
		
		try {
			jugador = new Jugador(terreno);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		Mapa terreno = Mapa.getMapa();

		Espadachin espadachin = new Espadachin(jugador);
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		Assert.assertTrue(plaza.comoNuevo());
		
		espadachin.atacar(plaza);
		
		Assert.assertFalse(plaza.comoNuevo());
		
	}
	
	public void recibirDanioDeArqueroYVerificarDanioTest() {
		
		try {
			jugador = new Jugador(terreno);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		Mapa terreno = Mapa.getMapa();
		
		Arquero archer = new Arquero(jugador);
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		Assert.assertTrue(plaza.comoNuevo());
		
		archer.atacar(plaza);
		
		Assert.assertFalse(plaza.comoNuevo());
		
	}
	
	public void recibirDanioDeArmaAsedioYVerificarDanioTest() {
		
		try {
			jugador = new Jugador(terreno);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		Mapa terreno = Mapa.getMapa();
		
		Arquero archer = new Arquero(jugador);
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		Assert.assertTrue(plaza.comoNuevo());
		
		archer.atacar(plaza);
		
		Assert.assertFalse(plaza.comoNuevo());
		
	}
	
	public void verificarReparacionEnTiempoIndicadoTest() {
		
		try {
			jugador = new Jugador(terreno);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		plaza.recibirDanio(50);

		try {
			plaza.reparar();
		} catch (EdificioReparadoException e) {
			e.printStackTrace();
		} catch (EdificioEnReparacionException e) {
			e.printStackTrace();
		}

		Assert.assertFalse(plaza.comoNuevo());
		
		plaza.actualizar();
		
		Assert.assertFalse(plaza.comoNuevo());
		
		plaza.actualizar();
		
		Assert.assertTrue(plaza.comoNuevo());
		
	}
	
	public void verificarQueNoCreaAldeanosCuandoEstaEnReparacionTest() throws EdificioReparadoException, EdificioEnReparacionException {
		
		try {
			jugador = new Jugador(terreno);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		plaza.recibirDanio(50);
		
		plaza.reparar();
		
		Assert.assertFalse(plaza.comoNuevo());
		
		plaza.actualizar();
		
		Assert.assertFalse(plaza.comoNuevo());
		
		plaza.actualizar();
		
		Assert.assertTrue(plaza.comoNuevo());
		
	}
	
	//por simplicidad dura un turno la creacion de aldeano, es decir queda disponible en el sig. turno
	public void verificarQueNoCreaAldeanoHastaTerminarActual() {
		
		try {
			jugador = new Jugador(terreno);
		} catch (CasilleroLlenoException e) {
			// 
		}
		
		PlazaCentral plaza = new PlazaCentral(jugador);
		
		plaza.crear(new Aldeano(jugador));
		
		Assert.assertFalse(plaza.libre());
		try {
			plaza.crear(new Aldeano(jugador));
		}catch(EdificioOcupadoException e) {
			//
		}
		
		plaza.actualizar();
		
		Assert.assertTrue(plaza.libre());
		
		plaza.crear(new Aldeano(jugador));
		
	}
	
}
