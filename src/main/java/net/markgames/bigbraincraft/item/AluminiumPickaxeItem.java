
package net.markgames.bigbraincraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class AluminiumPickaxeItem extends BigbraincraftModElements.ModElement {
	@ObjectHolder("bigbraincraft:aluminium_pickaxe")
	public static final Item block = null;
	public AluminiumPickaxeItem(BigbraincraftModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 122;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 8;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(BigBrainTabItemGroup.tab)) {
		}.setRegistryName("aluminium_pickaxe"));
	}
}
