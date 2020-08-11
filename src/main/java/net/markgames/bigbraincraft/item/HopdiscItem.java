
package net.markgames.bigbraincraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class HopdiscItem extends BigbraincraftModElements.ModElement {
	@ObjectHolder("bigbraincraft:hope_disc")
	public static final Item block = null;
	public HopdiscItem(BigbraincraftModElements instance) {
		super(instance, 345);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, BigbraincraftModElements.sounds.get(new ResourceLocation("bigbraincraft:hope_disc")),
					new Item.Properties().group(BigBrainTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("hope_disc");
		}
	}
}
