package busyWaiters;


import org.junit.Test;
import org.junit.Assert;
import java.util.*;
public class RestaurantTests
{
    FullTimeWaiter fullTimeWaiter;
    Restaurant restaurant;
    @Test
    public void test_FullTimeWaiter_Constructor_Should_Initialize_Correctly()
    {
        fullTimeWaiter = new FullTimeWaiter("Ludmil", 10);
        Assert.assertEquals("Ludmil", fullTimeWaiter.getName());
        Assert.assertEquals(10, fullTimeWaiter.getEfficiency());
    }
    @Test
    public void test_Restaurant_Constructor_Should_Initialize_Correctly()
    {
       restaurant = new Restaurant("Vetren", 5);
       Assert.assertEquals("Vetren", restaurant.getName());
       Assert.assertEquals(5, restaurant.getCapacity());
       Assert.assertEquals(0, restaurant.getCount());
       Assert.assertEquals(0, restaurant.getWaiters().size());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Restaurant_addFullTimeWaiter_Should_Throws_Exception_If_Waiter_Is_Already_Added()
    {
        restaurant = new Restaurant("Vetren", 10);
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("N1", 1);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("N2", 1);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("N3", 1);
        FullTimeWaiter fullTimeWaiter4 = new FullTimeWaiter("N4", 1);
        FullTimeWaiter fullTimeWaiter5 = new FullTimeWaiter("N5", 1);

        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        restaurant.addFullTimeWaiter(fullTimeWaiter2);
        restaurant.addFullTimeWaiter(fullTimeWaiter3);
        restaurant.addFullTimeWaiter(fullTimeWaiter4);
        restaurant.addFullTimeWaiter(fullTimeWaiter5);
        restaurant.addFullTimeWaiter(fullTimeWaiter5);
       /* try
        {
            restaurant.addFullTimeWaiter(fullTimeWaiter5);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println(iae.getMessage());
        }*/
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Restaurant_addFullTimeWaiter_Should_Throws_Exception_If_Capacity_Full()
    {
        restaurant = new Restaurant("Vetren", 5);
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("N1", 1);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("N2", 1);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("N3", 1);
        FullTimeWaiter fullTimeWaiter4 = new FullTimeWaiter("N4", 1);
        FullTimeWaiter fullTimeWaiter5 = new FullTimeWaiter("N5", 1);
        FullTimeWaiter fullTimeWaiter6 = new FullTimeWaiter("N6", 1);

        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        restaurant.addFullTimeWaiter(fullTimeWaiter2);
        restaurant.addFullTimeWaiter(fullTimeWaiter3);
        restaurant.addFullTimeWaiter(fullTimeWaiter4);
        restaurant.addFullTimeWaiter(fullTimeWaiter5);
        restaurant.addFullTimeWaiter(fullTimeWaiter6);
       /* try
        {
            restaurant.addFullTimeWaiter(fullTimeWaiter6);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println(iae.getMessage());
        }*/
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Restaurant_addFullTimeWaiter_Should_Throws_Exception_If_Waiter_Is_Already_Exist()
    {
        restaurant = new Restaurant("Vetren", 10);
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("N1", 1);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("N2", 1);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("N3", 1);
        FullTimeWaiter fullTimeWaiter4 = new FullTimeWaiter("N4", 1);
        FullTimeWaiter fullTimeWaiter5 = new FullTimeWaiter("N5", 1);


        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        restaurant.addFullTimeWaiter(fullTimeWaiter2);
        restaurant.addFullTimeWaiter(fullTimeWaiter3);
        restaurant.addFullTimeWaiter(fullTimeWaiter4);
        restaurant.addFullTimeWaiter(fullTimeWaiter5);
        restaurant.addFullTimeWaiter(fullTimeWaiter5);
       /* try
        {
            restaurant.addFullTimeWaiter(fullTimeWaiter5);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println(iae.getMessage());
        }*/
    }
    @Test
    public void test_Restaurant_addFullTimeWaiter_Should_Increase_Count_Of_Waiters()
    {
        restaurant = new Restaurant("Vetren", 10);
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("N1", 1);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("N2", 1);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("N3", 1);
        FullTimeWaiter fullTimeWaiter4 = new FullTimeWaiter("N4", 1);
        FullTimeWaiter fullTimeWaiter5 = new FullTimeWaiter("N5", 1);

        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        restaurant.addFullTimeWaiter(fullTimeWaiter2);
        restaurant.addFullTimeWaiter(fullTimeWaiter3);
        restaurant.addFullTimeWaiter(fullTimeWaiter4);
        restaurant.addFullTimeWaiter(fullTimeWaiter5);
        Assert.assertEquals(5, restaurant.getCount());
        Assert.assertEquals(5, restaurant.getWaiters().size());
    }
    @Test
    public void test_Restaurant_removeFullTimeWaiter_Should_Return_True_If_Waiter_Exist()
    {
        restaurant = new Restaurant("Vetren", 10);
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("N1", 1);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("N2", 1);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("N3", 1);
        FullTimeWaiter fullTimeWaiter4 = new FullTimeWaiter("N4", 1);
        FullTimeWaiter fullTimeWaiter5 = new FullTimeWaiter("N5", 1);

        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        restaurant.addFullTimeWaiter(fullTimeWaiter2);
        restaurant.addFullTimeWaiter(fullTimeWaiter3);
        restaurant.addFullTimeWaiter(fullTimeWaiter4);
        restaurant.addFullTimeWaiter(fullTimeWaiter5);
        Assert.assertTrue(restaurant.removeFullTimeWaiter("N5"));

    }
    @Test
    public void test_Restaurant_removeFullTimeWaiter_Should_Return_False_If_Waiter_Does_Not_Exist()
    {
        restaurant = new Restaurant("Vetren", 10);
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("N1", 1);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("N2", 1);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("N3", 1);
        FullTimeWaiter fullTimeWaiter4 = new FullTimeWaiter("N4", 1);
        FullTimeWaiter fullTimeWaiter5 = new FullTimeWaiter("N5", 1);

        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        restaurant.addFullTimeWaiter(fullTimeWaiter2);
        restaurant.addFullTimeWaiter(fullTimeWaiter3);
        restaurant.addFullTimeWaiter(fullTimeWaiter4);
        restaurant.addFullTimeWaiter(fullTimeWaiter5);
        Assert.assertFalse(restaurant.removeFullTimeWaiter("N6"));

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Restaurant_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {
        restaurant = new Restaurant("Vetren", -1);

       /* try
        {
            restaurant = new Restaurant("Vetren", -1);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println(iae.getMessage());
        }*/
    }
    @Test(expected = NullPointerException.class)
    public void test_Restaurant_setName_Should_Throws_Exception_If_Name_Null()
    {

        restaurant = new Restaurant(null, 10);
        /*try
        {
            restaurant = new Restaurant(null, 10);
        }
        catch (NullPointerException npe)
        {
            System.out.println(npe.getMessage());
        }*/
    }
    @Test(expected = NullPointerException.class)
    public void test_Restaurant_setName_Should_Throws_Exception_If_Name_Empty()
    {

        restaurant = new Restaurant("  ", 10);
       /* try
        {
            restaurant = new Restaurant("  ", 10);
        }
        catch (NullPointerException npe)
        {
            System.out.println(npe.getMessage());
        }*/
    }


}
