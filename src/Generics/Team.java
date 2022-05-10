package Generics;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    int won;
    int loss;
    int tied;
    int played;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName()+" is already in team");
            return false;
        }
        members.add(player);
        System.out.println(player.getName()+" is picked for team "+name);
        return true;
    }

    public int numPlayers(){
        return members.size();
    }
    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        if(ourScore > theirScore){
            won++;
        }else if(ourScore < theirScore){
            loss--;
        }else {
            tied++;
        }
        played++;
        if(opponent!=null){
            opponent.matchResult(null,theirScore,ourScore);
        }
    }
    public int ranking(){
        return (won*2)+tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(ranking() > team.ranking()){
            return -1;
        }else if (ranking() < team.ranking()){
            return 1;
        }
        return 0;
    }
}
