package stuntClimb;


import org.junit.Test;
import org.junit.Assert;

public class ClimbingTests
{
    private final double DELTA = 0.0000;
    RockClimber rockClimber;
    Climbing climbing;
    @Test
    public void test_RockClimber_Constructor_Should_Initialize_Correctly()
    {
        rockClimber = new RockClimber("Ro", 20.20);
        Assert.assertEquals("Ro", rockClimber.getName());
        Assert.assertEquals(20.20, rockClimber.getStrength(), DELTA);
    }
    @Test
    public void test_Climbing_Constructor_Should_Initialize_Correctly()
    {
        climbing = new Climbing("Ludmil", 5);
        Assert.assertEquals("Ludmil", climbing.getName());
        Assert.assertEquals(5, climbing.getCapacity());
        Assert.assertEquals(0, climbing.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Climbing_addRockClimber_Should_Throw_Exception_Full_Capacity()
    {
        climbing = new Climbing("Ludmil", 5);
        RockClimber rockClimber1 = new RockClimber("N1", 1.0);
        RockClimber rockClimber2 = new RockClimber("N2", 2.0);
        RockClimber rockClimber3 = new RockClimber("N3", 3.0);
        RockClimber rockClimber4 = new RockClimber("N4", 4.0);
        RockClimber rockClimber5 = new RockClimber("N5", 5.0);
        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
        climbing.addRockClimber(rockClimber4);
        climbing.addRockClimber(rockClimber5);
        RockClimber rockClimber6 = new RockClimber("N6", 6.0);
        climbing.addRockClimber(rockClimber6);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Climbing_addRockClimber_Should_Throw_Exception_If_Climber_Already_Added()
    {
        climbing = new Climbing("Ludmil", 10);
        RockClimber rockClimber1 = new RockClimber("N1", 1.0);
        RockClimber rockClimber2 = new RockClimber("N2", 2.0);
        RockClimber rockClimber3 = new RockClimber("N3", 3.0);
        RockClimber rockClimber4 = new RockClimber("N4", 4.0);
        RockClimber rockClimber5 = new RockClimber("N5", 5.0);
        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
        climbing.addRockClimber(rockClimber4);
        climbing.addRockClimber(rockClimber5);

        climbing.addRockClimber(rockClimber5);

    }
    @Test
    public void test_Climbing_addRockClimber_Should_Increase_Count()
    {
        climbing = new Climbing("Ludmil", 10);
        RockClimber rockClimber1 = new RockClimber("N1", 1.0);
        RockClimber rockClimber2 = new RockClimber("N2", 2.0);
        RockClimber rockClimber3 = new RockClimber("N3", 3.0);
        RockClimber rockClimber4 = new RockClimber("N4", 4.0);
        RockClimber rockClimber5 = new RockClimber("N5", 5.0);
        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
        climbing.addRockClimber(rockClimber4);
        climbing.addRockClimber(rockClimber5);
        Assert.assertEquals(5, climbing.getCount());

    }
    @Test
    public void test_Climbing_removeRockClimber_Should_Return_True_If_Removal_Successful()
    {
        climbing = new Climbing("Ludmil", 10);
        RockClimber rockClimber1 = new RockClimber("N1", 1.0);
        RockClimber rockClimber2 = new RockClimber("N2", 2.0);
        RockClimber rockClimber3 = new RockClimber("N3", 3.0);
        RockClimber rockClimber4 = new RockClimber("N4", 4.0);
        RockClimber rockClimber5 = new RockClimber("N5", 5.0);
        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
        climbing.addRockClimber(rockClimber4);
        climbing.addRockClimber(rockClimber5);
        Assert.assertTrue(climbing.removeRockClimber("N5"));

    }
    @Test
    public void test_Climbing_removeRockClimber_Should_Return_False_If_Climber_Does_Not_Exist()
    {
        climbing = new Climbing("Ludmil", 10);
        RockClimber rockClimber1 = new RockClimber("N1", 1.0);
        RockClimber rockClimber2 = new RockClimber("N2", 2.0);
        RockClimber rockClimber3 = new RockClimber("N3", 3.0);
        RockClimber rockClimber4 = new RockClimber("N4", 4.0);
        RockClimber rockClimber5 = new RockClimber("N5", 5.0);
        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
        climbing.addRockClimber(rockClimber4);
        climbing.addRockClimber(rockClimber5);
        Assert.assertFalse(climbing.removeRockClimber("N6"));

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Climbing_setCapacity_Should_Throw_Exception_If_Capacity_Negative()
    {
        climbing = new Climbing("Ludmil", -1);


    }
    @Test(expected = NullPointerException.class)
    public void test_Climbing_setName_Should_Throw_Exception_If_Name_Null()
    {
        climbing = new Climbing(null, 10);


    }
    @Test(expected = NullPointerException.class)
    public void test_Climbing_setName_Should_Throw_Exception_If_Name_Empty()
    {
        climbing = new Climbing("  ", 10);


    }
}
