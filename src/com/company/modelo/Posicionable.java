package com.company.modelo;

import com.company.excepciones.CasilleroNoExistenteException;

public interface Posicionable {

    void recibirDanio(int unDanio);

    void eliminar() throws CasilleroNoExistenteException;

}
