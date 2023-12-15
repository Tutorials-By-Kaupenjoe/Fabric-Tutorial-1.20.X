package net.kaupenjoe.tutorialmod.world.tree;

import net.kaupenjoe.tutorialmod.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator CHESTNUT =
            new SaplingGenerator("chestnut", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.CHESTNUT_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());

}
