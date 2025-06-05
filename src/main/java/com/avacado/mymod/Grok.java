package com.avacado.mymod;

import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

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
}

