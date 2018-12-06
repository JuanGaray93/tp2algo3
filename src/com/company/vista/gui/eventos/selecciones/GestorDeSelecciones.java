package com.company.vista.gui.eventos.selecciones;

import com.company.DTO.Accion;
import com.company.DTO.EntidadDTO;
import com.company.controlador.Controlador;
import com.company.excepciones.ArmaDesmontadaException;
import com.company.excepciones.ArmaMontadaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioNoDisponibleException;
import javafx.scene.control.Alert;

public class GestorDeSelecciones {

    private static Controlador controlador = Controlador.getControlador();
    private static Integer xDelCasilleroDeOrigen;
    private static Integer yDelCasilleroDeOrigen;
    private static Accion accionAEjecutar;

    public static void seleccionarCasilleroOrigen(Integer x, Integer y){
        EntidadDTO entidad= controlador.buscarContenidoDelCasillero(x, y);
        entidad.generarBotones();
        xDelCasilleroDeOrigen = x;
        yDelCasilleroDeOrigen = y;
    }

    public static void seleccionarAccion(Accion accion){
        accionAEjecutar = accion;
    }

    public static void seleccionarCasilleroDestino(Integer x, Integer y) {
        try {
            accionAEjecutar.llamarAccion(xDelCasilleroDeOrigen, yDelCasilleroDeOrigen, x, y);
            reiniciarOpciones();
        } catch (NullPointerException npe){
            System.out.println("No se selecciono ningun casillero");
            return;
        } catch (Exception | ArmaMontadaException | EdificioNoDisponibleException | ArmaDesmontadaException | EdificioEnConstruccionException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atencion!");
            //alert.setHeaderText("Ejemplo de mensaje de alerta");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    private static void reiniciarOpciones(){
        xDelCasilleroDeOrigen = -1;
        yDelCasilleroDeOrigen = -1;
        accionAEjecutar = null;
    }

    public static void pasarTurno(){
        //  TODO  controlador.pasarTurno();
        reiniciarOpciones();
        //TODO pasarle los datos a la barra lateral! numero de jugador, poblacion, etc.
        //EntidadDTO jugadorNuevo = Controlador.obtenerJugador();
        //jugadorNuevo.mostrarInformacion();
    }
}
