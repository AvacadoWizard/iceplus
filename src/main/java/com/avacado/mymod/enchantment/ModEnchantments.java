package com.avacado.mymod.enchantment;

import com.avacado.mymod.IcePlusMod;
import com.avacado.mymod.enchantment.custom.IcePlusEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantment.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(Registries.ENCHANTMENT, IcePlusMod.MODID);

    public static final RegistryObject<Enchantment> ICE_PLUS = ENCHANTMENTS.register("ice_plus",
            () -> new IcePlusEnchantment(Rarity.RARE, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));

}
