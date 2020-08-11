
package net.markgames.bigbraincraft.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;

import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.BigbraincraftModElements;

import java.util.List;

@BigbraincraftModElements.ModElement.Tag
public class EminemgodzilladiscItem extends BigbraincraftModElements.ModElement {
	@ObjectHolder("bigbraincraft:eminemgodzilladisc")
	public static final Item block = null;
	public EminemgodzilladiscItem(BigbraincraftModElements instance) {
		super(instance, 346);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, BigbraincraftModElements.sounds.get(new ResourceLocation("bigbraincraft:eminem-godzilla_disc")),
					new Item.Properties().group(BigBrainTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("eminemgodzilladisc");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Just Instrumental....."));
		}
	}
}
