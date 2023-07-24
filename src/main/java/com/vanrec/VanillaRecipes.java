package com.vanrec;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = VanillaRecipes.MODID, name = VanillaRecipes.NAME, version = VanillaRecipes.VERSION)
public class VanillaRecipes {
  public static final String MODID = "vanrec";
  public static final String NAME = "Vanilla Recipes";
  public static final String VERSION = "0.1-1.12.2";

  private static Logger logger;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger = event.getModLog();
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {}

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {}
}
