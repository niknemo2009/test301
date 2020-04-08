package com.example.grey.zerro.entity;

public class Ship {
    String name;
    String picture;
    ShipSize size;

}

enum ShipSize{
    SMALL(1),MIDDLE(2),LARDGE(3),SUPER(4);
    int countTrub;

    ShipSize(int countTrub) {
        this.countTrub = countTrub;
    }
}
