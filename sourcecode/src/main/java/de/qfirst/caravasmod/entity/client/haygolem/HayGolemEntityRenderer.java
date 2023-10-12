package de.qfirst.caravasmod.entity.client.haygolem;

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
public class HayGolemEntityRenderer extends MobEntityRenderer<HayGolemEntity, HayGolemEntityModel<HayGolemEntity>> {
    private static final Identifier TEXTURE = new Identifier(CaravasMod.MOD_ID, "textures/entity/hay_golem.png");

    public HayGolemEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new HayGolemEntityModel(context.getPart(EntityModelLayers.IRON_GOLEM)), 0.7F);
    }

    public Identifier getTexture(HayGolemEntity hayGolemEntity) {
        return TEXTURE;
    }

    protected void setupTransforms(HayGolemEntity hayGolemEntity, MatrixStack matrixStack, float f, float g, float h) {
        super.setupTransforms(hayGolemEntity, matrixStack, f, g, h);
        if (!((double)hayGolemEntity.limbDistance < 0.01)) {
            float i = 13.0F;
            float j = hayGolemEntity.limbAngle - hayGolemEntity.limbDistance * (1.0F - h) + 6.0F;
            float k = (Math.abs(j % 13.0F - 6.5F) - 3.25F) / 3.25F;
            matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(6.5F * k));
        }
    }

}
