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
    protected Integer vidaActual;
    protected Aldeano trabajadorActual = null;


    public EstadoEdificio(Integer vida, Integer monto) {
        this.VIDA_MAXIMA = vida;
        this.MONTO_REPARACION = monto;
        this.vidaActual = VIDA_MAXIMA;
    }

    public EstadoEdificio recibirDanio(Integer montoDeDanio) {

        if(montoDeDanio < 0){
            throw new RuntimeException("El daño recibido fue negativo todo mal.");
        }

        this.vidaActual -= montoDeDanio;

        if(vidaActual <= 0){
            return new EstadoEdificioMuerto(VIDA_MAXIMA,MONTO_REPARACION);
        }

        return this;
    }

    public abstract EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion)
            throws EdificioDestruidoExcepcion, EdificioEnConstruccionException, EdificioReparadoException,
            EdificioNoConstruidoException, EdificioEnReparacionException;

    public abstract EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioEnConstruccionException, EdificioDestruidoExcepcion, EdificioEnReparacionException;

    public abstract EstadoEdificio suspenderConstruccion(Aldeano quienLoConstruye) throws EdificioDestruidoExcepcion, EdificioNoConstruidoException;
}
/*estado puede estar reparando, construyendo o haciendo nada si esta reparando entonces hasta que no termine
;a vda del edifico  no termina si esta construyendo dura la cantidad de turnos
 */