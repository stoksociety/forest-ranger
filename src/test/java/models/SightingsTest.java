package models;

import org.junit.Test;
import static org.junit.Assert.*;

class SightingsTest {
    @Test
public void getrangerName(){
        Sighting testSighting = new Sighting("Arnold","Runda","tiger","bad","young");
       assertEquals("Arnold",testSighting.getRangerName());
    }
public void getlocation(){
        Sighting testSighting = new Sighting("Arnold","Runda","tiger","bad","young");
        assertEquals("Arnold",testSighting.getLocation());
    }
}