package com.example.grey.zerro.entity;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> gamers=new ArrayList<>();
    String name;
    int[] nabirTemplate={1};
    final int COUNT_PLAYER=2;

    public Game(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Game game=new Game("testGame");
        game.add(new Player(game.nabirTemplate));
        game.add(new Player(game.nabirTemplate));
        Player pl=game.getActivePlayer().get(0);
        Player pl33=game.getEnemy(pl);
        pl.flot.get(0).setPosition(new Point(3,4),false);
        pl33.flot.get(0).setPosition(new Point(5,5),false);
        ResultShot result=pl.shot(3,7,game.getEnemy(pl));
    }

    private Player getEnemy(Player player) {
        Player result=null;
        for(Player temp:gamers){
            if(temp!=player){
                result=temp;
            }
        }
        return result;
    }

    private List<Player> getActivePlayer() {
        List<Player> result=new ArrayList<>();
        if(gamers.size()<COUNT_PLAYER){
            return result;
        }
        for (Player temp:  gamers) {
           if(temp.isNextStep==true){
               result.add(temp);
               break;
           }
           if(result.size()==0){
               gamers.get(0).isNextStep=true;
               result.add(gamers.get(0));
           }
        }
        return  result;
    }

    private boolean add(Player plaer) {
        boolean result=false;
        if(!(gamers.size()>COUNT_PLAYER-1)){
            result=gamers.add(plaer);
        }
        return result;
    }

}
