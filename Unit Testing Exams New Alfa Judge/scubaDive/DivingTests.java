package scubaDive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivingTests
{
    Diving diving;
    DeepWaterDiver deepWaterDiver;
    double DELTA = 0.00;
    @Test
    public void test_DeepWaterDiver_Constructor_Should_Initialize_Correctly()
    {
        deepWaterDiver = new DeepWaterDiver("Ludmil", 10.00);
        Assertions.assertEquals("Ludmil", deepWaterDiver.getName());
        Assertions.assertEquals(10.00, deepWaterDiver.getOxygen(), DELTA);
    }

    @Test
    public void test_Diving_Constructor_Should_Initialize_Correctly()
    {
        diving = new Diving("Vetren", 3);
        Assertions.assertEquals("Vetren", diving.getName());
        Assertions.assertEquals(3, diving.getCapacity());
        Assertions.assertEquals(0, diving.getCount());
    }

    @Test
    public void test_Diving_addDeepWaterDiver_Should_Throws_Exception_If_Capacity_Full()
    {
        diving = new Diving("Vetren", 3);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("N1", 1.00);
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("N2", 2.00);
        DeepWaterDiver deepWaterDiver3 = new DeepWaterDiver("N3", 3.00);
        DeepWaterDiver deepWaterDiver4 = new DeepWaterDiver("N4", 4.00);
        diving.addDeepWaterDiver(deepWaterDiver1);
        diving.addDeepWaterDiver(deepWaterDiver2);
        diving.addDeepWaterDiver(deepWaterDiver3);
        assertThrows(IllegalArgumentException.class,
                () -> diving.addDeepWaterDiver(deepWaterDiver4),
                "No more places for this dive!");

    }

    @Test
    public void test_Diving_addDeepWaterDiver_Should_Throws_Exception_If_Diver_Exist()
    {
        diving = new Diving("Vetren", 10);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("N1", 1.00);
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("N2", 2.00);
        DeepWaterDiver deepWaterDiver3 = new DeepWaterDiver("N3", 3.00);

        diving.addDeepWaterDiver(deepWaterDiver1);
        diving.addDeepWaterDiver(deepWaterDiver2);
        diving.addDeepWaterDiver(deepWaterDiver3);
        assertThrows(IllegalArgumentException.class,
                () -> diving.addDeepWaterDiver(deepWaterDiver3),
                "The diver N3 is already in the dive!");

    }

    @Test
    public void test_Diving_removeDeepWaterDiver_Should_Return_True_If_Removal_Successful()
    {
        diving = new Diving("Vetren", 10);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("N1", 1.00);
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("N2", 2.00);
        DeepWaterDiver deepWaterDiver3 = new DeepWaterDiver("N3", 3.00);

        diving.addDeepWaterDiver(deepWaterDiver1);
        diving.addDeepWaterDiver(deepWaterDiver2);
        diving.addDeepWaterDiver(deepWaterDiver3);
        Assertions.assertTrue(diving.removeDeepWaterDiver("N2"));

    }

    @Test
    public void test_Diving_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {
        

        assertThrows(IllegalArgumentException.class,
                () -> new Diving("Vetren", -1),
                "Invalid capacity!");

    }

    @Test
    public void test_Diving_setName_Should_Throws_Exception_If_Name_Null()
    {
        

        assertThrows(NullPointerException.class,
                () -> new Diving(null, 10),
                "Invalid diving site!");

    }

    @Test
    public void test_Diving_setName_Should_Throws_Exception_If_Name_Empty()
    {
    

        assertThrows(NullPointerException.class,
                () -> new Diving("  ", 10),
                "Invalid diving site!");

    }
}
