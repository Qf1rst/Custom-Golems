package de.qfirst.caravasmod.items;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        //if (!world.isClient && entity instanceof PlayerEntity && slot == EquipmentSlot.LEGS.getEntitySlotId()) {
        //    PlayerEntity player = (PlayerEntity) entity;
        //    // Überprüfe, ob der Spieler eine Deepslate-Hose anhat
        //    if (stack == player.getEquippedStack(EquipmentSlot.LEGS)) {
        //        // Füge den Regeneration-Effekt hinzu
        //        StatusEffectInstance effect = new StatusEffectInstance(ModEffects.STOMP, 2, 0);
        //        player.addStatusEffect(effect);
        //    }
        //}

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
