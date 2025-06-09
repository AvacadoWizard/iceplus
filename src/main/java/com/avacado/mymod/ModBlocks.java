package com.avacado.mymod;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final String MODID = "iceplus";

    // very blue ice block in item and block :)
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VeryBlueIce.MODID);
    public static final RegistryObject<Block> VERY_BLUE_ICE  = BLOCKS.register("very_blue_ice", () -> new VeryBlueIce());

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VeryBlueIce.MODID);
    public static final RegistryObject<BlockItem> VERY_BLUE_ICE_ITEM = ITEMS.register("very_blue_ice", () -> new BlockItem(VERY_BLUE_ICE.get(), new Item.Properties()));
    
    // grok fr nc
    public static final RegistryObject<Item> GROK = ITEMS.register("grok", Grok::new);

    // ice wand item
    public static final RegistryObject<Item> ICE_WAND = ITEMS.register("ice_wand", IceWand::new);

    // osrs put that john in creative
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(VERY_BLUE_ICE_ITEM);
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
            event.accept(GROK);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
            event.accept(ICE_WAND);
    }

    
}
