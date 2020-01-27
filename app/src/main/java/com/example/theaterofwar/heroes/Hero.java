package com.example.theaterofwar.heroes;

public class Hero {

    private String name;
    private int health;
    private int attack;
    private int defense;
    private boolean block = false;
    private boolean dodge = false;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public boolean isBlock() {
        return block;
    }
    public void setBlock(boolean block) {
        this.block = block;
    }
    public boolean isDodge() {
        return dodge;
    }
    public void setDodge(boolean dodge) {
        this.dodge = dodge;
    }


}

