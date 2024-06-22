package scubaDive;

import org.junit.Assert;
import org.junit.Test;

public class DivingTests
{
    private final double DELTA = 0.0000;
    DeepWaterDiver deepWaterDiver;
    Diving diving;
    @Test
    public void test_DeepWaterDiver_Constructor_Should_Initialize_Correctly()
    {
        deepWaterDiver = new DeepWaterDiver("Ludmil", 10.10);
        Assert.assertEquals("Ludmil", deepWaterDiver.getName());
        Assert.assertEquals(10.10, deepWaterDiver.getOxygen(), DELTA);
    }
    @Test
    public void test_Diving_Constructor_Should_Initialize_Correctly()
    {
        diving = new Diving("Dive", 5);
        Assert.assertEquals("Dive", diving.getName());
        Assert.assertEquals(5, diving.getCapacity());
        Assert.assertEquals(0, diving.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Diving_addDeepWaterDiver_Should_Throw_Exception_Full_Capacity()
    {
        diving = new Diving("Dive", 5);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("N1", 1.0);
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("N2", 2.0);
        DeepWaterDiver deepWaterDiver3 = new DeepWaterDiver("N3", 3.0);
        DeepWaterDiver deepWaterDiver4 = new DeepWaterDiver("N4", 4.0);
        DeepWaterDiver deepWaterDiver5 = new DeepWaterDiver("N5", 5.0);
        diving.addDeepWaterDiver(deepWaterDiver1);
        diving.addDeepWaterDiver(deepWaterDiver2);
        diving.addDeepWaterDiver(deepWaterDiver3);
        diving.addDeepWaterDiver(deepWaterDiver4);
        diving.addDeepWaterDiver(deepWaterDiver5);
        DeepWaterDiver deepWaterDiver6 = new DeepWaterDiver("N6", 6.0);
        diving.addDeepWaterDiver(deepWaterDiver6);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Diving_addDeepWaterDiver_Should_Throw_Exception_If_Diver_Exist()
    {
        diving = new Diving("Dive", 10);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("N1", 1.0);
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("N2", 2.0);
        DeepWaterDiver deepWaterDiver3 = new DeepWaterDiver("N3", 3.0);
        DeepWaterDiver deepWaterDiver4 = new DeepWaterDiver("N4", 4.0);
        DeepWaterDiver deepWaterDiver5 = new DeepWaterDiver("N5", 5.0);
        diving.addDeepWaterDiver(deepWaterDiver1);
        diving.addDeepWaterDiver(deepWaterDiver2);
        diving.addDeepWaterDiver(deepWaterDiver3);
        diving.addDeepWaterDiver(deepWaterDiver4);
        diving.addDeepWaterDiver(deepWaterDiver5);
        diving.addDeepWaterDiver(deepWaterDiver5);
    }
    @Test
    public void test_Diving_addDeepWaterDiver_Should_Increase_Count()
    {
        diving = new Diving("Dive", 10);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("N1", 1.0);
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("N2", 2.0);
        DeepWaterDiver deepWaterDiver3 = new DeepWaterDiver("N3", 3.0);
        DeepWaterDiver deepWaterDiver4 = new DeepWaterDiver("N4", 4.0);
        DeepWaterDiver deepWaterDiver5 = new DeepWaterDiver("N5", 5.0);
        diving.addDeepWaterDiver(deepWaterDiver1);
        diving.addDeepWaterDiver(deepWaterDiver2);
        diving.addDeepWaterDiver(deepWaterDiver3);
        diving.addDeepWaterDiver(deepWaterDiver4);
        diving.addDeepWaterDiver(deepWaterDiver5);
        Assert.assertEquals(5, diving.getCount());
    }
    @Test
    public void test_Diving_removeDeepWaterDiver_Should_Return_True_If_Diver_Exist()
    {
        diving = new Diving("Dive", 10);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("N1", 1.0);
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("N2", 2.0);
        DeepWaterDiver deepWaterDiver3 = new DeepWaterDiver("N3", 3.0);
        DeepWaterDiver deepWaterDiver4 = new DeepWaterDiver("N4", 4.0);
        DeepWaterDiver deepWaterDiver5 = new DeepWaterDiver("N5", 5.0);
        diving.addDeepWaterDiver(deepWaterDiver1);
        diving.addDeepWaterDiver(deepWaterDiver2);
        diving.addDeepWaterDiver(deepWaterDiver3);
        diving.addDeepWaterDiver(deepWaterDiver4);
        diving.addDeepWaterDiver(deepWaterDiver5);
        Assert.assertTrue(diving.removeDeepWaterDiver("N5"));
    }
    @Test
    public void test_Diving_removeDeepWaterDiver_Should_Return_False_If_Diver_Does_Not_Exist()
    {
        diving = new Diving("Dive", 10);
        DeepWaterDiver deepWaterDiver1 = new DeepWaterDiver("N1", 1.0);
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("N2", 2.0);
        DeepWaterDiver deepWaterDiver3 = new DeepWaterDiver("N3", 3.0);
        DeepWaterDiver deepWaterDiver4 = new DeepWaterDiver("N4", 4.0);
        DeepWaterDiver deepWaterDiver5 = new DeepWaterDiver("N5", 5.0);
        diving.addDeepWaterDiver(deepWaterDiver1);
        diving.addDeepWaterDiver(deepWaterDiver2);
        diving.addDeepWaterDiver(deepWaterDiver3);
        diving.addDeepWaterDiver(deepWaterDiver4);
        diving.addDeepWaterDiver(deepWaterDiver5);
        Assert.assertFalse(diving.removeDeepWaterDiver("N6"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Diving_setCapacity_Should_Throw_Exception_If_Capacity_Negative()
    {
        diving = new Diving("Dive", -1);

    }
    @Test(expected = NullPointerException.class)
    public void test_Diving_setName_Should_Throw_Exception_If_Name_Null()
    {
        diving = new Diving(null, 10);

    }
    @Test(expected = NullPointerException.class)
    public void test_Diving_setName_Should_Throw_Exception_If_Name_Empty()
    {
        diving = new Diving("  ", 10);

    }
}
