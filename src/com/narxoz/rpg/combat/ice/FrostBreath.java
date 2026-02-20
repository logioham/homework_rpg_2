package com.narxoz.rpg.combat.ice;

import com.narxoz.rpg.combat.Ability;

public class FrostBreath implements Ability {
    private final int damage = 100;

    @Override
    public String getName() { return "Frost Breath"; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getDescription() { return "Damage + slow effect."; }

    @Override
    public Ability clone() { return new FrostBreath(); }
}