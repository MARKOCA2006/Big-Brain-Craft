
package net.markgames.bigbraincraft.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.markgames.bigbraincraft.item.PetrolItem;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class PetrolfuelFuel extends BigbraincraftModElements.ModElement {
	public PetrolfuelFuel(BigbraincraftModElements instance) {
		super(instance, 307);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(PetrolItem.block, (int) (1)).getItem())
			event.setBurnTime(6000);
	}
}
