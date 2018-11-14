package modelo.edificios;

import modelo.terreno.Mapa;
import modelo.unidades.MaquinaAsedio;

public class Castillo extends Edificio{
	
	public Castillo(int x,int y) {
		super(x,y);
	}
	
	public void crearMaquinaAsedio(Mapa mapa){
		mapa.ubicar(new MaquinaAsedio(), this.x, this.y);
	}
	

}
