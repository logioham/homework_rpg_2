package com.narxoz.rpg.combat.shadow;

import com.narxoz.rpg.combat.Ability;

public class Vanish implements Ability {
    private final int damage = 0;

    @Override
    public String getName() { return "Vanish"; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getDescription() { return "Stealth/evasion ability."; }

    @Override
    public Ability clone() { return new Vanish(); }
}
