package com.vanrec.event;

import com.vanrec.handler.CauldronHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerInteractListener {
  @SubscribeEvent
  public void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
    Level level = event.getLevel();
    BlockPos blockPos = event.getPos();
    BlockState blockState = level.getBlockState(blockPos);
    Player player = event.getEntity();
    InteractionHand hand = event.getHand();

    if (blockState.is(Blocks.WATER_CAULDRON)) {
      CauldronHandler.handleCauldronUse(
          level, blockPos, blockState, player, player.getItemInHand(hand));
    }
  }
}
