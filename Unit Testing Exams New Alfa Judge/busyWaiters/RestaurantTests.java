package busyWaiters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RestaurantTests {

    FullTimeWaiter fullTimeWaiter;
    Restaurant restaurant;

    @Test
    public void test_FullTimeWaiter_Constructor_Should_Initialize_Correctly()
    {
        fullTimeWaiter = new FullTimeWaiter("Ludmil", 10);
        Assertions.assertEquals("Ludmil", fullTimeWaiter.getName());
        Assertions.assertEquals(10, fullTimeWaiter.getEfficiency());
    }

    @Test
    public void test_Restaurant_Constructor_Should_Initialize_Correctly()
    {
        restaurant = new Restaurant("Rakovski", 3);
        Assertions.assertEquals("Rakovski", restaurant.getName());
        Assertions.assertEquals(3, restaurant.getCapacity());
        Assertions.assertEquals(0, restaurant.getCount());
        Assertions.assertEquals(0, restaurant.getWaiters().size());
    }

    @Test
    public void test_Restaurant_addFullTimeWaiter_Should_Throws_Exception_If_Capacity_Full()
    {
        restaurant = new Restaurant("Rakovski", 3);
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("N1", 1);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("N2", 2);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("N3", 3);
        FullTimeWaiter fullTimeWaiter4 = new FullTimeWaiter("N4", 4);
        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        restaurant.addFullTimeWaiter(fullTimeWaiter2);
        restaurant.addFullTimeWaiter(fullTimeWaiter3);
        assertThrows(IllegalArgumentException.class,
                () -> restaurant.addFullTimeWaiter(fullTimeWaiter4),
                "No more places!");

    }

    @Test
    public void test_Restaurant_addFullTimeWaiter_Should_Throws_Exception_If_Waiter_Exist()
    {
        restaurant = new Restaurant("Rakovski", 10);
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("N1", 1);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("N2", 2);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("N3", 3);

        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        restaurant.addFullTimeWaiter(fullTimeWaiter2);
        restaurant.addFullTimeWaiter(fullTimeWaiter3);
        assertThrows(IllegalArgumentException.class,
                () -> restaurant.addFullTimeWaiter(fullTimeWaiter3),
                "The waiter N3 already exist!");

    }

    @Test
    public void test_Restaurant_removeFullTimeWaiter_Should_Return_True_If_Removal_Successful()
    {
        restaurant = new Restaurant("Rakovski", 10);
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("N1", 1);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("N2", 2);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("N3", 3);

        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        restaurant.addFullTimeWaiter(fullTimeWaiter2);
        restaurant.addFullTimeWaiter(fullTimeWaiter3);
        Assertions.assertTrue(restaurant.removeFullTimeWaiter(fullTimeWaiter3.getName()));

    }

    @Test
    public void test_Restaurant_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {
        //restaurant = new Restaurant("Rakovski", 10);

        assertThrows(IllegalArgumentException.class,
                () -> new Restaurant("Rakovski", -1),
                "Invalid capacity!");
    }

    @Test
    public void test_Restaurant_setName_Should_Throws_Exception_If_Name_Null()
    {
        //restaurant = new Restaurant("Rakovski", 10);

        assertThrows(NullPointerException.class,
                () -> new Restaurant(null, 10),
                "Invalid client!");
    }
    @Test
    public void test_Restaurant_setName_Should_Throws_Exception_If_Name_Empty()
    {
        //restaurant = new Restaurant("Rakovski", 10);

        assertThrows(NullPointerException.class,
                () -> new Restaurant("   ", 10),
                "Invalid client!");
    }

}
