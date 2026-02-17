package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;


import java.util.List;

public interface Enemy extends Cloneable {

    String getName();
    int getHealth();
    int getAttackPower();

    List<Ability> getAbilities();
    LootTable getLootTable();

    void display();

    Enemy clone();
}





