package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.Map;

public interface Enemy extends Cloneable {
    String getName();
    int getHealth();
    int getDamage();
    int getDefense();
    int getSpeed();
    String getElement();
    String getAiBehavior();
    List<Ability> getAbilities();
    LootTable getLootTable();
    Map<Integer, Integer> getPhases();

    void displayInfo();

    void addAbility(Ability ability);
    void setAbilities(List<Ability> abilities);
    void setLootTable(LootTable lootTable);
    void setAIBehavior(String aiBehavior);
    void setElement(String element);
    void multiplyStats(double multiplier);

    Enemy clone();
}

