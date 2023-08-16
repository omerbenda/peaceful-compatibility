package com.peco.event;

import com.peco.handler.LootHandler;
import java.util.Optional;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootEventListener {
  @SubscribeEvent
  public void onLootTableLoad(LootTableLoadEvent event) {
    Optional<LootPool> lootPool = LootHandler.getPoolByTable(event.getName().toString());

    lootPool.ifPresent(event.getTable()::addPool);
  }
}
