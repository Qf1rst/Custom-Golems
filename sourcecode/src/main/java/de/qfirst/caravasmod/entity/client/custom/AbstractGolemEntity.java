package de.qfirst.caravasmod.entity.client.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.world.World;

public class AbstractGolemEntity extends GolemEntity {

    private static final TrackedData<Integer> CUSTOM_BLOCK_ID;
    private static final TrackedData<Integer> CUSTOM_BLOCK_OFFSET;
    private static final TrackedData<Boolean> CUSTOM_BLOCK_PRESENT;

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(CUSTOM_BLOCK_ID, Block.getRawIdFromState(Blocks.AIR.getDefaultState()));
        this.dataTracker.startTracking(CUSTOM_BLOCK_OFFSET, 6);
        this.dataTracker.startTracking(CUSTOM_BLOCK_PRESENT, false);
    }

    protected AbstractGolemEntity(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
        this.intersectionChecked = true;
    }

    public static AbstractGolemEntity create(World world, double x, double y, double z, Type type) {
        if(type == Type.CHEST){
            return null;
        }
        else {
            return null;
        }
    }

    protected MoveEffect getMoveEffect() {
        return MoveEffect.EVENTS;
    }
    public boolean isPushable() {
        return false;
    }


    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.getBoolean("CustomDisplayTile")) {
            this.setCustomBlock(NbtHelper.toBlockState(nbt.getCompound("DisplayState")));
            this.setCustomBlockOffset(nbt.getInt("DisplayOffset"));
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        if (this.hasCustomBlock()) {
            nbt.putBoolean("CustomDisplayTile", true);
            nbt.put("DisplayState", NbtHelper.fromBlockState(this.getContainedBlock()));
            nbt.putInt("DisplayOffset", this.getBlockOffset());
        }
    }

    public void setCustomBlock(BlockState state) {
        this.getDataTracker().set(CUSTOM_BLOCK_ID, Block.getRawIdFromState(state));
        this.setCustomBlockPresent(true);
    }

    public void setCustomBlockOffset(int offset) {
        this.getDataTracker().set(CUSTOM_BLOCK_OFFSET, offset);
        this.setCustomBlockPresent(true);
    }

    public void setCustomBlockPresent(boolean present) {
        this.getDataTracker().set(CUSTOM_BLOCK_PRESENT, present);
    }
    public boolean hasCustomBlock() {
        return (Boolean)this.getDataTracker().get(CUSTOM_BLOCK_PRESENT);
    }
    public BlockState getContainedBlock() {
        return !this.hasCustomBlock() ? this.getDefaultContainedBlock() : Block.getStateFromRawId((Integer)this.getDataTracker().get(CUSTOM_BLOCK_ID));
    }
    public BlockState getDefaultContainedBlock() {
        return Blocks.AIR.getDefaultState();
    }
    public int getBlockOffset() {
        return !this.hasCustomBlock() ? this.getDefaultBlockOffset() : (Integer)this.getDataTracker().get(CUSTOM_BLOCK_OFFSET);
    }

    public int getDefaultBlockOffset() {
        return 6;
    }

    public Type getGolemType() {
        return null;
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    static {
        CUSTOM_BLOCK_ID = DataTracker.registerData(AbstractGolemEntity.class, TrackedDataHandlerRegistry.INTEGER);
        CUSTOM_BLOCK_OFFSET = DataTracker.registerData(AbstractGolemEntity.class, TrackedDataHandlerRegistry.INTEGER);
        CUSTOM_BLOCK_PRESENT = DataTracker.registerData(AbstractGolemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    public static enum Type {
        CHEST,
        FURNACE;
    }
}
