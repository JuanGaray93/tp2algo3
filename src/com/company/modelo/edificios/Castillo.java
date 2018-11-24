package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.MapaLlenoException;
import com.company.excepciones.UnidadErroneaException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoEdificioInactivo;
import com.company.modelo.edificios.estados.EstadoPorConstruir;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public class Castillo extends Edificio {


    public Castillo(Jugador jugador) {
        super(jugador);
        VIDA_MAXIMA = 1000;

        this.estado = new EstadoEdificioInactivo(VIDA_MAXIMA,VIDA_MAXIMA,0);
    }

    @Override
    public void construir(Aldeano quienLoConstruye, Integer posicionHorizontal, Integer posicionVertical) throws EdificioEnConstruccionException, Exception {
        throw new Exception("Este edificio no se puede construir");
    }

    @Override
    public void crear(Unidad unidad)
            throws CasilleroNoExistenteException, CasilleroLlenoException, MapaLlenoException {
        if(!unidad.seLlama("ARMA_ASEDIO")){
            throw new UnidadErroneaException("esta unidad no puede ser creada aqui");
        }
        posiciones.get(1).posicionar(unidad);
    }

    public void actualizar() {

    }

    public void atacar(Unidad enemigo) {
        // TODO
    }

    public void atacar(Edificio enemigo) {
        // TODO
    }


}
