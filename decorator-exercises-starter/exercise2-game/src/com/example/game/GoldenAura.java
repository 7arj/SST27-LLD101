package com.example.game;

public class GoldenAura extends CharacterDecorator {
    private static final String GOLDEN_SPRITE = "golden_aura.png";
    private int speedBonus = 2;
    private int damageBonus = 5;
    
    public GoldenAura(Character character) {
        super(character);
    }
    
    @Override
    public void move() {
        System.out.println(" Moving at speed " + getSpeed() + " with sprite " + getSprite() + " [GOLDEN AURA] ");
    }
    
    @Override
    public void attack() {
        System.out.println(" Attacking with damage " + getDamage() + " using sprite " + getSprite() + " [GOLDEN AURA] ");
    }
    
    @Override
    public int getSpeed() {
        return super.getSpeed() + speedBonus;
    }
    
    @Override
    public int getDamage() {
        return super.getDamage() + damageBonus;
    }
    
    @Override
    public String getSprite() {
        return GOLDEN_SPRITE;
    }
}