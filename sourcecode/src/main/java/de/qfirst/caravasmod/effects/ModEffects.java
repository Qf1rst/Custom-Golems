package de.qfirst.caravasmod.effects;

import de.qfirst.caravasmod.CaravasMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {

    public static StatusEffect STOMP;
    public static StatusEffect registerStatusEffect(String name){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(CaravasMod.MOD_ID, name),
                new StompEffect(StatusEffectCategory.NEUTRAL, 30284585));
    }

    public static void registerEffects(){
        STOMP = registerStatusEffect("stomp");
    }
}
