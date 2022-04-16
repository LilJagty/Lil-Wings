package com.toadstoolstudios.lilwings.registry;

import com.toadstoolstudios.lilwings.LilWings;
import com.toadstoolstudios.lilwings.entity.ButterflyEntity;
import com.toadstoolstudios.lilwings.entity.effects.EnderflyCatchEffect;
import com.toadstoolstudios.lilwings.entity.jareffects.*;
import com.toadstoolstudios.lilwings.platform.CommonServices;
import com.toadstoolstudios.lilwings.registry.entity.Butterfly;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;

import java.util.Random;

public class LilWingsEntities {

    public static Butterfly WHITE_FOX_BUTTERFLY = Butterfly.Builder.of("white_fox")
            .setBreedingItem(Items.LILY_OF_THE_VALLEY)
            .addParticles(ParticleTypes.SNOWFLAKE, 0.08f)
            .addSpawnEgg(0x6DC6D7, 0xBEF0F0)
            .setJarEffect(WhiteFoxJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly SWAMP_HOPPER_BUTTERFLY = Butterfly.Builder.of("swamp_hopper")
            .setBreedingItem(Items.BLUE_ORCHID)
            .addSpawnEgg(0X1463C5, 0X2FCEFD)
            .setJarEffect(SwampHopperJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly SWALLOW_TAIL_BUTTERFLY = Butterfly.Builder.of("swallow_tail")
            .setBreedingItem(Items.WHEAT_SEEDS)
            .addSpawnEgg(0xC0C5D1, 0xF3F6F7)
            .setJarEffect(SwallowTailJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);


    public static Butterfly SHROOM_SKIPPER_BUTTERFLY = Butterfly.Builder.of("shroom_skipper")
            .setBreedingItem(Items.RED_MUSHROOM)
            .addParticles(ParticleTypes.CRIMSON_SPORE, 0.1f)
            .addSpawnEgg(0XBB2225, 0XE0612A)
            .setJarEffect(ShroomSkipperJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly PAINTED_PANTHER_BUTTERFLY = Butterfly.Builder.of("painted_panther")
            .setBreedingItem(Items.COCOA_BEANS)
            .addSpawnEgg(0x0A0A0A, 0x271F19)
            .setJarEffect(PaintedPantherJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly ENDER_WING_BUTTERFLY = Butterfly.Builder.of("ender_wing")
            .setBreedingItem(Items.END_STONE)
            .addParticles(ParticleTypes.REVERSE_PORTAL, 0.15f)
            .addSpawnEgg(0x101E29, 0xB5E45A)
            .setJarEffect(EnderWingJarEffect::new)
            .setBoundingBoxSize(2.5f, 1.7f)
            .setSpawnScale(1f, 0.85f)
            .setMaxHealth(9)
            .setCatchAmount(2)
            .setCatchEffect(new EnderflyCatchEffect())
            .setNet(LilWingsItems.ENDERFLY_NET)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly CRYSTAL_PUFF_BUTTERFLY = Butterfly.Builder.of("crystal_puff")
            .setBreedingItem(Items.ALLIUM)
            .addSpawnEgg(0xCC88EF, 0xEBC5FD)
            .setJarEffect(CrystalpuffJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly CLOUDY_PUFF_BUTTERFLY = Butterfly.Builder.of("cloudy_puff")
            .setBreedingItem(Items.AZURE_BLUET)
            .addParticles(ParticleTypes.WHITE_ASH, 0.15f)
            .addSpawnEgg(0xF1DD3C, 0xEDDE70)
            .setJarEffect(CloudyPuffJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly BUTTER_GOLD_BUTTERFLY = Butterfly.Builder.of("butter_gold")
            .setBreedingItem(Items.DANDELION)
            .addSpawnEgg(0xAE6D26, 0xFAEA2E)
            .setJarEffect(ButterGoldJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly APONI_BUTTERFLY = Butterfly.Builder.of("aponi")
            .setBreedingItem(Items.BROWN_MUSHROOM)
            .addSpawnEgg(0x6A4418, 0xBE742D)
            .setJarEffect(AponiJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly RED_APPLEFLY_BUTTERFLY = Butterfly.Builder.of("red_applefly")
            .setBreedingItem(Items.APPLE)
            .addSpawnEgg(0x54090E, 0xFF969D)
            .setJarEffect(AppleFlyJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly GOLD_APPLEFLY_BUTTERFLY = Butterfly.Builder.of("gold_applefly")
            .addSpawnEgg(0xB26411, 0xECCB45)
            .setJarEffect(GoldAppleFlyJarEffect::new)
            .addWings()
            .addElytra()
            .build(LilWings.MODID);

    public static Butterfly GRAYLING_BUTTERFLY = Butterfly.Builder.of("grayling")
            .setBreedingItem(Blocks.MOSS_BLOCK.asItem())
            .addSpawnEgg(0x85837B, 0xB4B4B1)
            .addWings("flowering", "blooming")
            .addElytra("flowering", "blooming")
            .setJarEffect(GraylingJarEffect::new)
            .build(LilWings.MODID);

    public static void addSpawnPlacements() {
        CommonServices.REGISTRY.setSpawnRules(WHITE_FOX_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(SWALLOW_TAIL_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(SWAMP_HOPPER_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(SHROOM_SKIPPER_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(PAINTED_PANTHER_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(ENDER_WING_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(CRYSTAL_PUFF_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(CLOUDY_PUFF_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(BUTTER_GOLD_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(APONI_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(RED_APPLEFLY_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(GOLD_APPLEFLY_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
        CommonServices.REGISTRY.setSpawnRules(GRAYLING_BUTTERFLY.entityType(), SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LilWingsEntities::normalButterflySpawnRules);
    }

    public static boolean normalButterflySpawnRules(EntityType<ButterflyEntity> entityType, ServerWorldAccess levelAccessor, SpawnReason spawnType, BlockPos blockPos, Random random) {
        return entityType == GRAYLING_BUTTERFLY.entityType().get() || levelAccessor.getBlockState(blockPos.down()).isIn(BlockTags.DIRT);
    }

    public static void register() {}

    //TODO Entity Attributes
}
