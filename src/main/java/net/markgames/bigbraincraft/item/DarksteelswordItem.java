
package net.markgames.bigbraincraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class DarksteelswordItem extends BigbraincraftModElements.ModElement {
	@ObjectHolder("bigbraincraft:darksteelsword")
	public static final Item block = null;
	public DarksteelswordItem(BigbraincraftModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2130;
			}

			public float getEfficiency() {
				return 3f;
			}

			public float getAttackDamage() {
				return 6.5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 4;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarksteelItem.block, (int) (1)));
			}
		}, 3, -3.2000000000000001f, new Item.Properties().group(BigBrainTabItemGroup.tab)) {
		}.setRegistryName("darksteelsword"));
	}
}
