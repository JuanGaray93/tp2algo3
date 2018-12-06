package com.company.vista.gui.eventos.selecciones;

import com.company.DTO.Accion;
import javafx.scene.control.Alert;

public class GestorDeSelecciones {

    //private static Controlador controlador = Controlador.getControlador();
    //private static GeneradorDeBotones generadorDeBotones = GeneradorDeBotones.getGenerador();
    private static Integer xDelCasilleroDeOrigen;
    private static Integer yDelCasilleroDeOrigen;
    private static Accion accionAEjecutar;

    public static void seleccionarCasilleroOrigen(Integer x, Integer y){
        //EntidadDTO entidad= controlador.obtenerEntidad(x, y);
        //entidad.generarBotones();
        xDelCasilleroDeOrigen = x;
        yDelCasilleroDeOrigen = y;
    }

    public static void seleccionarAccion(Accion accion){
        accionAEjecutar = accion;
    }

    public static void seleccionarCasilleroDestino(Integer x, Integer y){
        try{
            //accionAEjecutar.llamarAccion(xDelCasilleroDeOrigen, yDelCasilleroDeOrigen, x, y);
            xDelCasilleroDeOrigen = -1;
            yDelCasilleroDeOrigen = -1;
            accionAEjecutar = null;
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atencion!");
            //alert.setHeaderText("Ejemplo de mensaje de alerta");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
