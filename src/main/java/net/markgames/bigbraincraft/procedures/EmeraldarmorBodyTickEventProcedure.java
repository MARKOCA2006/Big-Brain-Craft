package net.markgames.bigbraincraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.markgames.bigbraincraft.item.EmeraldarmorItem;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class EmeraldarmorBodyTickEventProcedure extends BigbraincraftModElements.ModElement {
	public EmeraldarmorBodyTickEventProcedure(BigbraincraftModElements instance) {
		super(instance, 120);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EmeraldarmorBodyTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((new ItemStack(EmeraldarmorItem.boots, (int) (1))
				.getItem() == ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
						.getItem())
				&& (new ItemStack(EmeraldarmorItem.legs, (int) (1))
						.getItem() == ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
								.getItem()))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LUCK, (int) 5, (int) 6, (false), (false)));
		}
	}
}
