package com.creeperface.nukkitx.emptyworld;

import cn.nukkit.block.*;
import cn.nukkit.level.biome.BiomeID;
import cn.nukkit.level.format.ChunkState;
import cn.nukkit.level.format.IChunk;
import cn.nukkit.level.generator.ChunkGenerateContext;
import cn.nukkit.level.generator.GenerateStage;

public class EmptyGenerateStage extends GenerateStage {
    public static final String NAME = "empty_generatestage";

    static final BlockState air = BlockAir.PROPERTIES.getDefaultState();
    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void apply(ChunkGenerateContext chunkGenerateContext) {
        IChunk chunk = chunkGenerateContext.getChunk();
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int i = chunkGenerateContext.getGenerator().getDimensionData().getMinSectionY(); i < chunkGenerateContext.getGenerator().getDimensionData().getMinSectionY(); i++) {
                    chunk.setBiomeId(x, i, z, BiomeID.JUNGLE);
                }
            }
        }
        chunk.setChunkState(ChunkState.POPULATED);
    }
};
