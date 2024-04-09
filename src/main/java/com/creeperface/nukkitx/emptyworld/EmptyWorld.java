package com.creeperface.nukkitx.emptyworld;

import cn.nukkit.level.generator.Generator;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.registry.RegisterException;
import cn.nukkit.registry.Registries;

/**
 * Created by CreeperFace on 16. 11. 2016.
 */
public class EmptyWorld extends PluginBase {

    @Override
    public void onLoad() {
        try {
            Registries.GENERATOR.register("emptyworld", EmptyGenerator.class);
        } catch (RegisterException e) {
            throw new RuntimeException(e);
        }
    }

    public void onEnable() {
        try {
            Registries.GENERATE_STAGE.register(EmptyGenerateStage.NAME, EmptyGenerateStage.class);
        } catch (RegisterException e) {
            throw new RuntimeException(e);
        }
    }
}
