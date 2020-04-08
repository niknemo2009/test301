package com.example.grey.zerro.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Plaer {
    String nik;
    List<Ship> flot=new ArrayList();
    Map<Point,ResultShot> enemyField=new HashMap<>();
    boolean isNextStep;


    public ResultShot shot(int x, int y,Plaer enemy) {
        ResultShot result=enemy.getResultShotEnemy(x,y);
return  result;
    }

    private ResultShot getResultShotEnemy(int x, int y) {
    ResultShot result=ResultShot.MILK;
        for(Ship temp:flot){
        result=temp.checkState(x,y);
        if(result!=ResultShot.MILK){
            break;
        }
    }
        return  result;
    }
}

enum ResultShot{
    MILK,KILL,HIT
}
