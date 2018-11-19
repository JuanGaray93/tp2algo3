package test.terreno;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.terreno.Casillero;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.terreno.Reptador;
import com.company.modelo.unidades.Aldeano;
import org.junit.Before;
import org.junit.Test;

public class ReptadorTest {

    private Reptador reptador;
    private Mapa mapa;

    @Before
    public void resetMapa() {
        mapa.destruir();
    }




}
