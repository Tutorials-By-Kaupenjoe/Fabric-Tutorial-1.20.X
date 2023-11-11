package net.kaupenjoe.tutorialmod.world.tree;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.mixin.FoliagePlacerTypeInvoker;
import net.kaupenjoe.tutorialmod.world.tree.custom.ChestnutFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> CHESTNUT_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("chestnut_foliage_placer", ChestnutFoliagePlacer.CODEC);

    public static void register() {
        TutorialMod.LOGGER.info("Registering Foliage Placer for " + TutorialMod.MOD_ID);
    }
}
