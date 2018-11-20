import org.junit.Test;
import org.junit.Assert;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;



public class PosicionTest {

	/*@Test
	public void nacerAldeanoYVerificarQueSePosicionaEnPosicionIndicadaTest() {
		Aldeano aldeano = null;
		try {
			aldeano = new Aldeano(new Jugador(Mapa.getMapa()));
		} catch (CasilleroLlenoException e) {
			// TODO Auto-generated catch block
		}
		
		Posicion posicion = new Posicion(3,4);
		
		aldeano.establecerCoordenadasDeNacimiento(3,4);
		
		Assert.assertTrue(posicion.contiene(aldeano));
		
	}
*/
	/*@Test
	public void crearPlazaCentralYVerificarQueSePosicionaEnPosicionIndicadaTest() throws CasilleroLlenoException {
		
		PlazaCentral plazaCentral = new PlazaCentral(new Jugador(Mapa.getMapa()));
		
		Posicion posicion = new Posicion(3,4);
		
		try {
			plazaCentral.construirEn(3,4);
		} catch (CasilleroNoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertTrue(posicion.contiene(plazaCentral));
		
	}*/
	
}
