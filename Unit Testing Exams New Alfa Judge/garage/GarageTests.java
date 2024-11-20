package garage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GarageTests {
    Car car;
    Garage garage;
    @Test
    public void test_Car_Constructor_Should_Initialize_Correctly()
    {
        car = new Car("BMW", 100, 10000.0);
        Assertions.assertEquals("BMW", car.getBrand());
        Assertions.assertEquals(100, car.getMaxSpeed());
        Assertions.assertEquals(10000.0, car.getPrice(), 0.01);
    }
    @Test
    public void test_Garage_Constructor_Should_Initialize_Correctly()
    {
        garage = new Garage();
        Assertions.assertEquals(0, garage.getCount());
    }
    @Test
    public void test_Garage_FindAllCarsWithMaxSpeedAbove_Should_Return_All_Cars_With_Greatest_Speed_Than_Given_As_List()
    {
        garage = new Garage();
        Car car1 = new Car("B1", 100, 1000.0);
        Car car2 = new Car("B2", 101, 2000.0);
        Car car3 = new Car("B3", 102, 3000.0);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        List<Car> expected = new ArrayList<>();
        expected.add(car2);
        expected.add(car3);
        Assertions.assertArrayEquals(expected.toArray(), garage.findAllCarsWithMaxSpeedAbove(100).toArray());
    }
    @Test
    public void test_Garage_AddCar_Should_Throws_Exception_Null_Car()
    {
        assertThrows(NullPointerException.class,
                () -> garage.addCar(null),
                "Car can't be null");

    }
    @Test
    public void test_Garage_GetTheMostExpensiveCar_Should_Return_Car_With_Max_Price_Or_Null_If_Empty_Collection()
    {
        garage = new Garage();
        Car car1 = new Car("B1", 100, 1000.0);
        Car car2 = new Car("B2", 101, 2000.0);
        Car car3 = new Car("B3", 102, 3000.0);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assertions.assertEquals(car3, garage.getTheMostExpensiveCar());
    }
    @Test
    public void test_Garage_FindAllCarsByBrand_Should_Return_Cars_With_Given_Brand_As_List()
    {
        garage = new Garage();
        Car car1 = new Car("B1", 100, 1000.0);
        Car car2 = new Car("B1", 101, 2000.0);
        Car car3 = new Car("B3", 102, 3000.0);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        List<Car> expected = new ArrayList<>();
        expected.add(car1);
        expected.add(car2);
        Assertions.assertArrayEquals(expected.toArray(), garage.findAllCarsByBrand("B1").toArray());
    }

}
