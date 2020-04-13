package com.example.grey.zerro.entity;

import java.util.ArrayList;
import java.util.List;

public class Game {
    String name;
    Player currentPlayer;
    List<Player> players = new ArrayList<>();
    final int MIN_PLAYER_COUNT_TO_START =2;

    public Game(String name) {
        this.name = name;
    }

    private Player getEnemy(Player player) {
        Player result=null;
        for(Player temp: players){
            if(temp!=player){
                result=temp;
            }
        }
        return result;
    }

    private List<Player> getActivePlayer() {
        List<Player> result=new ArrayList<>();
        if (players.size()< MIN_PLAYER_COUNT_TO_START){
            return result;
        }
        for (Player temp: players) {
           if (temp.isNextStep==true) {
               result.add(temp);
               break;
           }
           if (result.size()==0) {
               players.get(0).isNextStep=true;
               result.add(players.get(0));
           }
        }
        return  result;
    }

    public boolean addPlayer(Player Player) {
        boolean result = false;

        if(players.size() < MIN_PLAYER_COUNT_TO_START){
            result = players.add(Player);
        }

        return result;
    }

}
