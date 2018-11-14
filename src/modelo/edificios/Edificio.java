package modelo.edificios;

import modelo.Posicionable;

public class Edificio implements Posicionable{
	
	protected int x,y, vida;

	public Edificio(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void reducirVida(int danio) {
		
	}
}
