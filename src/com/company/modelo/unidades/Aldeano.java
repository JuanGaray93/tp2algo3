package com.company.modelo.unidades;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioReparadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeano;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoConstruyendo;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoRecolectandoOro;
import com.company.modelo.unidades.estados.estadosAldeano.EstadoAldeanoReparando;

import java.util.ArrayList;

public class Aldeano extends Unidad {

	EstadoAldeano estadoActual;

	//LISTO
	public Aldeano(Jugador jugador) {
		super(jugador);
		estadoActual = new EstadoAldeanoRecolectandoOro(this);
		this.nombre = "ALDEANO";
	}

	private boolean existentesEnRadio(Edificio e){
		ArrayList<Posicionable> cercanos= this.posicion.buscarEnRadio(1);
		return cercanos.contains(e);
	}


	//LISTO
	public void construir(Edificio edificio,Integer x, Integer y) throws Exception, DistanciaInvalidaException {
		if(posicion.posicionEnRadio(x,y)){
			try {
                estadoActual = new EstadoAldeanoConstruyendo(this);
				estadoActual  = estadoActual.construir(edificio,x,y);
                edificio.construir(this,x,y);

            } catch (EdificioEnConstruccionException e) { }
			catch (CasilleroLlenoException e) { }
			catch (CasilleroNoExistenteException e) { }
			catch (MovimientoInvalidoException e) { }
		}else{

			throw new DistanciaInvalidaException("No puedo construir a esa distancia");
		}

	}

	//LISTO
	public void reparar(Edificio edificio) throws EdificioLejanoException {
        if(existentesEnRadio(edificio)){

            estadoActual = new EstadoAldeanoReparando(this);

			try {
                edificio.reparar(this);
				estadoActual  = estadoActual.reparar(edificio);

            } catch (EdificioReparadoException e) {
                //
            }  catch (EdificioEnConstruccionException e) {

            } catch (Exception e) {

            }

        }else{
            throw new EdificioLejanoException("Disculpe, esto esta muy lejos");
        }

    }

	public void liberar(){
		estadoActual = new EstadoAldeanoRecolectandoOro(this);
	}

	@Override
	public void recibirDanio(Integer montoDeDanio) {
		this.estadoActual.recibirDanio(montoDeDanio);
	}

    @Override
    public void actualizar() {

	    try{
            estadoActual.otorgarGanancia(jugador);
	    } catch(AldeanoOcupadoException e){
	       //si esta ocupado no hace nada, no suma oro

        }
    }

}
