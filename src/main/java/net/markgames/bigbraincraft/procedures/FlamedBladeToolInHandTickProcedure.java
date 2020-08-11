package net.markgames.bigbraincraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.markgames.bigbraincraft.BigbraincraftModElements;

import java.util.Random;
import java.util.Map;

@BigbraincraftModElements.ModElement.Tag
public class FlamedBladeToolInHandTickProcedure extends BigbraincraftModElements.ModElement {
	public FlamedBladeToolInHandTickProcedure(BigbraincraftModElements instance) {
		super(instance, 111);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FlamedBladeToolInHandTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure FlamedBladeToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 2, (int) 3));
		if ((Math.random() < 0.03)) {
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
	}
}
