package aquarium;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class AquariumTests
{
    Fish fish;
    Aquarium aquarium;
    @Test
    public void test_Fish_Constructor_ShouldInitialize_Correctly()
    {
        fish = new Fish("Shark");
        Assert.assertEquals("Shark", fish.getName());
        Assert.assertTrue(fish.isAvailable());
    }
    @Test
    public void test_Aquarium_Constructor_ShouldInitialize_Correctly()
    {
        aquarium = new Aquarium("Varna", 5);
        Assert.assertEquals("Varna", aquarium.getName());
        Assert.assertEquals(5, aquarium.getCapacity());
        Assert.assertEquals(0, aquarium.getCount());
    }
    @Test(expected = NullPointerException.class)
    public void test_Aquarium_Name_Should_Throws_Exception_If_Null()
    {
        aquarium  = new Aquarium(null, 5);

    }
    @Test(expected = NullPointerException.class)
    public void test_Aquarium_Name_Should_Throws_Exception_If_Empty()
    {
        aquarium  = new Aquarium("  ", 5);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Aquarium_Capacity_Should_Throws_Exception_If_Negative()
    {
        aquarium  = new Aquarium("Varna", -1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Aquarium_add_Fish_Should_Throws_Exception_If_Full_Capacity()
    {

        Fish fish1 = new Fish("N1");
        Fish fish2 = new Fish("N2");
        Fish fish3 = new Fish("N3");
        Fish fish4 = new Fish("N4");
        Fish fish5 = new Fish("N5");
        aquarium = new Aquarium("Varna", 4);
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
        aquarium.add(fish4);
        aquarium.add(fish5);

    }
    @Test
    public void test_Aquarium_add_Fish_Should_Increase_Count()
    {

        Fish fish1 = new Fish("N1");
        Fish fish2 = new Fish("N2");
        Fish fish3 = new Fish("N3");
        Fish fish4 = new Fish("N4");
        Fish fish5 = new Fish("N5");
        aquarium = new Aquarium("Varna", 4);
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
        aquarium.add(fish4);
        Assert.assertEquals(4, aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Aquarium_remove_Fish_Should_Throws_Exception_If_Fish_Does_Not_Exist()
    {

        Fish fish1 = new Fish("N1");
        Fish fish2 = new Fish("N2");
        Fish fish3 = new Fish("N3");
        Fish fish4 = new Fish("N4");
        Fish fish5 = new Fish("N5");
        aquarium = new Aquarium("Varna", 4);
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
        aquarium.add(fish4);
        aquarium.remove("N5");

    }
    @Test
    public void test_Aquarium_remove_Fish_Should_Decrease_Count()
    {

        Fish fish1 = new Fish("N1");
        Fish fish2 = new Fish("N2");
        Fish fish3 = new Fish("N3");
        Fish fish4 = new Fish("N4");

        aquarium = new Aquarium("Varna", 4);
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
        aquarium.add(fish4);
        aquarium.remove("N4");
        Assert.assertEquals(3, aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Aquarium_sellFish_Should_Throws_Exception_If_Fish_Does_Not_Exist()
    {

        Fish fish1 = new Fish("N1");
        Fish fish2 = new Fish("N2");
        Fish fish3 = new Fish("N3");
        Fish fish4 = new Fish("N4");
        Fish fish5 = new Fish("N5");
        aquarium = new Aquarium("Varna", 4);
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
        aquarium.add(fish4);
        aquarium.sellFish("N5");

    }
    @Test
    public void test_Aquarium_sellFish_Should_Set_setAvailable_To_False()
    {

        Fish fish1 = new Fish("N1");
        Fish fish2 = new Fish("N2");
        Fish fish3 = new Fish("N3");
        Fish fish4 = new Fish("N4");

        aquarium = new Aquarium("Varna", 5);
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
        aquarium.add(fish4);
        aquarium.sellFish("N4");
        Assert.assertFalse(fish4.isAvailable());
    }
    @Test
    public void test_Aquarium_sellFish_Should_Return_Sold_Fish()
    {

        Fish fish1 = new Fish("N1");
        Fish fish2 = new Fish("N2");
        Fish fish3 = new Fish("N3");
        Fish fish4 = new Fish("N4");

        aquarium = new Aquarium("Varna", 5);
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
        aquarium.add(fish4);

        Assert.assertEquals(fish4,  aquarium.sellFish("N4"));
    }
    @Test
    public void test_Aquarium_report_Should_Return_List_With_Fish_Names()
    {

        Fish fish1 = new Fish("N1");
        Fish fish2 = new Fish("N2");
        Fish fish3 = new Fish("N3");
        Fish fish4 = new Fish("N4");
        List<String> names = new ArrayList<>();
        names.add("N1");  names.add("N2");  names.add("N3");  names.add("N4");
        aquarium = new Aquarium("Varna", 5);
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(fish3);
        aquarium.add(fish4);
        String expected = "Fish available at Varna: " + String.join(", ", names);
        Assert.assertEquals(expected,  aquarium.report());
    }
}
