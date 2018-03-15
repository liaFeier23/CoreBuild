package model;

public class Ship {

    private int id;
    private String name;
    private int speed;
    private char type;
    private int maxCargoWeight;

    public Ship() {
    }

    public Ship(int id, String name, int speed, char type, int maxCargoWeight) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.type = type;
        this.maxCargoWeight = maxCargoWeight;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public void setMaxCargoWeight(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }
}
