package football;

import org.junit.Test;
import org.junit.Assert;

public class FootballTeamTests
{
     Footballer footballer;
     FootballTeam footballTeam;
     @Test
    public void test_Footballer_Constructor_Should_Initialize_Correctly()
     {
         footballer = new Footballer("Ludmil");
         Assert.assertEquals("Ludmil", footballer.getName());
         Assert.assertTrue(footballer.isActive());

     }
    @Test
    public void test_FootballTeam_Constructor_Should_Initialize_Correctly()
    {
       footballTeam = new FootballTeam("Botev", 5);
       Assert.assertEquals("Botev", footballTeam.getName());
       Assert.assertEquals(5, footballTeam.getVacantPositions());
       Assert.assertEquals(0, footballTeam.getCount());
    }
    @Test(expected = NullPointerException.class)
    public void test_FootballTeam_setName_Should_Throw_Exception_If_Name_Null()
    {
        footballTeam = new FootballTeam(null, 5);
    }
    @Test(expected = NullPointerException.class)
    public void test_FootballTeam_setName_Should_Throw_Exception_If_Name_WhiteSpace()
    {
        footballTeam = new FootballTeam("  ", 5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_FootballTeam_setVacantPositions_Should_Throw_Exception_If_setVacantPositions_Negative()
    {
        footballTeam = new FootballTeam("Botev", -1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_FootballTeam_addFootballer_Should_Throw_Exception_If_VacantPositions_Is_Full()
    {
        footballTeam = new FootballTeam("Botev", 5);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");
        Footballer footballer4 = new Footballer("N4");
        Footballer footballer5 = new Footballer("N5");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
        footballTeam.addFootballer(footballer5);
        Footballer footballer6 = new Footballer("N6");
        footballTeam.addFootballer(footballer6);
    }
    @Test
    public void test_FootballTeam_addFootballer_Should_Increase_Count()
    {
        footballTeam = new FootballTeam("Botev", 5);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");
        Footballer footballer4 = new Footballer("N4");
        Footballer footballer5 = new Footballer("N5");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
        footballTeam.addFootballer(footballer5);

        Assert.assertEquals(5, footballTeam.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_FootballTeam_removeFootballer_Should_Throw_Exception_If_Footballer_Does_Not_Exist()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");
        Footballer footballer4 = new Footballer("N4");
        Footballer footballer5 = new Footballer("N5");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
        footballTeam.addFootballer(footballer5);
        Footballer footballer6 = new Footballer("N6");
        footballTeam.removeFootballer("N6");
    }
    @Test
    public void test_FootballTeam_removeFootballer_Should_Decrease_Count()
    {
        footballTeam = new FootballTeam("Botev", 5);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");
        Footballer footballer4 = new Footballer("N4");
        Footballer footballer5 = new Footballer("N5");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
        footballTeam.addFootballer(footballer5);

        footballTeam.removeFootballer("N5");
        Assert.assertEquals(4, footballTeam.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_FootballTeam_footballerForSale_Should_Throw_Exception_If_Footballer_Does_Not_Exist()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");
        Footballer footballer4 = new Footballer("N4");
        Footballer footballer5 = new Footballer("N5");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
        footballTeam.addFootballer(footballer5);
        Footballer footballer6 = new Footballer("N6");
        footballTeam.footballerForSale("N6");
    }
    @Test
    public void test_FootballTeam_footballerForSale_Should_Set_setActive_To_False()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");
        Footballer footballer4 = new Footballer("N4");
        Footballer footballer5 = new Footballer("N5");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
        footballTeam.addFootballer(footballer5);

        footballTeam.footballerForSale("N5");
        Assert.assertFalse(footballer5.isActive());
    }
    @Test
    public void test_FootballTeam_footballerForSale_Should_Return_Correct_Sold_Player()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");
        Footballer footballer4 = new Footballer("N4");
        Footballer footballer5 = new Footballer("N5");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
        footballTeam.addFootballer(footballer5);
        Assert.assertEquals(footballer5,  footballTeam.footballerForSale("N5"));
    }
    @Test
    public void test_FootballTeam_getStatistics_Should_Return_Correct_String()
    {
        footballTeam = new FootballTeam("Botev", 10);
        Footballer footballer1 = new Footballer("N1");
        Footballer footballer2 = new Footballer("N2");
        Footballer footballer3 = new Footballer("N3");
        Footballer footballer4 = new Footballer("N4");
        Footballer footballer5 = new Footballer("N5");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
        footballTeam.addFootballer(footballer5);
        Assert.assertEquals("The footballer N1, N2, N3, N4, N5 is in the team Botev.", footballTeam.getStatistics());
    }
}
