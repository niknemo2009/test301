package com.example.grey.zerro.entity;

import java.util.ArrayList;
import java.util.List;

public class Ship {
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
        setPosition();
    }

    private void setPosition() {
        cells.add(startPoint);
        int currentY = startPoint.getY();
        int currentX = startPoint.getX();
        for (int i = 1; i < size.countTrub; i++) {
            int tempY = isHorizontal ? currentY : currentY++;
            int tempX = isHorizontal ? currentX++ : currentX;
            Point pointNext = new Point(tempX, tempY);
            cells.add(pointNext);
        }
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
enum ShipSize{
    SMALL(1),MIDDLE(2),LARDGE(3),SUPER(4);
    int countTrub;

    ShipSize(int countTrub) {
        this.countTrub = countTrub;
    }
}
