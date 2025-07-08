package model;

public class Power {
    private String powerName;
    private int damage;
    private int magicCost;

    public Power(String powerName, int damage, int magicCost) {
        this.powerName = powerName;
        this.damage = damage;
        this.magicCost = magicCost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public int getMagicCost() {
        return magicCost;
    }

    public void setMagicCost(int magicCost) {
        this.magicCost = magicCost;
    }
}
