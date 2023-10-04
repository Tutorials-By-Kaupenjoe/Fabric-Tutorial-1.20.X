package net.kaupenjoe.tutorialmod.entity.client;

import net.kaupenjoe.tutorialmod.entity.animation.ModAnimations;
import net.kaupenjoe.tutorialmod.entity.custom.PorcupineEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PorcupineModel<T extends PorcupineEntity> extends SinglePartEntityModel<T> {
	private final ModelPart porcupine;
	private final ModelPart head;

	public PorcupineModel(ModelPart root) {
		this.porcupine = root.getChild("porcupine");
		this.head = porcupine.getChild("body").getChild("torso").getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData porcupine = modelPartData.addChild("porcupine", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = porcupine.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -4.0F, 6.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData tail = torso.addChild("tail", ModelPartBuilder.create(), ModelTransform.of(0.5F, -1.251F, 4.0F, -0.4363F, 0.0F, 0.0F));

		ModelPartData cube_r1 = tail.addChild("cube_r1", ModelPartBuilder.create().uv(11, 25).cuboid(-6.0F, -0.499F, -1.0F, 7.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, 0.0F, 0.0F, 0.9599F, 0.0F));

		ModelPartData cube_r2 = tail.addChild("cube_r2", ModelPartBuilder.create().uv(11, 25).cuboid(-6.0F, 0.001F, -1.0F, 7.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, 0.0F, 0.0F, 0.6109F, 0.0F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -4.0F));

		ModelPartData skull = head.addChild("skull", ModelPartBuilder.create().uv(0, 13).cuboid(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 14).cuboid(1.1F, -0.75F, -3.25F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 13).cuboid(1.425F, -0.975F, -3.025F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3F))
		.uv(0, 14).mirrored().cuboid(-2.1F, -0.75F, -3.25F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(12, 13).mirrored().cuboid(-2.425F, -0.975F, -3.025F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3F)).mirrored(false)
		.uv(16, 18).cuboid(-1.0F, -0.25F, -5.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData hair = skull.addChild("hair", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -4.0F, 0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r3 = hair.addChild("cube_r3", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		ModelPartData cube_r4 = hair.addChild("cube_r4", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		ModelPartData left_eyelid = skull.addChild("left_eyelid", ModelPartBuilder.create().uv(24, 0).cuboid(0.1F, -1.75F, -7.25F, 2.0F, 2.0F, 2.0F, new Dilation(-0.4F)), ModelTransform.pivot(-0.4F, 0.5F, 3.5F));

		ModelPartData right_eyelid = skull.addChild("right_eyelid", ModelPartBuilder.create().uv(24, 0).mirrored().cuboid(-2.1F, -1.75F, -7.25F, 2.0F, 2.0F, 2.0F, new Dilation(-0.4F)).mirrored(false), ModelTransform.pivot(0.4F, 0.5F, 3.5F));

		ModelPartData spikes = torso.addChild("spikes", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, -3.5F));

		ModelPartData spike = spikes.addChild("spike", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.0436F));

		ModelPartData spike2 = spikes.addChild("spike2", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		ModelPartData spike5 = spikes.addChild("spike5", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		ModelPartData spike3 = spikes.addChild("spike3", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		ModelPartData spike4 = spikes.addChild("spike4", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.4363F));

		ModelPartData spikes2 = torso.addChild("spikes2", ModelPartBuilder.create(), ModelTransform.of(0.5F, -3.0F, -2.5F, 0.3054F, 0.0F, 0.0F));

		ModelPartData spike6 = spikes2.addChild("spike6", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

		ModelPartData spike7 = spikes2.addChild("spike7", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.2618F));

		ModelPartData spike8 = spikes2.addChild("spike8", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.4363F));

		ModelPartData spike9 = spikes2.addChild("spike9", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, -1.5F, 0.0F, 0.0F, -0.3054F));

		ModelPartData spike10 = spikes2.addChild("spike10", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.6545F));

		ModelPartData spikes3 = torso.addChild("spikes3", ModelPartBuilder.create(), ModelTransform.of(0.5F, -3.0F, -2.5F, -0.1745F, 0.0F, 0.0F));

		ModelPartData spike11 = spikes3.addChild("spike11", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.1309F));

		ModelPartData spike12 = spikes3.addChild("spike12", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		ModelPartData spike13 = spikes3.addChild("spike13", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.2618F));

		ModelPartData spike14 = spikes3.addChild("spike14", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		ModelPartData spike15 = spikes3.addChild("spike15", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1745F));

		ModelPartData spikes4 = torso.addChild("spikes4", ModelPartBuilder.create(), ModelTransform.of(0.0F, -3.0F, -2.0F, -0.5672F, 0.0F, 0.0F));

		ModelPartData spike16 = spikes4.addChild("spike16", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.5F));

		ModelPartData spike17 = spikes4.addChild("spike17", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData spike18 = spikes4.addChild("spike18", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.2182F));

		ModelPartData spike19 = spikes4.addChild("spike19", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		ModelPartData spike20 = spikes4.addChild("spike20", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1309F));

		ModelPartData spikes5 = torso.addChild("spikes5", ModelPartBuilder.create(), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData spike21 = spikes5.addChild("spike21", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.5F));

		ModelPartData spike22 = spikes5.addChild("spike22", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		ModelPartData spike23 = spikes5.addChild("spike23", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.7854F));

		ModelPartData spike24 = spikes5.addChild("spike24", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		ModelPartData spike25 = spikes5.addChild("spike25", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5672F));

		ModelPartData spikes6 = torso.addChild("spikes6", ModelPartBuilder.create(), ModelTransform.of(0.5F, -3.0F, -0.5F, -0.6545F, 0.0F, 0.0F));

		ModelPartData spike26 = spikes6.addChild("spike26", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.5F));

		ModelPartData spike27 = spikes6.addChild("spike27", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		ModelPartData spike28 = spikes6.addChild("spike28", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.48F));

		ModelPartData spike29 = spikes6.addChild("spike29", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		ModelPartData spike30 = spikes6.addChild("spike30", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.48F));

		ModelPartData spikes7 = torso.addChild("spikes7", ModelPartBuilder.create(), ModelTransform.of(0.5F, -3.0F, 1.5F, -0.9599F, 0.0F, 0.0F));

		ModelPartData spike31 = spikes7.addChild("spike31", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.5F));

		ModelPartData spike32 = spikes7.addChild("spike32", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		ModelPartData spike33 = spikes7.addChild("spike33", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

		ModelPartData spike34 = spikes7.addChild("spike34", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		ModelPartData spike35 = spikes7.addChild("spike35", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3054F));

		ModelPartData spikes8 = torso.addChild("spikes8", ModelPartBuilder.create(), ModelTransform.of(0.0F, -3.0F, 3.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData spike36 = spikes8.addChild("spike36", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1309F));

		ModelPartData spike37 = spikes8.addChild("spike37", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData spike38 = spikes8.addChild("spike38", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3927F));

		ModelPartData spike39 = spikes8.addChild("spike39", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

		ModelPartData spike40 = spikes8.addChild("spike40", ModelPartBuilder.create().uv(20, 0).cuboid(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3054F));

		ModelPartData left_front_leg = body.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 0.0F, -2.5F));

		ModelPartData right_front_leg = body.addChild("right_front_leg", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-3.0F, 0.0F, -2.5F));

		ModelPartData right_back_leg = body.addChild("right_back_leg", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-3.0F, 0.0F, 2.5F));

		ModelPartData left_back_leg = body.addChild("left_back_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 0.0F, 2.5F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(PorcupineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.PORCUPINE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.PORCUPINE_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.PORCUPINE_ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		porcupine.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return porcupine;
	}
}