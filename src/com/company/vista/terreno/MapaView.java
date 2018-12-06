package com.company.vista.terreno;

import com.company.DTO.EntidadDTO;
import com.company.controlador.Controlador;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.vista.terreno.entidades.Casillero;
import javafx.scene.layout.GridPane;

public class MapaView extends GridPane {

    private static MapaView instancia = new MapaView();

    private final Integer CASILLEROS_DE_ANCHO = 25;
    private final Integer CASILLEROS_DE_ALTO = 25;
    private Float dimensionCasillero = 25.0F;
    private Controlador controlador = Controlador.getControlador();

    private MapaView(){
        this.actualizarCasilleros();
        this.setHgap(dimensionCasillero / 20);
        this.setVgap(dimensionCasillero / 20);
    }

    public void actualizarCasilleros(){
        for(Integer y = 0; y < CASILLEROS_DE_ALTO; y++){
            for(Integer x = 0; x < CASILLEROS_DE_ANCHO; x++){
                try {
                    EntidadDTO entidad = controlador.buscarContenidoDelCasillero(x,y);
                    Casillero casilleroNuevo = new Casillero(x, y, dimensionCasillero, this,
                            entidad);
                    establecerCasillero(casilleroNuevo);
                    casilleroNuevo.mostrarEtiqueta();
                } catch (CasilleroNoExistenteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void establecerCasillero(Casillero casilleroNuevo){
        GridPane.setRowIndex(casilleroNuevo, casilleroNuevo.getFila() );
        GridPane.setColumnIndex(casilleroNuevo, casilleroNuevo.getColumna());
        this.getChildren().addAll(casilleroNuevo);
    }

    public static MapaView getMapa(){
        if(instancia == null){
            instancia = new MapaView();
        }
        return instancia;
    }

}