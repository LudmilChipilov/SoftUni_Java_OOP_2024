package stuntClimb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ClimbingTests
{
    Climbing climbing;
    RockClimber rockClimber;
    private final static double DELTA = 0.00;
    @Test
    public void test_RockClimber_Constructor_Should_Initialize_Correctly()
    {
        rockClimber = new RockClimber("Ludmil", 10.50);
        Assertions.assertEquals("Ludmil", rockClimber.getName());
        Assertions.assertEquals(10.50, rockClimber.getStrength(), DELTA);
    }

    @Test
    public void test_Climbing_Constructor_Should_Initialize_Correctly()
    {
        climbing = new Climbing("Vetren", 3);
        Assertions.assertEquals("Vetren", climbing.getName());
        Assertions.assertEquals(3, climbing.getCapacity());
        Assertions.assertEquals(0, climbing.getCount());
    }

    @Test
    public void test_Climbing_addRockClimber_Should_Throws_Exception_If_Capacity_Full()
    {
        climbing = new Climbing("Vetren", 3);
        RockClimber rockClimber1 = new RockClimber("N1", 1.00);
        RockClimber rockClimber2 = new RockClimber("N2", 2.00);
        RockClimber rockClimber3 = new RockClimber("N3", 3.00);
        RockClimber rockClimber4 = new RockClimber("N4", 4.00);
        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
        assertThrows(IllegalArgumentException.class,
                () -> climbing.addRockClimber(rockClimber4),
                "No more places for this climb!");

    }

    @Test
    public void test_Climbing_addRockClimber_Should_Throws_Exception_If_Climber_Is_Already_Added()
    {
        climbing = new Climbing("Vetren", 10);
        RockClimber rockClimber1 = new RockClimber("N1", 1.00);
        RockClimber rockClimber2 = new RockClimber("N2", 2.00);
        RockClimber rockClimber3 = new RockClimber("N3", 3.00);

        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
        assertThrows(IllegalArgumentException.class,
                () -> climbing.addRockClimber(rockClimber3),
                "The climber N3 is already in the climb!");

    }

    @Test
    public void test_Climbing_removeRockClimber_Should_Return_True_If_Removal_Successful()
    {
        climbing = new Climbing("Vetren", 10);
        RockClimber rockClimber1 = new RockClimber("N1", 1.00);
        RockClimber rockClimber2 = new RockClimber("N2", 2.00);
        RockClimber rockClimber3 = new RockClimber("N3", 3.00);

        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
        Assertions.assertTrue(climbing.removeRockClimber("N2"));
    }

    @Test
    public void test_Climbing_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {


        assertThrows(IllegalArgumentException.class,
                () -> new Climbing("Vetren", -1),
                "Invalid capacity!");

    }

    @Test
    public void test_Climbing_setName_Should_Throws_Exception_If_Name_Null()
    {


        assertThrows(NullPointerException.class,
                () -> new Climbing(null, 10),
                "Invalid capacity!");

    }
    @Test
    public void test_Climbing_setName_Should_Throws_Exception_If_Name_Is_Empty()
    {


        assertThrows(NullPointerException.class,
                () -> new Climbing("   ", 10),
                "Invalid capacity!");

    }
}
