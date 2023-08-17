package com.peco.util;

import com.peco.model.RandomDropResult;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Optional;

public class ShearUtils {
  public static boolean shearBlock(
      Level level, BlockPos blockPos, ItemStack itemStack, Player player) {
    Optional<RandomDropResult> optionalResultRecipe =
        getShearResult(level.getBlockState(blockPos).getBlock());

    if (optionalResultRecipe.isEmpty()) {
      return false;
    }

    if (!player.isCreative()) {
      itemStack.setDamageValue(itemStack.getDamageValue() + 1);

      if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) {
        itemStack.hurtAndBreak(1, player, breaker -> {});
        level.playLocalSound(
            blockPos,
            SoundEvent.createVariableRangeEvent(
                new ResourceLocation("minecraft:entity.item.break")),
            SoundSource.PLAYERS,
            1f,
            0.6f,
            false);
      }
    }

    level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 1);
    level.playLocalSound(
        blockPos,
        SoundEvent.createVariableRangeEvent(new ResourceLocation("minecraft:entity.sheep.shear")),
        SoundSource.PLAYERS,
        1f,
        0.6f,
        false);
    RandomDropResult resultRecipe = optionalResultRecipe.get();
    int dropCount = resultRecipe.getDropCount();

    for (int dropIter = 0; dropIter < dropCount; dropIter++) {
      level.addFreshEntity(
          new ItemEntity(
              level,
              blockPos.getX(),
              blockPos.getY(),
              blockPos.getZ(),
              new ItemStack(Items.STRING)));
    }

    return true;
  }

  private static Optional<RandomDropResult> getShearResult(Block shearedBlock) {
    if (shearedBlock.equals(Blocks.WHITE_WOOL)) {
      return Optional.of(new RandomDropResult(Items.STRING, 1, 3));
    }

    return Optional.empty();
  }
}
