package de.qfirst.caravasmod.particles;


import de.qfirst.caravasmod.entity.ModEntities;
import de.qfirst.caravasmod.entity.custom.RainbowGolemEntity;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;

public class SpawnParticles {
    private static final ParticleType<?>[] PARTICLE_TYPES = {ModParticles.BLUE_FLAME_PARTICLE, ModParticles.GREEN_FLAME_PARTICLE, ParticleTypes.FLAME};
    private static final int PARTICLE_COUNT = 20;

    private static int tickCount = 0;
    private static int particleIndex = 0;
    public static void spawn(){
        ServerTickEvents.START_WORLD_TICK.register((serverWorld -> {
            if (!serverWorld.isClient) {
                for (RainbowGolemEntity rainbowGolem : serverWorld.getEntitiesByType(ModEntities.RAINBOW_GOLEM, e -> true)) {
                    Random random = rainbowGolem.getRandom();
                    double x = rainbowGolem.getX() + (random.nextDouble() - 0.5D) * rainbowGolem.getWidth();
                    double y = rainbowGolem.getY() + random.nextDouble() * rainbowGolem.getHeight();
                    double z = rainbowGolem.getZ() + (random.nextDouble() - 0.5D) * rainbowGolem.getWidth();
                    ((ServerWorld) rainbowGolem.getEntityWorld()).spawnParticles(
                            ModParticles.BLUE_FLAME_PARTICLE, x, y, z, 1, 0.0D, 0.0D, 0.0D, 0.0D
                    );
                    ((ServerWorld) rainbowGolem.getEntityWorld()).spawnParticles(
                            ModParticles.GREEN_FLAME_PARTICLE, x, y, z, 1, 0.0D, 0.0D, 0.0D, 0.0D
                    );
                    ((ServerWorld) rainbowGolem.getEntityWorld()).spawnParticles(
                            ParticleTypes.FLAME, x, y, z, 1, 0.0D, 0.0D, 0.0D, 0.0D
                    );
                }
            }
        }));
    }
}