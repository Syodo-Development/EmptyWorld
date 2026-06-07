package org.powernukkitx.emptyworld;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.registry.RegisterException;
import cn.nukkit.registry.Registries;
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
