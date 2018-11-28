package com.company.modelo.edificios.estados;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Posicion;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public class EstadoEdificioMuerto extends EstadoEdificio {

    public EstadoEdificioMuerto(Integer vida, Integer montoDeReparacion) {

        super(vida,montoDeReparacion);
        this.vidaActual = 0;
    }

    @Override
    public EstadoEdificio recibirDanio(Integer montoDeDanio) {

        throw new RuntimeException("El edificio esta destruido!");
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion)
            throws Exception {
        throw new Exception("El edificio esta destruido!");
    }

    @Override
    public EstadoEdificioEnConstruccion construir(Aldeano quienLoConstruye) throws Exception {
        throw new Exception("El edificio esta destruido!");
    }

    @Override
    public EstadoEdificioEnReparacion suspender() throws Exception {
        if(this.trabajadorActual!=null){
            trabajadorActual.liberar();
        }
        trabajadorActual = null;
        throw new Exception("El edificio esta destruido!");
    }

    @Override
    public EstadoEdificio crear(Unidad unidad, Posicion posicion) throws EdificioEnConstruccionException {
        throw new EdificioEnConstruccionException("El edificio esta destruido!");
    }

    @Override
    public Integer getVidaActual() {
        return null;
    }

    @Override
    public EstadoEdificio ejecutarAccion() {
        return this;
    }

}
