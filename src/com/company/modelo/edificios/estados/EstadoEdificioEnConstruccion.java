package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoEdificioEnConstruccion extends EstadoEdificio {


    public EstadoEdificioEnConstruccion(Integer vidaMaxima, Integer montoReparacion) {
        super(vidaMaxima, montoReparacion);
        this.VIDA_ACTUAL = 0;
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("El edificio se esta construyendo");
    }

    @Override
    public EstadoEdificio ejecutarAccion() {
        return this.construir(trabajadorActual);

    }

    @Override
    public EstadoEdificio construir(Aldeano quienLoConstruye) throws EdificioOcupadoException {

        if(trabajadorActual == null){
            trabajadorActual = quienLoConstruye;
        }

        else if( trabajadorActual != quienLoConstruye){
            throw new EdificioOcupadoException("No se puede construir este edificio, hay otro aldeano construyendolo!");
        }

        this.VIDA_ACTUAL += (this.VIDA_MAXIMA.divideUnsigned(this.VIDA_MAXIMA, 3) + 1);//this.VIDA_MAXIMA/3, 3 es la cantidad de turnos que tardan en construirse los edificios

        if(VIDA_ACTUAL >= VIDA_MAXIMA) {
            VIDA_ACTUAL = VIDA_MAXIMA;
            return new EstadoEdificioInactivo(this.VIDA_MAXIMA, this.MONTO_REPARACION, this.VIDA_ACTUAL);
        }

        return this;
    }

    @Override
    public EstadoEdificio suspenderConstruccion(){

        if(this.trabajadorActual !=null){
            trabajadorActual.liberar();
            this.trabajadorActual = null;
        }

        return new EstadoEdificioInactivo(this.VIDA_MAXIMA, this.MONTO_REPARACION, this.VIDA_ACTUAL);
    }

    @Override
    public Integer getVidaActual() throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("El edificio esta en construccion");

    }

    @Override
    public EstadoEdificio recibirDanio(Integer danio){
        throw new RuntimeException("El edifico no existe, no recibe danio");
    }
}
