package com.narxoz.rpg.combat.ice;

import com.narxoz.rpg.combat.Ability;

public class IceShield implements Ability {
    private final int damage = 0;

    @Override
    public String getName() { return "Ice Shield"; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getDescription() { return "Defensive buff: increases defense temporarily."; }

    @Override
    public Ability clone() { return new IceShield(); }
}