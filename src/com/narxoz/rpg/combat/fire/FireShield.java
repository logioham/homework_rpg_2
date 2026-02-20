package com.narxoz.rpg.combat.fire;

import com.narxoz.rpg.combat.Ability;

public class FireShield implements Ability {
    private final int damage = 0;

    @Override
    public String getName() { return "Fire Shield"; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getDescription() { return "Defensive buff: reduces incoming damage."; }

    @Override
    public Ability clone() { return new FireShield(); }
}