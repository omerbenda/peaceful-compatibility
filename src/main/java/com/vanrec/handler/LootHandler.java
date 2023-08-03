package com.vanrec.handler;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import java.util.Optional;

public class LootHandler {

  public static Optional<LootPool> getPoolByTable(String tableName) {
    return switch (tableName) {
      case "minecraft:chests/nether_bridge" -> Optional.of(
          LootPool.lootPool()
              .add(LootItem.lootTableItem(Items.WITHER_SKELETON_SKULL).setWeight(1))
              .add(LootItem.lootTableItem(Items.AIR).setWeight(12))
              .build());
      default -> Optional.empty();
    };
  }
}
