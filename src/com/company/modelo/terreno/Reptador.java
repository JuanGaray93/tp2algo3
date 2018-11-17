package com.company.modelo.terreno;

/** El Reptador es una entidad que se encarga de buscar en el mapa el casillero vacío
 * más cercano a un punto de origen que se indique. Se le pasan las coordenadas
 * iniciales por parámetro y se lo actualiza para que se mueva hasta que encuentre
 * un casillero vacío. Se mueve en espiral por el mapa para mantenerse lo más cerca
 * posible de su punto de origen.
 */
public class Reptador {

    private Integer posicionHorizontalInicial;
    private Integer posicionVerticalInicial;

    public Reptador(Integer posicionHorizontal, Integer posicionVertical){
        this.posicionHorizontalInicial = posicionHorizontal;
        this.posicionVerticalInicial = posicionVertical;
    }

    public Casillero buscar(){

    }

}
