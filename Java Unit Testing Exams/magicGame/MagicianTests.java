package magicGame;

import org.junit.Test;
import org.junit.Assert;

public class MagicianTests
{
    Magic magic;
    Magician magician;
    @Test
    public void test_Magic_Constructor_Should_Initialize_Correctly()
    {
        magic = new Magic("Ludmil", 5);
        Assert.assertEquals("Ludmil", magic.getName());
        Assert.assertEquals(5, magic.getBullets());
    }
    @Test
    public void test_Magician_Constructor_Should_Initialize_Correctly()
    {
        magician = new Magician("userLud", 5);
        Assert.assertEquals("userLud", magician.getUsername());
        Assert.assertEquals(5, magician.getHealth());
        Assert.assertEquals(0, magician.getMagics().size());
    }
    @Test(expected = NullPointerException.class)
    public void test_Magician_setUsername_Should_Throws_Exception_If_UserName_Null()
    {
        magician = new Magician(null, 5);

    }
    @Test(expected = NullPointerException.class)
    public void test_Magician_setUsername_Should_Throws_Exception_If_UserName_Empty()
    {
        magician = new Magician("", 5);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Magician_setHealth_Should_Throws_Exception_If_Health_Negative()
    {
        magician = new Magician("userLud", -1);

    }
    @Test(expected = IllegalStateException.class)
    public void test_Magician_takeDamage_Should_Throws_Exception_If_Health_Negative()
    {
        magician = new Magician("userLud", 10);
        magician.takeDamage(10);
        magician.takeDamage(1);

    }
    @Test
    public void test_Magician_takeDamage_Should_Decrease_Health_Or_Set_To_Zero()
    {
        magician = new Magician("userLud", 10);
        magician.takeDamage(11);
        Assert.assertEquals(0, magician.getHealth());

    }
    @Test(expected = NullPointerException.class)
    public void test_Magician_addMagic_Should_Throws_Exception_If_Magic_Null()
    {
        magician = new Magician("userLud", 10);
        magic = null;
        magician.addMagic(magic);
    }
    @Test
    public void test_Magician_addMagic_Should_Increase_Size_Of_Collection()
    {
        magician = new Magician("userLud", 10);
        magic = new Magic("Ludmil", 5);
        magician.addMagic(magic);
        Assert.assertEquals(1, magician.getMagics().size());
    }
    @Test
    public void test_Magician_removeMagic_Should_Return_True_If_Removal_Successful()
    {
        magician = new Magician("userLud", 10);
        magic = new Magic("Ludmil", 5);
        magician.addMagic(magic);
        Assert.assertTrue(magician.removeMagic(magic));
    }
    @Test
    public void test_Magician_removeMagic_Should_Return_False_If_Removal_Not_Successful()
    {
        magician = new Magician("userLud", 10);
        magic = new Magic("Ludmil", 5);
        magician.addMagic(magic);
        Magic magic1 = new Magic("Lu", 10);
        Assert.assertFalse(magician.removeMagic(magic1));
    }
    @Test
    public void test_Magician_getMagic_Should_Return_Magic_With_Given_Name()
    {
        magician = new Magician("userLud", 10);
        magic = new Magic("Ludmil", 5);
        magician.addMagic(magic);
        Magic magic1 = new Magic("Lu", 10);
        Assert.assertEquals(magic, magician.getMagic("Ludmil"));
    }
    @Test
    public void test_Magician_getMagic_Should_Return_Null_If_Magic_Not_Exist()
    {
        magician = new Magician("userLud", 10);
        magic = new Magic("Ludmil", 5);
        magician.addMagic(magic);
        Magic magic1 = new Magic("Lu", 10);
        Assert.assertEquals(null, magician.getMagic("Lud"));
    }
}
