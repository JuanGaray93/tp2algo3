package modelo.edificios;

import modelo.terreno.Mapa;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

public class Cuartel extends Edificio{
	
	public Cuartel(int x,int y) {
		super(x,y);
	}
	
	public void crearEspadachin(Mapa mapa) {
		mapa.ubicar(new Espadachin(), this.x, this.y);
	}
	
	public void crearArquero(Mapa mapa) {
		mapa.ubicar(new Arquero(), this.x, this.y);
	}

}
