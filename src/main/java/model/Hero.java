package model;

import java.util.ArrayList;
import java.lang.Character;

public class Hero {
    private int id;
    private String name;
    private ArrayList<Character> shipsType;

    public Hero() {
    }

    public Hero(int id, String name, ArrayList<Character> shipsType) {
        this.id = id;
        this.name = name;
        this.shipsType = shipsType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Character> getShipsType() {
        return shipsType;
    }

    public void setShipsType(ArrayList<Character> shipsType) {
        this.shipsType = shipsType;
    }
}
