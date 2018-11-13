package edificios;

import org.junit.Test;

public class CastilloTest {
    /*castillo crea arma de asedio*/
    @Test
    public void creaArmaDeAsedioTest(){
        Asedio asedio = new Asedio();
        asedio.crearArmaDeAsedio();
    }
}
