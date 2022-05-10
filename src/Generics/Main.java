package Generics;

public class Main {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckman = new SoccerPlayer("Beckman");

        Team<FootballPlayer> adelideCrows = new Team<>("Adelide Crows");
        adelideCrows.addPlayer(joe);
//        adelideCrows.addPlayer(pat);

        Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Chicago Cubs");
        baseballPlayerTeam.addPlayer(pat);
//        baseballPlayerTeam.addPlayer(beckman);
//        System.out.println(adelideCrows.numPlayers());
//        Team<String> baseballPlayerTeam = new Team<>("Chicago Cubs");

//        adelideCrows.matchResult(baseballPlayerTeam);
    }
}
