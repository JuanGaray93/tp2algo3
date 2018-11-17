package com.company.modelo.terreno;

import com.company.excepciones.MapaLlenoException;
import com.company.modelo.unidades.Unidad;

/** El Reptador es una entidad que se encarga de buscar en el mapa el casillero vacío
 * más cercano a un punto de origen que se indique. Se le pasan las coordenadas
 * iniciales por parámetro y se lo actualiza para que se mueva hasta que encuentre
 * un casillero vacío. Se mueve en espiral por el mapa para mantenerse lo más cerca
 * posible de su punto de origen.
 */
public class Reptador {

    private Integer posicionHorizontal;
    private Integer posicionVertical;
    private Mapa mapa = Mapa.getMapa();
    private Integer casillerosMirados = 0;


    public Reptador(Integer posicionHorizontal, Integer posicionVertical){
        this.posicionHorizontal = posicionHorizontal;
        this.posicionVertical = posicionVertical;
    }

    /* Devuelve un Casillero si encuentra uno vacío, null si no. Avanza el Reptador.
     */
    public Casillero buscar() throws MapaLlenoException{

        if(casillerosMirados > mapa.obtenerTamanio()){
            throw new MapaLlenoException("No se encontró un casillero vacío en el mapa");
        }

        Casillero aDevolver;
        try{
            Casillero corriente = mapa.obtenerCasillero(posicionHorizontal, posicionVertical );
            casillerosMirados++;
            if(!corriente.estaOcupado()){
                aDevolver = corriente;
            } else {
                aDevolver = null;
            }
        } catch (Exception e){
            aDevolver = null;
        }

        avanzarPosicion();
        return aDevolver;
    }

    private void avanzarPosicion(){
        // TODO: Hay que sumarle una Direccion a este objeto para su movimiento
    }

}
