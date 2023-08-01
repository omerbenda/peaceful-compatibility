package com.vanrec.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Optional;

public class CauldronUtils {
  public static void lowerCauldronLevel(Level level, BlockPos blockPos, BlockState blockState) {
    IntegerProperty levelProperty = IntegerProperty.create("level", 1, 3);
    int currValue = blockState.getValue(levelProperty);

    if (currValue == 1) {
      level.setBlock(blockPos, Blocks.CAULDRON.defaultBlockState(), 1);
    } else {
      BlockState newState =
          blockState.setValue(levelProperty, blockState.getValue(levelProperty) - 1);
      level.setBlock(blockPos, newState, 1);
    }
  }

  public static Optional<Item> getCauldronResult(Item ingredient) {
    if (ingredient == Items.WITHER_SKELETON_SKULL) {
      return Optional.of(Items.SKELETON_SKULL);
    }

    return Optional.empty();
  }
}
