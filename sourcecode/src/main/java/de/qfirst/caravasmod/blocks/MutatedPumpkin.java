package de.qfirst.caravasmod.blocks;

import de.qfirst.caravasmod.entity.ModEntities;
import de.qfirst.caravasmod.entity.custom.*;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Wearable;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.function.MaterialPredicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.function.Predicate;

public class MutatedPumpkin extends HorizontalFacingBlock implements Wearable {
    public static final DirectionProperty FACING;
    @Nullable
    private BlockPattern ironGolemDispenserPattern;
    @Nullable
    private BlockPattern ironGolemPattern;

    private BlockPattern woodenGolemPattern;
    private BlockPattern leavesGolemPattern;
    private BlockPattern amethystGolemPattern;
    private BlockPattern netheriteGolemPattern;
    private BlockPattern stoneGolemPattern;
    private BlockPattern deepslateGolemPattern;
    private BlockPattern rainbowGolemPattern;
    private BlockPattern glassGolemPattern;
    private BlockPattern skeletonGolemPattern;
    private BlockPattern bookGolemPattern;
    private BlockPattern netherBrickGolemPattern;
    private BlockPattern sandGolemPattern;
    private BlockPattern coalGolemPattern;
    private BlockPattern dirtGolemPattern;
    private BlockPattern warpedGolemPattern;
    private BlockPattern crimsonGolemPattern;
    private BlockPattern obsidianGolemPattern;
    private BlockPattern diamondGolemPattern;
    private BlockPattern emeraldGolemPattern;
    private BlockPattern endGolemPattern;
    private BlockPattern lampGolemPattern;
    private BlockPattern goldenGolemPattern;
    private BlockPattern hayGolemPattern;
    private BlockPattern lapisGolemPattern;
    private BlockPattern magmaGolemPattern;
    private BlockPattern melonGolemPattern;
    private BlockPattern mossyGolemPattern;
    private BlockPattern snowGolemPattern;
    private BlockPattern pumpkinGolemPattern;
    private BlockPattern redstoneGolemPattern;
    private BlockPattern slimeGolemPattern;
    private BlockPattern soulGolemPattern;
    private BlockPattern tntGolemPattern;
    private BlockPattern chestGolemPattern;
    private BlockPattern furnaceGolemPattern;
    private BlockPattern craftingGolemPattern;
    private static final Predicate<BlockState> IS_GOLEM_HEAD_PREDICATE;
    private static final Predicate<BlockState> IS_WOOD;
    private static final Predicate<BlockState> IS_LEAVES;
    private static final Predicate<BlockState> IS_NETHERITE;
    private static final Predicate<BlockState> IS_STONE;
    private static final Predicate<BlockState> IS_DEEPSLATE;
    private static final Predicate<BlockState> IS_JUKEBOX;
    private static final Predicate<BlockState> IS_RAINBOW;
    private static final Predicate<BlockState> IS_GLASS;
    private static final Predicate<BlockState> IS_NETHER;
    private static final Predicate<BlockState> IS_SAND;
    private static final Predicate<BlockState> IS_DIRT;
    private static final Predicate<BlockState> IS_WARPED;
    private static final Predicate<BlockState> IS_CRIMSON;
    private static final Predicate<BlockState> IS_OBSIDIAN;
    private static final Predicate<BlockState> IS_LAMP;
    private static final Predicate<BlockState> IS_MOSSY;
    private static final Predicate<BlockState> IS_PUMPKIN;
    private static final Predicate<BlockState> IS_SOUL;
    private static final Predicate<BlockState> IS_CHEST;



    public MutatedPumpkin(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH));

    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
            this.trySpawnEntity(world, pos);
        }
    }
    private void trySpawnEntity(World world, BlockPos pos) {
        BlockPattern.Result resultWoodenGolem = this.getWoodenGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultLeavesGolem = this.getLeavesGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultAmethystGolem = this.getAmethystGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultNetheriteGolem = this.getNetheriteGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultStoneGolem = this.getStoneGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultDeepslateGolem = this.getDeepslateGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultRainbowGolem = this.getRainbowGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultGlassGolem = this.getGlassGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultSkeletonGolem = this.getSkeletonGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultBookGolem = this.getBookGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultNetherBrickGolem = this.getNetherBrickGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultSandGolem = this.getSandGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultCoalGolem = this.getCoalGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultDirtGolem = this.getDirtGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultWarpedGolem = this.getWarpedGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultCrimsonGolem = this.getCrimsonGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultObsidianGolem = this.getObsidianGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultDiamondGolem = this.getDiamondGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultEmeraldGolem = this.getEmeraldGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultEndGolem = this.getEndGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultLampGolem = this.getLampGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultGoldenGolem = this.getGoldenGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultHayGolem = this.getHayGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultLapisGolem = this.getLapisGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultMagmaGolem = this.getMagmaGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultMelonGolem = this.getMelonGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultMossyGolem = this.getMossyGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultSnowGolem = this.getSnowGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultPumpkinGolem = this.getPumpkinGolemPattern().searchAround(world, pos);
        BlockPattern.Result resultRedstoneGolem = this.getPattern(redstoneGolemPattern, Blocks.REDSTONE_BLOCK).searchAround(world, pos);
        BlockPattern.Result resultSlimeGolem = this.getPattern(slimeGolemPattern, Blocks.SLIME_BLOCK).searchAround(world, pos);
        BlockPattern.Result resultSoulGolem = this.getPattern(slimeGolemPattern, IS_SOUL).searchAround(world, pos);
        BlockPattern.Result resultTNTGolem = this.getPattern(tntGolemPattern, Blocks.TNT).searchAround(world, pos);
        BlockPattern.Result resultChestGolem = this.getPattern(chestGolemPattern, IS_CHEST).searchAround(world, pos);


        PumpkinGolemEntity pumpkinGolemEntity = (PumpkinGolemEntity) ModEntities.PUMPKIN_GOLEM.create(world);
        RedstoneGolemEntity redstoneGolemEntity = (RedstoneGolemEntity) ModEntities.REDSTONE_GOLEM.create(world);
        SlimeGolemEntity slimeGolemEntity = (SlimeGolemEntity) ModEntities.SLIME_GOLEM.create(world);
        SoulGolemEntity soulGolemEntity = (SoulGolemEntity) ModEntities.SOUL_GOLEM.create(world);
        TNTGolemEntity tntGolemEntity = (TNTGolemEntity) ModEntities.TNT_GOLEM.create(world);
        ChestGolemEntity chestGolemEntity = (ChestGolemEntity) ModEntities.CHEST_GOLEM.create(world);


        int i;
        Iterator var6;
        ServerPlayerEntity serverPlayerEntity;
        int j;
        newPattern(pumpkinGolemEntity, pumpkinGolemPattern, IS_PUMPKIN, resultPumpkinGolem, world);
        newPattern(redstoneGolemEntity, redstoneGolemPattern, Blocks.REDSTONE_BLOCK, resultRedstoneGolem, world);
        newPattern(slimeGolemEntity, slimeGolemPattern, Blocks.SLIME_BLOCK, resultSlimeGolem, world);
        newPattern(soulGolemEntity, soulGolemPattern, IS_SOUL, resultSoulGolem, world);
        newPattern(tntGolemEntity, tntGolemPattern, Blocks.TNT, resultTNTGolem, world);
        newPattern(chestGolemEntity, chestGolemPattern, IS_CHEST, resultChestGolem, world);
        newPattern(tntGolemEntity, tntGolemPattern, Blocks.TNT, resultTNTGolem, world);



        if (resultWoodenGolem != null) {
            for(i = 0; i < this.getWoodenGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getWoodenGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultWoodenGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            WoodenGolemEntity woodenGolemEntity = (WoodenGolemEntity) ModEntities.WOODEN_GOLEM.create(world);
            BlockPos blockPos = resultWoodenGolem.translate(1, 2, 0).getBlockPos();
            woodenGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(woodenGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, woodenGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, woodenGolemEntity);
            }

            for(j = 0; j < this.getWoodenGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getWoodenGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultWoodenGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultLeavesGolem != null) {
            for(i = 0; i < this.getLeavesGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getLeavesGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultLeavesGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            LeavesGolemEntity leavesGolemEntity = (LeavesGolemEntity) ModEntities.LEAVES_GOLEM.create(world);
            BlockPos blockPos = resultLeavesGolem.translate(1, 2, 0).getBlockPos();
            leavesGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(leavesGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, leavesGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, leavesGolemEntity);
            }

            for(j = 0; j < this.getLeavesGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getLeavesGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultLeavesGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultNetheriteGolem != null) {
            for(i = 0; i < this.getNetheriteGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getNetheriteGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultNetheriteGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            NetheriteGolemEntity netheriteGolemEntity = (NetheriteGolemEntity) ModEntities.NETHERITE_GOLEM.create(world);
            BlockPos blockPos = resultNetheriteGolem.translate(1, 2, 0).getBlockPos();
            netheriteGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(netheriteGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, netheriteGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, netheriteGolemEntity);
            }

            for(j = 0; j < this.getNetheriteGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getNetheriteGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultNetheriteGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultAmethystGolem != null) {
            for(i = 0; i < this.getAmethystGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getAmethystGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultAmethystGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            AmethystGolemEntity amethystGolemEntity = (AmethystGolemEntity) ModEntities.AMETHYST_GOLEM.create(world);
            BlockPos blockPos = resultAmethystGolem.translate(1, 2, 0).getBlockPos();
            amethystGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(amethystGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, amethystGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, amethystGolemEntity);
            }

            for(j = 0; j < this.getAmethystGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getAmethystGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultAmethystGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultStoneGolem != null) {
            for(i = 0; i < this.getStoneGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getStoneGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultStoneGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            StoneGolemEntity stoneGolemEntity = (StoneGolemEntity) ModEntities.STONE_GOLEM.create(world);
            BlockPos blockPos = resultStoneGolem.translate(1, 2, 0).getBlockPos();
            stoneGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(stoneGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, stoneGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, stoneGolemEntity);
            }

            for(j = 0; j < this.getStoneGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getStoneGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultStoneGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultDeepslateGolem != null) {
            for(i = 0; i < this.getDeepslateGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getDeepslateGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultDeepslateGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            DeepslateGolemEntity deepslateGolemEntity = (DeepslateGolemEntity) ModEntities.DEEPSLATE_GOLEM.create(world);
            BlockPos blockPos = resultDeepslateGolem.translate(1, 2, 0).getBlockPos();
            deepslateGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(deepslateGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, deepslateGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, deepslateGolemEntity);
            }

            for(j = 0; j < this.getDeepslateGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getDeepslateGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultDeepslateGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultRainbowGolem != null) {
            for(i = 0; i < this.getRainbowGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getRainbowGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultRainbowGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            RainbowGolemEntity rainbowGolemEntity = (RainbowGolemEntity) ModEntities.RAINBOW_GOLEM.create(world);
            BlockPos blockPos = resultRainbowGolem.translate(1, 2, 0).getBlockPos();
            rainbowGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(rainbowGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, rainbowGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, rainbowGolemEntity);
            }

            for(j = 0; j < this.getRainbowGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getRainbowGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultRainbowGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultGlassGolem != null) {
            for(i = 0; i < this.getGlassGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getGlassGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultGlassGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            GlassGolemEntity glassGolemEntity = (GlassGolemEntity) ModEntities.GLASS_GOLEM.create(world);
            BlockPos blockPos = resultGlassGolem.translate(1, 2, 0).getBlockPos();
            glassGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(glassGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, glassGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, glassGolemEntity);
            }

            for(j = 0; j < this.getGlassGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getGlassGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultGlassGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultSkeletonGolem != null) {
            for(i = 0; i < this.getSkeletonGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getSkeletonGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultSkeletonGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            SkeletonGolemEntity skeletonGolemEntity = (SkeletonGolemEntity) ModEntities.SKELETON_GOLEM.create(world);
            BlockPos blockPos = resultSkeletonGolem.translate(1, 2, 0).getBlockPos();
            skeletonGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(skeletonGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, skeletonGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, skeletonGolemEntity);
            }

            for(j = 0; j < this.getSkeletonGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getSkeletonGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultSkeletonGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultBookGolem != null) {
            for(i = 0; i < this.getBookGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getBookGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultBookGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            BookGolemEntity bookGolemEntity = (BookGolemEntity) ModEntities.BOOK_GOLEM.create(world);
            BlockPos blockPos = resultBookGolem.translate(1, 2, 0).getBlockPos();
            bookGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(bookGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, bookGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, bookGolemEntity);
            }

            for(j = 0; j < this.getBookGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getBookGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultBookGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultNetherBrickGolem != null) {
            for(i = 0; i < this.getNetherBrickGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getNetherBrickGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultNetherBrickGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            NetherBrickGolemEntity netherBrickGolemEntity = (NetherBrickGolemEntity) ModEntities.NETHER_BRICK_GOLEM.create(world);
            BlockPos blockPos = resultNetherBrickGolem.translate(1, 2, 0).getBlockPos();
            netherBrickGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(netherBrickGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, netherBrickGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, netherBrickGolemEntity);
            }

            for(j = 0; j < this.getNetherBrickGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getNetherBrickGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultNetherBrickGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultSandGolem != null) {
            for(i = 0; i < this.getSandGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getSandGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultSandGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            SandGolemEntity sandGolemEntity = (SandGolemEntity) ModEntities.SAND_GOLEM.create(world);
            BlockPos blockPos = resultSandGolem.translate(1, 2, 0).getBlockPos();
            sandGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(sandGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, sandGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, sandGolemEntity);
            }

            for(j = 0; j < this.getSandGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getSandGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultSandGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultCoalGolem != null) {
            for(i = 0; i < this.getCoalGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getCoalGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultCoalGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            CoalGolemEntity coalGolemEntity = (CoalGolemEntity) ModEntities.COAL_GOLEM.create(world);
            BlockPos blockPos = resultCoalGolem.translate(1, 2, 0).getBlockPos();
            coalGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(coalGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, coalGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, coalGolemEntity);
            }

            for(j = 0; j < this.getCoalGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getCoalGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultCoalGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultDirtGolem != null) {
            for(i = 0; i < this.getDirtGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getDirtGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultDirtGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            DirtGolemEntity dirtGolemEntity = (DirtGolemEntity) ModEntities.DIRT_GOLEM.create(world);
            BlockPos blockPos = resultDirtGolem.translate(1, 2, 0).getBlockPos();
            dirtGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(dirtGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, dirtGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, dirtGolemEntity);
            }

            for(j = 0; j < this.getDirtGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getDirtGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultDirtGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultWarpedGolem != null) {
            for(i = 0; i < this.getWarpedGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getWarpedGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultWarpedGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            WarpedGolemEntity warpedGolemEntity = (WarpedGolemEntity) ModEntities.WARPED_GOLEM.create(world);
            BlockPos blockPos = resultWarpedGolem.translate(1, 2, 0).getBlockPos();
            warpedGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(warpedGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, warpedGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, warpedGolemEntity);
            }

            for(j = 0; j < this.getWarpedGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getWarpedGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultWarpedGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultCrimsonGolem != null) {
            for(i = 0; i < this.getCrimsonGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getCrimsonGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultCrimsonGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            CrimsonGolemEntity crimsonGolemEntity = (CrimsonGolemEntity) ModEntities.CRIMSON_GOLEM.create(world);
            BlockPos blockPos = resultCrimsonGolem.translate(1, 2, 0).getBlockPos();
            crimsonGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(crimsonGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, crimsonGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, crimsonGolemEntity);
            }

            for(j = 0; j < this.getCrimsonGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getCrimsonGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultCrimsonGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultObsidianGolem != null) {
            for(i = 0; i < this.getObsidianGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getObsidianGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultObsidianGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            ObsidianGolemEntity obsidianGolemEntity = (ObsidianGolemEntity) ModEntities.OBSIDIAN_GOLEM.create(world);
            BlockPos blockPos = resultObsidianGolem.translate(1, 2, 0).getBlockPos();
            obsidianGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(obsidianGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, obsidianGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, obsidianGolemEntity);
            }

            for(j = 0; j < this.getObsidianGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getObsidianGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultObsidianGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultDiamondGolem != null) {
            for(i = 0; i < this.getDiamondGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getDiamondGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultDiamondGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            DiamondGolemEntity diamondGolemEntity = (DiamondGolemEntity) ModEntities.DIAMOND_GOLEM.create(world);
            BlockPos blockPos = resultDiamondGolem.translate(1, 2, 0).getBlockPos();
            diamondGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(diamondGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, diamondGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, diamondGolemEntity);
            }

            for(j = 0; j < this.getDiamondGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getDiamondGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultDiamondGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultEmeraldGolem != null) {
            for(i = 0; i < this.getEmeraldGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getEmeraldGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultEmeraldGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            EmeraldGolemEntity emeraldGolemEntity = (EmeraldGolemEntity) ModEntities.EMERALD_GOLEM.create(world);
            BlockPos blockPos = resultEmeraldGolem.translate(1, 2, 0).getBlockPos();
            emeraldGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(emeraldGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, emeraldGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, emeraldGolemEntity);
            }

            for(j = 0; j < this.getEmeraldGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getEmeraldGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultEmeraldGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultEndGolem != null) {
            for(i = 0; i < this.getEndGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getEndGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultEndGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            EndGolemEntity endGolemEntity = (EndGolemEntity) ModEntities.END_GOLEM.create(world);
            BlockPos blockPos = resultEndGolem.translate(1, 2, 0).getBlockPos();
            endGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(endGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, endGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, endGolemEntity);
            }

            for(j = 0; j < this.getEndGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getEndGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultEndGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultLampGolem != null) {
            for(i = 0; i < this.getLampGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getLampGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultLampGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            LampGolemEntity lampGolemEntity = (LampGolemEntity) ModEntities.LAMP_GOLEM.create(world);
            BlockPos blockPos = resultLampGolem.translate(1, 2, 0).getBlockPos();
            lampGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(lampGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, lampGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, lampGolemEntity);
            }

            for(j = 0; j < this.getLampGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getLampGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultLampGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultGoldenGolem != null) {
            for(i = 0; i < this.getGoldenGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getGoldenGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultGoldenGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            GoldenGolemEntity goldenGolemEntity = (GoldenGolemEntity) ModEntities.GOLDEN_GOLEM.create(world);
            BlockPos blockPos = resultGoldenGolem.translate(1, 2, 0).getBlockPos();
            goldenGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(goldenGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, goldenGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, goldenGolemEntity);
            }

            for(j = 0; j < this.getGoldenGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getGoldenGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultGoldenGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultHayGolem != null) {
            for(i = 0; i < this.getHayGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getHayGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultHayGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            HayGolemEntity hayGolemEntity = (HayGolemEntity) ModEntities.HAY_GOLEM.create(world);
            BlockPos blockPos = resultHayGolem.translate(1, 2, 0).getBlockPos();
            hayGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(hayGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, hayGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, hayGolemEntity);
            }

            for(j = 0; j < this.getHayGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getHayGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultHayGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultLapisGolem != null) {
            for(i = 0; i < this.getLapisGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getLapisGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultLapisGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            LapisGolemEntity lapisGolemEntity = (LapisGolemEntity) ModEntities.LAPIS_GOLEM.create(world);
            BlockPos blockPos = resultLapisGolem.translate(1, 2, 0).getBlockPos();
            lapisGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(lapisGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, lapisGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, lapisGolemEntity);
            }

            for(j = 0; j < this.getLapisGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getLapisGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultLapisGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultMagmaGolem != null) {
            for(i = 0; i < this.getMagmaGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getMagmaGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultMagmaGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            MagmaGolemEntity magmaGolemEntity = (MagmaGolemEntity) ModEntities.MAGMA_GOLEM.create(world);
            BlockPos blockPos = resultMagmaGolem.translate(1, 2, 0).getBlockPos();
            magmaGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(magmaGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, magmaGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, magmaGolemEntity);
            }

            for(j = 0; j < this.getMagmaGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getMagmaGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultMagmaGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultMelonGolem != null) {
            for(i = 0; i < this.getMelonGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getMelonGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultMelonGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            MelonGolemEntity melonGolemEntity = (MelonGolemEntity) ModEntities.MELON_GOLEM.create(world);
            BlockPos blockPos = resultMelonGolem.translate(1, 2, 0).getBlockPos();
            melonGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(melonGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, melonGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, melonGolemEntity);
            }

            for(j = 0; j < this.getMelonGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getMelonGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultMelonGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultMossyGolem != null) {
            for(i = 0; i < this.getMossyGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getMossyGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultMossyGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            MossyGolemEntity mossyGolemEntity = (MossyGolemEntity) ModEntities.MOSSY_GOLEM.create(world);
            BlockPos blockPos = resultMossyGolem.translate(1, 2, 0).getBlockPos();
            mossyGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(mossyGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, mossyGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, mossyGolemEntity);
            }

            for(j = 0; j < this.getMossyGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getMossyGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultMossyGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
        if (resultSnowGolem != null) {
            for(i = 0; i < this.getSnowGolemPattern().getWidth(); ++i) {
                for(int k = 0; k < this.getSnowGolemPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = resultSnowGolem.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            SnowGolemEntity snowGolemEntity = (SnowGolemEntity) ModEntities.SNOW_GOLEM.create(world);
            BlockPos blockPos = resultSnowGolem.translate(1, 2, 0).getBlockPos();
            snowGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(snowGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, snowGolemEntity.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, snowGolemEntity);
            }

            for(j = 0; j < this.getSnowGolemPattern().getWidth(); ++j) {
                for(int l = 0; l < this.getSnowGolemPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = resultSnowGolem.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }








    }
    private BlockPattern getWoodenGolemPattern() {
        if (this.woodenGolemPattern == null) {
            this.woodenGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_WOOD)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.woodenGolemPattern;
    }
    private BlockPattern getLeavesGolemPattern() {
        if (this.leavesGolemPattern == null) {
            this.leavesGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_LEAVES)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.leavesGolemPattern;
    }
    private BlockPattern getAmethystGolemPattern() {
        if (this.amethystGolemPattern == null) {
            this.amethystGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.AMETHYST_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.amethystGolemPattern;
    }
    private BlockPattern getNetheriteGolemPattern() {
        if (this.netheriteGolemPattern == null) {
            this.netheriteGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_NETHERITE)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.netheriteGolemPattern;
    }
    private BlockPattern getStoneGolemPattern() {
        if (this.stoneGolemPattern == null) {
            this.stoneGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_STONE)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.stoneGolemPattern;
    }
    private BlockPattern getDeepslateGolemPattern() {
        if (this.deepslateGolemPattern == null) {
            this.deepslateGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_DEEPSLATE)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.deepslateGolemPattern;
    }
    private BlockPattern getRainbowGolemPattern() {
        if (this.rainbowGolemPattern == null) {
            this.rainbowGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_RAINBOW)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.rainbowGolemPattern;
    }
    private BlockPattern getGlassGolemPattern() {
        if (this.glassGolemPattern == null) {
            this.glassGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_GLASS)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.glassGolemPattern;
    }
    private BlockPattern getSkeletonGolemPattern() {
        if (this.skeletonGolemPattern == null) {
            this.skeletonGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.BONE_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.skeletonGolemPattern;
    }
    private BlockPattern getBookGolemPattern() {
        if (this.bookGolemPattern == null) {
            this.bookGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.BOOKSHELF))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.bookGolemPattern;
    }
    private BlockPattern getNetherBrickGolemPattern() {
        if (this.netherBrickGolemPattern == null) {
            this.netherBrickGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_NETHER)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.netherBrickGolemPattern;
    }
    private BlockPattern getSandGolemPattern() {
        if (this.sandGolemPattern == null) {
            this.sandGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_SAND)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.sandGolemPattern;
    }
    private BlockPattern getCoalGolemPattern() {
        if (this.coalGolemPattern == null) {
            this.coalGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.COAL_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.coalGolemPattern;
    }
    private BlockPattern getDirtGolemPattern() {
        if (this.dirtGolemPattern == null) {
            this.dirtGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_DIRT)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.dirtGolemPattern;
    }
    private BlockPattern getWarpedGolemPattern() {
        if (this.warpedGolemPattern == null) {
            this.warpedGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_WARPED)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.warpedGolemPattern;
    }
    private BlockPattern getCrimsonGolemPattern() {
        if (this.crimsonGolemPattern == null) {
            this.crimsonGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_CRIMSON)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.crimsonGolemPattern;
    }
    private BlockPattern getObsidianGolemPattern() {
        if (this.obsidianGolemPattern == null) {
            this.obsidianGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_OBSIDIAN)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.obsidianGolemPattern;
    }
    private BlockPattern getDiamondGolemPattern() {
        if (this.diamondGolemPattern == null) {
            this.diamondGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.DIAMOND_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.diamondGolemPattern;
    }
    private BlockPattern getEmeraldGolemPattern() {
        if (this.emeraldGolemPattern == null) {
            this.emeraldGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.EMERALD_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.emeraldGolemPattern;
    }
    private BlockPattern getEndGolemPattern() {
        if (this.endGolemPattern == null) {
            this.endGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.END_STONE))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.endGolemPattern;
    }
    private BlockPattern getLampGolemPattern() {
        if (this.lampGolemPattern == null) {
            this.lampGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_LAMP)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.lampGolemPattern;
    }
    private BlockPattern getGoldenGolemPattern() {
        if (this.goldenGolemPattern == null) {
            this.goldenGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.GOLD_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.goldenGolemPattern;
    }
    private BlockPattern getHayGolemPattern() {
        if (this.hayGolemPattern == null) {
            this.hayGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.HAY_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.hayGolemPattern;
    }
    private BlockPattern getLapisGolemPattern() {
        if (this.lapisGolemPattern == null) {
            this.lapisGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.LAPIS_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.lapisGolemPattern;
    }
    private BlockPattern getMagmaGolemPattern() {
        if (this.magmaGolemPattern == null) {
            this.magmaGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.MAGMA_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.magmaGolemPattern;
    }
    private BlockPattern getMelonGolemPattern() {
        if (this.melonGolemPattern == null) {
            this.melonGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.MELON))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.melonGolemPattern;
    }
    private BlockPattern getMossyGolemPattern() {
        if (this.mossyGolemPattern == null) {
            this.mossyGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_MOSSY)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.mossyGolemPattern;
    }
    private BlockPattern getSnowGolemPattern() {
        if (this.snowGolemPattern == null) {
            this.snowGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.snowGolemPattern;
    }
    private BlockPattern getPumpkinGolemPattern() {
        if (this.pumpkinGolemPattern == null) {
            this.pumpkinGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(IS_PUMPKIN)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.pumpkinGolemPattern;
    }



    public BlockPattern getPattern(BlockPattern pattern, Predicate<BlockState> predicate){
        if (pattern == null) {
            pattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(predicate)).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }
        return pattern;
    }
    public BlockPattern getPattern(BlockPattern pattern, Block block){
        if (pattern == null) {
            pattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(block))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }
        return pattern;
    }

    public void newPattern(TameableEntity newGolem, BlockPattern pattern, Predicate<BlockState> predicate, BlockPattern.Result result, World world){
        if (result != null) {
            for(int i = 0; i < this.getPattern(pattern, predicate).getWidth(); ++i) {
                for(int k = 0; k < this.getPattern(pattern, predicate).getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = result.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            //SnowGolemEntity snowGolemEntity = (SnowGolemEntity) ModEntities.SNOW_GOLEM.create(world);
            BlockPos blockPos = result.translate(1, 2, 0).getBlockPos();
            newGolem.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(newGolem);
            Iterator var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, newGolem.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, newGolem);
            }

            for(int j = 0; j < this.getPattern(pattern, predicate).getWidth(); ++j) {
                for(int l = 0; l < this.getPattern(pattern, predicate).getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = result.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
    }
    public void newPattern(TameableEntity newGolem, BlockPattern pattern, Block block, BlockPattern.Result result, World world){
        if (result != null) {
            for(int i = 0; i < this.getPattern(pattern, block).getWidth(); ++i) {
                for(int k = 0; k < this.getPattern(pattern, block).getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition = result.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }

            //SnowGolemEntity snowGolemEntity = (SnowGolemEntity) ModEntities.SNOW_GOLEM.create(world);
            BlockPos blockPos = result.translate(1, 2, 0).getBlockPos();
            newGolem.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
            world.spawnEntity(newGolem);
            Iterator var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, newGolem.getBoundingBox().expand(5.0)).iterator();

            while(var6.hasNext()) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, newGolem);
            }

            for(int j = 0; j < this.getPattern(pattern, block).getWidth(); ++j) {
                for(int l = 0; l < this.getPattern(pattern, block).getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition2 = result.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
            }
        }
    }


    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    private BlockPattern getIronGolemDispenserPattern() {
        if (this.ironGolemDispenserPattern == null) {
            this.ironGolemDispenserPattern = BlockPatternBuilder.start().aisle(new String[]{"~ ~", "###", "~#~"}).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.IRON_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.ironGolemDispenserPattern;
    }

    private BlockPattern getIronGolemPattern() {
        if (this.ironGolemPattern == null) {
            this.ironGolemPattern = BlockPatternBuilder.start().aisle(new String[]{"~^~", "###", "~#~"}).where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.IRON_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.ironGolemPattern;
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        IS_GOLEM_HEAD_PREDICATE = (state) -> {
            return state != null && state.isOf(ModBlocks.CUSTOM_PUMPKIN);
        };
        IS_WOOD = (state) -> {
            return state != null && (state.isOf(Blocks.OAK_PLANKS) || state.isOf(Blocks.OAK_WOOD) || state.isOf(Blocks.OAK_LOG) ||
                    state.isOf(Blocks.SPRUCE_PLANKS) || state.isOf(Blocks.SPRUCE_WOOD) || state.isOf(Blocks.SPRUCE_LOG) ||
                    state.isOf(Blocks.BIRCH_PLANKS) || state.isOf(Blocks.BIRCH_WOOD) || state.isOf(Blocks.BIRCH_LOG) ||
                    state.isOf(Blocks.JUNGLE_PLANKS) || state.isOf(Blocks.JUNGLE_WOOD) || state.isOf(Blocks.JUNGLE_LOG) ||
                    state.isOf(Blocks.ACACIA_PLANKS) || state.isOf(Blocks.ACACIA_WOOD) || state.isOf(Blocks.ACACIA_LOG) ||
                    state.isOf(Blocks.MANGROVE_PLANKS) || state.isOf(Blocks.MANGROVE_WOOD) || state.isOf(Blocks.MANGROVE_LOG) ||
                    state.isOf(Blocks.DARK_OAK_PLANKS) || state.isOf(Blocks.DARK_OAK_WOOD) || state.isOf(Blocks.DARK_OAK_LOG));
        };
        IS_LEAVES = (state) -> {
            return state != null && (state.isOf(Blocks.OAK_LEAVES) || state.isOf(Blocks.SPRUCE_LEAVES) ||
                    state.isOf(Blocks.BIRCH_LEAVES) || state.isOf(Blocks.JUNGLE_LEAVES) ||
                    state.isOf(Blocks.ACACIA_LEAVES) || state.isOf(Blocks.MANGROVE_LEAVES) ||
                    state.isOf(Blocks.DARK_OAK_LEAVES));
        };
        IS_NETHERITE = (state) -> {
            return state != null && (state.isOf(Blocks.NETHERITE_BLOCK) || state.isOf(Blocks.ANCIENT_DEBRIS));
        };
        IS_STONE = (state) -> {
            return state != null && (state.isOf(Blocks.STONE) || state.isOf(Blocks.STONE_BRICKS) || state.isOf(Blocks.CALCITE) ||
                    state.isOf(Blocks.ANDESITE) || state.isOf(Blocks.DIORITE) || state.isOf(Blocks.GRANITE) ||
                    state.isOf(Blocks.COBBLESTONE) || state.isOf(Blocks.BASALT) || state.isOf(Blocks.BLACKSTONE) ||
                    state.isOf(Blocks.BRICKS) || state.isOf(Blocks.TUFF));
        };
        IS_DEEPSLATE = (state) -> {
            return state != null && (state.isOf(Blocks.DEEPSLATE) || state.isOf(Blocks.COBBLED_DEEPSLATE));
        };
        IS_JUKEBOX = (state) -> {
            return state != null && state.isOf(Blocks.JUKEBOX);
        };
        IS_RAINBOW = (state) -> {
            return state != null && (state.isOf(Blocks.WHITE_WOOL) || state.isOf(Blocks.BLACK_WOOL) ||state.isOf(Blocks.BLUE_WOOL) || state.isOf(Blocks.BROWN_WOOL) ||
                    state.isOf(Blocks.CYAN_WOOL) || state.isOf(Blocks.GRAY_WOOL) ||state.isOf(Blocks.GREEN_WOOL) || state.isOf(Blocks.LIGHT_BLUE_WOOL) ||
                    state.isOf(Blocks.LIGHT_GRAY_WOOL) || state.isOf(Blocks.LIME_WOOL) ||state.isOf(Blocks.MAGENTA_WOOL) || state.isOf(Blocks.ORANGE_WOOL) ||
                    state.isOf(Blocks.YELLOW_WOOL) || state.isOf(Blocks.PINK_WOOL) ||state.isOf(Blocks.PURPLE_WOOL) || state.isOf(Blocks.RED_WOOL) ||
                    state.isOf(Blocks.WHITE_CONCRETE) || state.isOf(Blocks.BLACK_CONCRETE) ||state.isOf(Blocks.BLUE_CONCRETE) || state.isOf(Blocks.BROWN_CONCRETE) ||
                    state.isOf(Blocks.CYAN_CONCRETE) || state.isOf(Blocks.GRAY_CONCRETE) ||state.isOf(Blocks.GREEN_CONCRETE) || state.isOf(Blocks.LIGHT_BLUE_CONCRETE) ||
                    state.isOf(Blocks.LIGHT_GRAY_CONCRETE) || state.isOf(Blocks.LIME_CONCRETE) ||state.isOf(Blocks.MAGENTA_CONCRETE) || state.isOf(Blocks.ORANGE_CONCRETE) ||
                    state.isOf(Blocks.YELLOW_CONCRETE) || state.isOf(Blocks.PINK_CONCRETE) ||state.isOf(Blocks.PURPLE_CONCRETE) || state.isOf(Blocks.RED_CONCRETE) ||
                    state.isOf(Blocks.WHITE_CONCRETE_POWDER) || state.isOf(Blocks.BLACK_CONCRETE_POWDER) ||state.isOf(Blocks.BLUE_CONCRETE_POWDER) || state.isOf(Blocks.BROWN_CONCRETE_POWDER) ||
                    state.isOf(Blocks.CYAN_CONCRETE_POWDER) || state.isOf(Blocks.GRAY_CONCRETE_POWDER) ||state.isOf(Blocks.GREEN_CONCRETE_POWDER) || state.isOf(Blocks.LIGHT_BLUE_CONCRETE_POWDER) ||
                    state.isOf(Blocks.LIGHT_GRAY_CONCRETE_POWDER) || state.isOf(Blocks.LIME_CONCRETE_POWDER) ||state.isOf(Blocks.MAGENTA_CONCRETE_POWDER) || state.isOf(Blocks.ORANGE_CONCRETE_POWDER) ||
                    state.isOf(Blocks.YELLOW_CONCRETE_POWDER) || state.isOf(Blocks.PINK_CONCRETE_POWDER) ||state.isOf(Blocks.PURPLE_CONCRETE_POWDER) || state.isOf(Blocks.RED_CONCRETE_POWDER));
        };
        IS_GLASS = (state) -> {
            return state != null && (state.isOf(Blocks.WHITE_STAINED_GLASS) || state.isOf(Blocks.BLACK_STAINED_GLASS) ||state.isOf(Blocks.BLUE_STAINED_GLASS) || state.isOf(Blocks.BROWN_STAINED_GLASS) ||
                    state.isOf(Blocks.CYAN_STAINED_GLASS) || state.isOf(Blocks.GRAY_STAINED_GLASS) ||state.isOf(Blocks.GREEN_STAINED_GLASS) || state.isOf(Blocks.LIGHT_BLUE_STAINED_GLASS) ||
                    state.isOf(Blocks.LIGHT_GRAY_STAINED_GLASS) || state.isOf(Blocks.LIME_STAINED_GLASS) ||state.isOf(Blocks.MAGENTA_STAINED_GLASS) || state.isOf(Blocks.ORANGE_STAINED_GLASS) ||
                    state.isOf(Blocks.YELLOW_STAINED_GLASS) || state.isOf(Blocks.PINK_STAINED_GLASS) ||state.isOf(Blocks.PURPLE_STAINED_GLASS) || state.isOf(Blocks.RED_STAINED_GLASS) ||
                    state.isOf(Blocks.GLASS) || state.isOf(Blocks.TINTED_GLASS));
        };
        IS_NETHER = (state) -> {
            return state != null && (state.isOf(Blocks.NETHER_BRICKS) || state.isOf(Blocks.NETHERRACK));
        };
        IS_SAND = (state) -> {
            return state != null && (state.isOf(Blocks.SANDSTONE) || state.isOf(Blocks.RED_SANDSTONE));
        };
        IS_DIRT = (state) -> {
            return state != null && (state.isOf(Blocks.DIRT) || state.isOf(Blocks.COARSE_DIRT) ||
                    state.isOf(Blocks.GRASS_BLOCK) || state.isOf(Blocks.MUD));
        };
        IS_WARPED = (state) -> {
            return state != null && (state.isOf(Blocks.WARPED_STEM) || state.isOf(Blocks.WARPED_PLANKS) ||
                    state.isOf(Blocks.WARPED_WART_BLOCK));
        };
        IS_CRIMSON = (state) -> {
            return state != null && (state.isOf(Blocks.CRIMSON_STEM) || state.isOf(Blocks.CRIMSON_PLANKS) ||
                    state.isOf(Blocks.NETHER_WART_BLOCK));
        };
        IS_OBSIDIAN = (state) -> {
            return state != null && (state.isOf(Blocks.OBSIDIAN) || state.isOf(Blocks.CRYING_OBSIDIAN));
        };
        IS_LAMP = (state) -> {
            return state != null && (state.isOf(Blocks.GLOWSTONE) || state.isOf(Blocks.SHROOMLIGHT));
        };
        IS_MOSSY = (state) -> {
            return state != null && (state.isOf(Blocks.MOSS_BLOCK) || state.isOf(Blocks.MOSSY_COBBLESTONE));
        };
        IS_PUMPKIN = (state) -> {
            return state != null && (state.isOf(Blocks.PUMPKIN) || state.isOf(Blocks.JACK_O_LANTERN) || state.isOf(Blocks.CARVED_PUMPKIN));
        };
        IS_SOUL = (state) -> {
            return state != null && (state.isOf(Blocks.SOUL_SAND) || state.isOf(Blocks.SOUL_SOIL));
        };
        IS_CHEST = (state) -> {
            return state != null && (state.isOf(Blocks.CHEST) || state.isOf(Blocks.TRAPPED_CHEST) || state.isOf(Blocks.BARREL));
        };


    }
}
