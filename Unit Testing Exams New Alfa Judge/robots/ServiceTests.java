package robots;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTests {

    Robot robot;
    Service service;

    @Test
    public void test_Robot_Constructor_Should_Initialize_Correctly()
    {
        robot = new Robot("Ludmil");
        Assertions.assertEquals("Ludmil", robot.getName());
        Assertions.assertTrue(robot.isReadyForSale());
    }

    @Test
    public void test_Service_Constructor_Should_Initialize_Correctly()
    {
        service = new Service("Vetren", 3);
        Assertions.assertEquals("Vetren", service.getName());
        Assertions.assertEquals(3, service.getCapacity());
        Assertions.assertEquals(0, service.getCount());
    }

    @Test
    public void test_Service_Set_Name_Should_Throws_Exception_If_Name_Null()
    {
        assertThrows(NullPointerException.class,
                () -> new Service(null, 3),
                "Invalid name!");

    }

    @Test
    public void test_Service_Set_Name_Should_Throws_Exception_If_Name_Empty()
    {
        assertThrows(NullPointerException.class,
                () -> new Service("   ", 3),
                "Invalid name!");

    }

    @Test
    public void test_Service_Set_Capacity_Should_Throws_Exception_If_Capacity_Negative()
    {
        assertThrows(IllegalArgumentException.class,
                () -> new Service("Vetren", -1),
                "Invalid capacity!");

    }

    @Test
    public void test_Service_Add_Should_Throws_Exception_If_Capacity_Full()
    {
        service = new Service("Vetren", 3);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        assertThrows(IllegalArgumentException.class,
                () -> service.add(robot4),
                "Full service!");

    }

    @Test
    public void test_Service_Remove_Should_Throws_Exception_If_Robot_Not_Exist()
    {
        service = new Service("Vetren", 10);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        assertThrows(IllegalArgumentException.class,
                () -> service.remove("N4"),
                "Robot with name N4 doesn't exist!");

    }

    @Test
    public void test_Service_Remove_Should_Decrease_Count()
    {
        service = new Service("Vetren", 10);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        service.remove("N3");
        Assertions.assertEquals(2, service.getCount());

    }

    @Test
    public void test_Service_forSale_Should_Throws_Exception_If_Robot_Not_Exist()
    {
        service = new Service("Vetren", 10);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        assertThrows(IllegalArgumentException.class,
                () -> service.forSale("N4"),
                "Robot with name N4 doesn't exist!");

    }

    @Test
    public void test_Service_forSale_Should_Set_isReadyForSale_To_False()
    {
        service = new Service("Vetren", 10);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);
        service.forSale("N3");
        Assertions.assertFalse(robot3.isReadyForSale());

    }

    @Test
    public void test_Service_report_Should_Return_Correct_String()
    {
        service = new Service("Vetren", 10);
        Robot robot1 = new Robot("N1");
        Robot robot2 = new Robot("N2");
        Robot robot3 = new Robot("N3");
        Robot robot4 = new Robot("N4");
        service.add(robot1);
        service.add(robot2);
        service.add(robot3);

        Assertions.assertEquals("The robot N1, N2, N3 is in the service Vetren!", service.report());

    }
}
