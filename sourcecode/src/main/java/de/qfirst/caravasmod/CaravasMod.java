package de.qfirst.caravasmod;

import de.qfirst.caravasmod.blocks.ModBlocks;
import de.qfirst.caravasmod.effects.createStomp;
import de.qfirst.caravasmod.effects.ModEffects;
import de.qfirst.caravasmod.effects.SnowHelmetEffect;
import de.qfirst.caravasmod.entity.ModEntities;
import de.qfirst.caravasmod.entity.custom.*;
import de.qfirst.caravasmod.items.ModItems;
import de.qfirst.caravasmod.particles.ModParticles;
import de.qfirst.caravasmod.particles.SpawnParticles;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class CaravasMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "caravasmod";

	@Override
	public void onInitialize() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerWorld world : server.getWorlds()) {
				for (PlayerEntity player : world.getPlayers()) {
					createStomp.onPlayerTick(player);
					SnowHelmetEffect.onPlayerTick(player);
				}
			}
		});

		ModBlocks.register();
		ModItems.register();
		ModEffects.registerEffects();
		ModParticles.registerParticles();
		SpawnParticles.spawn();


		FabricDefaultAttributeRegistry.register(ModEntities.WOODEN_GOLEM, WoodenGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.LEAVES_GOLEM, LeavesGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.AMETHYST_GOLEM, AmethystGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.NETHERITE_GOLEM, NetheriteGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.STONE_GOLEM, StoneGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.DEEPSLATE_GOLEM, DeepslateGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.RAINBOW_GOLEM, RainbowGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GLASS_GOLEM, GlassGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SKELETON_GOLEM, SkeletonGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BOOK_GOLEM, BookGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.NETHER_BRICK_GOLEM, NetherBrickGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SAND_GOLEM, SandGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.COAL_GOLEM, CoalGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.DIRT_GOLEM, DirtGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.WARPED_GOLEM, WarpedGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CRIMSON_GOLEM, CrimsonGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.OBSIDIAN_GOLEM, ObsidianGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.DIAMOND_GOLEM, DiamondGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.EMERALD_GOLEM, EmeraldGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.END_GOLEM, EndGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.LAMP_GOLEM, LampGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GOLDEN_GOLEM, GoldenGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.HAY_GOLEM, HayGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.LAPIS_GOLEM, LapisGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MAGMA_GOLEM, MagmaGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MELON_GOLEM, MelonGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MOSSY_GOLEM, MossyGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SNOW_GOLEM, SnowGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.PUMPKIN_GOLEM, PumpkinGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.REDSTONE_GOLEM, RedstoneGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SLIME_GOLEM, SlimeGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SOUL_GOLEM, SoulGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.TNT_GOLEM, TNTGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CHEST_GOLEM, ChestGolemEntity.setAttributes());
	}
}