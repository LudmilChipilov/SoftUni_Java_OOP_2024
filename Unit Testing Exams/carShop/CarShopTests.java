package carShop;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class CarShopTests
{
    Car car;
    CarShop carShop;
    private final double DELTA = 0.0000;
    @Test
    public void test_Car_Constructor_Should_Initialize_Correctly()
    {
        car = new Car("Toyota", 100, 1000.50);
        Assert.assertEquals("Toyota", car.getModel());
        Assert.assertEquals(100, car.getHorsePower());
        Assert.assertEquals(1000.50, car.getPrice(), DELTA);
    }
    @Test
    public void test_CarShop_Constructor_Should_Initialize_Correctly()
    {
        carShop = new CarShop();
        Assert.assertEquals(0, carShop.getCount());
        Assert.assertEquals(0, carShop.getCars().size());
    }
    @Test
    public void test_CarShop_findAllCarsWithMaxHorsePower_Should_Return_All_Car_With_HorsePower_Greater_Than_Given()
    {
        carShop = new CarShop();
        Car car1 = new Car("M1", 100, 1000.50);
        Car car2 = new Car("M2", 200, 2000.50);
        Car car3 = new Car("M3", 300, 3000.50);
        Car car4 = new Car("M4", 400, 4000.50);
        Car car5 = new Car("M5", 500, 5000.50);
        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);
        carShop.add(car4);
        carShop.add(car5);
        List<Car> expected = new ArrayList<>();
        expected.add(car3);
        expected.add(car4);
        expected.add(car5);
        Assert.assertEquals(expected, carShop.findAllCarsWithMaxHorsePower(200));
    }
    @Test(expected = NullPointerException.class)
    public void test_CarShop_add_Should_Throws_Exception_If_Car_Null()
    {
        carShop = new CarShop();
        car = null;
        carShop.add(car);

    }
    @Test
    public void test_CarShop_remove_Should_Return_True_If_Removal_Successful()
    {
        carShop = new CarShop();
        car = new Car("Toyota", 100, 1000.50);
        carShop.add(car);
        Assert.assertTrue(carShop.remove(car));
    }
    @Test
    public void test_CarShop_remove_Should_Return_False_If_Removal_Not_Successful()
    {
        carShop = new CarShop();
        car = new Car("Toyota", 100, 1000.50);
        Car car1 = new Car("M1", 100, 1000.50);
        carShop.add(car);
        Assert.assertFalse(carShop.remove(car1));
    }
    @Test
    public void test_CarShop_getTheMostLuxuryCar_Should_Return_Car_With_Biggest_Price()
    {
        carShop = new CarShop();
        Car car1 = new Car("M1", 100, 1000.50);
        Car car2 = new Car("M2", 200, 2000.50);
        Car car3 = new Car("M3", 300, 3000.50);
        Car car4 = new Car("M4", 400, 4000.50);
        Car car5 = new Car("M5", 500, 5000.50);
        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);
        carShop.add(car4);
        carShop.add(car5);
        Assert.assertEquals(car5, carShop.getTheMostLuxuryCar());
    }
    @Test
    public void test_CarShop_findAllCarByModel_Should_Return_All_Cars_With_Given_Model()
    {
        carShop = new CarShop();
        Car car1 = new Car("M1", 100, 1000.50);
        Car car2 = new Car("M1", 200, 2000.50);
        Car car3 = new Car("M1", 300, 3000.50);
        Car car4 = new Car("M4", 400, 4000.50);
        Car car5 = new Car("M5", 500, 5000.50);
        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);
        carShop.add(car4);
        carShop.add(car5);
        List<Car> expected = new ArrayList<>();
        expected.add(car1);
        expected.add(car2);
        expected.add(car3);
        Assert.assertEquals(expected, carShop.findAllCarByModel("M1"));
    }
}
