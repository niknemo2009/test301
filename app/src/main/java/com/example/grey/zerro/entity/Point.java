package com.example.grey.zerro.entity;

public class Point {
     private int x;
    private int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if(x <0){
            x=0;
        }else if(x>9){
           x=9;
        }
        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {
        if(x <0){
            x=0;
        }else if(x>9){
            x=9;
        }
        this.y = y;
    }
}
