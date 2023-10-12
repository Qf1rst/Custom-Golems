package de.qfirst.caravasmod.entity;

import de.qfirst.caravasmod.CaravasMod;
import de.qfirst.caravasmod.entity.custom.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<WoodenGolemEntity> WOODEN_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "wooden_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WoodenGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<LeavesGolemEntity> LEAVES_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "leaves_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LeavesGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<AmethystGolemEntity> AMETHYST_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "amethyst_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AmethystGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<NetheriteGolemEntity> NETHERITE_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "netherite_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, NetheriteGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<StoneGolemEntity> STONE_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "stone_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StoneGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<DeepslateGolemEntity> DEEPSLATE_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "deepslate_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DeepslateGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<RainbowGolemEntity> RAINBOW_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "rainbow_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RainbowGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<GlassGolemEntity> GLASS_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "glass_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GlassGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<SkeletonGolemEntity> SKELETON_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "skeleton_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SkeletonGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<BookGolemEntity> BOOK_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "book_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BookGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<NetherBrickGolemEntity> NETHER_BRICK_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "nether_brick_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, NetherBrickGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<SandGolemEntity> SAND_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "sand_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SandGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<CoalGolemEntity> COAL_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "coal_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CoalGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<DirtGolemEntity> DIRT_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "dirt_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DirtGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<WarpedGolemEntity> WARPED_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "warped_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WarpedGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<CrimsonGolemEntity> CRIMSON_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "crimson_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CrimsonGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<ObsidianGolemEntity> OBSIDIAN_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "obsidian_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ObsidianGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<DiamondGolemEntity> DIAMOND_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "diamond_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DiamondGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<EmeraldGolemEntity> EMERALD_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "emerald_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EmeraldGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<EndGolemEntity> END_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "end_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EndGolemEntity::new).dimensions(EntityDimensions.fixed(2.8f,5.8f)).build());
    public static final EntityType<LampGolemEntity> LAMP_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "lamp_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LampGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<GoldenGolemEntity> GOLDEN_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "golden_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GoldenGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<HayGolemEntity> HAY_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "hay_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HayGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<LapisGolemEntity> LAPIS_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "lapis_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LapisGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<MagmaGolemEntity> MAGMA_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "magma_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MagmaGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<MelonGolemEntity> MELON_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "melon_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MelonGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<MossyGolemEntity> MOSSY_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "mossy_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MossyGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<SnowGolemEntity> SNOW_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "snow_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SnowGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<PumpkinGolemEntity> PUMPKIN_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "pumpkin_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PumpkinGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<RedstoneGolemEntity> REDSTONE_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "redstone_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedstoneGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<SlimeGolemEntity> SLIME_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "slime_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SlimeGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<SoulGolemEntity> SOUL_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "soul_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SoulGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<TNTGolemEntity> TNT_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "tnt_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TNTGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
    public static final EntityType<ChestGolemEntity> CHEST_GOLEM = Registry.register(Registry.ENTITY_TYPE, new Identifier(CaravasMod.MOD_ID, "chest_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChestGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());



}

