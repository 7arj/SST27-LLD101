package com.example.game;

public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();
        
        System.out.println("--- Base Character ---");
        base.move();
        base.attack();
        
        System.out.println("\n--- Base + SpeedBoost + DamageBoost ---");
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        buffed.move();
        buffed.attack();
        
        System.out.println("\n--- Add GoldenAura ---");
        Character shiny = new GoldenAura(buffed);
        shiny.move();
        shiny.attack();
        
        System.out.println("\n--- Remove GoldenAura (recomposition) ---");
        Character withoutAura = buffed; // removal by recomposition
        withoutAura.move();
        withoutAura.attack();
        
        System.out.println("\n--- Stats Comparison ---");
        System.out.println("Base: Speed=" + base.getSpeed() + ", Damage=" + base.getDamage() + ", Sprite=" + base.getSprite());
        System.out.println("Buffed: Speed=" + buffed.getSpeed() + ", Damage=" + buffed.getDamage() + ", Sprite=" + buffed.getSprite());
        System.out.println("Golden: Speed=" + shiny.getSpeed() + ", Damage=" + shiny.getDamage() + ", Sprite=" + shiny.getSprite());
    }
}