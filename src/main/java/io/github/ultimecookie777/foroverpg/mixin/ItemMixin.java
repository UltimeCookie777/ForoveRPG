package io.github.ultimecookie777.foroverpg.mixin;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Item.class)
public abstract class ItemMixin {

    /*@Inject(method = "appendHoverText", at = @At("HEAD"))
    public void appendHoverTextInject(ItemStack itemStack, Level p_41422_, List<Component> componentList, TooltipFlag p_41424_, CallbackInfo ci) {

        Item item = itemStack.getItem();

        if (item instanceof TieredItem || item instanceof ArmorItem) {

            if (itemStack.getTag() == null) {
                itemStack.getOrCreateTag().putInt("Rarity", RarityUtils.randomRarity());
                //componentList.add(Component.literal("Unknown"));
            } else {
                int rarity = itemStack.getTag().getInt("Rarity");

                componentList.add(RarityUtils.gatRarityFromLevel(rarity).getDesc());
            }


        }

    }*/
}
