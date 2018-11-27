package com.company.modelo.edificios.estados;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.excepciones.Edificio.EdificioTerminadoException;
import com.company.excepciones.MapaLlenoException;
import com.company.modelo.Posicion;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;



public class EstadoEdificioInactivo extends EstadoEdificio {

    private Integer vidaDos;

    public EstadoEdificioInactivo(Integer vidaMax,Integer vida, Integer monto) {

        super(vidaMax, monto);
        this.vidaActual = vida;
        vidaDos = vida;
    }

    @Override
    public EstadoEdificio actualizar() {

        return this.suspender();
    }

    @Override
    public EstadoEdificio crear(Unidad unidad, Posicion posicion)
            throws CasilleroLlenoException, CasilleroNoExistenteException, MapaLlenoException {

        return new EstadoEdificioCreando(VIDA_MAXIMA,vidaActual, MONTO_REPARACION).crear(unidad, posicion);
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion)
             {

        trabajadorActual = reparador;

        return new EstadoEdificioEnReparacion(VIDA_MAXIMA, vidaActual, montoDeReparacion)
                  .reparar(reparador,MONTO_REPARACION);

    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye)
            throws EdificioTerminadoException {
        trabajadorActual = quienLoConstruye;
        return new EstadoEdificioEnConstruccion(VIDA_MAXIMA, MONTO_REPARACION);
    }

    @Override
    public EstadoEdificio suspender() {

        if(trabajadorActual!=null){
            trabajadorActual.liberar();

        }
        this.trabajadorActual = null;

        return new EstadoEdificioInactivo(VIDA_MAXIMA,vidaActual,MONTO_REPARACION);
    }

    @Override
    public EstadoEdificio ejecutarAccion() throws EdificioEnConstruccionException, EdificioReparadoException {
        return this;
    }

}
