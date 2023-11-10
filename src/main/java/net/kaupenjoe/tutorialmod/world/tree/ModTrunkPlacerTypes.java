package net.kaupenjoe.tutorialmod.world.tree;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.mixin.TrunkPlacerTypeInvoker;
import net.kaupenjoe.tutorialmod.world.tree.custom.ChestnutTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> CHESTNUT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("chestnut_trunk_placer", ChestnutTrunkPlacer.CODEC);

    public static void register() {
        TutorialMod.LOGGER.info("Registering Trunk Placers for " + TutorialMod.MOD_ID);
    }
}
