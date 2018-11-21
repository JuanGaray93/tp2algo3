package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.modelo.Jugador;

public class EstadoAldeanoRecolectandoOro extends EstadoAldeano {

    public EstadoAldeanoRecolectandoOro(){
        this.nombreEstado += "INACTIVO";
    }

    @Override
    public EstadoAldeano ejecutarAccion() {

        return new EstadoAldeanoRecolectandoOro();
    }

    public void otorgarGanancia(Jugador jugador){
        jugador.sumarOro(PRODUCCION_ORO);
    }

}
