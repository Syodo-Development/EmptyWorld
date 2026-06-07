package org.powernukkitx.emptyworld.generator;

import cn.nukkit.level.DimensionData;
import cn.nukkit.level.Level;
import cn.nukkit.level.generator.BiomedGenerator;
import cn.nukkit.level.generator.GenerateStage;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.level.generator.biome.BiomePicker;
import cn.nukkit.level.generator.biome.result.BiomeResult;
import cn.nukkit.level.generator.holder.ObjectHolder;
import cn.nukkit.level.generator.stages.BiomeMapStage;
import cn.nukkit.level.generator.stages.FinishedStage;
import cn.nukkit.level.generator.stages.LightPopulationStage;
import cn.nukkit.registry.Registries;
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
