package de.qfirst.caravasmod.entity.client.pumpkingolem;

import de.qfirst.caravasmod.CaravasMod;
import de.qfirst.caravasmod.entity.custom.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;


@Environment(EnvType.CLIENT)
public class PumpkinGolemEntityRenderer extends MobEntityRenderer<PumpkinGolemEntity, PumpkinGolemEntityModel<PumpkinGolemEntity>> {
    private static final Identifier TEXTURE = new Identifier(CaravasMod.MOD_ID, "textures/entity/pumpkin_golem.png");

    public PumpkinGolemEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PumpkinGolemEntityModel(context.getPart(EntityModelLayers.IRON_GOLEM)), 0.7F);
    }

    public Identifier getTexture(PumpkinGolemEntity pumpkinGolemEntity) {
        return TEXTURE;
    }

    protected void setupTransforms(PumpkinGolemEntity pumpkinGolemEntity, MatrixStack matrixStack, float f, float g, float h) {
        super.setupTransforms(pumpkinGolemEntity, matrixStack, f, g, h);
        if (!((double)pumpkinGolemEntity.limbDistance < 0.01)) {
            float i = 13.0F;
            float j = pumpkinGolemEntity.limbAngle - pumpkinGolemEntity.limbDistance * (1.0F - h) + 6.0F;
            float k = (Math.abs(j % 13.0F - 6.5F) - 3.25F) / 3.25F;
            matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(6.5F * k));
        }
    }

}
