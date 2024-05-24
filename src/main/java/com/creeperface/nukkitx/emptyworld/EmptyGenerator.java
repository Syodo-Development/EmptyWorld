package com.creeperface.nukkitx.emptyworld;

import cn.nukkit.Server;
import cn.nukkit.level.DimensionData;
import cn.nukkit.level.generator.GenerateStage;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.level.generator.stages.FinishedStage;
import cn.nukkit.level.generator.stages.FlatGenerateStage;
import cn.nukkit.level.generator.stages.LightPopulationStage;
import cn.nukkit.math.Vector3;
import cn.nukkit.registry.Registries;

import java.util.Map;

/**
 * Created by CreeperFace on 16. 11. 2016.
 */
public class EmptyGenerator extends Generator {

    private static final String NAME = "emptyworld";

    public EmptyGenerator(DimensionData dimensionData, Map<String, Object> options) {
        super(dimensionData, options);
    }

    @Override
    public void stages(GenerateStage.Builder builder) {
        builder.start(Registries.GENERATE_STAGE.get(EmptyGenerateStage.NAME));
        builder.next(Registries.GENERATE_STAGE.get(LightPopulationStage.NAME));
        builder.next(Registries.GENERATE_STAGE.get(FinishedStage.NAME));
    }


    @Override
    public String getName() {
        return null;
    }
}
