
package net.markgames.bigbraincraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.Entity;

import net.markgames.bigbraincraft.procedures.HeavyswordToolInHandTickProcedure;
import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.BigbraincraftModElements;

import java.util.Map;
import java.util.HashMap;

@BigbraincraftModElements.ModElement.Tag
public class HeavyswordItem extends BigbraincraftModElements.ModElement {
	@ObjectHolder("bigbraincraft:heavysword")
	public static final Item block = null;
	public HeavyswordItem(BigbraincraftModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1045;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SteelItem.block, (int) (1)));
			}
		}, 3, -3.8f, new Item.Properties().group(BigBrainTabItemGroup.tab)) {
			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					HeavyswordToolInHandTickProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("heavysword"));
	}
}
