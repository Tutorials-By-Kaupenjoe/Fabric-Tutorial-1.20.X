package net.kaupenjoe.tutorialmod.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.kaupenjoe.tutorialmod.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ChestnutFoliagePlacer extends FoliagePlacer {
    public static final Codec<ChestnutFoliagePlacer> CODEC = RecordCodecBuilder.create(chestnutFoliagePlacerInstance ->
            fillFoliagePlacerFields(chestnutFoliagePlacerInstance).and(Codec.intRange(0, 12).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(chestnutFoliagePlacerInstance, ChestnutFoliagePlacer::new));
    private final int height;

    public ChestnutFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.CHESTNUT_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset) {

        // generateSquare(world, placer, random, config, treeNode.getCenter());
        // radius on how many blocks it extends into x and z direction
        // y how much offset in the y direction from treeNode.getCenter()
        // y if it is dependent on i, also offsets each new layer in the y direction

        generateSquare(world, placer, random, config, treeNode.getCenter().up(0), 2, 1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(1), 2, 1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(2), 2, 1, treeNode.isGiantTrunk());
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
