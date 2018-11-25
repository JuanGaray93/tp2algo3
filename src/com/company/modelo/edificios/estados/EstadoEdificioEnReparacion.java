package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.modelo.Posicion;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public class EstadoEdificioEnReparacion extends EstadoEdificio {

    public EstadoEdificioEnReparacion(Integer vidaMax,Integer vidaActual,Integer reparacion)
    {
        super(vidaMax, reparacion);
        this.vidaActual = vidaActual;
    }

    public EstadoEdificio reparar(Aldeano reparador,
                                  Integer montoDeReparacion) {

        if(trabajadorActual == null){
            trabajadorActual = reparador;

        }else if(trabajadorActual != reparador){

            throw new EdificioOcupadoException("No se puede reparar este edificio, " +
                    "hay otro aldeano reparandolo!");
        }

        if(vidaActual >= VIDA_MAXIMA){


            vidaActual = VIDA_MAXIMA;
            return new EstadoEdificioInactivo(VIDA_MAXIMA,vidaActual,MONTO_REPARACION).suspender();

        }else {

            vidaActual+=montoDeReparacion;

        }
        return this;
    }

    @Override
    public EstadoEdificio actualizar() throws Exception, EdificioEnConstruccionException {
        return this.reparar(trabajadorActual,MONTO_REPARACION);
    }

    @Override
    public EstadoEdificio crear(Unidad unidad, Posicion posicion)
            throws EdificioEnReparacionException {
        throw new EdificioEnReparacionException("Edificio en reparacion, no es posible crear unidad");
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws EdificioEnConstruccionException, Exception {
       throw new EdificioEnReparacionException("El edificio se esta reparando!");
    }

    @Override
    public EstadoEdificio suspender() {
        if(this.trabajadorActual !=null){
            trabajadorActual.liberar();
        }
        this.trabajadorActual = null;
        return new EstadoEdificioInactivo(VIDA_MAXIMA,vidaActual, MONTO_REPARACION);
    }

    @Override
    public Integer getVidaActual() {
        return vidaActual;
    }
}
