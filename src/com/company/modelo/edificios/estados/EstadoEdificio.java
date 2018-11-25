package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.unidades.Aldeano;

public abstract class EstadoEdificio {

    protected final Integer VIDA_MAXIMA;
    protected final Integer MONTO_REPARACION;
    protected Integer VIDA_ACTUAL;
    protected Aldeano trabajadorActual;


    public EstadoEdificio(Integer vidaMaxima, Integer montoReparacion) {
        this.VIDA_MAXIMA = vidaMaxima;
        this.MONTO_REPARACION = montoReparacion;
        this.VIDA_ACTUAL = VIDA_MAXIMA;
        this.trabajadorActual = null;
    }

    public abstract EstadoEdificio ejecutarAccion() throws EdificioEnConstruccionException, EdificioReparadoException;

    public EstadoEdificio recibirDanio(Integer montoDeDanio) {

        if(montoDeDanio < 0){
            throw new RuntimeException("El daño recibido fue negativo todo mal.");
        }

        this.VIDA_ACTUAL -= montoDeDanio;

        if(VIDA_ACTUAL <= 0){
            return new EstadoEdificioMuerto(VIDA_MAXIMA, MONTO_REPARACION);
        }

        return this;
    }

    public abstract EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion)
            throws EdificioDestruidoExcepcion, EdificioEnConstruccionException, EdificioReparadoException,
            EdificioNoConstruidoException, EdificioEnReparacionException;

    public abstract EstadoEdificio construir(Aldeano quienLoConstruye) throws EdificioEnConstruccionException, EdificioDestruidoExcepcion, EdificioEnReparacionException;

    public abstract EstadoEdificio suspenderConstruccion() throws EdificioDestruidoExcepcion, EdificioNoConstruidoException;

    public abstract Integer getVidaActual() throws EdificioDestruidoExcepcion, EdificioEnConstruccionException, EdificioEnReparacionException, EdificioNoConstruidoException;
}
/*estado puede estar reparando, construyendo o haciendo nada si esta reparando entonces hasta que no termine
;a vda del edifico  no termina si esta construyendo dura la cantidad de turnos
 */