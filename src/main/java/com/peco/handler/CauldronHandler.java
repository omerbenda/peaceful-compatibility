package com.peco.handler;

import com.peco.model.MultipleItemResult;
import com.peco.util.CauldronUtils;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CauldronHandler {
  public static boolean handleCauldronUse(
      Level level, BlockPos blockPos, BlockState blockState, Player player, ItemStack itemStack) {
    if (player.isCrouching()) {
      return false;
    }

    Optional<MultipleItemResult> resultItems = CauldronUtils.getCauldronResult(itemStack.getItem());

    if (resultItems.isEmpty()) {
      return false;
    }

    CauldronUtils.lowerCauldronLevel(level, blockPos, blockState);
    level.playLocalSound(
        blockPos,
        SoundEvent.createVariableRangeEvent(
            new ResourceLocation("minecraft:entity.hostile.swim")),
        SoundSource.PLAYERS,
        1f,
        0.6f,
        false);

    for (MultipleItemResult.MultipleItems multipleItems : resultItems.get().get()) {
      player.addItem(new ItemStack(multipleItems.item(), multipleItems.count()));
    }

    if (!player.isCreative()) {
      itemStack.shrink(1);
    }

    return true;
  }
}
