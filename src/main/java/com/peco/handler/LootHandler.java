package com.peco.handler;

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
      case "minecraft:chests/pillager_outpost" -> Optional.of(
          LootPool.lootPool()
              .add(LootItem.lootTableItem(Items.TOTEM_OF_UNDYING).setWeight(1))
              .add(LootItem.lootTableItem(Items.AIR).setWeight(16))
              .build());
      case "minecraft:chests/buried_treasure" -> Optional.of(
          LootPool.lootPool()
              .add(LootItem.lootTableItem(Items.TRIDENT).setWeight(1))
              .add(LootItem.lootTableItem(Items.AIR).setWeight(6))
              .build());
      default -> Optional.empty();
    };
  }
}
