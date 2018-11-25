package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.modelo.Posicion;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public class EstadoEdificioEnConstruccion extends EstadoEdificio {


    public EstadoEdificioEnConstruccion(Integer vidaMax, Integer reparacion) {
        super(vidaMax,reparacion);
        vidaActual = 0;
    }

    @Override
    public EstadoEdificio ejecutarAccion() {

        return this.construir(trabajadorActual);

    }

    @Override
    public EstadoEdificio crear(Unidad unidad, Posicion posicion)
            throws EdificioEnConstruccionException {
       throw new EdificioEnConstruccionException("No es posible crear unidades edificio construyendose");
    }

    @Override
    public EstadoEdificio recibirDanio(Integer montoDeDanio) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("No es posible atacar este edificio! en construccion");
    }

    @Override
    public Integer getVidaActual(){
        return vidaActual;
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador,
                                  Integer montoDeReparacion) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("imposible reparar edificio en construccion");
    }

    @Override
    public EstadoEdificio construir(Aldeano quienLoConstruye) {

        if(trabajadorActual == null){
            trabajadorActual = quienLoConstruye;

        } else if( trabajadorActual != quienLoConstruye){

            throw new EdificioOcupadoException("No se puede construir este edificio," +
                                               " hay otro aldeano construyendolo!");
        }
        if(vidaActual >= VIDA_MAXIMA){
            vidaActual = VIDA_MAXIMA;

            return new EstadoEdificioInactivo(VIDA_MAXIMA,vidaActual,MONTO_REPARACION).suspender();
        }else{
            vidaActual+= VIDA_MAXIMA/3;
        }
        return this;
    }

    @Override
    public EstadoEdificio suspender() {
        if(this.trabajadorActual !=null){
            trabajadorActual.liberar();
        }
        this.trabajadorActual = null;
        return new EstadoEdificioInactivo(VIDA_MAXIMA,vidaActual,MONTO_REPARACION);
    }
}
