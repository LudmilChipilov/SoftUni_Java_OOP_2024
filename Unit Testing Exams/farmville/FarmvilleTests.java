package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests
{

    Animal animal;
    Farm farm;
    private static final double DELTA = 1e-15;

    @Test
    public void test_Animal_Constructor_Should_Create_New_Object()
    {
        animal = new Animal("fish", 10);
    }
    @Test
    public void test_Animal_getType_Should_Return_Correct_Type()
    {
        animal = new Animal("fish", 10);
        Assert.assertEquals("fish", animal.getType());
    }
    @Test
    public void test_Animal_getEnergy_Should_Return_Correct_Energy()
    {
        animal = new Animal("fish", 10.0);
        Assert.assertEquals(10.0, animal.getEnergy(), DELTA);
    }
    @Test
    public void test_Farm_Constructor_Should_Create_New_Object()
    {
        farm = new Farm("Rancho", 2);
    }
    @Test
    public void test_Farm_getName_Should_Return_Correct_Name()
    {
        farm = new Farm("Rancho", 2);
        Assert.assertEquals("Rancho", farm.getName());
    }
    @Test
    public void test_Farm_getCapacity_Should_Return_Correct_Capacity()
    {
        farm = new Farm("Rancho", 2);
        Assert.assertEquals(2, farm.getCapacity());
    }
    @Test
    public void test_Farm_getCount_Should_Return_Correct_Size_Of_Collection()
    {
        farm = new Farm("Rancho", 2);
        Assert.assertEquals(0, farm.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Farm_setCapacity_Should_Throws_Exception_When_Negative_Capacity()
    {
        farm = new Farm("Rancho", -1);

    }
    @Test(expected = NullPointerException.class)
    public void test_Farm_setName_Should_Throws_Exception_When_Name_Is_Null()
    {
        farm = new Farm(null, 2);

    }
    @Test(expected = NullPointerException.class)
    public void test_Farm_setName_Should_Throws_Exception_When_Name_Is_Empty()
    {
        farm = new Farm("  ", 2);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Farm_add_Should_Throws_Exception_When_Full_Capacity()
    {
        farm = new Farm("Rancho", 2);
        Animal animal1 = new Animal("T1", 1);
        Animal animal2 = new Animal("T2", 2);
        farm.add(animal1);
        farm.add(animal2);
        Animal animal3 = new Animal("T3", 3);
        farm.add(animal3);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Farm_add_Should_Throws_Exception_When_Animal_Exist()
    {
        farm = new Farm("Rancho", 3);
        Animal animal1 = new Animal("T1", 1);
        farm.add(animal1);
        farm.add(animal1);

    }
    @Test
    public void test_Farm_add_Should_Increase_Size_Of_Collection()
    {
        farm = new Farm("Rancho", 2);
        Animal animal1 = new Animal("T1", 1);
        farm.add(animal1);
        Assert.assertEquals(1, farm.getCount());
    }
    @Test
    public void test_Farm_remove_Should_Return_True_If_Exist_Animal_By_Given_Type_And_Remove_Animal()
    {
        farm = new Farm("Rancho", 2);
        Animal animal1 = new Animal("T1", 1);
        farm.add(animal1);
        Assert.assertTrue(farm.remove("T1"));
    }
    @Test
    public void test_Farm_remove_Should_Return_False_If_Not_Exist_Animal_By_Given_Type()
    {
        farm = new Farm("Rancho", 2);
        Animal animal1 = new Animal("T1", 1);
        farm.add(animal1);
        Assert.assertFalse(farm.remove("T2"));
    }
}
