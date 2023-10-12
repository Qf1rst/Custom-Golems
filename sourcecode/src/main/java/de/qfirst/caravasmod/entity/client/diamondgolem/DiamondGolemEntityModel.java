package de.qfirst.caravasmod.entity.client.diamondgolem;

import de.qfirst.caravasmod.entity.custom.DiamondGolemEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class DiamondGolemEntityModel<T extends DiamondGolemEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;

    public DiamondGolemEntityModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
    }

    public DiamondGolemEntityModel(ModelPart root, ModelPart head, ModelPart rightArm, ModelPart leftArm, ModelPart rightLeg, ModelPart leftLeg) {
        this.root = root;
        this.head = head;
        this.rightArm = rightArm;
        this.leftArm = leftArm;
        this.rightLeg = rightLeg;
        this.leftLeg = leftLeg;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F).uv(24, 0).cuboid(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 40).cuboid(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F).uv(0, 70).cuboid(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));
        modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(60, 21).cuboid(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F), ModelTransform.pivot(0.0F, -7.0F, 0.0F));
        modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(60, 58).cuboid(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F), ModelTransform.pivot(0.0F, -7.0F, 0.0F));
        modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(37, 0).cuboid(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F), ModelTransform.pivot(-4.0F, 11.0F, 0.0F));
        modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(60, 0).mirrored().cuboid(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F), ModelTransform.pivot(5.0F, 11.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    public ModelPart getPart() {
        return this.root;
    }

    public void setAngles(T diamondGolemEnitity, float f, float g, float h, float i, float j) {
        this.head.yaw = i * 0.017453292F;
        this.head.pitch = j * 0.017453292F;
        this.rightLeg.pitch = -1.5F * MathHelper.wrap(f, 13.0F) * g;
        this.leftLeg.pitch = 1.5F * MathHelper.wrap(f, 13.0F) * g;
        this.rightLeg.yaw = 0.0F;
        this.leftLeg.yaw = 0.0F;
    }

    public void animateModel(T diamondGolemEntity, float f, float g, float h) {
        int i = diamondGolemEntity.getAttackTicksLeft();
        if (i > 0) {
            this.rightArm.pitch = -2.0F + 1.5F * MathHelper.wrap((float)i - h, 10.0F);
            this.leftArm.pitch = -2.0F + 1.5F * MathHelper.wrap((float)i - h, 10.0F);
        } else {
            int j = diamondGolemEntity.getLookingAtVillagerTicks();
            if (j > 0) {
                this.rightArm.pitch = -0.8F + 0.025F * MathHelper.wrap((float)j, 70.0F);
                this.leftArm.pitch = 0.0F;
            } else {
                this.rightArm.pitch = (-0.2F + 1.5F * MathHelper.wrap(f, 13.0F)) * g;
                this.leftArm.pitch = (-0.2F - 1.5F * MathHelper.wrap(f, 13.0F)) * g;
            }
        }

    }

    public ModelPart getRightArm() {
        return this.rightArm;
    }
}
