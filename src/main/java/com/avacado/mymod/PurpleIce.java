package com.avacado.mymod;

import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

public class PurpleIce extends Block {

    public static final String MODID = "iceplus";



    public PurpleIce () {
        super(Properties.of()
            .mapColor(MapColor.ICE)
            .friction(0.9999999999f)
            .strength(0.1f)
            .explosionResistance(9999.9f)
        ); 

        
        
    }
}

