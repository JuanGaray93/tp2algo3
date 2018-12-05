package com.company.controlador;

import com.company.DTO.Accion;
import com.company.DTO.EntidadDTO;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.terreno.Mapa;

import java.util.ArrayList;

public class Controlador {

    private static Controlador instancia = new Controlador();

    Mapa mapa = Mapa.getMapa();


    public static Controlador getControlador(){
        if (instancia == null){
            instancia = new Controlador();
        }
        return instancia;
    }

    public EntidadDTO buscarContenidoDelCasillero(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException {
        Posicionable posicionable = mapa.conseguirOcupante(posicionHorizontal, posicionVertical);
        EntidadDTO entidad = null;
        if (posicionable != null) {
            String nombrePosicionable = posicionable.getClass().getSimpleName();
            Jugador jugador = posicionable.getJugador();
            Integer numeroJugador = jugador.getNumeroDeJugador();
            ArrayList<Accion> acciones = devolverAcciones(nombrePosicionable);
            entidad = new EntidadDTO(numeroJugador, nombrePosicionable, acciones );
        }
       return entidad;
    }

    private ArrayList<Accion> devolverAcciones(String nombrePosicionable){
        ArrayList<Accion> acciones = new ArrayList<Accion>();

        if (nombrePosicionable.equals("Aldeano")){
            Accion accion1 = new Accion("mover unidad aqui");
            Accion accion2 = new Accion("reparar este edificio");
            Accion accion3 = new Accion("construir cuartel");
            Accion accion4 = new Accion("construir plaza central");

            acciones.add(accion1);
            acciones.add(accion2);
            acciones.add(accion3);
            acciones.add(accion4);
        }

        if (nombrePosicionable.equals("Espadachin") || nombrePosicionable.equals("Arquero") ){
            Accion accion1 = new Accion("mover unidad aqui");
            Accion accion2 = new Accion("atacar esta unidad");
            Accion accion3 = new Accion("atacar este edificio");

            acciones.add(accion1);
            acciones.add(accion2);
            acciones.add(accion3);
        }

        if (nombrePosicionable.equals("ArmaAsedio")){
            Accion accion1 = new Accion("mover unidad aqui");
            Accion accion2 = new Accion("atacar este edificio");

            acciones.add(accion1);
            acciones.add(accion2);
        }

        if (nombrePosicionable.equals("Castillo")){
            Accion accion1 = new Accion("crear arma de asedio");

            acciones.add(accion1);
        }

        if (nombrePosicionable.equals("Cuartel")){
            Accion accion1 = new Accion("crear espadachin");
            Accion accion2 = new Accion("crear arquero");

            acciones.add(accion1);
            acciones.add(accion2);
        }

        if (nombrePosicionable.equals("PlazaCentral")){
            Accion accion1 = new Accion("crear aldeano");

            acciones.add(accion1);
        }

        return acciones;
    }
}
