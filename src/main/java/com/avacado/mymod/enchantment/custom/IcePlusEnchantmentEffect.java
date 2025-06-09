package com.avacado.mymod.enchantment.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantmentEffectContext;
import net.minecraft.world.item.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class IcePlusEnchantmentEffect implements EnchantmentEntityEffect {

    @Override
    public void apply(ServerLevel world, int level, EnchantmentEffectContext context, Entity entity, net.minecraft.world.phys.Vec3 pos) {
        if (context.blockState() != null && context.blockPos() != null) {
            BlockState blockState = context.blockState();
            BlockPos blockPos = context.blockPos();

            // Check if the broken block is ice or very blue ice (custom block)
            if (blockState.is(Blocks.ICE) || blockState.is(Blocks.PACKED_ICE) || blockState.is(Blocks.BLUE_ICE) || blockState.is(com.avacado.mymod.ModBlocks.VERY_BLUE_ICE.get())) {
                int dropMultiplier = 5;

                // Get the default drops for the block
                ItemStack tool = context.stack();
                Block.getDroppedStacks(blockState, world, blockPos, null, entity, tool).forEach(stack -> {
                    stack.setCount(stack.getCount() * dropMultiplier);
                    Block.dropStack(world, blockPos, stack);
                });

                // Emit block break event to ensure proper game mechanics
                world.gameEvent(entity, GameEvent.BLOCK_DESTROY, blockPos);
            }
        }
    }
}
