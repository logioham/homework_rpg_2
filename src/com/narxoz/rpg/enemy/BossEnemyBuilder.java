package com.narxoz.rpg.enemy;

import com.narxoz.rpg.builder.EnemyBuilder;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder implements EnemyBuilder {
    private String name;
    private Integer health;
    private Integer damage;
    private Integer defense;
    private Integer speed;
    private String element;
    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer, Integer> phases = new HashMap<>();
    private LootTable loot;
    private String ai;
    private boolean canFly;
    private boolean hasBreathAttack;
    private Integer wingspan;

    @Override public BossEnemyBuilder setName(String name) { this.name = name; return this; }
    @Override public BossEnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override public BossEnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override public BossEnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override public BossEnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    @Override public BossEnemyBuilder setElement(String element) { this.element = element; return this; }
    @Override public BossEnemyBuilder addAbility(Ability ability) { if (ability != null) abilities.add(ability); return this; }
    @Override public BossEnemyBuilder setAbilities(List<Ability> abilities) { this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>(); return this; }
    @Override public BossEnemyBuilder setLootTable(LootTable loot) { this.loot = loot; return this; }
    @Override public BossEnemyBuilder setAI(String aiBehavior) { this.ai = aiBehavior; return this; }

    @Override
    public BossEnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        phases.put(phaseNumber, healthThreshold);
        return this;
    }

    public BossEnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }

    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
        return this;
    }

    public BossEnemyBuilder setWingspan(int wingspan) {
        this.wingspan = wingspan;
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || name.isBlank()) throw new IllegalStateException("Name required");
        if (health == null || health <= 0) throw new IllegalStateException("Health must be positive");
        if (damage == null) throw new IllegalStateException("Damage required");
        if (defense == null) throw new IllegalStateException("Defense required");
        if (speed == null) throw new IllegalStateException("Speed required");
        if (element == null || element.isBlank()) throw new IllegalStateException("Element required");
        if (loot == null) throw new IllegalStateException("Loot required");
        if (ai == null || ai.isBlank()) throw new IllegalStateException("AI required");
        if (wingspan == null) throw new IllegalStateException("Wingspan required");

        return new DragonBoss(
                name, health, damage, defense, speed,
                element, abilities, phases, loot, ai,
                canFly, hasBreathAttack, wingspan
        );
    }
}