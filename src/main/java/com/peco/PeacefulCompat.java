package com.peco;

import com.mojang.logging.LogUtils;
import com.peco.event.LootEventListener;
import com.peco.event.PlayerInteractListener;
import com.peco.item.ModCreativeModeTabs;
import com.peco.item.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(PeacefulCompat.MOD_ID)
public class PeacefulCompat {
  public static final String MOD_ID = "peco";
  private static final Logger LOGGER = LogUtils.getLogger();

  public PeacefulCompat() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ModItems.register(modEventBus);
    ModCreativeModeTabs.register(modEventBus);

    modEventBus.addListener(this::commonSetup);

    MinecraftForge.EVENT_BUS.register(this);
    MinecraftForge.EVENT_BUS.register(new PlayerInteractListener());
    MinecraftForge.EVENT_BUS.register(new LootEventListener());

    modEventBus.addListener(this::addCreative);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {}

  private void addCreative(BuildCreativeModeTabContentsEvent event) {
    if (event.getTabKey() == ModCreativeModeTabs.VANREC_TAB.getKey()) {
      event.accept(ModItems.CHILL_ROD);
      event.accept(ModItems.DISC_RING);
    }
  }

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {}

  @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {}
  }
}
