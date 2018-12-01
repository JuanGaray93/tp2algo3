package com.company.vista.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class PopupExcepcionHandler implements EventHandler<ActionEvent> {

    private String mensaje = "";

    public void establecerMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atencion!");
        //alert.setHeaderText("Ejemplo de mensaje de alerta");
        alert.setContentText(mensaje);
        alert.show();
    }
}
