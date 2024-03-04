package io.github.ultimecookie777.foroverpg;

import io.github.ultimecookie777.foroverpg.rarity.RarityUtils;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;


public class EventHandler {



    @SubscribeEvent
    public void itemTooltipEvent(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();

        if (item instanceof TieredItem || item instanceof Equipable || item instanceof ProjectileWeaponItem || item instanceof TridentItem) {

            if (!itemStack.getOrCreateTag().contains("foroverpg.rarity")) {

                RarityUtils.addIntNBTToItemStack(itemStack, "foroverpg.rarity", RarityUtils.randomRarity());

                //itemStack.getOrCreateTag().putInt("Rarity", RarityUtils.randomRarity());
                //componentList.add(Component.literal("Unknown"));
            }

            int rarity = itemStack.getOrCreateTag().getInt("foroverpg.rarity");

            event.getToolTip().add(1, RarityUtils.gatRarityFromLevel(rarity).getDesc());

        }
    }

}
