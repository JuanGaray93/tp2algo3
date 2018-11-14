package modelo.terreno;

import modelo.Posicionable;

public class Casillero {
	
	private int x,y;
	
	private Posicionable posicionable;
	
	public Casillero(int x, int y) {
		posicionable = null;
		this.x = x;
		this.y = y;
	}
	
	public void posicionar(Posicionable posicionable) {
		this.posicionable = posicionable;
	}
	
	public void vaciar() {
		posicionable = null;
	}
	
    public Boolean estaLibre() {
        return posicionable == null;
    }

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
