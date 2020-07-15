// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelpenguin extends EntityModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer right_foot;
	private final ModelRenderer left_foot;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer left_wing;
	private final ModelRenderer right_wing;

	public Modelpenguin() {
		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(main, 0.0F, 3.1416F, 0.0F);

		right_foot = new ModelRenderer(this);
		right_foot.setRotationPoint(3.0F, -2.5F, 3.5F);
		main.addChild(right_foot);
		setRotationAngle(right_foot, 0.0F, 1.5708F, 0.0F);
		right_foot.setTextureOffset(30, 22).addBox(-2.0F, 1.5F, -2.5F, 9.0F, 1.0F, 5.0F, 0.0F, false);
		right_foot.setTextureOffset(0, 4).addBox(-3.0F, 1.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		left_foot = new ModelRenderer(this);
		left_foot.setRotationPoint(-3.0F, -2.5F, 3.5F);
		main.addChild(left_foot);
		setRotationAngle(left_foot, 0.0F, 1.5708F, 0.0F);
		left_foot.setTextureOffset(28, 0).addBox(-2.0F, 1.5F, -2.5F, 9.0F, 1.0F, 5.0F, 0.0F, false);
		left_foot.setTextureOffset(0, 0).addBox(-3.0F, 1.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(body);
		body.setTextureOffset(0, 22).addBox(-6.0F, -17.0F, -3.0F, 12.0F, 16.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-5.0F, -16.0F, -4.0F, 10.0F, 14.0F, 8.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -16.75F, -0.75F);
		main.addChild(head);
		head.setTextureOffset(28, 36).addBox(-4.0F, -8.25F, -2.25F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 22).addBox(-1.0F, -2.25F, 5.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(-6.5F, -16.0F, -0.3333F);
		main.addChild(left_wing);
		left_wing.setTextureOffset(0, 44).addBox(-0.5F, 0.0F, -2.6667F, 1.0F, 12.0F, 3.0F, 0.0F, false);
		left_wing.setTextureOffset(14, 44).addBox(-0.5F, 0.0F, 0.3333F, 1.0F, 10.0F, 2.0F, 0.0F, false);
		left_wing.setTextureOffset(24, 44).addBox(-0.5F, 0.0F, 2.3333F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(6.5F, -16.0F, -0.3333F);
		main.addChild(right_wing);
		right_wing.setTextureOffset(36, 6).addBox(-0.5F, 0.0F, -2.6667F, 1.0F, 12.0F, 3.0F, 0.0F, false);
		right_wing.setTextureOffset(8, 44).addBox(-0.5F, 0.0F, 0.3333F, 1.0F, 10.0F, 2.0F, 0.0F, false);
		right_wing.setTextureOffset(20, 44).addBox(-0.5F, 0.0F, 2.3333F, 1.0F, 8.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}