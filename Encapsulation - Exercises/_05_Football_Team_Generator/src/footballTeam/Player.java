package footballTeam;

public class Player
{
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting)
    {
       this.setName(name);
       this.setEndurance(endurance);
       this.setSprint(sprint);
       this.setDribble(dribble);
       this.setPassing(passing);
       this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name)
    {
        if(name == null || name.isEmpty() || name.equals(" "))
        {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance)
    {
        if(!checkIfStatsIsInRange(endurance))
        {
            //System.out.println("Endurance should be between 0 and 100.");
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;


    }

    private void setSprint(int sprint)
    {
        if(!checkIfStatsIsInRange(sprint))
        {
           // System.out.println("Sprint should be between 0 and 100.");
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;

    }

    private void setDribble(int dribble)
    {
        if(!checkIfStatsIsInRange(dribble))
        {
            //System.out.println("Dribble should be between 0 and 100.");
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;


    }

    private void setPassing(int passing)
    {
        if(!checkIfStatsIsInRange(passing))
        {
            //System.out.println("Passing should be between 0 and 100.");
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;


    }

    private void setShooting(int shooting)
    {
        if(!checkIfStatsIsInRange(shooting))
        {
            //System.out.println("Shooting should be between 0 and 100.");
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;


    }
    private boolean checkIfStatsIsInRange(int stat)
    {
        if(stat < 0 || stat > 100)
        {
            return false;
        }
        return true;
    }
    public double overallSkillLevel()
    {
         return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }
}
