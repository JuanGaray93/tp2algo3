package com.company.modelo;

import com.company.excepciones.*;
import com.company.modelo.edificios.Castillo;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.edificios.PlazaCentral;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

import java.util.ArrayList;

public class Jugador {

    private final static Integer LIMITE_POBLACIONAL = 50;
    private static Integer jugadoresCreados = 0;
    private Integer numeroDeJugador;


    ArrayList<Unidad> poblacion;
    ArrayList<Edificio> edificios;
    private static Integer oro;

    public Jugador() {
        this.oro = 100;
        jugadoresCreados++;
        this.numeroDeJugador = jugadoresCreados;
        poblacion = new ArrayList<Unidad>();
        edificios = new ArrayList<Edificio>();

    }
	/*
	 *No creo que sea necesario ver que pasa si el casillero esta lleno, la view podria mostrar en verde los casilleros
	 * libres y validos a los que se puede mover la unidad y en rojo a los casilleros invalidos u ocupados. (soy Martín)
	public void mover(Unidad unidad, Integer x, Integer y) throws CasilleroNoExistenteException {
		try {
			unidad.moverA(x,y);
		} catch (CasilleroLlenoException e) {
			// TODO si el casillero esta lleno...
		}
	}*/

    public Integer getOro() {
        return this.oro;
    }

    public void agregarAPoblacion(Unidad unidad) {

        if (poblacion.size() == LIMITE_POBLACIONAL) {
            throw new LimitePoblacionalException("Alcanzaste el limite permitido de unidades");
        }

        poblacion.add(unidad);
    }

    public void agregarAEdificios(Edificio unEdificio) {
        edificios.add(unEdificio);
    }

    public void eliminarDePoblacion(Unidad unidad) {
        if (!poblacion.contains(unidad)) {
            throw new UnidadInexistenteEnPoblacionException
                    ("Disculpe, la unidad no existe en la poblacion");
        }
        poblacion.remove(unidad);

    }

    public void eliminarDeConstrucciones(Edificio edificio) {
        if (!edificios.contains(edificio)) {

            throw new EdificioInexistenteEnConstruccionesException("No existe tal edificio");
        }
        edificios.remove(edificio);
    }

    public void sumarOro(Integer produccionOro) {
        this.oro += produccionOro;

    }

    public void cobrar(Integer monto) throws OroInsuficienteException {
        if (monto < 0) {
            throw new OroInsuficienteException
                    ("Se intentó hacer un cobro negativo. Algo salió horriblemente mal.");
        } else if (oro - monto < 0) {
            throw new OroInsuficienteException
                    ("Se intentó hacer un cobro negativo. Algo salió horriblemente mal.");
        }

        oro -= monto;
    }

    // hay que tener una forma de testear la creacion de unidades.
    public Boolean estaEnPoblacion(Unidad unidad) {
        return poblacion.contains(unidad);
    }


    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }

    public ArrayList<Unidad> getPoblacion() {
        return poblacion;
    }

	/*
	public void actualizar() {
		
	}*/

    public void crearEntidadesIniciales() throws CasilleroNoExistenteException, CasilleroLlenoException {
        Iniciador iniciador = new Iniciador(this);
        iniciador.crearEntidadesIniciales();

        /*Integer posicionInicialX = 0;
        Integer posicionInicialY = 0;

        if (this.numeroDeJugador == 1) {
            posicionInicialX = 1;
            posicionInicialY = 1;
        } else {
            posicionInicialX = 80;
            posicionInicialY = 80;
        }

        poblacion.add(new Aldeano(this));
        poblacion.add(new Aldeano(this));
        poblacion.add(new Aldeano(this));

        poblacion.get(0).establecerCoordenadasDeNacimiento(5 +
                posicionInicialX, +posicionInicialY);
        poblacion.get(1).establecerCoordenadasDeNacimiento(6 +
                posicionInicialX, +posicionInicialY);
        poblacion.get(2).establecerCoordenadasDeNacimiento(7 +
                posicionInicialX, +posicionInicialY);

        Castillo castillo = new Castillo(this);
        PlazaCentral plaza = new PlazaCentral(this);

        // castillo.construir((Aldeano) poblacion.get(0), 5 + posicionInicialX, 5 + posicionInicialY);
        // plaza.construir((Aldeano) poblacion.get(1), 5 + posicionInicialX, 10 + posicionInicialY);

        edificios.add(castillo);
        edificios.add(plaza);*/
    }

}
