package net.markgames.bigbraincraft.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.markgames.bigbraincraft.BigbraincraftModElements;

import java.util.Map;
import java.util.Comparator;

@BigbraincraftModElements.ModElement.Tag
public class ItemCollectorUpdateTickProcedure extends BigbraincraftModElements.ModElement {
	public ItemCollectorUpdateTickProcedure(BigbraincraftModElements instance) {
		super(instance, 342);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ItemCollectorUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ItemCollectorUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ItemCollectorUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ItemCollectorUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getEntitiesWithinAABB(ItemEntity.class, new AxisAlignedBB(x - 10 / 2, y - 10 / 2, z - 10 / 2, x + 10 / 2, y + 10 / 2, z + 10 / 2),
				null).stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)) != null)) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (0);
					final ItemStack _setstack = (new Object() {
						public ItemStack entityToItem(Entity _ent) {
							if (_ent instanceof ItemEntity) {
								return ((ItemEntity) _ent).getItem();
							}
							return ItemStack.EMPTY;
						}
					}.entityToItem((world
							.getEntitiesWithinAABB(ItemEntity.class,
									new AxisAlignedBB(x - 10 / 2, y - 10 / 2, z - 10 / 2, x + 10 / 2, y + 10 / 2, z + 10 / 2), null)
							.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null))));
					_setstack.setCount((int) 1);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
						}
					});
				}
			}
			if (!(world
					.getEntitiesWithinAABB(ItemEntity.class,
							new AxisAlignedBB(x - 10 / 2, y - 10 / 2, z - 10 / 2, x + 10 / 2, y + 10 / 2, z + 10 / 2), null)
					.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)).world.isRemote)
				(world.getEntitiesWithinAABB(ItemEntity.class,
						new AxisAlignedBB(x - 10 / 2, y - 10 / 2, z - 10 / 2, x + 10 / 2, y + 10 / 2, z + 10 / 2), null).stream()
						.sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)).remove();
		}
	}
}
