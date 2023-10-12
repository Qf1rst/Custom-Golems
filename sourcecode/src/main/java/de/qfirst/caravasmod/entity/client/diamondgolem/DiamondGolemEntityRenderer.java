package de.qfirst.caravasmod.entity.client.diamondgolem;

import de.qfirst.caravasmod.CaravasMod;
import de.qfirst.caravasmod.entity.custom.DiamondGolemEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;


@Environment(EnvType.CLIENT)
public class DiamondGolemEntityRenderer extends MobEntityRenderer<DiamondGolemEntity, DiamondGolemEntityModel<DiamondGolemEntity>> {
    private static final Identifier TEXTURE = new Identifier(CaravasMod.MOD_ID, "textures/entity/diamond_golem.png");

    public DiamondGolemEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new DiamondGolemEntityModel(context.getPart(EntityModelLayers.IRON_GOLEM)), 0.7F);
    }

    public Identifier getTexture(DiamondGolemEntity diamondGolemEntity) {
        return TEXTURE;
    }

    protected void setupTransforms(DiamondGolemEntity diamondGolemEntity, MatrixStack matrixStack, float f, float g, float h) {
        super.setupTransforms(diamondGolemEntity, matrixStack, f, g, h);
        if (!((double)diamondGolemEntity.limbDistance < 0.01)) {
            float i = 13.0F;
            float j = diamondGolemEntity.limbAngle - diamondGolemEntity.limbDistance * (1.0F - h) + 6.0F;
            float k = (Math.abs(j % 13.0F - 6.5F) - 3.25F) / 3.25F;
            matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(6.5F * k));
        }
    }

}
