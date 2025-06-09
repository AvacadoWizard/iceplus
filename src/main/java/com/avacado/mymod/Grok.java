package com.avacado.mymod;

import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

public class Grok extends Item {

    public static final String MODID = "iceplus";



    public Grok () {
        super(new Item.Properties()
        .stacksTo(3)
        .food(new Builder() 
            .alwaysEdible()
            .nutrition(1)
            .saturationModifier(-0.5f)
            .build())
        ); 

        
        
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        ItemStack itemstack = super.finishUsingItem(stack, world, entity);
        if (!world.isClientSide && entity instanceof Player) {
            // Apply poison effect for 100 ticks (5 seconds) with amplifier 1
            ((Player)entity).addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1));
        }
        return itemstack;
    }
}
