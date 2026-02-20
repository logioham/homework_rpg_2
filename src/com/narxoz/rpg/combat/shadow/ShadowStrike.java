package com.narxoz.rpg.combat.shadow;

import com.narxoz.rpg.combat.Ability;

public class ShadowStrike implements Ability {
    private final int damage = 140;

    @Override
    public String getName() { return "Shadow Strike"; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getDescription() { return "High single-target damage + blind."; }

    @Override
    public Ability clone() { return new ShadowStrike(); }
}