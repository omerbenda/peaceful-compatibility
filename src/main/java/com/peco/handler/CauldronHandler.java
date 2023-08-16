package com.peco.handler;

import com.peco.util.CauldronUtils;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CauldronHandler {
  public static boolean handleCauldronUse(
      Level level, BlockPos blockPos, BlockState blockState, Player player, ItemStack itemStack) {
    if (player.isCrouching()) {
      return false;
    }

    Optional<Item> resultItem = CauldronUtils.getCauldronResult(itemStack.getItem());

    if (resultItem.isEmpty()) {
      return false;
    }

    CauldronUtils.lowerCauldronLevel(level, blockPos, blockState);
    player.addItem(new ItemStack(resultItem.get()));

    if (!player.isCreative()) {
      itemStack.shrink(1);
    }

    return true;
  }
}
