package com.vanrec;

import com.mojang.logging.LogUtils;
import com.vanrec.event.LootEventListener;
import com.vanrec.event.PlayerInteractListener;
import com.vanrec.item.ModCreativeModeTabs;
import com.vanrec.item.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(VanillaRecipes.MOD_ID)
public class VanillaRecipes {
  public static final String MOD_ID = "vanrec";
  private static final Logger LOGGER = LogUtils.getLogger();

  public VanillaRecipes() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ModItems.register(modEventBus);
    ModCreativeModeTabs.register(modEventBus);

    modEventBus.addListener(this::commonSetup);

    MinecraftForge.EVENT_BUS.register(this);
    MinecraftForge.EVENT_BUS.register(new PlayerInteractListener());
    MinecraftForge.EVENT_BUS.register(new LootEventListener());

    modEventBus.addListener(this::addCreative);

    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
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
