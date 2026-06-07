package org.powernukkitx.emptyworld.generator.stages;

import cn.nukkit.block.BlockBedrock;
import cn.nukkit.level.format.IChunk;
import cn.nukkit.level.generator.ChunkGenerateContext;
import cn.nukkit.level.generator.GenerateStage;
import org.powernukkitx.emptyworld.generator.holder.EmptyObjectHolder;

import static cn.nukkit.level.generator.stages.normal.NormalTerrainStage.SEA_LEVEL;

public class EmptyBlockStage extends GenerateStage {

    public static final String NAME = "empty_block";

    @Override
    public void apply(ChunkGenerateContext context) {
        IChunk chunk = context.getChunk();
        if(chunk.getX() == 0 && chunk.getZ() == 0) {
            if(((EmptyObjectHolder) chunk.getLevel().getGeneratorObjectHolder()).isBlock()) {
                chunk.setBlockState(0, SEA_LEVEL, 0, BlockBedrock.PROPERTIES.getDefaultState());
            }
        }
    }

    @Override
    public String name() {
        return NAME;
    }
}
