package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoAldeanoRecolectandoOro extends EstadoAldeano {

    public EstadoAldeanoRecolectandoOro() {

        edificioATrabajar = null;
    }

    @Override
    public EstadoUnidad actualizar() throws Exception {
        return this;
    }

    public EstadoAldeano otorgarGanancia(Jugador jugador) {
        jugador.sumarOro(PRODUCCION_ORO);
        return this;
    }

    @Override
    public EstadoAldeano construir(Edificio edificio, Integer posicionH, Integer posicionV) {
        edificioATrabajar = edificio;
        return new EstadoAldeanoConstruyendo();
    }

    @Override
    public EstadoAldeano reparar(Edificio edificio) throws Exception {
        edificioATrabajar = edificio;
        return new EstadoAldeanoReparando();
    }

}
