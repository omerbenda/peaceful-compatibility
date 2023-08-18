package com.peco.model;

import net.minecraft.world.item.Item;

import java.util.Random;

public record RandomDropResult(Item item, int minDropCount, int maxDropCount) {
  public int getDropCount() {
    Random random = new Random();

    return random.nextInt(minDropCount, maxDropCount + 1);
  }
}
