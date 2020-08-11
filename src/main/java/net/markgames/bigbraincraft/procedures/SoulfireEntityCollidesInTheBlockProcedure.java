package net.markgames.bigbraincraft.procedures;

import net.minecraft.entity.Entity;

import net.markgames.bigbraincraft.BigbraincraftModElements;

import java.util.Map;

@BigbraincraftModElements.ModElement.Tag
public class SoulfireEntityCollidesInTheBlockProcedure extends BigbraincraftModElements.ModElement {
	public SoulfireEntityCollidesInTheBlockProcedure(BigbraincraftModElements instance) {
		super(instance, 314);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SoulfireEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 10);
	}
}
