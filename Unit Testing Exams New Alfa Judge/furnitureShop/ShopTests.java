package furnitureShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopTests {
    Furniture furniture;
    Shop shop;

    @Test
    public void test_Furniture_Constructor_Should_Initialize_Correctly()
    {
        furniture = new Furniture("F", "T", 10);
        Assertions.assertEquals("F", furniture.getName());
        Assertions.assertEquals("T", furniture.getType());
        Assertions.assertEquals(10, furniture.getPrice());
    }

    @Test
    public void test_Shop_Constructor_Should_Initialize_Correctly()
    {
        shop = new Shop("S", 3);
        Assertions.assertEquals("S", shop.getType());
        Assertions.assertEquals(3, shop.getCapacity());
        Assertions.assertEquals(0, shop.getCount());
        Assertions.assertEquals(0, shop.getFurnitures().size());
    }

    @Test
    public void test_Shop_addFurniture_Should_Throws_Exception_If_Null_Furniture()
    {
        shop = new Shop("S", 3);
        assertThrows(IllegalArgumentException.class,
                () -> shop.addFurniture(null),
                "Furniture can't be null");

    }

    @Test
    public void test_Shop_addFurniture_Should_Throws_Exception_If_Capacity_Full()
    {
        shop = new Shop("S", 3);
        Furniture furniture1 = new Furniture("N1", "T1", 1);
        Furniture furniture2 = new Furniture("N2", "T2", 2);
        Furniture furniture3 = new Furniture("N3", "T3", 3);
        Furniture furniture4 = new Furniture("N4", "T1", 4);
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        shop.addFurniture(furniture3);
        assertThrows(IllegalArgumentException.class,
                () -> shop.addFurniture(furniture4),
                "No more places!");

    }

    @Test
    public void test_Shop_addFurniture_Should_Throws_Exception_If_Furniture_Exist()
    {
        shop = new Shop("S", 10);
        Furniture furniture1 = new Furniture("N1", "T1", 1);
        Furniture furniture2 = new Furniture("N2", "T2", 2);
        Furniture furniture3 = new Furniture("N3", "T3", 3);

        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        shop.addFurniture(furniture3);
        assertThrows(IllegalArgumentException.class,
                () -> shop.addFurniture(furniture3),
                "The furniture N3 already exist!");

    }

    @Test
    public void test_Shop_removeFurniture_Should_Return_True_If_Removal_Successful()
    {
        shop = new Shop("S", 10);
        Furniture furniture1 = new Furniture("N1", "T1", 1);
        Furniture furniture2 = new Furniture("N2", "T2", 2);
        Furniture furniture3 = new Furniture("N3", "T3", 3);

        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        shop.addFurniture(furniture3);
        Assertions.assertTrue(shop.removeFurniture("T2"));
    }

    @Test
    public void test_Shop_getCheapestFurniture_Should_Return_Furniture_With_Lowest_Price()
    {
        shop = new Shop("S", 10);
        Furniture furniture1 = new Furniture("N1", "T1", 1);
        Furniture furniture2 = new Furniture("N2", "T2", 2);
        Furniture furniture3 = new Furniture("N3", "T3", 3);

        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        shop.addFurniture(furniture3);
        Assertions.assertEquals(furniture1.getName(), shop.getCheapestFurniture());
    }

    @Test
    public void test_Shop_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {
        //shop = new Shop("S", -1);
        assertThrows(IllegalArgumentException.class,
                () -> new Shop("S", -1),
                "Invalid capacity!");

    }

    @Test
    public void test_Shop_findAllFurnitureByType_Should_Return_Correct_List_Of_Furniture_By_Type()
    {
        shop = new Shop("S", 10);
        Furniture furniture1 = new Furniture("N1", "T1", 1);
        Furniture furniture2 = new Furniture("N2", "TT", 2);
        Furniture furniture3 = new Furniture("N3", "TT", 3);
        Furniture furniture4 = new Furniture("N4", "TT", 4);

        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        shop.addFurniture(furniture3);
        shop.addFurniture(furniture4);
        List<Furniture> expected = new ArrayList<>();
        expected.add(furniture2);
        expected.add(furniture3);
        expected.add(furniture4);
        Assertions.assertEquals(expected, shop.findAllFurnitureByType("TT"));
    }
}