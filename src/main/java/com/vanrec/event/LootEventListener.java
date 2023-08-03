package com.vanrec.event;

import com.vanrec.handler.LootHandler;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Optional;

public class LootEventListener {
  @SubscribeEvent
  public void onLootTableLoad(LootTableLoadEvent event) {
    Optional<LootPool> lootPool = LootHandler.getPoolByTable(event.getName().toString());

    if (lootPool.isPresent()) {
      event
          .getTable()
          .addPool(
              LootPool.lootPool()
                  .add(LootItem.lootTableItem(Items.WITHER_SKELETON_SKULL).setWeight(1))
                  .add(LootItem.lootTableItem(Items.AIR).setWeight(12))
                  .build());
    }
  }
}
