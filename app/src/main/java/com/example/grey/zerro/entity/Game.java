package com.example.grey.zerro.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {
    List<Plaer> gamers=new ArrayList<>();
    String name;
    final int COUNT_PLAYER=2;

    public Game(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Game game=new Game("testGame");
        game.add(new Plaer());
        game.add(new Plaer());
        Plaer pl=game.getActivePlayer().get(0);
        ResultShot result=pl.shot(3,7,game.getEnemy(pl));
    }

    private Plaer getEnemy(Plaer player) {
        Plaer result=null;
        for(Plaer temp:gamers){
            if(temp!=player){
                result=temp;
            }
        }
        return result;
    }

    private List<Plaer> getActivePlayer() {
        List<Plaer> result=new ArrayList<>();
        if(gamers.size()<COUNT_PLAYER){
            return result;
        }
        for (Plaer temp:  gamers) {
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

    private boolean add(Plaer plaer) {
        boolean result=false;
        if(!(gamers.size()>COUNT_PLAYER-1)){
            result=gamers.add(plaer);
        }
        return result;
    }

}
