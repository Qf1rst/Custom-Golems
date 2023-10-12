package de.qfirst.caravasmod.entity.client.endgolem;

import de.qfirst.caravasmod.CaravasMod;
import de.qfirst.caravasmod.entity.custom.EndGolemEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;


@Environment(EnvType.CLIENT)
public class EndGolemEntityRenderer extends MobEntityRenderer<EndGolemEntity, EndGolemEntityModel<EndGolemEntity>> {
    private static final Identifier TEXTURE = new Identifier(CaravasMod.MOD_ID, "textures/entity/end_golem.png");

    public EndGolemEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new EndGolemEntityModel(context.getPart(EntityModelLayers.IRON_GOLEM)), 0.7F);
    }

    public Identifier getTexture(EndGolemEntity endGolemEntity) {
        return TEXTURE;
    }

    protected void setupTransforms(EndGolemEntity endGolemEntity, MatrixStack matrixStack, float f, float g, float h) {
        super.setupTransforms(endGolemEntity, matrixStack, f, g, h);
        if (!((double)endGolemEntity.limbDistance < 0.01)) {
            float i = 13.0F;
            float j = endGolemEntity.limbAngle - endGolemEntity.limbDistance * (1.0F - h) + 6.0F;
            float k = (Math.abs(j % 13.0F - 6.5F) - 3.25F) / 3.25F;
            matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(6.5F * k));
        }
        matrixStack.scale(2.0F, 2.0F, 2.0F);
    }
}
