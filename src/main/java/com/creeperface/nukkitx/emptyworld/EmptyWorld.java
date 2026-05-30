package com.creeperface.nukkitx.emptyworld;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.registry.RegisterException;
import cn.nukkit.registry.Registries;


public class EmptyWorld extends PluginBase {

    @Override
    public void onLoad() {
        try {
            Registries.GENERATE_STAGE.register(EmptyGenerateStage.NAME, EmptyGenerateStage.class);
            Registries.GENERATOR.register("emptyworld", EmptyGenerator.class);
        } catch (RegisterException e) {
            throw new RuntimeException(e);
        }
    }
}
