package de.qfirst.caravasmod.entity.client.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.function.BiConsumer;

public interface EntityInventory extends Inventory, NamedScreenHandlerFactory {
    Vec3d getPos();

    @Nullable
    Identifier getLootTableId();

    void setLootTableId(@Nullable Identifier lootTableId);

    long getLootTableSeed();

    void setLootTableSeed(long lootTableSeed);

    DefaultedList<ItemStack> getInventory();

    void resetInventory();

    World getWorld();

    boolean isRemoved();

    default boolean isEmpty() {
        return this.isInventoryEmpty();
    }

    default void writeInventoryToNbt(NbtCompound nbt) {
        if (this.getLootTableId() != null) {
            nbt.putString("LootTable", this.getLootTableId().toString());
            if (this.getLootTableSeed() != 0L) {
                nbt.putLong("LootTableSeed", this.getLootTableSeed());
            }
        } else {
            Inventories.writeNbt(nbt, this.getInventory());
        }

    }

    default void readInventoryFromNbt(NbtCompound nbt) {
        this.resetInventory();
        if (nbt.contains("LootTable", 8)) {
            this.setLootTableId(new Identifier(nbt.getString("LootTable")));
            this.setLootTableSeed(nbt.getLong("LootTableSeed"));
        } else {
            Inventories.readNbt(nbt, this.getInventory());
        }

    }

    default void onBroken(DamageSource source, World world, Entity entity) {
        if (world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
            ItemScatterer.spawn(world, entity, this);
            if (!world.isClient) {
                Entity player = source.getSource();
                if (player != null && player.getType() == EntityType.PLAYER) {
                    PiglinBrain.onGuardedBlockInteracted((PlayerEntity)player, true);
                }
            }

        }
    }

    default ActionResult open(BiConsumer<GameEvent, Entity> gameEventEmitter, PlayerEntity player) {
        player.openHandledScreen(this);
        if (!player.world.isClient) {
            gameEventEmitter.accept(GameEvent.CONTAINER_OPEN, player);
            PiglinBrain.onGuardedBlockInteracted(player, true);
            return ActionResult.CONSUME;
        } else {
            return ActionResult.SUCCESS;
        }
    }

    default void clearInventory() {
        this.getInventory().clear();
    }

    default boolean isInventoryEmpty() {
        Iterator var1 = this.getInventory().iterator();

        ItemStack itemStack;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            itemStack = (ItemStack)var1.next();
        } while(itemStack.isEmpty());

        return false;
    }

    default ItemStack removeInventoryStack(int slot) {
        ItemStack itemStack = (ItemStack)this.getInventory().get(slot);
        if (itemStack.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            this.getInventory().set(slot, ItemStack.EMPTY);
            return itemStack;
        }
    }

    default ItemStack getInventoryStack(int slot) {
        return (ItemStack)this.getInventory().get(slot);
    }

    default ItemStack removeInventoryStack(int slot, int amount) {
        return Inventories.splitStack(this.getInventory(), slot, amount);
    }

    default void setInventoryStack(int slot, ItemStack stack) {
        this.getInventory().set(slot, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxCountPerStack()) {
            stack.setCount(this.getMaxCountPerStack());
        }

    }

    default StackReference getInventoryStackReference(final int slot) {
        return slot >= 0 && slot < this.size() ? new StackReference() {
            public ItemStack get() {
                return EntityInventory.this.getInventoryStack(slot);
            }

            public boolean set(ItemStack stack) {
                EntityInventory.this.setInventoryStack(slot, stack);
                return true;
            }
        } : StackReference.EMPTY;
    }

    default boolean canPlayerAccess(PlayerEntity player) {
        return !this.isRemoved() && this.getPos().isInRange(player.getPos(), 8.0);
    }

}
