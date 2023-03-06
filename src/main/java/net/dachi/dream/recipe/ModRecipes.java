package net.dachi.dream.recipe;

import net.dachi.dream.Dream;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Dream.MOD_ID);

    public static final RegistryObject<RecipeSerializer<DreamForgerRecipe>> DREAM_FORGER_SERIALIZER =
            SERIALIZERS.register("dream_forger", () -> DreamForgerRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
