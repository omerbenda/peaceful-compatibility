package com.vanrec.item;

import com.vanrec.VanillaRecipes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VanillaRecipes.MOD_ID);

  public static final RegistryObject<CreativeModeTab> VANREC_TAB =
      CREATIVE_MODE_TABS.register(
          "vanrec_tab",
          () ->
              CreativeModeTab.builder()
                  .icon(() -> new ItemStack(ModItems.CHILL_ROD.get()))
                  .title(Component.translatable("creativetab.vanrec_tab"))
                  .displayItems(
                      (pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CHILL_ROD.get());
                      })
                  .build());

  public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
  }
}
