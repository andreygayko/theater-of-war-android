package com.example.theaterofwar.heroes;

public class Elf extends Hero {
    private String name = "Elf";
    private int health = 90;
    private int attack = 30;
    private int defense = 2;
    private boolean dodge = true;

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
    public boolean isDodge() {
        return dodge;
    }
    public void setDodge(boolean dodge) {
        this.dodge = dodge;
    }

}

