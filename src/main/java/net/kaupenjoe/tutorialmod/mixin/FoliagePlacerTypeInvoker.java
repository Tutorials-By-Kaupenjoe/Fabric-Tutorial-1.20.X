package net.kaupenjoe.tutorialmod.mixin;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(FoliagePlacerType.class)
public interface FoliagePlacerTypeInvoker {
    @Invoker
    static <P extends FoliagePlacer> FoliagePlacerType<P> callRegister(String id, Codec<P> codec) {
        throw new IllegalStateException();
    }
}
