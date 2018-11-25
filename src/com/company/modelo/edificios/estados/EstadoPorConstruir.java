package com.company.modelo.edificios.estados;


import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioOcupadoException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.unidades.Aldeano;

public class EstadoPorConstruir extends EstadoEdificio {
    public EstadoPorConstruir(Integer vidaMaxima, Integer montoReparacion) {
        super(vidaMaxima, montoReparacion);
    }

    @Override
    public EstadoEdificio ejecutarAccion() {
        return this;
    }

    @Override
    public EstadoEdificio construir(Aldeano quienLoConstruye) throws EdificioOcupadoException, EdificioEnConstruccionException, EdificioEnReparacionException, EdificioDestruidoExcepcion {
        EstadoEdificio nuevoEstado = new EstadoEdificioEnConstruccion(VIDA_MAXIMA, MONTO_REPARACION);
        return nuevoEstado.construir(quienLoConstruye);
    }

    @Override
    public EstadoEdificio suspenderConstruccion() throws EdificioNoConstruidoException {
        throw new EdificioNoConstruidoException("El edificio todavia no se construyo");
    }

    @Override
    public Integer getVidaActual() throws EdificioNoConstruidoException {
        throw new EdificioNoConstruidoException("El edificio no esta construido");
    }

    @Override
    public EstadoEdificio reparar(Aldeano reparador, Integer montoDeReparacion) throws EdificioNoConstruidoException {
        throw new EdificioNoConstruidoException("Intenta reparar edificio no construido");
    }

    @Override
    public EstadoEdificio recibirDanio(Integer danio){
        throw new RuntimeException("El edifico no existe, no recibe danio");
    }

}
