package org.powernukkitx.emptyworld.generator.stages;

import org.powernukkitx.level.format.ChunkState;
import org.powernukkitx.level.format.IChunk;
import org.powernukkitx.level.generator.ChunkGenerateContext;
import org.powernukkitx.level.generator.GenerateStage;

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
