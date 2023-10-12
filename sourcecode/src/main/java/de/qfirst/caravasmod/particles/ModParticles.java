package de.qfirst.caravasmod.particles;

import de.qfirst.caravasmod.CaravasMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    public static final DefaultParticleType GREEN_FLAME_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BLUE_FLAME_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles(){
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(CaravasMod.MOD_ID, "green_flame_particle"), GREEN_FLAME_PARTICLE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(CaravasMod.MOD_ID, "blue_flame_particle"), BLUE_FLAME_PARTICLE);
    }
}
