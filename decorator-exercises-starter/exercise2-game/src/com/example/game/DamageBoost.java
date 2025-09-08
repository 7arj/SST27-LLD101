package com.example.game;

public class DamageBoost extends CharacterDecorator {
    private int damageBonus;
    
    public DamageBoost(Character character, int damageBonus) {
        super(character);
        this.damageBonus = damageBonus;
    }
    
    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite() + " [DAMAGE BOOSTED]");
    }
    
    @Override
    public int getDamage() {
        return super.getDamage() + damageBonus;
    }
}