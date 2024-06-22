package garage;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests
{
    Car car;
    Garage garage;
    final double DELTA = 0.00000;
    @Test
    public void test_Car_Constructor_Should_Initialize_Correctly()
    {
        car = new Car("Jeep", 200, 2000.00);
        Assert.assertEquals("Jeep", car.getBrand());
        Assert.assertEquals(200, car.getMaxSpeed());
        Assert.assertEquals(2000.00, car.getPrice(), DELTA);
    }
    @Test
    public void test_Garage_Constructor_Should_Initialize_Correctly()
    {
        garage = new Garage();
        Assert.assertEquals(0, garage.getCount());
        Assert.assertEquals(0, garage.getCars().size());
    }
    @Test
    public void test_Garage_findAllCarsWithMaxSpeedAbove_Should_Return_Collection_With_Correctly_Cars()
    {
        garage = new Garage();
        Car car1 = new Car("B1", 100, 1000.00);
        Car car2 = new Car("B2", 150, 2000.00);
        Car car3 = new Car("B3", 200, 3000.00);
        Car car4 = new Car("B4", 250, 4000.00);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
        List<Car> expected = new ArrayList<>();
        expected.add(car3);
        expected.add(car4);
        Assert.assertEquals(expected, garage.findAllCarsWithMaxSpeedAbove(150));
    }
    @Test
    public void test_Garage_addCar_Should_Throw_Exception_If_Car_Null()
    {
        garage = new Garage();
        try
        {
            garage.addCar(null);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println(iae.getMessage());
        }
    }
    @Test
    public void test_Garage_getTheMostExpensiveCar_Should_Return_Car_With_Highest_Price()
    {
        garage = new Garage();
        Car car1 = new Car("B1", 100, 1000.00);
        Car car2 = new Car("B2", 150, 2000.00);
        Car car3 = new Car("B3", 200, 3000.00);
        Car car4 = new Car("B4", 250, 4000.00);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
        Assert.assertEquals(car4, garage.getTheMostExpensiveCar());
    }
    @Test
    public void test_Garage_getTheMostExpensiveCar_Should_Return_Null_If_Empty_Collection()
    {
        garage = new Garage();

        Assert.assertEquals(null, garage.getTheMostExpensiveCar());
    }
    @Test
    public void test_Garage_findAllCarsByBrand_Should_Return_Correctly_Collection()
    {
        garage = new Garage();
        Car car1 = new Car("B", 100, 1000.00);
        Car car2 = new Car("B", 150, 2000.00);
        Car car3 = new Car("C", 200, 3000.00);
        Car car4 = new Car("C", 250, 4000.00);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
        List<Car> expected = new ArrayList<>();
        expected.add(car3);
        expected.add(car4);
        Assert.assertEquals(expected, garage.findAllCarsByBrand("C"));
    }
}