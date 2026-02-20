package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable {
    private final List<String> items = List.of("Ice Gem", "Frost Scale", "Ice Rune");
    private final int gold = 700;
    private final int xp = 1400;

    @Override
    public List<String> getItems() { return new ArrayList<>(items); }

    @Override
    public int getGoldDrop() { return gold; }

    @Override
    public int getExperienceDrop() { return xp; }

    @Override
    public LootTable clone() { return new IceLootTable(); }
}