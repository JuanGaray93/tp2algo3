package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.MontoErroneoError;
import com.company.excepciones.OroInsuficienteException;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

import java.util.ArrayList;

public class Jugador {

    private final Integer LIMITE_POBLACIONAL = 50;

    ArrayList<Unidad> poblacion;
    ArrayList <Edificio> edificios;
    private static Integer oro;

    public Jugador(Mapa mapa) throws CasilleroLlenoException {
        this.oro = 100;
    }

    public void mover(Unidad unidad, Integer coordenadaHorizontal, Integer coordenadaVertical) throws CasilleroNoExistenteException {
        try {
            unidad.moverA(coordenadaHorizontal, coordenadaVertical);
        } catch (CasilleroLlenoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Integer getOro(){
        return this.oro;
    }

    public void agregarAPoblacion(Unidad unidad) {

        if(poblacion.size() == LIMITE_POBLACIONAL) {
            throw new LimitePoblacionalException("Alcanzaste el limite permitido de unidades");
        }

        poblacion.add(unidad);
    }

    public void eliminarDePoblacion(Unidad unidad) {

        if(!poblacion.contains(unidad)){
            throw new UnidadInexistenteEnPoblacionException("Disculpe, la unidad no existe en la poblacion");
        }

        poblacion.remove(unidad);
    }

    public boolean tieneOro(Integer oro) {
        return this.oro == oro;
    }

    public void sumarOro(Integer produccionOro) {
        this.oro += produccionOro;

    }

    public void cobrar(Integer monto) throws OroInsuficienteException, MontoErroneoError {

        if(monto < 0){
            throw new MontoErroneoError("Se intentó hacer un cobro negativo. Algo salió horriblemente mal.");
        }

        if (oro - monto < 0){
            throw new OroInsuficienteException("El monto es mayor que los fondos actuales");
        }

        oro -= monto;
    }

    public void actualizar() {

    }

    public void crearEntidadesIniciales(Posicion posCastillo, Posicion posPlaza, Posicion posPriAldeano, Posicion posSegAldeano, Posicion posTerAldeano){
        //Le pasa el mapa a los edificios para permitirles ubicar unidades con su posicion

        Castillo castillo = new Castillo(this);

        try {
            castillo.construir(posCastillo.obtenerPosicionHorizontal(), posCastillo.obtenerPosicionVertical());
        } catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }
        edificios.add(castillo);

        PlazaCentral plaza = new PlazaCentral(this);

        try {
            plaza.construir(posPlaza.obtenerPosicionHorizontal(), posPlaza.obtenerPosicionVertical());
        } catch (CasilleroLlenoException e) {
            e.printStackTrace();
        }
        edificios.add(plaza);

        poblacion.add(new Aldeano(this));
        poblacion.add(new Aldeano(this));
        poblacion.add(new Aldeano(this));

        poblacion.get(0).establecerCoordenadasDeNacimiento(posPriAldeano.obtenerPosicionHorizontal(), posPriAldeano.obtenerPosicionVertical());
        poblacion.get(1).establecerCoordenadasDeNacimiento(posSegAldeano.obtenerPosicionHorizontal(), posSegAldeano.obtenerPosicionVertical());
        poblacion.get(2).establecerCoordenadasDeNacimiento(posTerAldeano.obtenerPosicionHorizontal(), posTerAldeano.obtenerPosicionVertical());
    }

    public void eliminarDeConstrucciones(Edificio edificio) {

        if(!edificios.contains(edificio)){
            throw new EdificioInexistenteEnConstruccionesException("No existe tal edificio");
        }

        edificios.remove(edificio);
    }
}
