package com.company.vista.terreno;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Mapa extends Pane {

    private Canvas canvas;


    private final Integer CASILLEROS_DE_ANCHO = 10;
    private final Integer CASILLEROS_DE_ALTO = 10;
    private final Integer DIMENSION_CASILLERO = 2;

    private Casillero[][] casilleros;

    public Mapa(){

        canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GREEN);

        casilleros = new Casillero[CASILLEROS_DE_ANCHO][CASILLEROS_DE_ALTO];

        for(Integer y = 0; y < CASILLEROS_DE_ALTO; y++){
            for(Integer x = 0; x < CASILLEROS_DE_ANCHO; x++){
                Casillero casillero = new Casillero(x, y, DIMENSION_CASILLERO);
                casilleros[x][y] = casillero;
            }
        }
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
        //canvas.getGraphicsContext2D().fillOval(robot.getPosicion().getX() + 230, robot.getPosicion().getY() + 110, robot.RADIO, robot.RADIO);
    }

    public void clean() {

        canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    }

    public void update() {
        this.dibujar();
    }
}
