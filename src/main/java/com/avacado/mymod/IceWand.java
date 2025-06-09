package com.avacado.mymod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

public class IceWand extends Item {

    public IceWand() {
        super(new Item.Properties()
            .durability(64) // Set durability to 64 uses
            .stacksTo(1)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        ItemStack stack = context.getItemInHand();

        // Check if the block is VeryBlueIce
        if (state.getBlock() instanceof VeryBlueIce) {
            if (!world.isClientSide) {
                // Change the block to regular ice
                world.setBlock(pos, Blocks.ICE.defaultBlockState(), 3);

                // Damage the item by 1 durability
                // stack.hurtAndBreak(1, context.getPlayer(), (player) -> {
                //     player.broadcastBreakEvent(context.getHand());
                // });
            }
            return InteractionResult.sidedSuccess(world.isClientSide);
        }

        return InteractionResult.PASS;
    }
}
