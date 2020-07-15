
package net.markgames.bigbraincraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.markgames.bigbraincraft.item.MultitoolItem;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class BigBrainTabItemGroup extends BigbraincraftModElements.ModElement {
	public BigBrainTabItemGroup(BigbraincraftModElements instance) {
		super(instance, 103);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbig_brain_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MultitoolItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
