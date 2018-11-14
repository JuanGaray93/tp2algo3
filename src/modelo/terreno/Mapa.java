package modelo.terreno;

import java.util.ArrayList;

import modelo.unidades.Unidad;

public class Mapa {

	private static Integer numeroDeCasillerosHorizontales = 30;
	private static Integer numeroDeCasillerosVerticales = 30;

	private static ArrayList<Casillero> parcelas = new ArrayList<Casillero>();

	private static Mapa mapa = new Mapa();

	private Mapa() {}

	public void ubicar(modelo.Posicionable posicionable, int x, int y) {
		
	}

	public static Mapa getMapa(){
		return mapa;
	}

	public void colocarUnidad(Unidad nuevaUnidad, int x, int y){
		Casillero casilleroDisponible = this.encontrarCasilleroDisponibleEnTornoA(int x, int y);
	}

	/*Si no hay ningún lugar disponible en toddo el mapa, lanza una excepcion*/
	private Casillero encontrarCasilleroDisponibleEnTornoA throws MapaLlenoException(Posicion posicion){
		// TODO implementar que busque el casillero más cercano a la posición pasada por parámetro
	}

	public boolean estaOcupado() {
		// TODO buscar enla lista de parcelas y devolver si esta ocupado
		return true;
	}

	public boolean estaOcupado(int i, int j) {
		// TODO buscar en la lista de parcelas y devolver si esta ocupado en i,j
		return false;
	}

}
