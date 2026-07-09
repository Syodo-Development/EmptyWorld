package org.powernukkitx.emptyworld;

import org.powernukkitx.plugin.PluginBase;
import org.powernukkitx.registry.RegisterException;
import org.powernukkitx.registry.Registries;
import org.powernukkitx.emptyworld.generator.stages.EmptyBlockStage;
import org.powernukkitx.emptyworld.generator.stages.EmptyGenerateStage;
import org.powernukkitx.emptyworld.generator.EmptyGenerator;

public class EmptyWorld extends PluginBase {

    @Override
    public void onLoad() {
        try {
            Registries.GENERATE_STAGE.register(EmptyGenerateStage.NAME, EmptyGenerateStage.class);
            Registries.GENERATE_STAGE.register(EmptyBlockStage.NAME, EmptyBlockStage.class);
            Registries.GENERATOR.register(EmptyGenerator.NAME, EmptyGenerator.class);
        } catch (RegisterException e) {
            throw new RuntimeException(e);
        }
    }
}
