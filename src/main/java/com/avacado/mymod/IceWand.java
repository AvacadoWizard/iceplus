package com.avacado.mymod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Explosion;
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

        if (state.getBlock() instanceof PurpleIce) {
            if (!world.isClientSide) {
                world.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, Level.ExplosionInteraction.BLOCK);
                return InteractionResult.SUCCESS;

            }
        }

        if (state.getBlock() instanceof VeryBlueIce) {
            if (!world.isClientSide) {
                world.setBlock(pos, ModBlocks.PURPLE_ICE.get().defaultBlockState(), 3);
            }
            return InteractionResult.sidedSuccess(world.isClientSide);
        }

        if (state.getBlock() == Blocks.BLUE_ICE) {
            if (!world.isClientSide) {
                world.setBlock(pos, ModBlocks.VERY_BLUE_ICE.get().defaultBlockState(), 3);
            }
            return InteractionResult.sidedSuccess(world.isClientSide);
        }

        if (state.getBlock() == Blocks.PACKED_ICE) {
            if (!world.isClientSide) {
                world.setBlock(pos, Blocks.BLUE_ICE.defaultBlockState(), 3);
            }
            return InteractionResult.sidedSuccess(world.isClientSide);
        }

        if (state.getBlock() == Blocks.ICE) {
            if (!world.isClientSide) {
                world.setBlock(pos, Blocks.PACKED_ICE.defaultBlockState(), 3);
            }
            return InteractionResult.sidedSuccess(world.isClientSide);
        }

        return InteractionResult.PASS;
    }
}
