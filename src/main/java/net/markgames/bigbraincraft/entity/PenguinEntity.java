
package net.markgames.bigbraincraft.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;

import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.item.WaterprooffeatherItem;
import net.markgames.bigbraincraft.BigbraincraftModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@BigbraincraftModElements.ModElement.Tag
public class PenguinEntity extends BigbraincraftModElements.ModElement {
	public static EntityType entity = null;
	public PenguinEntity(BigbraincraftModElements instance) {
		super(instance, 300);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("penguin")
						.setRegistryName("penguin");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -16750900, -1, new Item.Properties().group(BigBrainTabItemGroup.tab)).setRegistryName("penguin"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("frozen_ocean")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_tundra")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("frozen_river")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_tundra")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_mountains")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 16, 4, 7));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelpenguin(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("bigbraincraft:textures/penguin.png");
				}
			};
		});
	}
	public static class CustomEntity extends AnimalEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 3;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new FollowMobGoal(this, (float) 1, 17, 5));
			this.goalSelector.addGoal(3, new TemptGoal(this, 1, Ingredient.fromItems(new ItemStack(Items.COD, (int) (1)).getItem()), false));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new LookAtGoal(this, AgeableEntity.class, (float) 6));
			this.goalSelector.addGoal(6, new SwimGoal(this));
			this.goalSelector.addGoal(7, new RandomSwimmingGoal(this, 1, 40));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(WaterprooffeatherItem.block, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.parrot.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.vex.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.parrot.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public AgeableEntity createChild(AgeableEntity ageable) {
			return (CustomEntity) entity.create(this.world);
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(Items.COD, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}
	}

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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_foot.rotateAngleX = f2 / 20.f;
			this.right_wing.rotateAngleX = f2 / 20.f;
			this.left_wing.rotateAngleX = f2 / 20.f;
			this.left_foot.rotateAngleX = f2 / 20.f;
		}
	}
}
