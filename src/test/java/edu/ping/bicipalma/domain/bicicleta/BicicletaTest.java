package edu.ping.bicipalma.domain.bicicleta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class BicicletaTest {
    
    private Bicicleta bicicleta = null;

    @Before
    public void setup_Bicicleta(){
        this.bicicleta = new Bicicleta(190);
        assertNotNull(bicicleta);
    }

    @Test
    public void constructorBicicletaTest(){
        assertNotNull(this.bicicleta);
    }

    @Test
    public void getIdTest(){
        assertEquals(190, this.bicicleta.getId());
    }
}
