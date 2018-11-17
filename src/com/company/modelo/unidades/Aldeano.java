package com.company.modelo.unidades;

import com.company.excepciones.MapaLlenoException;
import com.company.modelo.terreno.Mapa;

public class Aldeano extends Unidad {


	
	public void construirPlazaCentral() {
		
	}
	
	public void construirCuartel() {
		
	}
	
	public void repararEdificio() {
		
	}

	public void nacerEn(Integer posicionHorizontal, Integer posicionVertical) throws MapaLlenoException {
		Mapa mapa = Mapa.getMapa();
		mapa.colocarUnidad(this, posicionHorizontal, posicionVertical );
	}

}
