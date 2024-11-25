package robots;

import org.junit.Test;
import org.junit.Assert;

public class ServiceTests
{
    Robot robot;
    Service service;
    @Test
    public void test_Robot_Constructor_Should_Initialize_Correctly()
    {
         robot = new Robot("Ludmil");
         Assert.assertEquals("Ludmil", robot.getName());
         Assert.assertTrue(robot.isReadyForSale());
    }
    @Test
    public void test_Service_Constructor_Should_Initialize_Correctly()
    {
       service = new Service("Vetren", 5);
       Assert.assertEquals("Vetren", service.getName());
       Assert.assertEquals(5, service.getCapacity());
       Assert.assertEquals(0, service.getCount());
    }
    @Test(expected = NullPointerException.class)
    public void test_Service_setName_Should_Throws_Exception_If_Name_Null()
    {
        service = new Service(null, 5);

    }
    @Test(expected = NullPointerException.class)
    public void test_Service_setName_Should_Throws_Exception_If_Name_WhiteSpace()
    {
        service = new Service("  ", 5);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Service_setCapacity_Should_Throws_Exception_If_Capacity_Negative()
    {
        service = new Service("Vetren", -1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Service_add_Should_Throws_Exception_If_Capacity_Full()
    {
        service = new Service("Vetren", 5);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        Robot robot5 = new Robot("N5");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        service.add(robot4);
        service.add(robot5);
        Robot robot6 = new Robot("N6");
        service.add(robot6);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Service_remove_Should_Throws_Exception_If_Robot_Does_Not_Exist()
    {
        service = new Service("Vetren", 10);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        Robot robot5 = new Robot("N5");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        service.add(robot4);
        service.add(robot5);
        Robot robot6 = new Robot("N6");
        service.remove("N6");

    }
    @Test
    public void test_Service_remove_Should_Decrease_Count()
    {
        service = new Service("Vetren", 10);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        Robot robot5 = new Robot("N5");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        service.add(robot4);
        service.add(robot5);

        service.remove("N5");
        Assert.assertEquals(4, service.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Service_forSale_Should_Throws_Exception_If_Robot_Does_Not_Exist()
    {
        service = new Service("Vetren", 10);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        Robot robot5 = new Robot("N5");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        service.add(robot4);
        service.add(robot5);
        Robot robot6 = new Robot("N6");
        service.forSale("N6");

    }
    @Test
    public void test_Service_forSale_Should_Set_isReadyForSale_To_False()
    {
        service = new Service("Vetren", 10);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        Robot robot5 = new Robot("N5");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        service.add(robot4);
        service.add(robot5);
        service.forSale("N4");
        Assert.assertFalse(robot4.isReadyForSale());
    }
    @Test
    public void test_Service_report_Should_Return_Correct_String()
    {
        service = new Service("Vetren", 10);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        Robot robot5 = new Robot("N5");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        service.add(robot4);
        service.add(robot5);
        service.forSale("N4");
        Assert.assertEquals("The robot N1, N2, N3, N4, N5 is in the service Vetren!", service.report());
    }
}
