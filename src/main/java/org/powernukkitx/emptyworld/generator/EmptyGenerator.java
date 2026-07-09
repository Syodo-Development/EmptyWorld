package org.powernukkitx.emptyworld.generator;

import org.powernukkitx.level.DimensionData;
import org.powernukkitx.level.Level;
import org.powernukkitx.level.generator.BiomedGenerator;
import org.powernukkitx.level.generator.GenerateStage;
import org.powernukkitx.level.generator.Generator;
import org.powernukkitx.level.generator.biome.BiomePicker;
import org.powernukkitx.level.generator.biome.result.BiomeResult;
import org.powernukkitx.level.generator.holder.ObjectHolder;
import org.powernukkitx.level.generator.stages.BiomeMapStage;
import org.powernukkitx.level.generator.stages.FinishedStage;
import org.powernukkitx.level.generator.stages.LightPopulationStage;
import org.powernukkitx.registry.Registries;
import org.powernukkitx.emptyworld.generator.holder.EmptyObjectHolder;
import org.powernukkitx.emptyworld.generator.stages.EmptyBlockStage;
import org.powernukkitx.emptyworld.generator.stages.EmptyGenerateStage;

import java.util.Map;

public class EmptyGenerator extends Generator implements BiomedGenerator {

    public static final String NAME = "emptyworld";

    private final BiomePicker biomePicker;

    public EmptyGenerator(DimensionData dimensionData, Map<String, Object> options) {
        super(dimensionData, options);
        this.biomePicker = new BiomePicker(null) {
            @Override
            public BiomeResult pick(int x, int y, int z) {
                return new BiomeResult(Registries.BIOME.getBiomeId((String) options.getOrDefault("biome", "minecraft:plains"))) {
                    @Override
                    public int getBiomeId() {
                        return super.getBiomeId();
                    }
                };
            }
        };
    }

    @Override
    public void stages(GenerateStage.Builder builder) {
        builder.start(Registries.GENERATE_STAGE.get(EmptyGenerateStage.NAME));
        builder.next(Registries.GENERATE_STAGE.get(BiomeMapStage.NAME));
        builder.next(Registries.GENERATE_STAGE.get(EmptyBlockStage.NAME));
        builder.next(Registries.GENERATE_STAGE.get(LightPopulationStage.NAME));
        builder.next(Registries.GENERATE_STAGE.get(FinishedStage.NAME));
    }

    @Override
    public BiomePicker createBiomePicker(Level level) {
        return biomePicker;
    }

    @Override
    public ObjectHolder createObjectHolder(Level level) {
        var options = getSettings();
        boolean block = !options.containsKey("block") || (boolean) options.get("block");
        return new EmptyObjectHolder(block);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
