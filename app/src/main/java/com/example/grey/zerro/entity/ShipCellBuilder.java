package com.example.grey.zerro.entity;

public class ShipCellBuilder {
    private Point point;
    private ShipCellState shipCellState;

    public ShipCellBuilder() {
    }

    public ShipCellBuilder setPoint(Point point) {
        this.point = point;
        return this;
    }

    public ShipCellBuilder setShipCellState(ShipCellState shipCellState) {
        this.shipCellState = shipCellState;
        return this;
    }

    public ShipCell build() {
        return new ShipCell(point, shipCellState);
    }
}
