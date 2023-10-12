package de.qfirst.caravasmod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.UUID;


public class WoodenGolemEntity extends TameableEntity implements Angerable {



    private static final UniformIntProvider ANGER_TIME_RANGE;
    protected static final TrackedData<Byte> IRON_GOLEM_FLAGS;
    private int angerTime;
    private UUID angryAt;
    private int lookingAtVillagerTicksLeft;
    private int attackTicksLeft;

    public WoodenGolemEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new FollowOwnerGoal(this, 0.5, 15.0f, 2.0f, false));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.9, 1));
        this.goalSelector.add(3, new WanderAroundPointOfInterestGoal(this, 0.6, false));
        this.goalSelector.add(4, new IronGolemWanderAroundGoal(this, 0.6));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(3, new ActiveTargetGoal(this, MobEntity.class, 5, false, false, (entity) -> {
            return entity instanceof Monster && !(entity instanceof CreeperEntity);
        }));
        this.targetSelector.add(4, new UniversalAngerGoal(this, false));
    }
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        Item itemForTaming = Items.STONE;

        if ((item == Items.OAK_PLANKS  || item == Items.OAK_WOOD  || item == Items.OAK_LOG  ||
                item == Items.SPRUCE_PLANKS  || item == Items.SPRUCE_WOOD  || item == Items.SPRUCE_LOG  ||
                item == Items.BIRCH_PLANKS  || item == Items.BIRCH_WOOD  || item == Items.BIRCH_LOG  ||
                item == Items.JUNGLE_PLANKS  || item == Items.JUNGLE_WOOD  || item == Items.JUNGLE_LOG  ||
                item == Items.ACACIA_PLANKS  || item == Items.ACACIA_WOOD  || item == Items.ACACIA_LOG  ||
                item == Items.MANGROVE_PLANKS  || item == Items.MANGROVE_WOOD  || item == Items.MANGROVE_LOG  ||
                item == Items.DARK_OAK_PLANKS  || item == Items.DARK_OAK_WOOD  || item == Items.DARK_OAK_LOG) && !isTamed()) {
            if(this.world.isClient()){
                return ActionResult.CONSUME;
            }else{
                if(!player.getAbilities().creativeMode){
                    itemStack.decrement(1);
                }
                if(!this.world.isClient()){

                    super.setOwner(player);
                    this.navigation.recalculatePath();
                    this.setTarget(null);
                    this.world.sendEntityStatus(this, (byte)7);
                }
                return ActionResult.SUCCESS;
            }
        }
        if(isTamed() && !this.world.isClient() && hand == Hand.MAIN_HAND){
            return ActionResult.SUCCESS;
        }
        if(itemStack.getItem() == Items.OAK_PLANKS  ||  itemStack.getItem() == Items.OAK_WOOD  ||  itemStack.getItem() == Items.OAK_LOG  ||
                 itemStack.getItem() == Items.SPRUCE_PLANKS  ||  itemStack.getItem() == Items.SPRUCE_WOOD  ||  itemStack.getItem() == Items.SPRUCE_LOG  ||
                 itemStack.getItem() == Items.BIRCH_PLANKS  ||  itemStack.getItem() == Items.BIRCH_WOOD  ||  itemStack.getItem() == Items.BIRCH_LOG  ||
                 itemStack.getItem() == Items.JUNGLE_PLANKS  ||  itemStack.getItem() == Items.JUNGLE_WOOD  ||  itemStack.getItem() == Items.JUNGLE_LOG  ||
                 itemStack.getItem() == Items.ACACIA_PLANKS  ||  itemStack.getItem() == Items.ACACIA_WOOD  ||  itemStack.getItem() == Items.ACACIA_LOG  ||
                 itemStack.getItem() == Items.MANGROVE_PLANKS  ||  itemStack.getItem() == Items.MANGROVE_WOOD  ||  itemStack.getItem() == Items.MANGROVE_LOG  ||
                 itemStack.getItem() == Items.DARK_OAK_PLANKS  ||  itemStack.getItem() == Items.DARK_OAK_WOOD  ||  itemStack.getItem() == Items.DARK_OAK_LOG){
            return ActionResult.PASS;
        }
        return super.interactMob(player, hand);
    }

    @Override
    public int getAngerTime() {
        return this.angerTime;
    }

    @Override
    public void setAngerTime(int angerTime) {
        this.angerTime = angerTime;
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.angryAt;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_IRON_GOLEM_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 1.0F, 1.0F);
    }


    static {
        IRON_GOLEM_FLAGS = DataTracker.registerData(IronGolemEntity.class, TrackedDataHandlerRegistry.BYTE);
        ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    }

    public int getLookingAtVillagerTicks() {
        return this.lookingAtVillagerTicksLeft;
    }

    public int getAttackTicksLeft() {
        return this.attackTicksLeft;
    }

    protected void pushAway(Entity entity) {
        if (entity instanceof Monster && !(entity instanceof CreeperEntity) && this.getRandom().nextInt(20) == 0) {
            this.setTarget((LivingEntity)entity);
        }

        super.pushAway(entity);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public void tickMovement() {

        Random rnd = new Random();
        int num = rnd.nextInt(6);

        super.tickMovement();
        if (this.attackTicksLeft > 0) {
            --this.attackTicksLeft;
        }

        if (this.lookingAtVillagerTicksLeft > 0) {
            --this.lookingAtVillagerTicksLeft;
        }

        if (this.getVelocity().horizontalLengthSquared() > 2.500000277905201E-7 && this.random.nextInt(5) == 0) {
            int i = MathHelper.floor(this.getX());
            int j = MathHelper.floor(this.getY() - 0.20000000298023224);
            int k = MathHelper.floor(this.getZ());
            BlockState blockState = this.world.getBlockState(new BlockPos(i, j, k));
            int l = MathHelper.floor(this.getX());
            int m = MathHelper.floor(this.getY() - 0.20000000298023224);
            int n = MathHelper.floor(this.getZ());
            BlockState blockState2 = this.world.getBlockState(new BlockPos(l, m, n));
            if (!blockState.isAir() || !blockState2.isAir()) {
                this.world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState), this.getX() + ((double)this.random.nextFloat() - 0.5) * (double)this.getWidth(), this.getY() + 0.1, this.getZ() + ((double)this.random.nextFloat() - 0.5) * (double)this.getWidth(), 4.0 * ((double)this.random.nextFloat() - 0.5), 0.5, ((double)this.random.nextFloat() - 0.5) * 4.0);
                this.world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState2), this.getX() + ((double)this.random.nextFloat() - 0.5) * (double)this.getWidth(), this.getY() + 0.1, this.getZ() + ((double)this.random.nextFloat() - 0.5) * (double)this.getWidth(), 4.0 * ((double)this.random.nextFloat() - 0.5), 0.5, ((double)this.random.nextFloat() - 0.5) * 4.0);
            }
        }

        if (!this.world.isClient) {
            this.tickAngerLogic((ServerWorld)this.world, true);

            int i = MathHelper.floor(this.getX());
            int j = MathHelper.floor(this.getY());
            int k = MathHelper.floor(this.getZ());

            int l = MathHelper.floor(this.getX());
            int m = MathHelper.floor(this.getY());
            int n = MathHelper.floor(this.getZ());


            BlockState bs = Blocks.DIRT.getDefaultState();
            switch (num){
                case 0: bs = Blocks.SPRUCE_SAPLING.getDefaultState(); break;
                case 1: bs = Blocks.OAK_SAPLING.getDefaultState(); break;
                case 2: bs = Blocks.BIRCH_SAPLING.getDefaultState(); break;
                case 3: bs = Blocks.DARK_OAK_SAPLING.getDefaultState(); break;
                case 4: bs = Blocks.ACACIA_SAPLING.getDefaultState(); break;
                case 5: bs = Blocks.JUNGLE_SAPLING.getDefaultState(); break;
            }
            BlockState blockState = Blocks.DIRT.getDefaultState();

                i = MathHelper.floor(this.getX());
                j = MathHelper.floor(this.getY() - 1);
                k = MathHelper.floor(this.getZ());
                BlockPos blockPos2 = new BlockPos(i, j, k);



                    if (!this.world.getBlockState(blockPos2).isAir() && this.world.getBlockState(blockPos2).isFullCube(world, blockPos2)) {
                        this.world.setBlockState(blockPos2, blockState);
                        this.world.emitGameEvent(GameEvent.BLOCK_PLACE, blockPos2, GameEvent.Emitter.of(this, blockState));
                    }
            l = MathHelper.floor(this.getX());
            m = MathHelper.floor(this.getY());
            n = MathHelper.floor(this.getZ());
            BlockPos blockPos3 = new BlockPos(l, m, n);

            if (!this.world.getBlockState(blockPos2).isAir() && this.world.getBlockState(blockPos2).isFullCube(world, blockPos2)) {
                this.world.setBlockState(blockPos3, bs);
                this.world.emitGameEvent(GameEvent.BLOCK_PLACE, blockPos3, GameEvent.Emitter.of(this, bs));
            }


        }

    }
    public boolean tryAttack(Entity target) {
        this.attackTicksLeft = 10;
        this.world.sendEntityStatus(this, (byte)4);
        float f = this.getAttackDamage();
        float g = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
        boolean bl = target.damage(DamageSource.mob(this), g);
        if (bl) {
            double var10000;
            if (target instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)target;
                var10000 = livingEntity.getAttributeValue(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE);
            } else {
                var10000 = 0.0;
            }

            double d = var10000;
            double e = Math.max(0.0, 1.0 - d);
            target.setVelocity(target.getVelocity().add(0.0, 0.4000000059604645 * e, 0.0));
            this.applyDamageEffects(this, target);
        }

        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return bl;
    }

    private float getAttackDamage() {
        return (float)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
    }

    public boolean damage(DamageSource source, float amount) {
        boolean bl = super.damage(source, amount);
        if (bl) {
            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_DAMAGE, 1.0F, 1.0F);
        }

        return bl;
    }
    public void handleStatus(byte status) {
        if (status == 4) {
            this.attackTicksLeft = 10;
            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        } else if (status == 11) {
            this.lookingAtVillagerTicksLeft = 400;
        } else if (status == 34) {
            this.lookingAtVillagerTicksLeft = 0;
        } else {
            super.handleStatus(status);
        }

    }
}
