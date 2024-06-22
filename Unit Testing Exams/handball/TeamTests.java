package handball;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TeamTests
{
    HandballPlayer handballPlayer;
    Team team;
    @Test
    public void test_HandballPlayer_Constructor_Should_Initialize_Correctly()
    {
        handballPlayer = new HandballPlayer("Ludmil");
        Assert.assertEquals("Ludmil", handballPlayer.getName());
        Assert.assertTrue(handballPlayer.isActive());
    }
    @Test
    public void test_Team_Constructor_Should_Initialize_Correctly()
    {
       team = new Team("Vetren", 5);
       Assert.assertEquals("Vetren", team.getName());
       Assert.assertEquals(5, team.getPosition());
       Assert.assertEquals(0, team.getCount());

    }
    @Test(expected = NullPointerException.class)
    public void test_Team_setName_Should_Throws_Exception_If_Name_Null()
    {
        team = new Team(null, 5);
    }
    @Test(expected = NullPointerException.class)
    public void test_Team_setName_Should_Throws_Exception_If_Name_Empty()
    {
        team = new Team("  ", 5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Team_setPosition_Should_Throws_Exception_If_Position_Negative()
    {
        team = new Team("Vetren", -1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Team_add_Should_Throws_Exception_If_Position_Is_Full()
    {
        team = new Team("Vetren", 5);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        HandballPlayer handballPlayer5 = new HandballPlayer("N5");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        team.add(handballPlayer4);
        team.add(handballPlayer5);
        HandballPlayer handballPlayer6 = new HandballPlayer("N6");
        team.add(handballPlayer6);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Team_remove_Should_Throws_Exception_If_Player_Does_Not_Exist()
    {
        team = new Team("Vetren", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        HandballPlayer handballPlayer5 = new HandballPlayer("N5");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        team.add(handballPlayer4);
        team.add(handballPlayer5);
        team.remove("N6");
    }
    @Test
    public void test_Team_remove_Should_Decrease_Count()
    {
        team = new Team("Vetren", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        HandballPlayer handballPlayer5 = new HandballPlayer("N5");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        team.add(handballPlayer4);
        team.add(handballPlayer5);
        team.remove("N5");
        Assert.assertEquals(4, team.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Team_playerForAnotherTeam_Should_Throws_Exception_If_Player_Is_Not_In_Team()
    {
        team = new Team("Vetren", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        HandballPlayer handballPlayer5 = new HandballPlayer("N5");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        team.add(handballPlayer4);
        team.add(handballPlayer5);
        team.playerForAnotherTeam("N6");
    }
    @Test
    public void test_Team_playerForAnotherTeam_Should_Set_isActive_To_False()
    {
        team = new Team("Vetren", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        HandballPlayer handballPlayer5 = new HandballPlayer("N5");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        team.add(handballPlayer4);
        team.add(handballPlayer5);
        team.playerForAnotherTeam("N5");
        Assert.assertFalse(handballPlayer5.isActive());
    }
    @Test
    public void test_Team_playerForAnotherTeam_Should_Return_Correct_Player()
    {
        team = new Team("Vetren", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        HandballPlayer handballPlayer5 = new HandballPlayer("N5");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        team.add(handballPlayer4);
        team.add(handballPlayer5);

        Assert.assertEquals(handballPlayer5,  team.playerForAnotherTeam("N5"));
    }
    @Test
    public void test_Team_getStatistics_Should_Return_Correct_String()
    {
        team = new Team("Vetren", 10);
        HandballPlayer handballPlayer1 = new HandballPlayer("N1");
        HandballPlayer handballPlayer2 = new HandballPlayer("N2");
        HandballPlayer handballPlayer3 = new HandballPlayer("N3");
        HandballPlayer handballPlayer4 = new HandballPlayer("N4");
        HandballPlayer handballPlayer5 = new HandballPlayer("N5");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        team.add(handballPlayer3);
        team.add(handballPlayer4);
        team.add(handballPlayer5);

        Assert.assertEquals("The player N1, N2, N3, N4, N5 is in the team Vetren.", team.getStatistics());
    }
    
}
