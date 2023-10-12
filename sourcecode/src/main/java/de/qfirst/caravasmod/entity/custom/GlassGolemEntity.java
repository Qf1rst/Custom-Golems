package de.qfirst.caravasmod.entity.custom;

import net.minecraft.block.Block;
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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;


public class GlassGolemEntity extends TameableEntity implements Angerable {



    private static final UniformIntProvider ANGER_TIME_RANGE;
    protected static final TrackedData<Byte> IRON_GOLEM_FLAGS;
    private int angerTime;
    private UUID angryAt;
    private int lookingAtVillagerTicksLeft;
    private int attackTicksLeft;

    public GlassGolemEntity(EntityType<? extends TameableEntity> entityType, World world) {
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

        if ((item == Items.WHITE_STAINED_GLASS || item == Items.BLACK_STAINED_GLASS ||
                item == Items.BLUE_STAINED_GLASS || item == Items.BROWN_STAINED_GLASS ||
                item == Items.CYAN_STAINED_GLASS || item == Items.GRAY_STAINED_GLASS ||
                item == Items.GREEN_STAINED_GLASS || item == Items.LIGHT_BLUE_STAINED_GLASS ||
                item == Items.LIGHT_GRAY_STAINED_GLASS || item == Items.LIME_STAINED_GLASS ||
                item == Items.MAGENTA_STAINED_GLASS || item == Items.ORANGE_STAINED_GLASS ||
                item == Items.YELLOW_STAINED_GLASS || item == Items.PINK_STAINED_GLASS ||
                item == Items.PURPLE_STAINED_GLASS || item == Items.RED_STAINED_GLASS ||
                item == Items.GLASS || item == Items.TINTED_GLASS) && !isTamed()) {
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
        if((itemStack.getItem() == Items.WHITE_STAINED_GLASS || itemStack.getItem() == Items.BLACK_STAINED_GLASS ||
                itemStack.getItem() == Items.BLUE_STAINED_GLASS || itemStack.getItem() == Items.BROWN_STAINED_GLASS ||
                itemStack.getItem() == Items.CYAN_STAINED_GLASS || itemStack.getItem() == Items.GRAY_STAINED_GLASS ||
                itemStack.getItem() == Items.GREEN_STAINED_GLASS || itemStack.getItem() == Items.LIGHT_BLUE_STAINED_GLASS ||
                itemStack.getItem() == Items.LIGHT_GRAY_STAINED_GLASS || itemStack.getItem() == Items.LIME_STAINED_GLASS ||
                itemStack.getItem() == Items.MAGENTA_STAINED_GLASS || itemStack.getItem() == Items.ORANGE_STAINED_GLASS ||
                itemStack.getItem() == Items.YELLOW_STAINED_GLASS || itemStack.getItem() == Items.PINK_STAINED_GLASS ||
                itemStack.getItem() == Items.PURPLE_STAINED_GLASS || itemStack.getItem() == Items.RED_STAINED_GLASS ||
                itemStack.getItem() == Items.GLASS || itemStack.getItem() == Items.TINTED_GLASS)){
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

        super.tickMovement();
        if (this.attackTicksLeft > 0) {
            --this.attackTicksLeft;
        }

        if (this.lookingAtVillagerTicksLeft > 0) {
            --this.lookingAtVillagerTicksLeft;
        }

        if (!this.world.isClient) {
            this.tickAngerLogic((ServerWorld)this.world, true);
        }
        for (int x = (int) getX() - 20; x <= (int) getX() + 20; x++) {
            for (int y = (int) getY() - 20; y <= (int) getY() + 20; y++) {
                for (int z = (int) getZ() - 20; z <= (int) getZ() + 20; z++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockState blockState = world.getBlockState(pos);
                    Block block = blockState.getBlock();
                    if (block.equals(Blocks.STONE) || block.equals(Blocks.DEEPSLATE)) {
                        world.setBlockState(pos, Blocks.GLASS.getDefaultState());
                    }
                }
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

