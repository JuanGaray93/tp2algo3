package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioTerminadoException;
import com.company.modelo.unidades.Aldeano;

public abstract class EstadoEdificio {

    protected final Integer VIDA_MAXIMA;
    protected final Integer MONTO_REPARACION;
    protected Integer vidaActual;
    protected Aldeano trabajadorActual = null;


    public EstadoEdificio(Integer vida,Integer monto) {
        this.VIDA_MAXIMA = vida;
        this.MONTO_REPARACION = monto;
        vidaActual = VIDA_MAXIMA;
    }

    public EstadoEdificio recibirDanio(Integer montoDeDanio) throws Exception {

        if(montoDeDanio < 0){
            throw new RuntimeException("El daño recibido fue negativo todo mal.");
        }

        this.vidaActual -= montoDeDanio;

        if(vidaActual <= 0){
            return new EstadoEdificioMuerto(VIDA_MAXIMA,MONTO_REPARACION);
        }

        return this;
    }

    public abstract EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws Exception;

    public abstract EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioEnConstruccionException, Exception;

    public abstract EstadoEdificio suspenderConstruccion(Aldeano quienLoConstruye) throws Exception;
}
/*estado puede estar reparando, construyendo o haciendo nada si esta reparando entonces hasta que no termine
;a vda del edifico  no termina si esta construyendo dura la cantidad de turnos
 */