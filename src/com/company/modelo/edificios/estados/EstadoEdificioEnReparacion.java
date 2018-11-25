package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioEnReparacion extends EstadoEdificio {

    public EstadoEdificioEnReparacion(Integer vidaMaxima, Integer montoReparacion, Integer vidaActual) {
        super(vidaMaxima, montoReparacion);
        this.VIDA_ACTUAL = vidaActual;
    }

    @Override
    public EstadoEdificio ejecutarAccion() throws EdificioReparadoException {
        return this.reparar(trabajadorActual,MONTO_REPARACION);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws EdificioReparadoException, EdificioOcupadoException {

        if (this.VIDA_ACTUAL == this.VIDA_MAXIMA) throw new EdificioReparadoException("El edificio esta reparado");

        if( trabajadorActual != reparador){
            throw new EdificioOcupadoException("No se puede reparar este edificio, hay otro aldeano reparandolo!");
        }

        if(trabajadorActual == null) trabajadorActual = reparador;

        Integer posibleVida =this.VIDA_ACTUAL + montoDeReparacion;

        if(posibleVida > this.VIDA_ACTUAL){
            this.VIDA_ACTUAL = this.VIDA_MAXIMA;

            if(this.trabajadorActual != null){
                trabajadorActual.liberar();
                this.trabajadorActual = null;
            }

            return new EstadoEdificioInactivo(this.VIDA_MAXIMA, this.MONTO_REPARACION, this.VIDA_ACTUAL);

        }
        return this;
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioEnReparacionException {
        throw new EdificioEnReparacionException("No se puede construir, el edificio esta en reparación");
    }

    @Override
    public EstadoEdificio suspenderConstruccion() throws EdificioDestruidoExcepcion, EdificioNoConstruidoException {

        if(this.trabajadorActual !=null){
            trabajadorActual.liberar();
            this.trabajadorActual = null;
        }

        return new EstadoEdificioInactivo(this.VIDA_MAXIMA, this.MONTO_REPARACION, this.VIDA_ACTUAL);
    }

    @Override
    public Integer getVidaActual() throws EdificioEnReparacionException {
        throw new EdificioEnReparacionException("El edificio esta en reparacion");
    }

    @Override
    public EstadoEdificio recibirDanio(Integer danio){
        throw new RuntimeException("El edifico no existe, no recibe danio");
    }


}
