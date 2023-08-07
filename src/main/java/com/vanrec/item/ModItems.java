package com.vanrec.item;

import com.vanrec.PeacefulCompat;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, PeacefulCompat.MOD_ID);

  public static final RegistryObject<Item> CHILL_ROD =
      ITEMS.register("chill_rod", () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> DISC_RING =
      ITEMS.register("disc_ring", () -> new Item(new Item.Properties()));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
