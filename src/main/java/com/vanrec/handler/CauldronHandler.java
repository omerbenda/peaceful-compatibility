package com.vanrec.handler;

import com.vanrec.util.CauldronUtils;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CauldronHandler {
  public static void handleCauldronUse(
      Level level, BlockPos blockPos, BlockState blockState, Player player, ItemStack itemStack) {
    Optional<Item> resultItem = CauldronUtils.getCauldronResult(itemStack.getItem());

    if (resultItem.isPresent()) {
      CauldronUtils.lowerCauldronLevel(level, blockPos, blockState);
      player.addItem(new ItemStack(resultItem.get()));

      if (!player.isCreative()) {
        itemStack.shrink(1);
      }
    }
  }
}
