
package net.markgames.bigbraincraft.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.markgames.bigbraincraft.itemgroup.BigBrainTabItemGroup;
import net.markgames.bigbraincraft.BigbraincraftModElements;

import java.util.List;
import java.util.Collections;

@BigbraincraftModElements.ModElement.Tag
public class LeadOreBlockBlock extends BigbraincraftModElements.ModElement {
	@ObjectHolder("bigbraincraft:lead_ore_block")
	public static final Block block = null;
	public LeadOreBlockBlock(BigbraincraftModElements instance) {
		super(instance, 58);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(BigBrainTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5f, 10f).lightValue(0).harvestLevel(12)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("lead_ore_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
