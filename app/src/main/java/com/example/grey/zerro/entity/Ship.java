package com.example.grey.zerro.entity;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    String name;
    String picture;
    ShipSize shipSize;
    final Point startPoint;
    final Point endPoint;
    boolean isHorizontal;
    boolean isAlive = true;
    List<ShipCell> shipCells = new ArrayList();

    public Ship(String name, String picture, Point startPoint, Point endPoint) {
        this.name = name;
        this.picture = picture;
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        if (this.startPoint.getX() != this.endPoint.getX() && this.startPoint.getY() != this.endPoint.getY())
            return;

        if (this.startPoint.getY() == this.endPoint.getY())
            isHorizontal = true;
        else
            isHorizontal = false;

        setShipCells();
    }

    private void setShipCells() {
        if (this.startPoint.getX() == this.endPoint.getX() && this.startPoint.getY() == this.endPoint.getY()) {
            ShipCell shipCell = new ShipCellBuilder()
                    .setPoint(new Point(this.startPoint.getX(), this.startPoint.getY()))
                    .setShipCellState(ShipCellState.OK)
                    .build();

            shipCells.add(shipCell);
            return;
        }

        int currentX = startPoint.getX();
        int currentY = startPoint.getY();

        while (true) {
            if (isHorizontal && this.startPoint.getX() > this.endPoint.getX())
                break;

            if (!isHorizontal && this.startPoint.getY() > this.endPoint.getY())
                break;

            ShipCell shipCell = new ShipCellBuilder()
                    .setPoint(new Point(currentX, currentY))
                    .setShipCellState(ShipCellState.OK)
                    .build();

            shipCells.add(shipCell);

            if (isHorizontal)
                currentX++;

            if (!isHorizontal)
                currentY++;
        }
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", size=" + shipSize +
                ", startPoint=" + startPoint +
                ", isHorizontal=" + isHorizontal +
                ", isActive=" + isAlive +
                '}';
    }

    public ResultShot checkHit(int x, int y) {
        ResultShot result = ResultShot.MISS;
        boolean aliveCells = false;

        for (ShipCell shipCell : shipCells) {
            Point point = shipCell.getPoint();

            if ((point.getX() == x && point.getY() == y)) {
                shipCell.shipCellState = ShipCellState.HIT;
                result = ResultShot.HIT;
            }

            if(shipCell.getShipCellState() == ShipCellState.OK)
                aliveCells = true;
        }

        if (!aliveCells){
            this.isAlive = false;
            return ResultShot.KILL;
        }

        return result;
    }
}

enum ShipSize {
    SMALL(1), MIDDLE(2), LARGE(3), SUPER(4);
    private int size;

    ShipSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
