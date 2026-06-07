package org.powernukkitx.emptyworld.generator.stages;

import cn.nukkit.level.format.ChunkState;
import cn.nukkit.level.format.IChunk;
import cn.nukkit.level.generator.ChunkGenerateContext;
import cn.nukkit.level.generator.GenerateStage;

public class EmptyGenerateStage extends GenerateStage {
    public static final String NAME = "empty_generatestage";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void apply(ChunkGenerateContext chunkGenerateContext) {
        IChunk chunk = chunkGenerateContext.getChunk();
        chunk.setChunkState(ChunkState.GENERATED);
    }
};
