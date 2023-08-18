package com.peco.util;

import com.peco.item.ModItems;
import com.peco.model.MultipleItemResult;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.*;

public class CauldronUtils {
  public static void lowerCauldronLevel(Level level, BlockPos blockPos, BlockState blockState) {
    IntegerProperty levelProperty = IntegerProperty.create("level", 1, 3);
    int currValue = blockState.getValue(levelProperty);

    if (currValue == 1) {
      level.setBlock(blockPos, Blocks.CAULDRON.defaultBlockState(), 1);
    } else {
      BlockState newState = blockState.setValue(levelProperty, currValue - 1);
      level.setBlock(blockPos, newState, 1);
    }
  }

  public static Optional<MultipleItemResult> getCauldronResult(Item ingredient) {
    if (ingredient == Items.WITHER_SKELETON_SKULL) {
      return Optional.of(new MultipleItemResult(Items.SKELETON_SKULL));
    } else if (ingredient == Items.BLAZE_ROD) {
      return Optional.of(
          new MultipleItemResult(
              new MultipleItemResult.MultipleItems(Items.GUNPOWDER, 2),
              new MultipleItemResult.MultipleItems(ModItems.CHILL_ROD.get())));
    }

    return Optional.empty();
  }
}
