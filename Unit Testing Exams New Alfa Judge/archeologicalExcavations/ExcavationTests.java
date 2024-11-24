package archeologicalExcavations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExcavationTests
{
     Archaeologist archaeologist;
     Excavation excavation;
     private final static double DELTA = 0.00;
     @Test
    public void test_Archaeologist_Constructor_Should_Initialize_Correctly()
     {
         archaeologist = new Archaeologist("Ludmil", 10.50);
         Assertions.assertEquals("Ludmil", archaeologist.getName());
         Assertions.assertEquals(10.50, archaeologist.getEnergy(), DELTA);
     }
    @Test
    public void test_Excavation_Constructor_Should_Initialize_Correctly()
    {
        excavation = new Excavation("Vetren", 5);
        Assertions.assertEquals("Vetren", excavation.getName());
        Assertions.assertEquals(5, excavation.getCapacity());
        Assertions.assertEquals(0, excavation.getCount());
    }
    @Test
    public void test_Excavation_addArchaeologist_Should_Throws_Exception_If_Full_Capacity()
    {
        excavation = new Excavation("Vetren", 5);
        Archaeologist archaeologist1 = new Archaeologist("N1", 1.5);
        Archaeologist archaeologist2 = new Archaeologist("N2", 2.5);
        Archaeologist archaeologist3 = new Archaeologist("N3", 3.5);
        Archaeologist archaeologist4 = new Archaeologist("N4", 4.5);
        Archaeologist archaeologist5 = new Archaeologist("N5", 5.5);
        Archaeologist archaeologist6 = new Archaeologist("N6", 6.5);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        excavation.addArchaeologist(archaeologist4);
        excavation.addArchaeologist(archaeologist5);
        assertThrows(IllegalArgumentException.class,
                () -> excavation.addArchaeologist(archaeologist6),
                "No more excavation!");


    }
    @Test
    public void test_Excavation_addArchaeologist_Should_Throws_Exception_If_Archaeologist_Exist()
    {
        excavation = new Excavation("Vetren", 10);
        Archaeologist archaeologist1 = new Archaeologist("N1", 1.5);
        Archaeologist archaeologist2 = new Archaeologist("N2", 2.5);
        Archaeologist archaeologist3 = new Archaeologist("N3", 3.5);
        Archaeologist archaeologist4 = new Archaeologist("N4", 4.5);
        Archaeologist archaeologist5 = new Archaeologist("N5", 5.5);
        Archaeologist archaeologist6 = new Archaeologist("N6", 6.5);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        excavation.addArchaeologist(archaeologist4);
        excavation.addArchaeologist(archaeologist5);
        assertThrows(IllegalArgumentException.class,
                () -> excavation.addArchaeologist(archaeologist5),
                "The archaeologist is already in the excavation!");


    }
    @Test
    public void test_Excavation_removeArchaeologist_Should_Return_True_If_Removal_Successful()
    {
        excavation = new Excavation("Vetren", 10);
        Archaeologist archaeologist1 = new Archaeologist("N1", 1.5);
        Archaeologist archaeologist2 = new Archaeologist("N2", 2.5);
        Archaeologist archaeologist3 = new Archaeologist("N3", 3.5);
        Archaeologist archaeologist4 = new Archaeologist("N4", 4.5);
        Archaeologist archaeologist5 = new Archaeologist("N5", 5.5);

        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        excavation.addArchaeologist(archaeologist4);
        excavation.addArchaeologist(archaeologist5);
        Assertions.assertTrue(excavation.removeArchaeologist("N4"));
    }
    @Test
    public void test_Excavation_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {
        

        assertThrows(IllegalArgumentException.class,
                () -> new Excavation("Vetren", -1),
                "Invalid capacity!");


    }
    @Test
    public void test_Excavation_setName_Should_Throws_Exception_If_Name_Null()
    {
        

        assertThrows(NullPointerException.class,
                () -> new Excavation(null, 10),
                "Invalid excavation name!");


    }
    @Test
    public void test_Excavation_setName_Should_Throws_Exception_If_Name_Whitespace()
    {
        

        assertThrows(NullPointerException.class,
                () -> new Excavation("  ", 10),
                "Invalid excavation name!");


    }
}
