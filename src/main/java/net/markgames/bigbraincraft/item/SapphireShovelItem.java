
package net.markgames.bigbraincraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class SapphireShovelItem extends BigbraincraftModElements.ModElement {
	@ObjectHolder("bigbraincraft:sapphire_shovel")
	public static final Item block = null;
	public SapphireShovelItem(BigbraincraftModElements instance) {
		super(instance, 255);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 3072;
			}

			public float getEfficiency() {
				return 18f;
			}

			public float getAttackDamage() {
				return 10f;
			}

			public int getHarvestLevel() {
				return 12;
			}

			public int getEnchantability() {
				return 84;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(BigBrainTabItemGroup.tab)) {
		}.setRegistryName("sapphire_shovel"));
	}
}
