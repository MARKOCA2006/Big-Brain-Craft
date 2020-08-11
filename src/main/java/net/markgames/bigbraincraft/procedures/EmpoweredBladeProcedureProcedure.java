package net.markgames.bigbraincraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.markgames.bigbraincraft.enchantment.EmpoweredBladeEnchantment;
import net.markgames.bigbraincraft.BigbraincraftModElements;

import java.util.Map;
import java.util.HashMap;

@BigbraincraftModElements.ModElement.Tag
public class EmpoweredBladeProcedureProcedure extends BigbraincraftModElements.ModElement {
	public EmpoweredBladeProcedureProcedure(BigbraincraftModElements instance) {
		super(instance, 334);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EmpoweredBladeProcedure!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure EmpoweredBladeProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((1 <= (EnchantmentHelper.getEnchantmentLevel(EmpoweredBladeEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))))) {
			if (((EnchantmentHelper.getEnchantmentLevel(EmpoweredBladeEnchantment.enchantment,
					((sourceentity instanceof LivingEntity)
							? ((LivingEntity) sourceentity).getHeldItemMainhand()
							: ItemStack.EMPTY))) <= ((sourceentity instanceof PlayerEntity)
									? ((PlayerEntity) sourceentity).getFoodStats().getFoodLevel()
									: 0))) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) (EnchantmentHelper.getEnchantmentLevel(EmpoweredBladeEnchantment.enchantment,
						((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))));
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
