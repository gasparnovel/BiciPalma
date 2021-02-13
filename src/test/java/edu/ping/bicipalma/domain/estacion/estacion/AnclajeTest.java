package edu.ping.bicipalma.domain.estacion.estacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ping.bicipalma.domain.bicicleta.Bicicleta;
import edu.ping.bicipalma.domain.estacion.Anclaje;

public class AnclajeTest {
    private Anclaje anclaje = null;
    private Bicicleta bici = null;

    @Before
    public void setup_Anclaje(){
        this.bici = new Bicicleta(180);
        this.anclaje = new Anclaje(true, this.bici);
        assertNotNull(anclaje);
        assertNotNull(bici);
    }

    @Test
    public void contructorAnclajeTest(){
        assertNotNull(this.bici);
        assertNotNull(this.anclaje);
    }

    @Test
    public void getIdTest(){
        assertEquals(180, anclaje.getBici().getId());
    }

    @Test
    public void isOcupadoTest(){
        assertTrue(this.anclaje.isOcupado());
    }

    @Test
    public void anclarBici(){
        Bicicleta bicicleta = new Bicicleta(1);
        this.anclaje.anclarBici(bicicleta);
        assertTrue(this.anclaje.isOcupado());
    }

    @Test 
    public void liberarBici(){
        this.anclaje.liberarBici();
        assertFalse(this.anclaje.isOcupado());
    }

    @Test
    public void toStringTest(){
        assertEquals("ocupada: true", anclaje.toString());
    }
}
