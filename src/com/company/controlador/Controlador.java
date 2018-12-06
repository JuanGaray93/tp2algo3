package com.company.controlador;

import com.company.DTO.Accion;
import com.company.DTO.EntidadDTO;
import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioEnReparacionException;
import com.company.excepciones.Edificio.EdificioNoDisponibleException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.edificios.Cuartel;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.*;
import com.company.vista.gui.eventos.*;
import com.company.vista.gui.eventos.AtacarHandler;
import com.company.vista.gui.eventos.ConstruirCuartelHandler;
import com.company.vista.gui.eventos.ConstruirPlazaCentralHandler;
import com.company.vista.gui.eventos.CrearAldeanoHandler;
import com.company.vista.gui.eventos.CrearArmaDeAsedioHandler;
import com.company.vista.gui.eventos.CrearArqueroHandler;
import com.company.vista.gui.eventos.CrearEspadachinHandler;
import com.company.vista.gui.eventos.DesmontarHandler;
import com.company.vista.gui.eventos.MontarHandler;
import com.company.vista.gui.eventos.MoverHandler;
import com.company.vista.gui.eventos.RepararHandler;

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

    public Posicionable obtenerContenidoDelCasillero(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException {
        return mapa.conseguirOcupante(posicionHorizontal, posicionVertical);
    }

    public void mover(Unidad unidad, Integer posicionHorizontal, Integer posicionVertical) throws ArmaMontadaException, CasilleroNoExistenteException, MovimientoInvalidoException, CasilleroLlenoException {
        unidad.moverA(posicionHorizontal,posicionVertical);
    }

    public void reparar(Aldeano aldeano, Edificio edificio) throws EdificioLejanoException {
        aldeano.reparar(edificio);
    }

    public void construirCuartel(Aldeano aldeano, Cuartel cuartel, Integer posicionHorizontal, Integer posicionVertical) throws Exception, EdificioEnConstruccionException {
        aldeano.construir(cuartel, posicionHorizontal, posicionVertical);
    }

    public void construirPlazaCentral(Aldeano aldeano, PlazaCentral plazaCentral, Integer posicionHorizontal, Integer posicionVertical) throws Exception, EdificioEnConstruccionException {
        aldeano.construir(plazaCentral, posicionHorizontal, posicionVertical);
    }

    public void atacar(UnidadAtacante unidad, Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException, ArmaDesmontadaException, EnemigoInvalidoException {
        Posicionable enemigo = mapa.conseguirOcupante(posicionHorizontal, posicionVertical);

        if(enemigo instanceof  Unidad) unidad.atacarA( (Unidad)enemigo );

        else unidad.atacarA( (Edificio)enemigo );
    }

    public void crearArmaDeAsedio(Castillo castillo, ArmaAsedio armaAsedio) throws CasilleroNoExistenteException, UnidadErroneaException, CasilleroLlenoException, MapaLlenoException {
        castillo.crear(armaAsedio);
    }

    public void crearEspadachin(Cuartel cuartel, Espadachin espadachin) throws CasilleroNoExistenteException, UnidadErroneaException, CasilleroLlenoException, MapaLlenoException, EdificioNoDisponibleException {
        cuartel.crear(espadachin);
    }

    public void crearArquero(Cuartel cuartel, Arquero arquero) throws CasilleroNoExistenteException, UnidadErroneaException, CasilleroLlenoException, MapaLlenoException, EdificioNoDisponibleException {
        cuartel.crear(arquero);
    }

    public void crearAldeano(PlazaCentral plazaCentral, Aldeano aldeano) throws CasilleroNoExistenteException, UnidadErroneaException, CasilleroLlenoException, MapaLlenoException, EdificioNoDisponibleException, EdificioEnConstruccionException, EdificioEnReparacionException {
        plazaCentral.crear(aldeano);
    }

    public void montar(ArmaAsedio armaAsedio) throws ArmaMontadaException {
        armaAsedio.montar();
    }

    public void desmontar(ArmaAsedio armaAsedio) throws ArmaMontadaException, ArmaDesmontadaException {
        armaAsedio.desmontar();
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
            Accion accion1 = new Accion("mover unidad aqui", new MoverHandler());
            Accion accion2 = new Accion("reparar este edificio", new RepararHandler());
            // un handler para construccion? o dos?
            Accion accion3 = new Accion("construir cuartel", new ConstruirCuartelHandler());
            Accion accion4 = new Accion("construir plaza central", new ConstruirPlazaCentralHandler());

            acciones.add(accion1);
            acciones.add(accion2);
            acciones.add(accion3);
            acciones.add(accion4);
        }

        if (nombrePosicionable.equals("Espadachin") || nombrePosicionable.equals("Arquero")){
            Accion accion1 = new Accion("mover unidad aqui", new MoverHandler());
            Accion accion2 = new Accion("atacar", new AtacarHandler());

            acciones.add(accion1);
            acciones.add(accion2);
        }

        if(nombrePosicionable.equals("ArmaAsedio")){
            Accion accion1 = new Accion("mover unidad aqui", new MoverHandler());
            Accion accion2 = new Accion("atacar", new AtacarHandler());
            Accion accion3 = new Accion("montar", new MontarHandler());
            Accion accion4 = new Accion("desmontar", new DesmontarHandler());

            acciones.add(accion1);
            acciones.add(accion2);
            acciones.add(accion3);
            acciones.add(accion4);
        }

        if (nombrePosicionable.equals("Castillo")){
            Accion accion1 = new Accion("crear arma de asedio", new CrearArmaDeAsedioHandler());

            acciones.add(accion1);
        }

        if (nombrePosicionable.equals("Cuartel")){
            Accion accion1 = new Accion("crear espadachin", new CrearEspadachinHandler());
            Accion accion2 = new Accion("crear arquero", new CrearArqueroHandler());

            acciones.add(accion1);
            acciones.add(accion2);
        }

        if (nombrePosicionable.equals("PlazaCentral")){
            Accion accion1 = new Accion("crear aldeano", new CrearAldeanoHandler());

            acciones.add(accion1);
        }

        return acciones;
    }
}
