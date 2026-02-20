package com.narxoz.rpg;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.shadow.ShadowStrike;
import com.narxoz.rpg.enemy.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.prototype.EnemyRegistry;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        showFactory("FIRE", fireFactory);
        showFactory("ICE", iceFactory);
        showFactory("SHADOW", shadowFactory);

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        EnemyDirector director = new EnemyDirector();

        Enemy raidBoss = director.createRaidBoss(fireFactory);
        raidBoss.setElement("FIRE");
        raidBoss.displayInfo();

        Enemy miniBoss = director.createMiniBoss(iceFactory);
        miniBoss.setElement("ICE");
        miniBoss.displayInfo();

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        EnemyRegistry registry = new EnemyRegistry();

        Enemy baseGoblin = new com.narxoz.rpg.enemy.Goblin("Goblin");
        baseGoblin.setLootTable(fireFactory.createLootTable());
        baseGoblin.setAbilities(List.of());
        registry.registerTemplate("goblin", baseGoblin);

        registry.registerTemplate("dragon", raidBoss);

        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(2.0);
        eliteGoblin.addAbility(new ShadowStrike());
        eliteGoblin.displayInfo();

        System.out.println("Deep copy check:");
        System.out.println("Template abilities: " + registry.createFromTemplate("goblin").getAbilities().size());
        System.out.println("Elite abilities: " + eliteGoblin.getAbilities().size());
        System.out.println();

        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord")
                .setHealth(40000)
                .setDamage(450)
                .setDefense(180)
                .setSpeed(55)
                .setElement("SHADOW")
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .setAI(shadowFactory.createAIBehavior())
                .addPhase(1, 40000)
                .addPhase(2, 25000)
                .addPhase(3, 12000)
                .setCanFly(false)
                .setHasBreathAttack(false)
                .setWingspan(0)
                .build();

        registry.registerTemplate("demon-lord", demonLord);

        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        greaterDemon.multiplyStats(2.0);
        greaterDemon.addAbility((Ability) new ShadowStrike());
        greaterDemon.displayInfo();

        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println("Abstract Factory: Fire/Ice/Shadow component families");
        System.out.println("Builder: Fluent construction + validation");
        System.out.println("Factory Method: Builder.build() used by Director & client");
        System.out.println("Prototype: Enemy.clone() deep copy + EnemyRegistry templates");

        System.out.println("\n=== Demo Complete ===");
    }

    private static void showFactory(String name, EnemyComponentFactory factory) {
        System.out.println("Theme: " + name);
        System.out.println("AI: " + factory.createAIBehavior());
        System.out.println("Abilities:");
        for (Ability a : factory.createAbilities()) {
            System.out.println(" - " + a.getName() + " [" + a.getDamage() + "]: " + a.getDescription());
        }
        System.out.println("Loot: " + factory.createLootTable().getItems());
        System.out.println();
    }
}
