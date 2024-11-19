package dolphinsPlay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

//TODO write unit tests

public class PlayDolphinsTests {

    Dolphin dolphin;
    DolphinsPlay dolphinsPlay;

    @Test
    public void test_Dolphin_Constructor_Should_Initialize_Correctly()
    {
        dolphin = new Dolphin("Mammal", "Ludmil", 10);
        Assertions.assertEquals("Mammal", dolphin.getType());
        Assertions.assertEquals("Ludmil", dolphin.getName());
        Assertions.assertEquals(10, dolphin.getEnergy());
    }

    @Test
    public void test_DolphinsPlay_Constructor_Should_Initialize_Correctly()
    {
        dolphinsPlay = new DolphinsPlay("Rakovski", 3);
        Assertions.assertEquals("Rakovski", dolphinsPlay.getName());
        Assertions.assertEquals(3, dolphinsPlay.getCapacity());
        Assertions.assertEquals(0, dolphinsPlay.getCount());
        Assertions.assertEquals(0, dolphinsPlay.getDolphins().size());
    }

    @Test
    public void test_DolphinsPlay_addDolphin_Should_Throws_Exception_If_Dolphin_Null()
    {
        dolphinsPlay = new DolphinsPlay("Rakovski", 3);

        assertThrows(IllegalArgumentException.class,
                () -> dolphinsPlay.addDolphin(null),
                "Dolphin can't be null");

    }

    @Test
    public void test_DolphinsPlay_addDolphin_Should_Throws_Exception_If_Capacity_Full()
    {
        dolphinsPlay = new DolphinsPlay("Rakovski", 3);
        Dolphin dolphin1 = new Dolphin("T1", "N1", 1);
        Dolphin dolphin2 = new Dolphin("T2", "N2", 2);
        Dolphin dolphin3 = new Dolphin("T3", "N3", 3);
        Dolphin dolphin4 = new Dolphin("T4", "N3", 4);
        dolphinsPlay.addDolphin(dolphin1);
        dolphinsPlay.addDolphin(dolphin2);
        dolphinsPlay.addDolphin(dolphin3);
        assertThrows(IllegalArgumentException.class,
                () -> dolphinsPlay.addDolphin(dolphin4),
                "No more places!");

    }

    @Test
    public void test_DolphinsPlay_addDolphin_Should_Throws_Exception_If_Dolphin_Exist()
    {
        dolphinsPlay = new DolphinsPlay("Rakovski", 10);
        Dolphin dolphin1 = new Dolphin("T1", "N1", 1);
        Dolphin dolphin2 = new Dolphin("T2", "N2", 2);
        Dolphin dolphin3 = new Dolphin("T3", "N3", 3);

        dolphinsPlay.addDolphin(dolphin1);
        dolphinsPlay.addDolphin(dolphin2);
        dolphinsPlay.addDolphin(dolphin3);
        assertThrows(IllegalArgumentException.class,
                () -> dolphinsPlay.addDolphin(dolphin3),
                "The dolphin N3 already exist!");

    }

    @Test
    public void test_DolphinsPlay_removeDolphin_Should_Return_True_If_Removal_Successful() {
        dolphinsPlay = new DolphinsPlay("Rakovski", 10);
        Dolphin dolphin1 = new Dolphin("T1", "N1", 1);
        Dolphin dolphin2 = new Dolphin("T2", "N2", 2);
        Dolphin dolphin3 = new Dolphin("T3", "N3", 3);

        dolphinsPlay.addDolphin(dolphin1);
        dolphinsPlay.addDolphin(dolphin2);
        dolphinsPlay.addDolphin(dolphin3);
        Assertions.assertTrue(dolphinsPlay.removeDolphin("N2"));
    }

    @Test
    public void test_DolphinsPlay_getTheDolphinWithTheMaxEnergy_Should_Return_Dolphin_With_Biggest_Energy() {
        dolphinsPlay = new DolphinsPlay("Rakovski", 10);
        Dolphin dolphin1 = new Dolphin("T1", "N1", 1);
        Dolphin dolphin2 = new Dolphin("T2", "N2", 2);
        Dolphin dolphin3 = new Dolphin("T3", "N3", 3);

        dolphinsPlay.addDolphin(dolphin1);
        dolphinsPlay.addDolphin(dolphin2);
        dolphinsPlay.addDolphin(dolphin3);
        Assertions.assertEquals("N3", dolphinsPlay.getTheDolphinWithTheMaxEnergy());
    }

    @Test
    public void test_DolphinsPlay_findAllDolphinsByType_Should_Return_Dolphins_List_By_Type() {
        dolphinsPlay = new DolphinsPlay("Rakovski", 10);
        Dolphin dolphin1 = new Dolphin("TT", "N1", 1);
        Dolphin dolphin2 = new Dolphin("TT", "N2", 2);
        Dolphin dolphin3 = new Dolphin("T3", "N3", 3);

        dolphinsPlay.addDolphin(dolphin1);
        dolphinsPlay.addDolphin(dolphin2);
        dolphinsPlay.addDolphin(dolphin3);
        List<Dolphin> expected = new ArrayList<>();
        expected.add(dolphin1);
        expected.add(dolphin2);
        Assertions.assertEquals(expected, dolphinsPlay.findAllDolphinsByType("TT"));
    }

    @Test
    public void test_DolphinsPlay_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {
        //dolphinsPlay = new DolphinsPlay("Rakovski", 3);

        assertThrows(IllegalArgumentException.class,
                () -> new DolphinsPlay("Rakovski", -1),
                "Invalid capacity!");

    }
}
