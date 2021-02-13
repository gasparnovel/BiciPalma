package edu.ping.bicipalma.domain.estacion.estacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.ping.bicipalma.domain.estacion.Anclaje;

public class AnclajesTest {
    
    private Anclaje[] anclajes= null;

    @Before
    public void setup_Anclajes(){
        this.anclajes = new Anclaje[2];
        assertNotNull(anclajes);
    }

    @Test
    public void contructorAnclajesTest(){
        assertNotNull(this.anclajes);
    }

    @Test
    public void numAnclajesTest(){
        assertEquals(2, this.anclajes.length);
    }

}
