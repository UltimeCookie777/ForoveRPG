package io.github.ultimecookie777.foroverpg.rarity;

import net.minecraft.network.chat.Component;

public class ItemRarity {

    private final int level;
    private final Component desc;
    private final int chance;

    public ItemRarity(int _level, Component _desc, int _chance) {
        this.level = _level;
        this.desc = _desc;
        this.chance = _chance;
    }

    public int getChance() {
        return chance;
    }

    public int getLevel() {
        return level;
    }

    public Component getDesc() {
        return desc;
    }

}
