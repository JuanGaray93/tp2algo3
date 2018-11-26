package com.company.vista.terreno;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

public class Mapa {

    private final Integer CASILLEROS_DE_ANCHO = 10;
    private final Integer CASILLEROS_DE_ALTO = 10;
    private final Integer DIMENSION = 10;
    private ArrayList<Rectangle> casilleros = new ArrayList<>();
    public void mostrarCasilleros(){

        for(Integer y = 0; y < CASILLEROS_DE_ALTO; y++){
            for(Integer x = 0; x < CASILLEROS_DE_ANCHO; x++){
                Rectangle casillero = new Rectangle(x * DIMENSION, y * DIMENSION, DIMENSION,DIMENSION);
                casilleros.add(casillero);
            }
        }
    }
}
