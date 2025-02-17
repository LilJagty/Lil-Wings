package com.toadstoolstudios.lilwings.item;

import com.toadstoolstudios.lilwings.LilWings;
import com.toadstoolstudios.lilwings.block.ButterflyJarBlockEntity;
import com.toadstoolstudios.lilwings.entity.ButterflyEntity;
import com.toadstoolstudios.lilwings.registry.LilWingsItems;
import com.toadstoolstudios.lilwings.registry.entity.Butterfly;
import net.fabricmc.fabric.impl.registry.sync.FabricRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ButterflyNetItem extends Item {

    public ButterflyNetItem(int durability) {
        super(new Settings().group(LilWings.TAB).maxDamage(durability));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if(stack.getOrCreateNbt().contains("butterfly")) {
            String butterflyName = Util.createTranslationKey("entity", new Identifier(stack.getNbt().getString("butterflyId")));
            tooltip.add(new TranslatableText("tooltip.butterfly_net.prefix").append(new TranslatableText(butterflyName)).formatted(Formatting.GRAY));
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext pContext) {
        if(pContext.getWorld().isClient) super.useOnBlock(pContext);
        BlockPos blockPos = pContext.getBlockPos();
        World level = pContext.getWorld();
        BlockState blockState = level.getBlockState(blockPos);
        NbtCompound itemTag = pContext.getStack().getOrCreateNbt();
        if(itemTag.contains("butterfly")) {
            if(level.getBlockEntity(blockPos) instanceof ButterflyJarBlockEntity blockEntity) {
                if(blockEntity.getButterflyData() == null) {
                    Identifier id = new Identifier(itemTag.getString("butterflyId"));
                    EntityType<?> type = EntityType.get(itemTag.getString("butterflyId")).get();

                    if (Butterfly.BUTTERFLIES.containsKey(id)) {
                        blockEntity.setEntityType((EntityType<? extends ButterflyEntity>) type);
                        blockEntity.setButterflyData(itemTag.getCompound("butterfly"));
                        level.setBlockState(blockPos, blockState);
                        pContext.getStack().removeSubNbt("butterfly");
                        pContext.getStack().removeSubNbt("butterflyId");
                        return ActionResult.SUCCESS;
                    }
                }
            } else {
                EntityType<?> butterflyId = EntityType.get(itemTag.getString("butterflyId")).get();
                ButterflyEntity butterfly = new ButterflyEntity((EntityType<? extends ButterflyEntity>) butterflyId, level);

                butterfly.readNbt(pContext.getStack().getNbt().getCompound("butterfly"));
                butterfly.setCatchAmount(0);
                BlockPos pos = pContext.getBlockPos();
                butterfly.setPosition(pos.getX() + 0.5f, pos.getY() + 1, pos.getZ() + 0.5f);

                if (butterfly.getButterfly().particleType() != null) {
                    level.addParticle(butterfly.getButterfly().particleType(), pos.getX() + 0.5, pos.getY() + 0.08f, pos.getZ() + 0.5, 0.5f, 0.5f, 0.5f);
                }
                level.spawnEntity(butterfly);
                pContext.getStack().removeSubNbt("butterfly");
                pContext.getStack().removeSubNbt("butterflyId");
                return ActionResult.SUCCESS;
            }
        } else if(level.getBlockEntity(blockPos) instanceof ButterflyJarBlockEntity blockEntity) {
            NbtCompound butterflyData = blockEntity.getButterflyData();
            if(butterflyData != null && blockEntity.getEntityType() != null) {
                itemTag.put("butterfly", butterflyData);
                itemTag.putString("butterflyId", EntityType.getId(blockEntity.getEntityType()).toString());
                blockEntity.setEntityType(null);
                blockEntity.setButterflyData(null);
                blockEntity.removeButterfly();
                return ActionResult.SUCCESS;
            }
        }

        return super.useOnBlock(pContext);
    }
}
