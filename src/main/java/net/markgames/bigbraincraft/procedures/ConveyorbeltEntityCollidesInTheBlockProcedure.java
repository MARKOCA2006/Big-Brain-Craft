package net.markgames.bigbraincraft.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.DirectionProperty;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.markgames.bigbraincraft.BigbraincraftModElements;

import java.util.Collections;

@BigbraincraftModElements.ModElement.Tag
public class ConveyorbeltEntityCollidesInTheBlockProcedure extends BigbraincraftModElements.ModElement {
	public ConveyorbeltEntityCollidesInTheBlockProcedure(BigbraincraftModElements instance) {
		super(instance, 297);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ConveyorbeltEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ConveyorbeltEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ConveyorbeltEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ConveyorbeltEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ConveyorbeltEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((entity instanceof ItemEntity) || ((entity instanceof AnimalEntity) || ((entity instanceof MonsterEntity)
				|| ((entity instanceof ExperienceOrbEntity) || ((entity instanceof PlayerEntity) || (entity instanceof TNTEntity))))))) {
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
			}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.NORTH)) {
				entity.setMotion(0, 0, (-0.125));
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((entity.getPosX()), ((entity.getPosY()) + 0.015), (entity.getPosZ()));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), ((entity.getPosY()) + 0.015), (entity.getPosZ()),
								_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
					}
				}
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
				entity.setMotion(0, 0, 0.125);
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((entity.getPosX()), ((entity.getPosY()) + 0.015), (entity.getPosZ()));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), ((entity.getPosY()) + 0.015), (entity.getPosZ()),
								_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
					}
				}
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
				entity.setMotion((-0.125), 0, 0);
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((entity.getPosX()), ((entity.getPosY()) + 0.015), (entity.getPosZ()));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), ((entity.getPosY()) + 0.015), (entity.getPosZ()),
								_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
					}
				}
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
			}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.EAST)) {
				entity.setMotion(0.125, 0, 0);
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((entity.getPosX()), ((entity.getPosY()) + 0.015), (entity.getPosZ()));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), ((entity.getPosY()) + 0.015), (entity.getPosZ()),
								_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
					}
				}
			}
		}
	}
}
