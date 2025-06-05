// package com.avacado.mymod.enchantment.custom;

// import com.mojang.serialization.MapCodec;
// import com.mojang.serialization.codecs.RecordCodecBuilder;
// import net.minecraft.block.Block;
// import net.minecraft.block.Blocks;
// import net.minecraft.item.ItemStack;
// import net.minecraft.server.world.ServerWorld;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.world.World;
// import net.minecraft.world.event.GameEvent;
// import net.minecraft.world.item.enchantment.EnchantmentEffectContext;
// import net.minecraft.world.item.enchantment.effect.EnchantmentLevelBasedValue;
// import net.minecraft.world.item.enchantment.effect.EnchantmentEntityEffect;

// public record IceBreakerEnchantmentEffect(EnchantmentLevelBasedValue amount) implements EnchantmentEntityEffect {
//     public static final MapCodec<IceBreakerEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance ->
//         instance.group(
//             EnchantmentLevelBasedValue.CODEC.fieldOf("amount").forGetter(IceBreakerEnchantmentEffect::amount)
//         ).apply(instance, IceBreakerEnchantmentEffect::new)
//     );

//     @Override
//     public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity entity, Vec3 pos) {
//         // Ensure the context includes block-breaking information
//         if (context.blockState() != null && context.blockPos() != null) {
//             // Check if the broken block is ice (or extend to packed ice/blue ice if desired)
//             if (context.blockState().isOf(Blocks.ICE)) {
//                 // Calculate extra drops based on enchantment level (4 * level)
//                 float extraDrops = this.amount.getValue(level);
//                 int dropMultiplier = (int) (4 * extraDrops);

//                 // Get the default drops for the block
//                 BlockPos blockPos = context.blockPos();
//                 ItemStack tool = context.stack();
//                 Block.getDroppedStacks(context.blockState(), world, blockPos, null, entity, tool).forEach(stack -> {
//                     // Multiply the stack size by the drop multiplier
//                     stack.setCount(stack.getCount() * dropMultiplier);
//                     // Drop the items in the world
//                     Block.dropStack(world, blockPos, stack);
//                 });

//                 // Emit block break event to ensure proper game mechanics
//                 world.emitGameEvent(GameEvent.BLOCK_DESTROY, blockPos, GameEvent.Context.create(entity, context.blockState()));
//             }
//         }
//     }

//     @Override
//     public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
//         return CODEC;
//     }
// }