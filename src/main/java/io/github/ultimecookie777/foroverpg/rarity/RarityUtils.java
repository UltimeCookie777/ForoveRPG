package io.github.ultimecookie777.foroverpg.rarity;


import io.github.ultimecookie777.foroverpg.ForoveRPG;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.io.Console;

public class RarityUtils {

    private static final String rPath = "rarity.foroverpg.";
    private static final ItemRarity COMMON = new ItemRarity(0, Component.translatable(rPath + "common").withStyle(ChatFormatting.WHITE), 50);
    private static final ItemRarity UNCOMMON = new ItemRarity(1, Component.translatable(rPath + "uncommon").withStyle(ChatFormatting.GREEN), 20);
    private static final ItemRarity RARE = new ItemRarity(2, Component.translatable(rPath + "rare").withStyle(ChatFormatting.BLUE), 15);
    private static final ItemRarity EPIC = new ItemRarity(3, Component.translatable(rPath + "epic").withStyle(ChatFormatting.LIGHT_PURPLE), 10);
    private static final ItemRarity LEGENDARY = new ItemRarity(4, Component.translatable(rPath + "legendary").withStyle(ChatFormatting.GOLD), 5);



    private static int randomNum(int n) {
        return (int) (Math.random() * n);
    }
    public static int randomRarity() {

        // Disgusting piece of code but it works

        int n = randomNum(100);
        if(n <= COMMON.getChance()) {
            return COMMON.getLevel();
        }

        n -= COMMON.getChance();
        if (n <= UNCOMMON.getChance()) {
            return UNCOMMON.getLevel();
        }

        n -= UNCOMMON.getChance();
        if (n <= RARE.getChance()) {
            return RARE.getLevel();
        }

        n -= RARE.getChance();
        if (n <= EPIC.getChance()) {
            return EPIC.getLevel();
        }

        return LEGENDARY.getLevel();

    }

    public static void addIntNBTToItemStack(ItemStack itemStack, String key, int value) {

        CompoundTag tag = itemStack.getOrCreateTag();

        tag.putInt(key, value);

        itemStack.setTag(tag);

    }

    public static ItemRarity gatRarityFromLevel(int level) {
        switch (level) {
            case 1 : return UNCOMMON;
            case 2 : return RARE;
            case 3 : return EPIC;
            case 4 : return LEGENDARY;
            default : return COMMON;

        }
    }


}
