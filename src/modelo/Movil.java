package modelo;

import modelo.terreno.Casillero;

public interface Movil {

    /* Precondiciones: El casillero está a una distancia de 1
     *  Ese casillero está vacío.
     * Postcondición: Mueve la unidad a ese casillero
     * */
    public void moverACasillero(Casillero destino);
    
}