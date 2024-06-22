package computers;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComputerManagerTests
{
    final double DELTA = 0.00000;
    Computer computer;
    ComputerManager computerManager;
    @Test
    public void test_Computer_Constructor_Should_Initialize_Correctly()
    {
        computer = new Computer("IBM", "Intel", 100.00);
        Assert.assertEquals("IBM", computer.getManufacturer());
        Assert.assertEquals("Intel", computer.getModel());
        Assert.assertEquals(100.00, computer.getPrice(), DELTA);
    }
    @Test
    public void test_ComputerManager_Constructor_Should_Initialize_Correctly()
    {
        computerManager = new ComputerManager();
        Assert.assertEquals(0, computerManager.getCount());
        Assert.assertEquals(0, computerManager.getComputers().size());
        List<Computer> expected = new ArrayList<>();
        Assert.assertEquals(expected, computerManager.getComputers());
    }
    @Test
    public void test_ComputerManager_addComputer_Should_Throw_Exception_If_Computer_Already_Exist()
    {
        computerManager = new ComputerManager();
        computer = new Computer("IBM", "Intel", 100.00);
        computerManager.addComputer(computer);
        try
        {
            computerManager.addComputer(computer);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println(iae.getMessage());
        }
    }
    @Test
    public void test_ComputerManager_addComputer_Should_Increase_Count()
    {
        computerManager = new ComputerManager();
        computer = new Computer("IBM", "Intel", 100.00);
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());
        Assert.assertEquals(1, computerManager.getComputers().size());
    }
    @Test
    public void test_ComputerManager_removeComputer_Should_Remove_And_Return_Computer()
    {
        computerManager = new ComputerManager();
        computer = new Computer("IBM", "Intel", 100.00);
        computerManager.addComputer(computer);

        Assert.assertEquals(computer, computerManager.removeComputer("IBM", "Intel"));

    }
    @Test
    public void test_ComputerManager_removeComputer_Should_Decrease_Count()
    {
        computerManager = new ComputerManager();
        computer = new Computer("IBM", "Intel", 100.00);
        computerManager.addComputer(computer);
        computerManager.removeComputer("IBM", "Intel");
        Assert.assertEquals(0, computerManager.getCount());
    }
    @Test
    public void test_ComputerManager_getComputer_Should_Throw_Exception_If_Computer_Does_Not_Exist()
    {
        computerManager = new ComputerManager();
        computer = new Computer("IBM", "Intel", 100.00);
        computerManager.addComputer(computer);
        try
        {
            computerManager.getComputer("IBM1", "Intel");
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println(iae.getMessage());
        }
    }
    @Test
    public void test_ComputerManager_getComputer_Should_Return_Computer_Correctly()
    {
        computerManager = new ComputerManager();
        computer = new Computer("IBM", "Intel", 100.00);
        computerManager.addComputer(computer);
        Assert.assertEquals(computer, computerManager.getComputer("IBM", "Intel"));
    }
    @Test
    public void test_ComputerManager_getComputersByManufacturer_Should_Return_Computers_By_Given_Manufacturer()
    {
        computerManager = new ComputerManager();
        Computer computer1 = new Computer("M1", "N1", 100.00);
        Computer computer2 = new Computer("M1", "N2", 200.00);
        Computer computer3 = new Computer("M2", "N3", 300.00);
        Computer computer4 = new Computer("M3", "N4", 400.00);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer3);
        computerManager.addComputer(computer4);
        List<Computer> expected = new ArrayList<>();
        expected.add(computer1);
        expected.add(computer2);

        Assert.assertEquals(expected, computerManager.getComputersByManufacturer("M1"));
    }
    @Test
    public void test_ComputerManager_validateNullValue_Should_Throw_Exception_If_Variable_Null() throws IllegalArgumentException {
        computerManager = new ComputerManager();
        Method[] methods = computerManager.getClass().getDeclaredMethods();
        Method method = Arrays.stream(methods)
                .filter(m -> m.getName().equals("validateNullValue"))
                .findFirst().orElse(null);
        method.setAccessible(true);
        try
        {
            Object variable = null;
            method.invoke( variable, "Invalid");
        }
        catch (NullPointerException | IllegalAccessException | InvocationTargetException npe)
        {
            System.out.println(npe.getMessage());
        }
    }
}