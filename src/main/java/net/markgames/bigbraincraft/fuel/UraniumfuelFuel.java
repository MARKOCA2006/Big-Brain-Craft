
package net.markgames.bigbraincraft.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.markgames.bigbraincraft.item.UraniumDustItem;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class UraniumfuelFuel extends BigbraincraftModElements.ModElement {
	public UraniumfuelFuel(BigbraincraftModElements instance) {
		super(instance, 296);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(UraniumDustItem.block, (int) (1)).getItem())
			event.setBurnTime(10000);
	}
}
