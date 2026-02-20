package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Skeleton implements Enemy {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private String aiBehavior;
    private List<Ability> abilities;
    private LootTable lootTable;
    private Map<Integer, Integer> phases;

    public Skeleton(String name) {
        this.name = name;
        this.health = 120;
        this.damage = 20;
        this.defense = 10;
        this.speed = 25;
        this.element = "NONE";
        this.aiBehavior = "BASIC";
        this.abilities = new ArrayList<>();
        this.phases = new HashMap<>();
    }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }
    @Override public String getElement() { return element; }
    @Override public String getAiBehavior() { return aiBehavior; }
    @Override public List<Ability> getAbilities() { return new ArrayList<>(abilities); }
    @Override public LootTable getLootTable() { return lootTable; }
    @Override public Map<Integer, Integer> getPhases() { return new HashMap<>(phases); }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Skeleton) ===");
        System.out.println("HP: " + health + " | DMG: " + damage + " | DEF: " + defense + " | SPD: " + speed);
        System.out.println("Element: " + element + " | AI: " + aiBehavior);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println(" - " + a.getName() + " [" + a.getDamage() + "]: " + a.getDescription());
        }
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getItems() + " | Gold: " + lootTable.getGoldDrop() + " | XP: " + lootTable.getExperienceDrop());
        }
    }

    @Override public void addAbility(Ability ability) { if (ability != null) abilities.add(ability); }
    @Override public void setAbilities(List<Ability> abilities) { this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>(); }
    @Override public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }
    @Override public void setAIBehavior(String aiBehavior) { this.aiBehavior = aiBehavior; }
    @Override public void setElement(String element) { this.element = element; }

    @Override
    public void multiplyStats(double multiplier) {
        if (multiplier <= 0) return;
        health = (int) Math.round(health * multiplier);
        damage = (int) Math.round(damage * multiplier);
        defense = (int) Math.round(defense * multiplier);
        speed = (int) Math.round(speed * Math.min(multiplier, 2.0));
    }

    @Override
    public Enemy clone() {
        Skeleton copy = new Skeleton(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.element = this.element;
        copy.aiBehavior = this.aiBehavior;

        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) clonedAbilities.add(a.clone());
        copy.abilities = clonedAbilities;

        copy.lootTable = this.lootTable == null ? null : this.lootTable.clone();
        copy.phases = new HashMap<>(this.phases);
        return copy;
    }
}