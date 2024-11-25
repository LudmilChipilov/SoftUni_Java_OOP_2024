package archeologicalExcavations;

import org.junit.Test;
import org.junit.Assert;

public class ExcavationTests
{
    private final double DELTA = 0.0000;
    Archaeologist archaeologist;
    Excavation excavation;
    @Test
    public void test_Archaeologist_Constructor_Should_Initialize_Correctly()
    {
        archaeologist = new Archaeologist("Ludmil", 5);
        Assert.assertEquals("Ludmil", archaeologist.getName());
        Assert.assertEquals(5, archaeologist.getEnergy(), DELTA);
    }
    @Test
    public void test_Excavation_Constructor_Should_Initialize_Correctly()
    {
        excavation = new Excavation("Vetren", 5);
        Assert.assertEquals("Vetren", excavation.getName());
        Assert.assertEquals(5, excavation.getCapacity());
        Assert.assertEquals(0, excavation.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Excavation_addArchaeologist_Should_Throws_Exception_If_Full_Capacity()
    {
        excavation = new Excavation("Vetren", 5);
        Archaeologist archaeologist1 = new Archaeologist("N1", 1);
        Archaeologist archaeologist2 = new Archaeologist("N2", 2);
        Archaeologist archaeologist3 = new Archaeologist("N3", 3);
        Archaeologist archaeologist4 = new Archaeologist("N4", 4);
        Archaeologist archaeologist5 = new Archaeologist("N5", 5);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        excavation.addArchaeologist(archaeologist4);
        excavation.addArchaeologist(archaeologist5);
        Archaeologist archaeologist6 = new Archaeologist("N6", 6);
        excavation.addArchaeologist(archaeologist6);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Excavation_addArchaeologist_Should_Throws_Exception_If_Archeologist_Exist()
    {
        excavation = new Excavation("Vetren", 10);
        Archaeologist archaeologist1 = new Archaeologist("N1", 1);
        Archaeologist archaeologist2 = new Archaeologist("N2", 2);
        Archaeologist archaeologist3 = new Archaeologist("N3", 3);
        Archaeologist archaeologist4 = new Archaeologist("N4", 4);
        Archaeologist archaeologist5 = new Archaeologist("N5", 5);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        excavation.addArchaeologist(archaeologist4);
        excavation.addArchaeologist(archaeologist5);

        excavation.addArchaeologist(archaeologist5);
    }
    @Test
    public void test_Excavation_addArchaeologist_Should_Increase_Count()
    {
        excavation = new Excavation("Vetren", 10);
        Archaeologist archaeologist1 = new Archaeologist("N1", 1);
        Archaeologist archaeologist2 = new Archaeologist("N2", 2);
        Archaeologist archaeologist3 = new Archaeologist("N3", 3);
        Archaeologist archaeologist4 = new Archaeologist("N4", 4);
        Archaeologist archaeologist5 = new Archaeologist("N5", 5);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        excavation.addArchaeologist(archaeologist4);
        excavation.addArchaeologist(archaeologist5);

        Assert.assertEquals(5, excavation.getCount());
    }
    @Test
    public void test_Excavation_removeArchaeologist_Should_Return_True_If_Removal_Successful()
    {
        excavation = new Excavation("Vetren", 10);
        Archaeologist archaeologist1 = new Archaeologist("N1", 1);
        Archaeologist archaeologist2 = new Archaeologist("N2", 2);
        Archaeologist archaeologist3 = new Archaeologist("N3", 3);
        Archaeologist archaeologist4 = new Archaeologist("N4", 4);
        Archaeologist archaeologist5 = new Archaeologist("N5", 5);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        excavation.addArchaeologist(archaeologist4);
        excavation.addArchaeologist(archaeologist5);

        Assert.assertTrue(excavation.removeArchaeologist("N5"));
    }
    @Test
    public void test_Excavation_removeArchaeologist_Should_Return_False_If_Removal_Is_Not_Successful()
    {
        excavation = new Excavation("Vetren", 10);
        Archaeologist archaeologist1 = new Archaeologist("N1", 1);
        Archaeologist archaeologist2 = new Archaeologist("N2", 2);
        Archaeologist archaeologist3 = new Archaeologist("N3", 3);
        Archaeologist archaeologist4 = new Archaeologist("N4", 4);
        Archaeologist archaeologist5 = new Archaeologist("N5", 5);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        excavation.addArchaeologist(archaeologist4);
        excavation.addArchaeologist(archaeologist5);
        Assert.assertFalse(excavation.removeArchaeologist("N6"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Excavation_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {
        excavation = new Excavation("Vetren", -1);

    }
    @Test(expected = NullPointerException.class)
    public void test_Excavation_setName_Should_Throws_Exception_If_Name_Null()
    {
        excavation = new Excavation(null, 10);

    }
    @Test(expected = NullPointerException.class)
    public void test_Excavation_setName_Should_Throws_Exception_If_Name_WhiteSpace()
    {
        excavation = new Excavation("  ", 10);

    }
}

