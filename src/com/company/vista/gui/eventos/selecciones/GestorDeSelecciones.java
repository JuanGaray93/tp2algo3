package com.company.vista.gui.eventos.selecciones;

import com.company.DTO.Accion;
import com.company.DTO.EntidadDTO;
import com.company.DTO.JugadorDTO;
import com.company.controlador.Controlador;
import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioNoDisponibleException;
import com.company.modelo.terreno.Mapa;
import com.company.vista.gui.GeneradorDeBotones;
import com.company.vista.terreno.MapaView;
import javafx.scene.control.Alert;

public class GestorDeSelecciones {

    private static Controlador controlador = Controlador.getControlador();
    private static Integer xDelCasilleroDeOrigen;
    private static Integer yDelCasilleroDeOrigen;
    private static Accion accionAEjecutar;
    private static GeneradorDeBotones generadorDeBotones = GeneradorDeBotones.getGenerador();

    public static void seleccionarCasilleroOrigen(Integer x, Integer y){
        EntidadDTO entidad= controlador.buscarContenidoDelCasillero(x, y);

        if(entidad != null){
            entidad.generarBotones();
        } else {
            generadorDeBotones.limpiarBotonera();
        }
        xDelCasilleroDeOrigen = x;
        yDelCasilleroDeOrigen = y;
    }

    public static void seleccionarAccion(Accion accion){
        accionAEjecutar = accion;
    }

    public static void seleccionarCasilleroDestino(Integer x, Integer y) {
        try {
            accionAEjecutar.llamarAccion(xDelCasilleroDeOrigen, yDelCasilleroDeOrigen, x, y);
            pasarTurno();
        } catch (NullPointerException npe){
            if(xDelCasilleroDeOrigen == -1){
                System.out.println("No se selecciono ningun casillero");
            }
            return;
        } catch (Exception | ArmaMontadaException | EdificioNoDisponibleException | ArmaDesmontadaException | EdificioEnConstruccionException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atencion!");
            alert.setHeaderText(e.getMessage());
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    private static void reiniciarOpciones(){
        xDelCasilleroDeOrigen = -1;
        yDelCasilleroDeOrigen = -1;
        accionAEjecutar = null;
        generadorDeBotones.limpiarBotonera();
    }

    public static void pasarTurno() {
        controlador.pasarTurno();
        reiniciarOpciones();
        MapaView.getMapa().actualizarCasilleros();
        //TODO pasarle los datos a la barra lateral! numero de jugador, poblacion, etc.
        JugadorDTO jugadorNuevo = controlador.obtenerJugadorActual();
        //jugadorNuevo.mostrarInformacion();
    }
}
