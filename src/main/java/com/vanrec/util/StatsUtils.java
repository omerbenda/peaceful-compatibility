package com.vanrec.util;

import net.minecraft.stats.Stat;
import net.minecraft.stats.StatType;
import net.minecraft.world.entity.player.Player;

public class StatsUtils {
  public static <T> void giveStat(
      Player player, StatType<T> statType, T value, int incrementValue) {
    player.awardStat(
        (Stat<?>) Stat.byName(Stat.buildName(statType, value)).orElseThrow(), incrementValue);
  }

  public static <T> void giveStat(Player player, StatType<T> statType, T value) {
    giveStat(player, statType, value, 1);
  }
}
