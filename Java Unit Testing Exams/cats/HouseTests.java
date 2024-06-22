package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests
{
    Cat cat;
    House house;
    @Test
    public void test_Cat_Constructor_Should_Initialize_Correctly()
    {
        cat = new Cat("Laki");
        Assert.assertEquals("Laki", cat.getName());

    }
    @Test
    public void test_Cat_Constructor_Should_Initialize_IsHungry_To_True()
    {
        cat = new Cat("Laki");
        Assert.assertTrue(cat.isHungry());
    }
    @Test
    public void test_House_Constructor_Should_Initialize_Correctly_Name()
    {
        house = new House("A", 2);
        Assert.assertEquals("A", house.getName());

    }
    @Test
    public void test_House_Constructor_Should_Initialize_Correctly_Capacity()
    {
        house = new House("A", 2);

        Assert.assertEquals(2, house.getCapacity());
    }
    @Test
    public void test_House_Constructor_Should_Initialize_Correctly_Cat_Count()
    {
        house = new House("A", 2);


        Assert.assertEquals(0, house.getCount());
    }
    @Test(expected = NullPointerException.class)
    public void test_House_Constructor_Should_Throws_Exception_Null_Name()
    {
        house = new House(null, 2);

    }
    @Test(expected = NullPointerException.class)
    public void test_House_Constructor_Should_Throws_Exception_Empty_Name()
    {
        house = new House(" ", 2);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_House_Constructor_Should_Throws_Exception_When_Negative_Capacity()
    {
        house = new House("Vetren", -1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_House_GetCount_Should_Throws_Exception_When_Full_Capacity()
    {
        house = new House("Vetren", 2);
        Cat cat1 = new Cat("Name1");
        Cat cat2 = new Cat("Name2");
        house.addCat(cat1);
        house.addCat(cat2);
        Cat cat3 = new Cat("Name3");
        house.addCat(cat3);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_House_RemoveCat_Should_Throws_Exception_When_Cat_Does_Not_Exist()
    {
        house = new House("Vetren", 2);
        Cat cat1 = new Cat("Name1");
        Cat cat2 = new Cat("Name2");
        house.addCat(cat1);
        house.addCat(cat2);
        house.removeCat("Name3");

    }
    @Test
    public void test_House_RemoveCat_Should_Remove_CorrectLy_Existing_Cat()
    {
        house = new House("Vetren", 2);
        Cat cat1 = new Cat("Name1");
        Cat cat2 = new Cat("Name2");
        house.addCat(cat1);
        house.addCat(cat2);
        house.removeCat("Name2");
        Assert.assertEquals(1, house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_House_CatForSale_Should_Throws_Exception_When_Cat_Does_Not_Exist()
    {
        house = new House("Vetren", 2);
        Cat cat1 = new Cat("Name1");
        Cat cat2 = new Cat("Name2");
        house.addCat(cat1);
        house.addCat(cat2);
        house.catForSale("Name3");

    }
    @Test
    public void test_House_CatForSale_Should_Return_Existing_Cat()
    {
        house = new House("Vetren", 2);
        Cat cat1 = new Cat("Name1");
        Cat cat2 = new Cat("Name2");
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertEquals(cat1, house.catForSale("Name1"));

    }
    @Test
    public void test_House_CatForSale_Should_Set_IsHungry_To_False_If_Cat_Exist()
    {
        house = new House("Vetren", 2);
        Cat cat1 = new Cat("Name1");
        Cat cat2 = new Cat("Name2");
        house.addCat(cat1);
        house.addCat(cat2);
        house.catForSale("Name1");
        Assert.assertFalse(cat1.isHungry());

    }
    @Test
    public void test_House_Statistics_Should_Return_All_Cats_In_House_As_String()
    {
        house = new House("Vetren", 2);
        Cat cat1 = new Cat("Name1");
        Cat cat2 = new Cat("Name2");
        house.addCat(cat1);
        house.addCat(cat2);

        Assert.assertEquals("The cat Name1, Name2 is in the house Vetren!", house.statistics());

    }
}
