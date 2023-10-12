package de.qfirst.caravasmod.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class StompEffect extends StatusEffect {

    public static boolean key = false;
    public StompEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        PlayerEntity player = (PlayerEntity) entity;

        if (key) {
            World world = entity.getEntityWorld();
            BlockPos pos = entity.getBlockPos();

            // Erhalte alle lebenden Entitäten, die keine Spieler sind, in einem Bereich von 10 Blöcken um den Mob herum.
            List<Entity> entities = world.getEntitiesByClass(
                    Entity.class,
                    new Box(
                            pos.getX() - 10, pos.getY() - 10, pos.getZ() - 10,
                            pos.getX() + 10, pos.getY() + 10, pos.getZ() + 10
                    ),
                    // Nur lebende Entitäten, die keine Spieler sind, sollen enthalten sein.
                    (e) -> e instanceof LivingEntity && !(e instanceof PlayerEntity)
            );

            for (Entity e : entities) {
                e.damage(DamageSource.MAGIC, 10.0F);
            }

            // Erstelle ein ParticleEffect, das die sich ausbreitende Animation darstellt.
            ParticleEffect effect = ParticleTypes.FLAME;
            createFlameSphere(player);

            // Füge die Partikel in einem Bereich von 10 Blöcken um den Mob herum hinzu.
            //for (int x = pos.getX() - 10; x <= pos.getX() + 10; x++) {
            //    for (int y = pos.getY(); y <= pos.getY(); y++) {
            //        for (int z = pos.getZ() - 10; z <= pos.getZ() + 10; z++) {
            //            BlockPos particlePos = new BlockPos(x, y, z);
            //            world.addParticle(effect, particlePos.getX(), player.getY() + 0.2, particlePos.getZ(), 0, 0, 0);
            //        }
            //    }
            //}
        }
        super.applyUpdateEffect(entity, amplifier);
    }
    private static final double MAX_RADIUS = 10;
    private static final double SPEED = 0.1;

    public static void createFlameSphere(PlayerEntity player) {
        World world = player.getEntityWorld();
        double centerX = player.getX();
        double centerY = player.getEyeY();
        double centerZ = player.getZ();

        for (double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 8) {
            for (double phi = 0; phi <= Math.PI; phi += Math.PI / 8) {
                double x = centerX + MAX_RADIUS * Math.sin(phi) * Math.cos(theta);
                double y = centerY + MAX_RADIUS * Math.cos(phi);
                double z = centerZ + MAX_RADIUS * Math.sin(phi) * Math.sin(theta);

                double dx = (x - centerX) * SPEED;
                double dy = (y - centerY) * SPEED;
                double dz = (z - centerZ) * SPEED;

                world.addParticle(ParticleTypes.FLAME, centerX, centerY, centerZ, dx, dy, dz);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}


