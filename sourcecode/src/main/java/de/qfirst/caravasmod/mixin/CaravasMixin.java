package de.qfirst.caravasmod.mixin;

import de.qfirst.caravasmod.items.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public abstract class CaravasMixin extends LivingEntity {

    protected CaravasMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canWalkOnFluid(FluidState state) {
        if (state.getFluid() == Fluids.LAVA && this.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.MAGMA_BOOTS) {
            return true;
        }
        return super.canWalkOnFluid(state);
    }

    @Override
    public boolean isFireImmune() {
        if (this.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.MAGMA_BOOTS) {
            return true;
        }
        return super.isFireImmune();
    }
}
