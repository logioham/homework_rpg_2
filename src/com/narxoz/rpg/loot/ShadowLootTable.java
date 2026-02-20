package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable {
    private final List<String> items = List.of("Shadow Gem", "Dark Essence", "Shadow Rune");
    private final int gold = 900;
    private final int xp = 1700;

    @Override
    public List<String> getItems() { return new ArrayList<>(items); }

    @Override
    public int getGoldDrop() { return gold; }

    @Override
    public int getExperienceDrop() { return xp; }

    @Override
    public LootTable clone() { return new ShadowLootTable(); }
}