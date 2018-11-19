package com.company.modelo.terreno;

import com.company.excepciones.MapaLlenoException;

/** El Reptador es una entidad que se encarga de buscar en el mapa el casillero vacío
 * más cercano a un punto de origen que se indique. Se le pasan las coordenadas
 * iniciales por parámetro y se lo actualiza para que se mueva hasta que encuentre
 * un casillero vacío. Se mueve en espiral por el mapa para mantenerse lo más cerca
 * posible de su punto de origen.
 */
public class Reptador {

    private Integer posicionHorizontal;
    private Integer posicionVertical;
    private Mapa mapa;
    private Integer casillerosMirados = 0;

    private Integer direccionX = 1;


    protected Reptador(Integer posicionHorizontal, Integer posicionVertical, Mapa mapa){
        this.posicionHorizontal = posicionHorizontal;
        this.posicionVertical = posicionVertical;
        this.mapa = mapa;
    }

    /* Devuelve un Casillero si encuentra uno vacío, null si no. Avanza el Reptador.
     */
    protected Casillero buscar() throws MapaLlenoException{

        if(casillerosMirados > mapa.obtenerTamanio()){
            throw new MapaLlenoException("No se encontró un casillero vacío en el mapa");
        }

        try{
            Casillero lugar = mapa.obtenerCasillero(posicionHorizontal, posicionVertical );
            casillerosMirados++;
            if(! lugar.estaOcupado()){
                return lugar;
            }
        } catch (Exception e){
            //Se da vuelta si no encuentra en esa direccion
            direccionX *= -1;
        }

        avanzarPosicion();
        return null;
    }

    private void avanzarPosicion(){
        posicionHorizontal += direccionX;
    }

}
