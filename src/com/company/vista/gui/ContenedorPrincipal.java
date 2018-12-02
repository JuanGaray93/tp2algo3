package com.company.vista.gui;

import com.company.vista.terreno.Mapa;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    Mapa mapa;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorPrincipal(){
        Node appContent = new Mapa();
        setCenter(appContent);
    }

}
