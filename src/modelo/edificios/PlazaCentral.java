package modelo.edificios;

import modelo.terreno.Mapa;
import modelo.unidades.Aldeano;
import modelo.unidades.Espadachin;

public class PlazaCentral extends Edificio{
	
	private int vida;
	
	public PlazaCentral(int x,int y) {
		super(x,y);
	}
	
	public void crearAldeano(Mapa mapa) {
		mapa.ubicar(new Espadachin(), this.x, this.y);
	}

	public int getVida() {
		// TODO Auto-generated method stub
		return 0;
	}

}
