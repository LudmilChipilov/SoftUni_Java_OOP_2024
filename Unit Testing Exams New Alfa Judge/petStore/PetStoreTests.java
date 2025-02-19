package petStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PetStoreTests {

    private final double DELTA = 0.0000;
    Animal animal;
    PetStore petStore;
    @Test
    public void test_Animal_Constructor_Should_Initialize_Correctly()
    {
        animal = new Animal("Ludmil", 100, 50.50);
        Assertions.assertEquals("Ludmil", animal.getSpecie());
        Assertions.assertEquals(100, animal.getMaxKilograms());
        Assertions.assertEquals(50.50, animal.getPrice(), DELTA);
        animal.setAge(10);
        Assertions.assertEquals(10, animal.getAge());
    }
    @Test
    public void test_PetStore_Constructor_Should_Initialize_Correctly()
    {
        petStore = new PetStore();
        Assertions.assertEquals(0, petStore.getCount());
        Assertions.assertEquals(0, petStore.getAnimals().size());
    }
    @Test
    public void test_PetStore_findAllAnimalsWithMaxKilograms_Should_Return_All_Animals_With_MaxKg_Bigger_Than_Given()
    {
        petStore = new PetStore();
        Animal animal1 = new Animal("S1", 10, 50.50);
        Animal animal2 = new Animal("S2", 20, 60.50);
        Animal animal3 = new Animal("S3", 30, 70.50);
        Animal animal4 = new Animal("S4", 40, 80.50);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);
        List<Animal> expected = new ArrayList<>();
        expected.add(animal3);
        expected.add(animal4);
        Assertions.assertEquals(expected, petStore.findAllAnimalsWithMaxKilograms(20));
    }
    @Test
    public void test_PetStore_addAnimal_Should_Throws_Exception_If_Animal_Null()
    {
        assertThrows(NullPointerException.class,
                () -> petStore.addAnimal(null),
                "Animal can't be null");
    }
    @Test
    public void test_PetStore_getTheMostExpensiveAnimal_Should_Return_Animal_With_Max_Price()
    {
        petStore = new PetStore();
        Animal animal1 = new Animal("S1", 10, 50.50);
        Animal animal2 = new Animal("S2", 20, 60.50);
        Animal animal3 = new Animal("S3", 30, 70.50);
        Animal animal4 = new Animal("S4", 40, 80.50);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);
        Assertions.assertEquals(animal4, petStore.getTheMostExpensiveAnimal());
    }
    @Test
    public void test_PetStore_findAllAnimalBySpecie_Should_Return_All_Animals_By_Given_Specie()
    {
        petStore = new PetStore();
        Animal animal1 = new Animal("S1", 10, 50.50);
        Animal animal2 = new Animal("S2", 20, 60.50);
        Animal animal3 = new Animal("SS", 30, 70.50);
        Animal animal4 = new Animal("SS", 40, 80.50);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);
        List<Animal> expected = new ArrayList<>();
        expected.add(animal3);
        expected.add(animal4);
        Assertions.assertEquals(expected, petStore.findAllAnimalBySpecie("SS"));
    }


}
