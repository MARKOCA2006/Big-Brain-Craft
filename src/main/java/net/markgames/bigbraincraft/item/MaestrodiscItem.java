
package net.markgames.bigbraincraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class MaestrodiscItem extends BigbraincraftModElements.ModElement {
	@ObjectHolder("bigbraincraft:maestrodisc")
	public static final Item block = null;
	public MaestrodiscItem(BigbraincraftModElements instance) {
		super(instance, 349);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, BigbraincraftModElements.sounds.get(new ResourceLocation("bigbraincraft:maestro_disc")),
					new Item.Properties().group(BigBrainTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("maestrodisc");
		}
	}
}
