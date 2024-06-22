package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests
{
    Astronaut astronaut;
    Spaceship spaceship;
    final double DELTA = 0.01;
    @Test
    public void test_Astronaut_Constructor_Should_Initialize_Correctly()
    {
        astronaut = new Astronaut("Ludmil", 25.25);
        Assert.assertEquals("Ludmil", astronaut.getName());
        Assert.assertEquals(25.25, astronaut.getOxygenInPercentage(), DELTA);
    }
    @Test
    public void test_Spaceship_Constructor_Should_Initialize_Correctly()
    {
        spaceship = new Spaceship("Apolo", 5);
        Assert.assertEquals("Apolo", spaceship.getName());
        Assert.assertEquals(5, spaceship.getCapacity());
        Assert.assertEquals(0, spaceship.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Spaceship_add_Should_Throws_Exception_Full_Capacity()
    {
        spaceship = new Spaceship("Apolo", 5);
        Astronaut astronaut1 = new Astronaut("N1", 10.10);
        Astronaut astronaut2 = new Astronaut("N2", 11.10);
        Astronaut astronaut3 = new Astronaut("N3", 12.10);
        Astronaut astronaut4 = new Astronaut("N4", 13.10);
        Astronaut astronaut5 = new Astronaut("N5", 14.10);
        Astronaut astronaut6 = new Astronaut("N6", 15.10);
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        spaceship.add(astronaut4);
        spaceship.add(astronaut5);
        spaceship.add(astronaut6);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Spaceship_add_Should_Throws_Exception_If_Astronaut_Exist()
    {
        spaceship = new Spaceship("Apolo", 10);
        Astronaut astronaut1 = new Astronaut("N1", 10.10);
        Astronaut astronaut2 = new Astronaut("N2", 11.10);
        Astronaut astronaut3 = new Astronaut("N3", 12.10);
        Astronaut astronaut4 = new Astronaut("N4", 13.10);
        Astronaut astronaut5 = new Astronaut("N5", 14.10);
        Astronaut astronaut6 = new Astronaut("N6", 15.10);
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        spaceship.add(astronaut4);
        spaceship.add(astronaut5);
        spaceship.add(astronaut5);

    }
    @Test
    public void test_Spaceship_add_Should_Increase_Count_Of_Collection()
    {
        spaceship = new Spaceship("Apolo", 10);
        Astronaut astronaut1 = new Astronaut("N1", 10.10);
        Astronaut astronaut2 = new Astronaut("N2", 11.10);
        Astronaut astronaut3 = new Astronaut("N3", 12.10);
        Astronaut astronaut4 = new Astronaut("N4", 13.10);
        Astronaut astronaut5 = new Astronaut("N5", 14.10);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        spaceship.add(astronaut4);
        spaceship.add(astronaut5);
        Assert.assertEquals(5, spaceship.getCount());
    }
    @Test
    public void test_Spaceship_remove_Should_Decrease_Count_Of_Collection_And_Return_True()
    {
        spaceship = new Spaceship("Apolo", 10);
        Astronaut astronaut1 = new Astronaut("N1", 10.10);
        Astronaut astronaut2 = new Astronaut("N2", 11.10);
        Astronaut astronaut3 = new Astronaut("N3", 12.10);
        Astronaut astronaut4 = new Astronaut("N4", 13.10);
        Astronaut astronaut5 = new Astronaut("N5", 14.10);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        spaceship.add(astronaut4);
        spaceship.add(astronaut5);

        Assert.assertTrue(spaceship.remove("N5"));
    }
    @Test
    public void test_Spaceship_remove_Should_Return_False_If_Astronaut_Does_Not_Exist()
    {
        spaceship = new Spaceship("Apolo", 10);
        Astronaut astronaut1 = new Astronaut("N1", 10.10);
        Astronaut astronaut2 = new Astronaut("N2", 11.10);
        Astronaut astronaut3 = new Astronaut("N3", 12.10);
        Astronaut astronaut4 = new Astronaut("N4", 13.10);
        Astronaut astronaut5 = new Astronaut("N5", 14.10);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        spaceship.add(astronaut4);
        spaceship.add(astronaut5);

        Assert.assertFalse(spaceship.remove("N6"));
    }
    @Test
    public void test_Spaceship_remove_Should_Decrease_Count_Of_Collection()
    {
        spaceship = new Spaceship("Apolo", 10);
        Astronaut astronaut1 = new Astronaut("N1", 10.10);
        Astronaut astronaut2 = new Astronaut("N2", 11.10);
        Astronaut astronaut3 = new Astronaut("N3", 12.10);
        Astronaut astronaut4 = new Astronaut("N4", 13.10);
        Astronaut astronaut5 = new Astronaut("N5", 14.10);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        spaceship.add(astronaut4);
        spaceship.add(astronaut5);
        spaceship.remove("N5");
        Assert.assertEquals(4, spaceship.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Spaceship_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {

        spaceship = new Spaceship("Apolo", -1);

    }
    @Test(expected = NullPointerException.class)
    public void test_Spaceship_setName_Should_Throws_Exception_If_Name_Null()
    {
        spaceship = new Spaceship(null, 10);

    }
    @Test(expected = NullPointerException.class)
    public void test_Spaceship_setName_Should_Throws_Exception_If_Name_Empty()
    {
        spaceship = new Spaceship("  ", 10);

    }
}
