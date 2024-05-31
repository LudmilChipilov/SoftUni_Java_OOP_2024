package footballTeam;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Player>> teamNamePlayers = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while(!command.equals("END"))
        {
            String[] comArgs = command.split(";");
            if(command.contains("Team"))
            {
                String teamName = comArgs[1];
                teamNamePlayers = addNewTeam(teamNamePlayers, teamName);
            }
            else if(command.contains("Add"))
            {
                try
                {
                    String teamName = comArgs[1];
                    teamNamePlayers = addNewPlayerToTheTeam(teamNamePlayers, comArgs);
                }
                catch (IllegalArgumentException iae)
                {
                    System.out.println(iae.getMessage());
                }
            }
            else if(command.contains("Remove"))
            {
                removePlayerFromTheTeam(teamNamePlayers, comArgs);
            }
            else if(command.contains("Rating"))
            {
                printTeamRating(teamNamePlayers, comArgs);
            }
            command = scanner.nextLine();
        }


    }
    public static Map<String, List<Player>> addNewTeam(Map<String, List<Player>> teamNamePlayers,  String teamName)
    {
        if(teamNamePlayers.isEmpty() || !teamNamePlayers.containsKey(teamName))
        {
            List<Player> players = new ArrayList<>();
            teamNamePlayers.put(teamName, players);
        }

        return teamNamePlayers;
    }
    public static Map<String, List<Player>> addNewPlayerToTheTeam(Map<String, List<Player>> teamNamePlayers,  String[] comArgs)
    {
        String teamName = comArgs[1];
        Team team = new Team(teamName);
        //{PlayerName};{Endurance};{Sprint};{Dribble};{Passing};{Shooting}
        String playerName = comArgs[2];
        int endurance = Integer.parseInt(comArgs[3]);
        int sprint = Integer.parseInt(comArgs[4]);
        int dribble = Integer.parseInt(comArgs[5]);
        int passing = Integer.parseInt(comArgs[6]);
        int shooting = Integer.parseInt(comArgs[7]);
        if(teamNamePlayers.isEmpty() || !teamNamePlayers.containsKey(teamName))
        {
             System.out.printf("Team %s does not exist.%n", teamName);
        }
        else
        {
            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);


            List<Player> temp = teamNamePlayers.get(teamName);
            temp.add(player);
            teamNamePlayers.put(teamName, temp);
        }
        return teamNamePlayers;
    }
    public static Map<String, List<Player>> removePlayerFromTheTeam(Map<String, List<Player>> teamNamePlayers,  String[] comArgs)
    {
        String teamName = comArgs[1];
        String playerName = comArgs[2];
        List<Player> tempPlayers = teamNamePlayers.get(teamName);
        for(int i = 0; i < tempPlayers.size(); i++)
        {
            if(tempPlayers.get(i).getName().equals(playerName))
            {
                Player toRemove = tempPlayers.get(i);
                teamNamePlayers.get(teamName).remove(toRemove);
                return teamNamePlayers;
            }
        }
        System.out.printf("Player %s is not in %s team.%n", playerName, teamName);

        return teamNamePlayers;
    }
    public static void printTeamRating(Map<String, List<Player>> teamNamePlayers, String[] comArgs)
    {
        String teamName = comArgs[1];
        Team team = new Team(teamName);
        if(teamNamePlayers.containsKey(teamName))
        {
            List<Player> tempPlayers = teamNamePlayers.get(teamName);
            double sumAverages = calculateAverageTeamRating(tempPlayers);
            System.out.printf("%s - %d%n", teamName, Math.round(sumAverages));
        }
        else
        {
            System.out.printf("Team %s does not exist.%n", teamName);
        }
    }
    public static double calculateAverageTeamRating( List<Player> tempPlayers)
    {
        double sumAverages = 0;
        for(Player player : tempPlayers)
        {
            sumAverages += player.overallSkillLevel();
        }
        if(tempPlayers.size() > 1)
        {
            sumAverages /= tempPlayers.size()*1.0;
        }
        return sumAverages;
    }
}