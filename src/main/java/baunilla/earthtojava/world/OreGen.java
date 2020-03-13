package baunilla.earthtojava.world;

import baunilla.earthtojava.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
    public static void generateOre() {
        // Generate Ruby Ore
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome == Biomes.MUSHROOM_FIELDS || biome == Biomes.MUSHROOM_FIELD_SHORE) {
                ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                    .configure(new CountRangeConfig(5, 4, 4, 16));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.RUBY_ORE.get().getDefaultState(), 5))
                    .withPlacement(customConfig));
            }
        }
    }
}