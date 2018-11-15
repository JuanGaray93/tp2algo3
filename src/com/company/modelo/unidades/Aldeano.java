package unidades;

import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Unidad;

public class Aldeano extends Unidad {

	private int vida;
	
	public void construirPlazaCentral() {
		
	}
	
	public void construirCuartel() {
		
	}
	
	public void repararEdificio() {
		
	}
	
	public void recolectarOro() {
		
	}

	public void nacerEn(Integer posicionHorizontal, Integer posicionVertical){
		Mapa mapa = Mapa.getMapa();
		mapa.colocarUnidad(self, posicionHorizontal, posicionVertical );
	}

}
