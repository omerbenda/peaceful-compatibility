package com.vanrec.event;

import com.vanrec.handler.CauldronHandler;
import com.vanrec.util.StatsUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
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
      boolean result =
          CauldronHandler.handleCauldronUse(
              level, blockPos, blockState, player, player.getItemInHand(hand));

      if (result) {
        event.setCanceled(true);
        StatsUtils.giveStat(player, Stats.ITEM_CRAFTED, Items.SKELETON_SKULL);
        StatsUtils.giveStat(player, Stats.ITEM_USED, Items.WITHER_SKELETON_SKULL);
        event.setCancellationResult(InteractionResult.CONSUME);
      }
    }
  }
}
