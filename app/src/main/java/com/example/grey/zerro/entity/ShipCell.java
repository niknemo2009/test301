package com.example.grey.zerro.entity;

public class ShipCell {
    Point point;
    ShipCellState shipCellState;

    public ShipCell(Point point, ShipCellState shipCellState) {
        this.point = point;
        this.shipCellState = shipCellState;
    }

    public Point getPoint() {
        return point;
    }

    public ShipCell setPoint(Point point) {
        this.point = point;
        return this;
    }

    public ShipCellState getShipCellState() {
        return shipCellState;
    }

    public ShipCell setShipCellState(ShipCellState shipCellState) {
        this.shipCellState = shipCellState;
        return this;
    }
}

