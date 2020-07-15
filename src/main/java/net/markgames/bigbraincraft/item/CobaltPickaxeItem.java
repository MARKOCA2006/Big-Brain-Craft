
package net.markgames.bigbraincraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class CobaltPickaxeItem extends BigbraincraftModElements.ModElement {
	@ObjectHolder("bigbraincraft:cobalt_pickaxe")
	public static final Item block = null;
	public CobaltPickaxeItem(BigbraincraftModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(BigBrainTabItemGroup.tab)) {
		}.setRegistryName("cobalt_pickaxe"));
	}
}
