package modelo.unidades;

import modelo.Movil;
import modelo.Movimiento;
import modelo.Posicionable;
import modelo.terreno.Casillero;

public class Unidad implements Posicionable, Movil {
	
	private static Movimiento movimiento = Movimiento.getMovimiento();
	protected int x,y,vida;
	
	public Unidad() {
		
	}
	
	public Unidad(int x,int y ) {
		
	}
	
	public int getX() {
			
		return x;
	}

	public int getY() {
			
		return y;
	}

	@Override
	public void moverACasillero(Casillero destino) {
		// TODO Auto-generated method stub
		
	}

	public void moverEste() {
		this.x = movimiento.moverEste(this.x);
	}

	public void setX(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public void setY(int j) {
		
	}

}
