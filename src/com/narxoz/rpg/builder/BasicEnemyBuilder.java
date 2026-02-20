package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {
    private String name;
    private Integer health;
    private Integer damage;
    private Integer defense;
    private Integer speed;
    private String element = "NONE";
    private String ai = "BASIC";
    private List<Ability> abilities = new ArrayList<>();
    private LootTable loot;

    @Override public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    @Override public EnemyBuilder setElement(String element) { this.element = element; return this; }
    @Override public EnemyBuilder addAbility(Ability ability) { if (ability != null) abilities.add(ability); return this; }
    @Override public EnemyBuilder setAbilities(List<Ability> abilities) { this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>(); return this; }
    @Override public EnemyBuilder setLootTable(LootTable loot) { this.loot = loot; return this; }
    @Override public EnemyBuilder setAI(String aiBehavior) { this.ai = aiBehavior; return this; }

    @Override
    public Enemy build() {

        if (name == null || name.isBlank()) throw new IllegalStateException("Name required");
        if (health == null || health <= 0) throw new IllegalStateException("Health must be positive");

        Goblin g = new Goblin(name);
        g.setElement(element);
        g.setAIBehavior(ai);
        g.setAbilities(abilities);
        g.setLootTable(loot);

        if (damage != null) g.multiplyStats(1.0);
        if (damage != null || defense != null || speed != null) {
            double mh = 1.0;
            g.multiplyStats(mh);
        }
        return g;
    }
}