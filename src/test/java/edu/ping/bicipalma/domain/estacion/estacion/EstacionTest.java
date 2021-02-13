package edu.ping.bicipalma.domain.estacion.estacion;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.ping.bicipalma.domain.estacion.Estacion;

public class EstacionTest {
    
    private Estacion estacion = null;

    @Before
    public void setup_Estacion(){
        this.estacion = new Estacion(1, "Manacor", 4);
        assertNotNull(estacion);
    }

    @Test
    public void contructorTest(){
        assertNotNull(this.estacion);
    }

    @Test 
    public void getIdTest(){
        assertEquals(1, this.estacion.getId());
    }

    @Test
    public void getDireccion(){
        assertEquals("Manacor", this.estacion.getDireccion());
    }
}
