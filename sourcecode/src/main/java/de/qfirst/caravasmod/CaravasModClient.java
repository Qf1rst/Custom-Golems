package de.qfirst.caravasmod;

import de.qfirst.caravasmod.blocks.ModBlocks;
import de.qfirst.caravasmod.entity.ModEntities;
import de.qfirst.caravasmod.entity.client.amethystgolem.AmethystGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.bookgolem.BookGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.chestgolem.ChestGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.coalgolem.CoalGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.crimsongolem.CrimsonGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.deepslategolem.DeepslateGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.diamondgolem.DiamondGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.dirtgolem.DirtGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.emeraldgolem.EmeraldGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.endgolem.EndGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.glassgolem.GlassGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.golden_golem.GoldenGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.haygolem.HayGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.lampgolem.LampGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.lapisgolem.LapisGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.leavesgolem.LeavesGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.magmagolem.MagmaGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.melongolem.MelonGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.mossygolem.MossyGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.netherbrickgolem.NetherBrickGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.netheritegolem.NetheriteGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.obsidiangolem.ObsidianGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.pumpkingolem.PumpkinGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.rainbowgolem.RainbowGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.redstonegolem.RedstoneGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.sandgolem.SandGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.skeletongolem.SkeletonGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.slimegolem.SlimeGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.snowgolem.SnowGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.soulgolem.SoulGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.stonegolem.StoneGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.tntgolem.TNTGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.warpedgolem.WarpedGolemEntityRenderer;
import de.qfirst.caravasmod.entity.client.woodengolem.WoodenGolemEntityRenderer;
import de.qfirst.caravasmod.event.KeyInputHandler;
import de.qfirst.caravasmod.particles.BlueFlameParticle;
import de.qfirst.caravasmod.particles.GreenFlameParticle;
import de.qfirst.caravasmod.particles.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class CaravasModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CUSTOM_PUMPKIN, RenderLayer.getCutout());
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREEN_FLAME_PARTICLE, GreenFlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_FLAME_PARTICLE, BlueFlameParticle.Factory::new);

        KeyInputHandler.register();

        EntityRendererRegistry.register(ModEntities.WOODEN_GOLEM, WoodenGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LEAVES_GOLEM, LeavesGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.AMETHYST_GOLEM, AmethystGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.NETHERITE_GOLEM, NetheriteGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.STONE_GOLEM, StoneGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DEEPSLATE_GOLEM, DeepslateGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.RAINBOW_GOLEM, RainbowGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GLASS_GOLEM, GlassGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SKELETON_GOLEM, SkeletonGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.BOOK_GOLEM, BookGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.NETHER_BRICK_GOLEM, NetherBrickGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SAND_GOLEM, SandGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.COAL_GOLEM, CoalGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DIRT_GOLEM, DirtGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.WARPED_GOLEM, WarpedGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRIMSON_GOLEM, CrimsonGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.OBSIDIAN_GOLEM, ObsidianGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DIAMOND_GOLEM, DiamondGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.EMERALD_GOLEM, EmeraldGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.END_GOLEM, EndGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LAMP_GOLEM, LampGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GOLDEN_GOLEM, GoldenGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.HAY_GOLEM, HayGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LAPIS_GOLEM, LapisGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.MAGMA_GOLEM, MagmaGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.MELON_GOLEM, MelonGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.MOSSY_GOLEM, MossyGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SNOW_GOLEM, SnowGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.PUMPKIN_GOLEM, PumpkinGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.REDSTONE_GOLEM, RedstoneGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SLIME_GOLEM, SlimeGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SOUL_GOLEM, SoulGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.TNT_GOLEM, TNTGolemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.CHEST_GOLEM, ChestGolemEntityRenderer::new);
    }
}
