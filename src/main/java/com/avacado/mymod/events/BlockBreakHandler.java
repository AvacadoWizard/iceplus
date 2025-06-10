package com.avacado.mymod.events;

import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.Random;

import com.avacado.mymod.ModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockBreakHandler {

    private static final Random random = new Random();

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() == ModBlocks.PURPLE_ICE.get()) { // Check if Purple Ice was broken
            if (random.nextInt(10) == 0) { // 10% chance
                ServerLevel world = (ServerLevel) event.getLevel();
                BlockPos pos = event.getPos();

                ItemEntity item = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.GROK.get()));
                world.addFreshEntity(item);
            }
        }
    }
}