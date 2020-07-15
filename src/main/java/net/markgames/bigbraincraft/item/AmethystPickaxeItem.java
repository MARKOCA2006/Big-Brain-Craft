
package net.markgames.bigbraincraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class AmethystPickaxeItem extends BigbraincraftModElements.ModElement {
	@ObjectHolder("bigbraincraft:amethyst_pickaxe")
	public static final Item block = null;
	public AmethystPickaxeItem(BigbraincraftModElements instance) {
		super(instance, 273);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 614;
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
				return 27;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(BigBrainTabItemGroup.tab)) {
		}.setRegistryName("amethyst_pickaxe"));
	}
}
