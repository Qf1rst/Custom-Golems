package de.qfirst.caravasmod.effects;

import de.qfirst.caravasmod.items.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class SnowHelmetEffect {
    public static void onPlayerTick(PlayerEntity player){
        if (player.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.SNOW_HELMET) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2, 0, true, false, true));
        }
    }
}
