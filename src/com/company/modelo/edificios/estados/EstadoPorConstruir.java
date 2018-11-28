package com.company.modelo.edificios.estados;


import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Posicion;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public class EstadoPorConstruir extends EstadoEdificio {

    public EstadoPorConstruir(Integer vidaMax, Integer reparacion) {
        super(vidaMax,reparacion);
        this.vidaActual = 0;
        trabajadorActual = null;
    }

    @Override
    public EstadoEdificio crear(Unidad unidad, Posicion posicion) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("El edificio no existe!");
    }

    @Override
    public EstadoEdificio construir(Aldeano quienLoConstruye) throws EdificioEnConstruccionException, Exception {
        return new EstadoEdificioEnConstruccion(VIDA_MAXIMA,MONTO_REPARACION).construir(quienLoConstruye);}

    @Override
    public EstadoEdificioEnReparacion suspender() throws EdificioEnConstruccionException {
      this.trabajadorActual = null;
       throw new EdificioEnConstruccionException("Disculpe el edificio no existe");
    }

    @Override
    public Integer getVidaActual() throws Exception {
        throw new Exception("Este edificio aun no existe");
    }

    @Override
    public EstadoEdificio ejecutarAccion() throws EdificioEnConstruccionException, EdificioReparadoException {
        return this;
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws Exception {
        throw new Exception("Intenta reparar edificio no construido");
    }

    @Override
    public EstadoEdificio recibirDanio(Integer danio){

        throw new RuntimeException("El edifico no existe, no recibe danio");
    }

}
