package com.avacado.mymod;

import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

public class Grok extends Block {

    public static final String MODID = "iceplus";



    public Grok () {
        super(Properties.of()
            .mapColor(MapColor.CLAY)
        ); 

        
        
    }
}

