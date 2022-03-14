package models;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {
@Test
public void animal_instantiatescorrectly_true(){
    Animal testAnimal =new Animal("tiger", "bad" ,"0" );
    assertEquals(true, testAnimal instanceof Animal);
}
@Test
    public void animal_instantiatewithName_true(){
    Animal testAnimal = new Animal("tiger","bad","young");
    assertEquals(true,testAnimal.getName());
}
    @Test
    public void animal_InstantiateWithAge_true() {
        Animal testAnimal = new Animal("tiger","bad","young");
        Assert.assertEquals("young", testAnimal.getAge());


    }
    @Test
    public void animal_InstantiateWithHealth_true() {
        Animal testAnimal = new Animal("tiger","bad","young");
        Assert.assertEquals("bad", testAnimal.getHealth());


    }
}



