package net.kaupenjoe.tutorialmod.recipe;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TutorialMod.MOD_ID, GemPolishingRecipe.Serializer.ID),
                GemPolishingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(TutorialMod.MOD_ID, GemPolishingRecipe.Type.ID),
                GemPolishingRecipe.Type.INSTANCE);
    }
}
