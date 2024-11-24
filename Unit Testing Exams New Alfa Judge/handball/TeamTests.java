package handball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeamTests
{

    HandballPlayer handballPlayer;
    Team team;
    @Test
    public void test_HandballPlayer_Constructor_Should_Initialize_Correctly()
    {
        handballPlayer = new HandballPlayer("Ludmil");
        Assertions.assertEquals("Ludmil", handballPlayer.getName());
        Assertions.assertTrue(handballPlayer.isActive());
    }
    @Test
    public void test_Team_Constructor_Should_Initialize_Correctly()
    {
        team = new Team("Botev", 5);
        Assertions.assertEquals("Botev", team.getName());
        Assertions.assertEquals(5, team.getPosition());
        Assertions.assertEquals(0, team.getCount());
    }
    @Test
    public void test_Team_setName_Should_Throws_Exception_If_Name_Null()
    {
        //team = new Team("Botev", 5);
        assertThrows(NullPointerException.class,
                () -> new Team(null, 5),
                "Invalid name.");
    }

    @Test
    public void test_Team_setName_Should_Throws_Exception_If_Name_Empty()
    {
        //team = new Team("Botev", 5);
        assertThrows(NullPointerException.class,
                () -> new Team("  ", 5),
                "Invalid name.");
    }

    @Test
    public void test_Team_setPosition_Should_Throws_Exception_If_Position_Negative()
    {
       // team = new Team("Botev", 5);
        assertThrows(IllegalArgumentException.class,
                () -> new Team("Botev", -1),
                "Invalid vacant position.");
    }

    @Test
    public void test_Team_add_Should_Throws_Exception_If_Position_Full()
    {
        team = new Team("Botev", 3);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        assertThrows(IllegalArgumentException.class,
                () -> team.add(handballPlayer4),
                "Full team.");
    }

    @Test
    public void test_Team_remove_Should_Throws_Exception_If_Player_Not_Exist()
    {
        team = new Team("Botev", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        assertThrows(IllegalArgumentException.class,
                () -> team.remove("N4"),
                "A player named N4 is not on the team.");
    }

    @Test
    public void test_Team_remove_Should_Decrease_Count()
    {
        team = new Team("Botev", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        team.remove("N3");
        Assertions.assertEquals(2, team.getCount());
    }

    @Test
    public void test_Team_playerForAnotherTeam_Should_Throws_Exception_If_Player_Is_In_Other_Team()
    {
        team = new Team("Botev", 10);
        Team team1 = new Team("Botev1", 11);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        assertThrows(IllegalArgumentException.class,
                () -> team1.playerForAnotherTeam("N5"),
                "A player named N5 is not on the team.");
    }
    @Test
    public void test_Team_playerForAnotherTeam_Should_SetActive_To_False()
    {
        team = new Team("Botev", 10);

        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");

        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        team.playerForAnotherTeam("N3");
        Assertions.assertFalse(handballPlayer3.isActive());
    }

    @Test
    public void test_Team_getStatistics_Should_Return_Correct_String()
    {
        team = new Team("Botev", 10);

        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");

        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);

        Assertions.assertEquals("The player N1, N2, N3 is in the team Botev.", team.getStatistics());
    }


}
