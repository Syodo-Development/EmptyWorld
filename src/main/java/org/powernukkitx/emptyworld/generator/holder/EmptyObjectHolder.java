package org.powernukkitx.emptyworld.generator.holder;

import cn.nukkit.level.generator.holder.ObjectHolder;
import lombok.Getter;

@Getter
public class EmptyObjectHolder extends ObjectHolder {

    private final boolean block;

    public EmptyObjectHolder(boolean block) {
        this.block = block;
    }
}
