package com.company.modelo.edificios;

import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.unidades.Aldeano;

public abstract class EstadoEdificio {

    protected final Integer VIDA_MAXIMA;
    protected final Integer MONTO_REPARACION;
    protected Integer vidaActual;
    protected Aldeano trabajadorActual = null;


    public EstadoEdificio(Integer vida, Integer montoDeReparacion) {

        VIDA_MAXIMA = vida;
        MONTO_REPARACION = montoDeReparacion;
        vidaActual = vida;
    }

    public EstadoEdificio recibirDanio(Integer montoDeDanio) throws Exception {

        if(montoDeDanio < 0){
            throw new Exception("El daño recibido fue negativo todo mal.");
        }
        this.vidaActual -= montoDeDanio;

        if(vidaActual <= 0){
            return new EstadoMuerto();
        }
        return this;
    }

    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws Exception {
        if(trabajadorActual == null){
            trabajadorActual = reparador;
        }
        if(trabajadorActual != reparador){
            throw new EdificioEnReparacionException("El edificio ya esta siendo reparado por otro aldeano");
        }
        if(vidaActual == VIDA_MAXIMA){
            throw new EdificioReparadoException();
        }
        if(montoDeReparacion > vidaActual ){
            vidaActual = VIDA_MAXIMA;
        } else {
            vidaActual += montoDeReparacion;
        }
        return this;
    }

    public abstract EstadoEdificio construir(Aldeano quienLoConstruye);

}
/*estado puede estar reparando, construyendo o haciendo nada si esta reparando entonces hasta que no termine
;a vda del edifico  no termina si esta construyendo dura la cantidad de turnos
 */
