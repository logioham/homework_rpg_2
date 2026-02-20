package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DragonBoss implements Enemy {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    DragonBoss(String name,
               int health,
               int damage,
               int defense,
               int speed,
               String element,
               List<Ability> abilities,
               Map<Integer, Integer> phases,
               LootTable lootTable,
               String aiBehavior,
               boolean canFly,
               boolean hasBreathAttack,
               int wingspan) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>();
        this.phases = phases != null ? new HashMap<>(phases) : new HashMap<>();
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
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
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("HP: " + health + " | DMG: " + damage + " | DEF: " + defense + " | SPD: " + speed);
        System.out.println("Element: " + element + " | AI: " + aiBehavior);
        System.out.println("CanFly: " + canFly + " | Breath: " + hasBreathAttack + " | Wingspan: " + wingspan);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println(" - " + a.getName() + " [" + a.getDamage() + "]: " + a.getDescription());
        }
        System.out.println("Phases: " + phases);
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getItems() + " | Gold: " + lootTable.getGoldDrop() + " | XP: " + lootTable.getExperienceDrop());
        }
    }

    @Override public void addAbility(Ability ability) { if (ability != null) abilities.add(ability); }
    @Override public void setAbilities(List<Ability> abilities) { this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>(); }
    @Override public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }
    @Override public void setAIBehavior(String aiBehavior) { this.aiBehavior = aiBehavior; }
    @Override public void setElement(String element) { this.element = element; }

    public void addPhase(int phaseNumber, int healthThreshold) {
        phases.put(phaseNumber, healthThreshold);
    }

    @Override
    public void multiplyStats(double multiplier) {
        if (multiplier <= 0) return;
        health = (int) Math.round(health * multiplier);
        damage = (int) Math.round(damage * multiplier);
        defense = (int) Math.round(defense * multiplier);
        speed = (int) Math.round(speed * Math.min(multiplier, 1.5));
        Map<Integer, Integer> newPhases = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : phases.entrySet()) {
            newPhases.put(e.getKey(), (int) Math.round(e.getValue() * multiplier));
        }
        phases = newPhases;
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) clonedAbilities.add(a.clone());
        LootTable clonedLoot = this.lootTable == null ? null : this.lootTable.clone();
        Map<Integer, Integer> clonedPhases = new HashMap<>(this.phases);

        DragonBoss copy = new DragonBoss(
                this.name,
                this.health,
                this.damage,
                this.defense,
                this.speed,
                this.element,
                clonedAbilities,
                clonedPhases,
                clonedLoot,
                this.aiBehavior,
                this.canFly,
                this.hasBreathAttack,
                this.wingspan
        );
        return copy;
    }
}
