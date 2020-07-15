package net.markgames.bigbraincraft.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.markgames.bigbraincraft.BigbraincraftModElements;

@BigbraincraftModElements.ModElement.Tag
public class DrillOnMiningScriptProcedure extends BigbraincraftModElements.ModElement {
	public DrillOnMiningScriptProcedure(BigbraincraftModElements instance) {
		super(instance, 305);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DrillOnMiningScript!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DrillOnMiningScript!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DrillOnMiningScript!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DrillOnMiningScript!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.DOWN)) {
			Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)), world, new BlockPos((int) x, (int) y, (int) z));
			world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) z), false);
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.UP)) {
			Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)), world, new BlockPos((int) x, (int) y, (int) z));
			world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) z), false);
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.NORTH)) {
			Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))), world, new BlockPos((int) x, (int) y, (int) z));
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), false);
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.SOUTH)) {
			Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))), world, new BlockPos((int) x, (int) y, (int) z));
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z + 1)), false);
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.WEST)) {
			Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)), world, new BlockPos((int) x, (int) y, (int) z));
			world.destroyBlock(new BlockPos((int) (x + 1), (int) y, (int) z), false);
		} else {
			Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)), world, new BlockPos((int) x, (int) y, (int) z));
			world.destroyBlock(new BlockPos((int) (x - 1), (int) y, (int) z), false);
		}
	}
}
