package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.modelo.Posicion;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public class EstadoEdificioEnReparacion extends EstadoEdificio {

    public EstadoEdificioEnReparacion(Integer vidaMax,Integer vidaActual,Integer reparacion)
    {
        super(vidaMax, reparacion);
        this.vidaActual = vidaActual;
    }

    @Override
    public EstadoEdificio ejecutarAccion() throws Exception, EdificioEnConstruccionException {
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
