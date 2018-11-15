package modelo;

import modelo.terreno.Mapa;
import modelo.unidades.Unidad;

public class Movimiento {

	private static Movimiento movimiento = new Movimiento();
	
	public static  Movimiento getMovimiento() {
		return movimiento;
	}

	public int moverEste(int x) {
		return x+1;
	}
	
	public int moverOeste(int x) {
		return x-1;
	}
	
	public int moverNorte( int y) {
		return y+1; 
	}
	
	public int moverSur( int y) {
		return y-1;
	}
	
	public void moverDiagonalSuperiorEste(Unidad unidad) {
		unidad.setX(unidad.getX()+1);
		unidad.setY(unidad.getY()+1);
	}
	
	public void moverDiagonalSuperiorOeste(Unidad unidad) {
		unidad.setX(unidad.getX()-1);
		unidad.setY(unidad.getY()+1);
	}
	
	public void moverDiagonalInferiorEste(Unidad unidad) {
		unidad.setX(unidad.getX()+1);
		unidad.setY(unidad.getY()-1);
	}

	public void moverDiagonalInferiorOeste(Unidad unidad) {
		unidad.setX(unidad.getX()-1);
		unidad.setY(unidad.getY()-1);
	}
	
}

