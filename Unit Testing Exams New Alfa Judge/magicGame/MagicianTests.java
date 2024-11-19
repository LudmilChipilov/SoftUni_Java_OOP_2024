package magicGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MagicianTests
{
    Magic magic;
    Magician magician;
    @Test
    public void test_Magic_Constructor_Should_Initialize_Correctly()
    {
        magic = new Magic("N", 10);
        Assertions.assertEquals("N", magic.getName());
        Assertions.assertEquals(10, magic.getBullets());
    }

    @Test
    public void test_Magician_Constructor_Should_Initialize_Correctly()
    {
        magician = new Magician("MA", 5);
        Assertions.assertEquals("MA", magician.getUsername());
        Assertions.assertEquals(5, magician.getHealth());
        Assertions.assertEquals(0, magician.getMagics().size());
    }

    @Test
    public void test_Magician_Set_Username_Should_Throws_Exception_If_Null()
    {

        assertThrows(NullPointerException.class,
                () -> new Magician(null, 5),
                "Cannot be null!");

    }

    @Test
    public void test_Magician_Set_Username_Should_Throws_Exception_If_Name_Length_Is_Smaller_Than_One()
    {

        assertThrows(NullPointerException.class,
                () -> new Magician("", 5),
                "Cannot be null!");

    }

    @Test
    public void test_Magician_Set_Health_Should_Throws_Exception_If_Negative()
    {

        assertThrows(IllegalArgumentException.class,
                () -> new Magician("NN", -1),
                "Health cannot be bellow zero!");

    }

    @Test
    public void test_Magician_Take_Damage_Should_Throws_Exception_If_Health_Negative()
    {
        magician  = new Magician("Ludmil", 5);
        magician.takeDamage(5);
        assertThrows(IllegalStateException.class,
                () -> magician.takeDamage(4),
                "Magician is dead!");

    }

    @Test
    public void test_Magician_Take_Damage_Should_Decrease_Health()
    {
        magician  = new Magician("Ludmil", 5);
        magician.takeDamage(9);
        Assertions.assertEquals(0, magician.getHealth());

    }

    @Test
    public void test_Magician_Add_Magic_Should_Throws_Exception_If_Magic_Null()
    {
        magician  = new Magician("Ludmil", 5);

        assertThrows(NullPointerException.class,
                () -> magician.addMagic(null),
                "Magic cannot be null!");

    }

    @Test
    public void test_Magician_Add_Magic_Should_Increase_Count()
    {
        magician  = new Magician("Ludmil", 5);
        magic = new Magic("N1", 10);
        magician.addMagic(magic);
        Assertions.assertEquals(1, magician.getMagics().size());

    }

    @Test
    public void test_Magician_RemoveMagic_Should_Return_True_If_Removal_Successful()
    {
        magician  = new Magician("Ludmil", 5);
        Magic magic1 = new Magic("N1", 10);
        Magic magic2 = new Magic("N2", 20);
        magician.addMagic(magic1);
        magician.addMagic(magic2);
        Assertions.assertTrue(magician.removeMagic(magic1));
    }

    @Test
    public void test_Magician_GetMagic_Should_Return_Magic_By_Name()
    {
        magician  = new Magician("Ludmil", 5);
        Magic magic1 = new Magic("N1", 10);
        Magic magic2 = new Magic("N2", 20);
        magician.addMagic(magic1);
        magician.addMagic(magic2);
        Assertions.assertEquals(magic2, magician.getMagic("N2"));
    }
}
