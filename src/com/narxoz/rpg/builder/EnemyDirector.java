package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.BossEnemyBuilder;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    public Enemy createMinion(EnemyComponentFactory factory) {
        return new BasicEnemyBuilder()
                .setName("Minion")
                .setHealth(80)
                .setElement("NONE")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createElite(EnemyComponentFactory factory) {
        Enemy e = new BasicEnemyBuilder()
                .setName("Elite Minion")
                .setHealth(120)
                .setElement("NONE")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
        e.multiplyStats(2.0);
        return e;
    }

    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        return new BossEnemyBuilder()
                .setName("Mini Boss Dragon")
                .setHealth(15000)
                .setDamage(220)
                .setDefense(120)
                .setSpeed(40)
                .setElement("THEMED")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .addPhase(1, 15000)
                .addPhase(2, 9000)
                .addPhase(3, 4500)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(18)
                .build();
    }


    public Enemy createRaidBoss(BossEnemyBuilder builder) {
        return builder
                .setName("Raid Boss Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(25)
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .build();
    }


    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return new BossEnemyBuilder()
                .setName("Raid Boss Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("THEMED")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(25)
                .build();
    }
}