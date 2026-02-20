package com.narxoz.rpg.combat.fire;

import com.narxoz.rpg.combat.Ability;

public class FlameBreath implements Ability {
    private final int damage = 120;

    @Override
    public String getName() { return "Flame Breath"; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getDescription() { return "AoE fire damage with burn effect."; }

    @Override
    public Ability clone() { return new FlameBreath(); }
}
