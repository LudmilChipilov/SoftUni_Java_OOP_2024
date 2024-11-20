package football;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FootballTeamTests {
    Footballer footballer;
    FootballTeam footballTeam;

    @Test
    public void test_Footballer_Constructor_Should_Initialize_Correctly()
    {
        footballer = new Footballer("Ludmil");
        Assertions.assertEquals("Ludmil", footballer.getName());
        Assertions.assertTrue(footballer.isActive());
    }

    @Test
    public void test_FootballTeam_Constructor_Should_Initialize_Correctly()
    {
       footballTeam = new FootballTeam("Botev", 3);
       Assertions.assertEquals("Botev", footballTeam.getName());
       Assertions.assertEquals(3, footballTeam.getVacantPositions());
       Assertions.assertEquals(0, footballTeam.getCount());

    }

    @Test
    public void test_FootballTeam_setName_Should_Throws_Exception_If_Name_Null()
    {
        assertThrows(NullPointerException.class,
                () -> new FootballTeam(null, 3),
                "Invalid name.");

    }

    @Test
    public void test_FootballTeam_setName_Should_Throws_Exception_If_Name_Empty()
    {
        assertThrows(NullPointerException.class,
                () -> new FootballTeam("   ", 3),
                "Invalid name.");

    }

    @Test
    public void test_FootballTeam_setVacantPositions_Should_Throws_Exception_If_Position_Negative()
    {
        assertThrows(IllegalArgumentException.class,
                () -> new FootballTeam("Botev", -1),
                "Invalid vacant position.");

    }

    @Test
    public void test_FootballTeam_addFootballer_Should_Throws_Exception_If_Vacant_Positions_Full()
    {
        footballTeam = new FootballTeam("Botev", 3);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");
        Footballer footballer4 = new Footballer("N4");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        assertThrows(IllegalArgumentException.class,
                () -> footballTeam.addFootballer(footballer4),
                "Football team is full.");

    }

    @Test
    public void test_FootballTeam_removeFootballer_Should_Throws_Exception_If_Footballer_Does_Not_Exist()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        assertThrows(IllegalArgumentException.class,
                () -> footballTeam.removeFootballer("N4"),
                "A footballer named N4 is not on the soccer team.");

    }

    @Test
    public void test_FootballTeam_removeFootballer_Should_Decrease_Count()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.removeFootballer("N3");
        Assertions.assertEquals(2, footballTeam.getCount());

    }

    @Test
    public void test_FootballTeam_footballerForSale_Should_Throws_Exception_If_Footballer_Does_Not_Exist()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        assertThrows(IllegalArgumentException.class,
                () -> footballTeam.footballerForSale("N4"),
                "A footballer named N4 is not on the soccer team.");

    }

    @Test
    public void test_FootballTeam_footballerForSale_Should_Set_SetActive_To_False()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.footballerForSale("N1");
        Assertions.assertFalse(footballer1.isActive());

    }

    @Test
    public void test_FootballTeam_footballerForSale_Should_Return_Correct_Footballer()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        Assertions.assertEquals(footballer1, footballTeam.footballerForSale("N1"));

    }

    @Test
    public void test_FootballTeam_getStatistics_Should_Return_Correct_String()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        Assertions.assertEquals("The footballer N1, N2, N3 is in the team Botev.", footballTeam.getStatistics());

    }


}
