package com.avacado.mymod;

import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

public class VeryBlueIce extends Block {

    public static final String MODID = "iceplus";



    public VeryBlueIce () {
        super(Properties.of()
            .mapColor(MapColor.ICE)
            .friction(0.999f)
            .strength(-1)
            .explosionResistance(9999.9f)
        ); 

        
        
    }
}

