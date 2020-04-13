package com.example.grey.zerro.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    String nik;
    int[] nabirTemplate;
    List<Ship> flot=new ArrayList();
    Map<Point,ResultShot> enemyField=new HashMap<>();
    boolean isNextStep;

    public Player(int[] nabirTemplate) {
        this.nabirTemplate=nabirTemplate;
        for(int temp:nabirTemplate){
            flot.add(new Ship(null,null,this.getShipSize(temp),null,false ));
        }
    }


    public ResultShot shot(int x, int y, Player enemy) {
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
    ShipSize getShipSize(int countTrub){
        ShipSize result=null;
        for(ShipSize temp:ShipSize.values()){
            if(temp.countTrub==countTrub){
                result=temp;
                break;
            }
        }
        return result;
    }
     class Ship {
        String name;
        String picture;
        ShipSize size;
        Point startPoint;
        boolean isHorizontal;
        boolean isActive = true;
        List<Point> cells = new ArrayList();

        public Ship(String name, String picture, ShipSize size, Point startPoint, boolean isHorizontal) {
            this.name = name;
            this.picture = picture;
            this.size = size;
            this.startPoint = startPoint;
            this.isHorizontal = isHorizontal;


        }

         boolean setPosition(Point startPoint, boolean flagHorizont) {
           boolean result=false;
            if(checkPosition(startPoint,flagHorizont)){
                   result=true;
                cells.add(startPoint);
                this.isHorizontal=flagHorizont;
                int currentY = startPoint.getY();
                int currentX = startPoint.getX();
                for (int i = 1; i < size.countTrub; i++) {
                    int tempY = isHorizontal ? currentY : currentY++;
                    int tempX = isHorizontal ? currentX++ : currentX;
                    Point pointNext = new Point(tempX, tempY);
                }

            }
            return result;
                   }

        private boolean checkPosition(Point startPoint, boolean flagHorizont) {
            // TODO: 4/13/2020  not found check  right position
            return false;
        }




        @Override
        public String toString() {
            return "Ship{" +
                    "name='" + name + '\'' +
                    ", picture='" + picture + '\'' +
                    ", size=" + size +
                    ", startPoint=" + startPoint +
                    ", isHorizontal=" + isHorizontal +
                    ", isActive=" + isActive +
                    '}';
        }

        public ResultShot checkState(int x, int y) {
            ResultShot result = ResultShot.MILK;
            int count = 0;
            for (Point temp : cells) {
                if ((temp.getX() == x && temp.getY() == y) || temp.popal == true) {
                    count++;
                    temp.popal = true;
                }
            }
            result = count == 0 ? result : (count == this.size.countTrub ? ResultShot.KILL : ResultShot.HIT);
            return result;
        }
    }
}

enum ResultShot{
    MILK,KILL,HIT
}
