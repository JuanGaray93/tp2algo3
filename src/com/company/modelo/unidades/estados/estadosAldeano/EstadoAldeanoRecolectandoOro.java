package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.DistanciaInvalidaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.Aldeano;

public class EstadoAldeanoRecolectandoOro extends EstadoAldeano {

    public EstadoAldeanoRecolectandoOro(Aldeano aldeano){
        super(aldeano);

    }

    public void otorgarGanancia(Jugador jugador)
    {

        jugador.sumarOro(PRODUCCION_ORO);
    }

    @Override
    public EstadoAldeano construir(Edificio edificio, Integer posicionH, Integer posicionV) {
        edificioATrabajar = edificio;
        return new EstadoAldeanoConstruyendo(esteAldeano);
    }

    @Override
    public EstadoAldeano reparar(Edificio edificio) throws Exception {
        edificioATrabajar = edificio;
        return new EstadoAldeanoReparando(esteAldeano);
    }

}
