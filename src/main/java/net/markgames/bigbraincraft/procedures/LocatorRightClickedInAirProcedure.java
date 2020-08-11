package net.markgames.bigbraincraft.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.markgames.bigbraincraft.BigbraincraftModElements;

import java.util.Random;
import java.util.Map;

@BigbraincraftModElements.ModElement.Tag
public class LocatorRightClickedInAirProcedure extends BigbraincraftModElements.ModElement {
	public LocatorRightClickedInAirProcedure(BigbraincraftModElements instance) {
		super(instance, 106);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure LocatorRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure LocatorRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("XYZ: ") + "" + (Math.round((entity.getPosX()))) + "" + (" ") + ""
					+ (Math.round((entity.getPosY()))) + "" + (" ") + "" + (Math.round((entity.getPosZ()))))), (true));
		}
		{
			ItemStack _ist = (itemstack);
			if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
	}
}
