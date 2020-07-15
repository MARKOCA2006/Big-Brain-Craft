package net.markgames.bigbraincraft.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.markgames.bigbraincraft.item.HazmatkitItem;
import net.markgames.bigbraincraft.BigbraincraftModElements;

import java.util.Random;

@BigbraincraftModElements.ModElement.Tag
public class RadiationProcedure extends BigbraincraftModElements.ModElement {
	public RadiationProcedure(BigbraincraftModElements instance) {
		super(instance, 221);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Radiation!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(HazmatkitItem.block, (int) (1)))
				: false)) {
			if ((Math.random() < 0.05)) {
				{
					ItemStack _ist = new ItemStack(HazmatkitItem.block, (int) (1));
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).clearActivePotions();
			if ((Math.random() < 0.05)) {
				entity.attackEntityFrom(DamageSource.MAGIC, (float) 1);
			}
		}
	}
}
