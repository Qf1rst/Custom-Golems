package de.qfirst.caravasmod.effects;

import de.qfirst.caravasmod.items.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

public class createStomp {
    public static void onPlayerTick(PlayerEntity player) {
        if (player.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.DEEPSLATE_LEGGINGS) {
            player.addStatusEffect(new StatusEffectInstance(ModEffects.STOMP, 2, 0, true, false, true));
        }
    }
}