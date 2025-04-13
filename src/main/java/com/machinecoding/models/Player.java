package com.machinecoding.models;

public class Player {
    private String name;
//    private String id;
    private Character symbol;


    public Player(String name, Character symbol) {
        this.name = name;
//        this.id = id;
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
