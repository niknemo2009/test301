package com.example.grey.zerro.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    String name;
    List<Ship> shipList = new ArrayList();
    Map<Point, ResultShot> enemyField = new HashMap<>();
    boolean isNextStep;

    public Player(String name) {
        this.name = name;
    }

    public void askPlayerForTurn() {

    }

    public ResultShot shot(int x, int y, Player enemy) {
        ResultShot result = enemy.getResultShotEnemy(x, y);
        return result;
    }

    private ResultShot getResultShotEnemy(int x, int y) {
        ResultShot result = ResultShot.MISS;

        for (Ship ship : shipList) {
            result = ship.checkHit(x, y);
            if (result != ResultShot.MISS) {
                break;
            }
        }

        return result;
    }
}

enum ResultShot {
    MISS, KILL, HIT
}
