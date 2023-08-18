package com.peco.model;

import net.minecraft.world.item.Item;

public class MultipleItemResult {
  private final MultipleItems[] items;

  public MultipleItemResult(Item item) {
    this.items = new MultipleItems[] {new MultipleItems(item)};
  }

  public MultipleItemResult(MultipleItems... items) {
    this.items = items;
  }

  public MultipleItems[] get() {
    return this.items;
  }

  public static class MultipleItems {
    private final Item item;
    private final int number;

    public MultipleItems(Item item, int number) {
      this.item = item;
      this.number = number;
    }

    public MultipleItems(Item item) {
      this(item, 1);
    }

    public Item item() {
      return item;
    }

    public int count() {
      return number;
    }
  }
}
