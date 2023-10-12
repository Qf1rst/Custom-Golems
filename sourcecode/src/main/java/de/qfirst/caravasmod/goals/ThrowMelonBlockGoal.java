package de.qfirst.caravasmod.goals;

import de.qfirst.caravasmod.entity.custom.MelonGolemEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class ThrowMelonBlockGoal extends Goal {
    private final MelonGolemEntity melonGolemEntity;
    private int counter;

    public ThrowMelonBlockGoal(MelonGolemEntity melonGolemEntity) {
        this.melonGolemEntity = melonGolemEntity;
    }

    @Override
    public boolean canStart() {
        LivingEntity target = this.melonGolemEntity.getTarget();
        return target != null && target.isAlive() && this.melonGolemEntity.canSee(target);
    }

    @Override
    public void start() {
        this.counter = 0;
    }

    @Override
    public void tick() {
        LivingEntity target = this.melonGolemEntity.getTarget();
        if (target != null) {
            double distance = this.melonGolemEntity.squaredDistanceTo(target);
            if (distance < 4.0D) {
                if (this.counter > 20) {
                    this.melonGolemEntity.swingHand(this.melonGolemEntity.getActiveHand());
                    float damage = 0.5F; // half a heart of damage
                    target.damage(DamageSource.thrownProjectile(this.melonGolemEntity, this.melonGolemEntity), damage);
                    this.counter = -10;
                }
            } else if (distance < 256.0D) {
                double x = target.getX() - this.melonGolemEntity.getX();
                double y = target.getBodyY(0.5D) - this.melonGolemEntity.getEyeY();
                double z = target.getZ() - this.melonGolemEntity.getZ();
                if (this.counter % 10 == 0) { // shoot every 10 ticks (0.5 seconds)
                    SnowballEntity snowball = new SnowballEntity(this.melonGolemEntity.world, this.melonGolemEntity) {
                        @Override
                        protected void onCollision(HitResult hitResult) {
                            super.onCollision(hitResult);
                            if (!this.world.isClient) {
                                BlockPos pos;
                                if (hitResult.getType() == HitResult.Type.BLOCK) {
                                    pos = ((BlockHitResult) hitResult).getBlockPos().up();
                                } else if (hitResult.getType() == HitResult.Type.ENTITY) {
                                    Entity entity = ((EntityHitResult) hitResult).getEntity();
                                    pos = entity.getBlockPos();
                                } else {
                                    return;
                                }
                                world.setBlockState(pos, Blocks.MELON.getDefaultState());
                            }
                        }
                    };
                    snowball.setItem(new ItemStack(Items.MELON)); // set the texture to melon block
                    double d = MathHelper.sqrt((float) (x * x + z * z)) * 0.2F;
                    snowball.setVelocity(x, y + d - 1.0D /* lower the y velocity by 1 block */, z, 1.6F, 12.0F);
                    this.melonGolemEntity.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F,
                            1.0F / (this.melonGolemEntity.getRandom().nextFloat() * 0.4F + 0.8F));
                    this.melonGolemEntity.world.spawnEntity(snowball);
                }
            }
            super.tick();
            ++this.counter;

            // make the snowman look at the target
            this.melonGolemEntity.getLookControl().lookAt(target, 10.0F, 10.0F);
        }
    }
}