package carShop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarShopTests
{
    Car car;
    CarShop carShop;
    private final static double DELTA = 0.00;
    @Test
    public void test_Car_Constructor_Should_Initialize_Correctly()
    {
        car = new Car("M", 100, 1000.00);
        Assertions.assertEquals("M", car.getModel());
        Assertions.assertEquals(100, car.getHorsePower());
        Assertions.assertEquals(1000.00, car.getPrice(), DELTA);
    }

    @Test
    public void test_CarShop_Constructor_Should_Initialize_Correctly()
    {
        carShop = new CarShop();
        Assertions.assertEquals(0, carShop.getCars().size());
        Assertions.assertEquals(0, carShop.getCount());
    }

    @Test
    public void test_CarShop_findAllCarsWithMaxHorsePower_Should_Return_List_Car_With_Horse_Power_More_Than_Given()
    {
        carShop = new CarShop();
        Car car1 = new Car("M1", 100, 1000.00);
        Car car2 = new Car("M2", 200, 2000.00);
        Car car3 = new Car("M3", 300, 3000.00);
        Car car4 = new Car("M4", 400, 4000.00);
        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);
        carShop.add(car4);
        List<Car> expected = new ArrayList<>();
        expected.add(car2);
        expected.add(car3);
        expected.add(car4);
        Assertions.assertEquals(expected, carShop.findAllCarsWithMaxHorsePower(100));
    }
    @Test
    public void test_CarShop_Add_Car_Should_Throws_Exception_If_Car_Null()
    {
        carShop = new CarShop();
        car = new Car("M", 100, 1000.00);
        assertThrows(NullPointerException.class,
                () -> carShop.add(null),
                "Car cannot be null.");

    }
    @Test
    public void test_CarShop_Remove_Should_Return_True_If_Removal_Successful()
    {
        carShop = new CarShop();
        Car car1 = new Car("M1", 100, 1000.00);
        Car car2 = new Car("M2", 200, 2000.00);
        Car car3 = new Car("M3", 300, 3000.00);
        Car car4 = new Car("M4", 400, 4000.00);
        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);
        carShop.add(car4);
        Assertions.assertTrue(carShop.remove(car1));
    }
    @Test
    public void test_CarShop_getTheMostLuxuryCar_Should_Return_The_Most_Luxury_Car()
    {
        carShop = new CarShop();
        Car car1 = new Car("M1", 100, 1000.00);
        Car car2 = new Car("M2", 200, 2000.00);
        Car car3 = new Car("M3", 300, 3000.00);
        Car car4 = new Car("M4", 400, 4000.00);
        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);
        carShop.add(car4);

        Assertions.assertEquals(car4, carShop.getTheMostLuxuryCar());
    }

    @Test
    public void test_CarShop_findAllCarByModel_Should_Return_List_Car_With_Given_Model()
    {
        carShop = new CarShop();
        Car car1 = new Car("M1", 100, 1000.00);
        Car car2 = new Car("MM", 200, 2000.00);
        Car car3 = new Car("MM", 300, 3000.00);
        Car car4 = new Car("MM", 400, 4000.00);
        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);
        carShop.add(car4);
        List<Car> expected = new ArrayList<>();
        expected.add(car2);
        expected.add(car3);
        expected.add(car4);
        Assertions.assertEquals(expected, carShop.findAllCarByModel("MM"));
    }
}
